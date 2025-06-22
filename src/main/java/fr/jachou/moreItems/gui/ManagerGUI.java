package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.managers.ItemManager;
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

import java.util.List;

/**
 * Paged GUI showing items from a category.
 */
public class ManagerGUI {
    private static final int ITEMS_PER_PAGE = 45;
    private static final ItemStack NEXT = ItemBuilder.of(Material.ARROW).name(ChatColor.YELLOW + "Suivant").build();
    private static final ItemStack PREV = ItemBuilder.of(Material.ARROW).name(ChatColor.YELLOW + "Précédent").build();
    private static final ItemStack BACK = ItemBuilder.of(Material.BARRIER).name(ChatColor.RED + "Retour").build();

    private record Holder(Category category, int page) implements InventoryHolder {
        @Override
        public Inventory getInventory() {
            return null;
        }
    }

    public static void open(Player player, Category category, int page) {
        List<CustomItem> items = ItemManager.all(category).stream().toList();
        int maxPage = Math.max(0, (items.size() - 1) / ITEMS_PER_PAGE);
        if (page < 0) page = 0;
        if (page > maxPage) page = maxPage;
        Inventory inv = Bukkit.createInventory(new Holder(category, page), 54,
                ChatColor.GREEN + "MoreItems - " + category.getDisplay());
        int start = page * ITEMS_PER_PAGE;
        for (int i = 0; i < ITEMS_PER_PAGE && start + i < items.size(); i++) {
            inv.setItem(i, items.get(start + i).getItem());
        }
        if (page > 0) inv.setItem(45, PREV);
        inv.setItem(49, BACK);
        if (page < maxPage) inv.setItem(53, NEXT);
        player.openInventory(inv);
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof Holder holder)) {
            return false;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        int slot = event.getRawSlot();
        if (slot == 45 && event.getCurrentItem() != null && event.getCurrentItem().isSimilar(PREV)) {
            open(player, holder.category(), holder.page() - 1);
            return true;
        }
        if (slot == 53 && event.getCurrentItem() != null && event.getCurrentItem().isSimilar(NEXT)) {
            open(player, holder.category(), holder.page() + 1);
            return true;
        }
        if (slot == 49) {
            CategoryGUI.open(player);
            return true;
        }
        ItemStack clicked = event.getCurrentItem();
        if (clicked != null) {
            CustomItem item = ItemManager.fromItemStack(clicked);
            if (item != null) {
                ItemInfoGUI.open(player, item);
            }
        }
        return true;
    }
}
