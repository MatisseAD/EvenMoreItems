package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.managers.RecipeManager;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

/**
 * GUI used to edit crafting recipes.
 */
public class RecipeEditorGUI {
    private static final ItemStack CONFIRM = ItemBuilder.of(Material.LIME_WOOL).name(ChatColor.GREEN + "Confirmer").build();
    private static final ItemStack CANCEL = ItemBuilder.of(Material.RED_WOOL).name(ChatColor.RED + "Annuler").build();

    private record Holder(CustomItem item) implements InventoryHolder {
        @Override
        public Inventory getInventory() { return null; }
    }

    public static void open(Player player, CustomItem item) {
        Inventory inv = Bukkit.createInventory(new Holder(item), 36, ChatColor.GREEN + "Edit Craft");
        ShapedRecipe recipe = RecipeManager.get(item);
        if (recipe != null) {
            String[] shape = recipe.getShape();
            Map<Character, RecipeChoice> map = recipe.getChoiceMap();
            for (int r = 0; r < shape.length; r++) {
                for (int c = 0; c < shape[r].length(); c++) {
                    char ch = shape[r].charAt(c);
                    if (ch != ' ' && map.get(ch) != null) {
                        ItemStack icon = map.get(ch).getItemStack();
                        inv.setItem(10 + r * 9 + c, icon);
                    }
                }
            }
        }
        inv.setItem(22, item.getItem());
        inv.setItem(24, CONFIRM);
        inv.setItem(26, CANCEL);
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof Holder holder)) {
            return false;
        }
        if (event.getSlot() == 24 || event.getSlot() == 26 || event.getSlot() == 22) {
            event.setCancelled(true);
        }
        if (event.getSlot() == 24) {
            Inventory inv = event.getInventory();
            String[] shape = new String[3];
            Map<Character, ItemStack> items = new HashMap<>();
            char c = 'A';
            for (int r = 0; r < 3; r++) {
                StringBuilder row = new StringBuilder();
                for (int col = 0; col < 3; col++) {
                    ItemStack is = inv.getItem(10 + r * 9 + col);
                    if (is == null || is.getType() == Material.AIR) {
                        row.append(' ');
                    } else {
                        row.append(c);
                        items.put(c, is.clone());
                        c++;
                    }
                }
                shape[r] = row.toString();
            }
            ShapedRecipe recipe = new ShapedRecipe(holder.item().getKey(), holder.item().getItem());
            recipe.shape(shape);
            for (Map.Entry<Character, ItemStack> e : items.entrySet()) {
                recipe.setIngredient(e.getKey(), new RecipeChoice.ExactChoice(e.getValue()));
            }
            RecipeManager.update(holder.item(), recipe);
            event.getWhoClicked().sendMessage(ChatColor.GREEN + "Recette mise à jour !");
            ItemInfoGUI.open((Player) event.getWhoClicked(), holder.item());
            return true;
        }
        if (event.getSlot() == 26) {
            event.setCancelled(true);
            ItemInfoGUI.open((Player) event.getWhoClicked(), holder.item());
            return true;
        }
        return true;
    }
}
