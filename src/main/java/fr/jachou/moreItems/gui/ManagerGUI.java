package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.managers.ItemManager;
import fr.jachou.moreItems.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Simple GUI allowing players to obtain custom items.
 */
public class ManagerGUI {
    private static final String TITLE = ChatColor.GREEN + "MoreItems";

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(player, ((ItemManager.all().size() - 1) / 9 + 1) * 9, TITLE);
        for (CustomItem item : ItemManager.all()) {
            inv.addItem(item.getItem());
        }
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(TITLE)) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                event.getWhoClicked().getInventory().addItem(event.getCurrentItem());
            }
            return true;
        }
        return false;
    }
}
