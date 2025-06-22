package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.managers.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * GUI used to configure crafting recipes for custom items.
 */
public class RecipeEditorGUI {

    private static final String TITLE = ChatColor.GOLD + "Recipe Editor";
    private static final Map<UUID, CustomItem> EDITING = new HashMap<>();

    public static void open(Player player, CustomItem item) {
        Inventory inv = Bukkit.createInventory(player, 27, TITLE);
        EDITING.put(player.getUniqueId(), item);
        Material[] mats = RecipeManager.getRecipe(item);
        for (int i = 0; i < 9; i++) {
            inv.setItem(map(i), mats[i] == null ? null : new ItemStack(mats[i]));
        }
        ItemStack save = new ItemStack(Material.LIME_DYE);
        ItemMeta s = save.getItemMeta();
        s.setDisplayName(ChatColor.GREEN + "Save");
        save.setItemMeta(s);
        inv.setItem(22, save);

        ItemStack view = new ItemStack(Material.BOOK);
        ItemMeta v = view.getItemMeta();
        v.setDisplayName(ChatColor.YELLOW + "View");
        view.setItemMeta(v);
        inv.setItem(23, view);
        player.openInventory(inv);
    }

    private static int map(int i) {
        return switch (i) {
            case 0 -> 10; case 1 -> 11; case 2 -> 12;
            case 3 -> 13; case 4 -> 14; case 5 -> 15;
            case 6 -> 16; case 7 -> 17; default -> 18;
        };
    }

    private static boolean isGrid(int slot) {
        for (int i = 0; i < 9; i++) if (map(i) == slot) return true;
        return false;
    }

    public static boolean handle(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(TITLE)) return false;
        Player player = (Player) event.getWhoClicked();
        CustomItem item = EDITING.get(player.getUniqueId());
        if (item == null) return true;
        int slot = event.getRawSlot();
        if (isGrid(slot)) {
            // allow modifications
            return true;
        }
        event.setCancelled(true);
        if (slot == 22) {
            Material[] mats = new Material[9];
            for (int i = 0; i < 9; i++) {
                ItemStack s = event.getInventory().getItem(map(i));
                mats[i] = s == null ? Material.AIR : s.getType();
            }
            RecipeManager.saveRecipe(item, mats);
            player.sendMessage(ChatColor.GREEN + "Recipe saved.");
            return true;
        }
        if (slot == 23) {
            viewRecipe(player, item);
            return true;
        }
        return true;
    }

    private static void viewRecipe(Player player, CustomItem item) {
        Inventory inv = Bukkit.createInventory(player, 27, ChatColor.YELLOW + "Recipe");
        Material[] mats = RecipeManager.getRecipe(item);
        for (int i = 0; i < 9; i++) {
            inv.setItem(map(i), mats[i] == null ? null : new ItemStack(mats[i]));
        }
        ItemStack result = item.getItem();
        inv.setItem(15, result);
        player.openInventory(inv);
    }
}
