package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.managers.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

/**
 * Shows the crafting recipe of an item.
 */
public class RecipeGUI {
    private static final String TITLE = ChatColor.GREEN + "Recette";
    private record Holder(CustomItem item) implements InventoryHolder {
        @Override
        public Inventory getInventory() { return null; }
    }

    public static void open(Player player, CustomItem item) {
        Inventory inv = Bukkit.createInventory(new Holder(item), 36, TITLE);
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
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof Holder)) {
            return false;
        }
        event.setCancelled(true);
        return true;
    }
}
