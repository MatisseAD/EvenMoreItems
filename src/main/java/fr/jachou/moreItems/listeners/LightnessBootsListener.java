package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LightnessBoots;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Réduit les dégâts de chute
 */
public class LightnessBootsListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LightnessBoots.KEY_ID);

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
            
            // Réduire les dégâts de 75%
            event.setDamage(event.getDamage() * 0.25);
        }
    }
}
