package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * GUI displaying information about a custom item.
 */
public class ItemInfoGUI {
    private static final ItemStack RECIPE = ItemBuilder.of(Material.CRAFTING_TABLE).name(ChatColor.YELLOW + "Voir le craft").build();
    private static final ItemStack EDIT = ItemBuilder.of(Material.ANVIL).name(ChatColor.YELLOW + "Modifier le craft").build();
    private record Holder(CustomItem item) implements InventoryHolder {
        @Override
        public Inventory getInventory() {
            return null;
        }
    }

    public static void open(Player player, CustomItem item) {
        Inventory inv = Bukkit.createInventory(new Holder(item), 27,
                ChatColor.GREEN + item.getItem().getItemMeta().getDisplayName());
        inv.setItem(13, item.getItem());
        inv.setItem(22, RECIPE);
        inv.setItem(23, EDIT);
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof Holder holder)) {
            return false;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 22) {
            RecipeGUI.open(player, holder.item());
            return true;
        }
        if (event.getSlot() == 23) {
            RecipeEditorGUI.open(player, holder.item());
            return true;
        }
        return true;
    }
}
