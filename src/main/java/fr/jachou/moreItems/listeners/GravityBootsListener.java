package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.GravityBoots;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Bottes Gravitantes - Annulent les dégâts de chute
 * EntityDamageEvent: cancel fall damage
 */
public class GravityBootsListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), GravityBoots.KEY_ID);

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        
        ItemStack boots = player.getInventory().getBoots();
        if (boots != null && boots.hasItemMeta() &&
            boots.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            event.setCancelled(true);
            // Particules optionnelles
            player.getWorld().spawnParticle(org.bukkit.Particle.CLOUD, player.getLocation(), 10, 0.5, 0.1, 0.5, 0);
        }
    }
}
