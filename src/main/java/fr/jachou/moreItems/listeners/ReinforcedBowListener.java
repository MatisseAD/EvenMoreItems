package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ReinforcedBow;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Arc Renforcé - +25% de portée
 * EntityShootBowEvent: augmenter la vitesse du projectile
 */
public class ReinforcedBowListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ReinforcedBow.KEY_ID);

    @EventHandler
    public void onShootBow(EntityShootBowEvent event) {
        ItemStack bow = event.getBow();
        if (bow == null || !bow.hasItemMeta() || 
            !bow.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Augmenter la vitesse du projectile de 25%
        if (event.getProjectile() instanceof AbstractArrow arrow) {
            arrow.setVelocity(arrow.getVelocity().multiply(1.25));
        }
    }
}
