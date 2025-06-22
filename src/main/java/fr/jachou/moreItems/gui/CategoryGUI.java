package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * GUI listing available item categories.
 */
public class CategoryGUI {
    private static final String TITLE = ChatColor.GREEN + "MoreItems";

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9, TITLE);
        inv.addItem(ItemBuilder.of(Material.DIAMOND_CHESTPLATE).name(Category.ARMOR.getDisplay()).build());
        inv.addItem(ItemBuilder.of(Material.DIAMOND_SWORD).name(Category.WEAPON.getDisplay()).build());
        inv.addItem(ItemBuilder.of(Material.IRON_PICKAXE).name(Category.TOOL.getDisplay()).build());
        inv.addItem(ItemBuilder.of(Material.BOOK).name(Category.UTILITY.getDisplay()).build());
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(TITLE)) {
            return false;
        }
        event.setCancelled(true);
        if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) {
            return true;
        }
        String name = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
        Player player = (Player) event.getWhoClicked();
        for (Category cat : Category.values()) {
            if (cat.getDisplay().equals(ChatColor.GREEN + name) || name.equals(ChatColor.stripColor(cat.getDisplay()))) {
                ManagerGUI.open(player, cat, 0);
                break;
            }
        }
        return true;
    }
}
