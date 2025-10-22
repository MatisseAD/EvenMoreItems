package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ReflectiveShield;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Bouclier Réfléchissant - Renvoie flèches et tridents
 * ProjectileHitEvent: renvoyer le projectile
 */
public class ReflectiveShieldListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ReflectiveShield.KEY_ID);

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (!(event.getHitEntity() instanceof Player player)) {
            return;
        }
        
        // Vérifier si le joueur tient le bouclier réfléchissant
        ItemStack offHand = player.getInventory().getItemInOffHand();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        
        boolean hasShield = (offHand.hasItemMeta() && 
                            offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                           (mainHand.hasItemMeta() && 
                            mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
        
        if (!hasShield) {
            return;
        }
        
        // Vérifier si le joueur bloque
        if (!player.isBlocking()) {
            return;
        }
        
        Projectile projectile = (Projectile) event.getEntity();
        
        // Annuler les dommages
        event.setCancelled(true);
        
        // Renvoyer le projectile
        projectile.setVelocity(projectile.getVelocity().multiply(-1));
        projectile.setShooter(player);
    }
}
