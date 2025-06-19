package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.TeleportBow;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.persistence.PersistentDataContainer;

/**
 * Teleports players when arrows fired from the TeleportBow land.
 */
public class TeleportBowListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), TeleportBow.KEY_ID);

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        ItemStack bow = event.getBow();
        if (bow != null && bow.hasItemMeta() && bow.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            event.getProjectile().getPersistentDataContainer().set(key, PersistentDataType.STRING, "tp");
        }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof AbstractArrow arrow)) {
            return;
        }
        PersistentDataContainer container = arrow.getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING) && arrow.getShooter() instanceof Player player) {
            player.teleport(arrow.getLocation());
        }
    }
}
