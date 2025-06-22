package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ReturnScroll;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Teleports players to their bed when using the scroll.
 */
public class ReturnScrollListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ReturnScroll.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        Location bed = event.getPlayer().getBedSpawnLocation();
        if (bed != null) {
            event.getPlayer().teleport(bed);
            if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1); else event.getPlayer().getInventory().removeItem(item);
        }
    }
}
