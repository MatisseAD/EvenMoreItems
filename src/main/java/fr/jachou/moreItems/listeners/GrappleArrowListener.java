package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.GrappleArrow;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

/**
 * Pulls the player to the arrow's landing location.
 */
public class GrappleArrowListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), GrappleArrow.KEY_ID);

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack arrow = event.getConsumable();
        if (arrow != null && arrow.hasItemMeta() && arrow.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            event.getProjectile().getPersistentDataContainer().set(key, PersistentDataType.STRING, "grapple");
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof AbstractArrow arrow)) return;
        if (!arrow.getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        if (!(arrow.getShooter() instanceof Player player)) return;
        Vector pull = arrow.getLocation().toVector().subtract(player.getLocation().toVector());
        player.setVelocity(pull.normalize().multiply(1.5));
        arrow.remove();
    }
}
