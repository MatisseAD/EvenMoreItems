package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.PickupMagnet;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Collects dropped items around the player when using the magnet.
 */
public class PickupMagnetListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), PickupMagnet.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        Player player = event.getPlayer();
        for (Entity ent : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
            if (ent instanceof Item drop) {
                player.getInventory().addItem(drop.getItemStack());
                drop.remove();
            }
        }
    }
}
