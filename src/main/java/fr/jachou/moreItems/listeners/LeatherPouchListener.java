package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LeatherPouch;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import java.util.Map;

/**
 * Handles storing and retrieving emeralds in the LeatherPouch.
 */
public class LeatherPouchListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LeatherPouch.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)) {
            return;
        }
        event.setCancelled(true);
        Player player = event.getPlayer();
        int count = item.getItemMeta().getPersistentDataContainer().getOrDefault(key, PersistentDataType.INTEGER, 0);
        if (player.isSneaking()) {
            if (count > 0) {
                player.getInventory().addItem(new ItemStack(Material.EMERALD, count));
                item.getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 0);
                item.setItemMeta(item.getItemMeta());
            }
            return;
        }
        Map<Integer, ? extends ItemStack> emeralds = player.getInventory().all(Material.EMERALD);
        int available = emeralds.values().stream().mapToInt(ItemStack::getAmount).sum();
        int toStore = Math.min(64 - count, available);
        if (toStore <= 0) return;
        player.getInventory().removeItem(new ItemStack(Material.EMERALD, toStore));
        item.getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.INTEGER, count + toStore);
        item.setItemMeta(item.getItemMeta());
    }
}
