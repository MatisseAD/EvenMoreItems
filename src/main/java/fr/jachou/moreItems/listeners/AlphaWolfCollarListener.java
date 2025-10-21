package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AlphaWolfCollar;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Tous les loups proches suivent et attaquent
 */
public class AlphaWolfCollarListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AlphaWolfCollar.KEY_ID);

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (!(event.getEntity() instanceof Wolf wolf)) {
            return;
        }
        
        if (!(wolf.getOwner() instanceof Player owner)) {
            return;
        }
        
        // Vérifier si le propriétaire porte le collier
        ItemStack helmet = owner.getInventory().getHelmet();
        if (helmet == null || !helmet.hasItemMeta() ||
            !helmet.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Si le propriétaire cible une entité, tous les loups proches attaquent
        LivingEntity target = owner.getTargetEntity(20, false) instanceof LivingEntity ? 
                             (LivingEntity) owner.getTargetEntity(20, false) : null;
        
        if (target != null) {
            for (Wolf nearbyWolf : owner.getLocation().getNearbyEntitiesByType(Wolf.class, 20)) {
                if (nearbyWolf.isTamed() && nearbyWolf.getOwner() == owner) {
                    nearbyWolf.setTarget(target);
                }
            }
        }
    }
}
