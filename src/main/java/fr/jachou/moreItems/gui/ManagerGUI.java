package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.items.ItemCategory;
import fr.jachou.moreItems.managers.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * GUI letting players browse categories of custom items
 * and obtain them. Right-click an item to configure its recipe.
 */
public class ManagerGUI {
    private static final String TITLE = ChatColor.GREEN + "MoreItems";

    private static class PageInfo {
        final ItemCategory category;
        final int page;
        PageInfo(ItemCategory c, int p) { this.category = c; this.page = p; }
    }

    private static final Map<UUID, PageInfo> STATES = new HashMap<>();

    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9, TITLE);
        int i = 0;
        for (ItemCategory cat : ItemCategory.values()) {
            ItemStack icon = new ItemStack(cat.getIcon());
            ItemMeta meta = icon.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + cat.getDisplay());
            icon.setItemMeta(meta);
            inv.setItem(i++, icon);
        }
        player.openInventory(inv);
        STATES.remove(player.getUniqueId());
    }

    private static void openCategory(Player player, ItemCategory category, int page) {
        STATES.put(player.getUniqueId(), new PageInfo(category, page));
        List<CustomItem> items = ItemManager.byCategory(category);
        int size = 54;
        Inventory inv = Bukkit.createInventory(player, size, TITLE + " - " + category.getDisplay());
        int start = page * 45;
        int end = Math.min(items.size(), start + 45);
        for (int i = start; i < end; i++) {
            inv.addItem(items.get(i).getItem());
        }
        if (page > 0) {
            ItemStack prev = new ItemStack(Material.ARROW);
            ItemMeta m = prev.getItemMeta();
            m.setDisplayName(ChatColor.YELLOW + "Previous");
            prev.setItemMeta(m);
            inv.setItem(45, prev);
        }
        if (end < items.size()) {
            ItemStack next = new ItemStack(Material.ARROW);
            ItemMeta m = next.getItemMeta();
            m.setDisplayName(ChatColor.YELLOW + "Next");
            next.setItemMeta(m);
            inv.setItem(53, next);
        }
        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta b = back.getItemMeta();
        b.setDisplayName(ChatColor.RED + "Back");
        back.setItemMeta(b);
        inv.setItem(49, back);

        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!event.getView().getTitle().startsWith(TITLE)) {
            return false;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        PageInfo info = STATES.get(player.getUniqueId());
        ItemStack current = event.getCurrentItem();
        int slot = event.getRawSlot();

        if (info == null) {
            if (current == null) return true;
            for (ItemCategory cat : ItemCategory.values()) {
                if (current.getType() == cat.getIcon()) {
                    openCategory(player, cat, 0);
                    return true;
                }
            }
            return true;
        }

        if (slot == 45 && info.page > 0) {
            openCategory(player, info.category, info.page - 1);
            return true;
        }
        if (slot == 53 && ItemManager.byCategory(info.category).size() > (info.page + 1) * 45) {
            openCategory(player, info.category, info.page + 1);
            return true;
        }
        if (slot == 49) {
            open(player);
            return true;
        }

        if (current != null && slot < 45) {
            if (event.getClick() == ClickType.RIGHT) {
                CustomItem item = ItemManager.fromItem(current);
                if (item != null) {
                    RecipeEditorGUI.open(player, item);
                }
            } else {
                player.getInventory().addItem(current.clone());
            }
        }
        return true;
    }
}
