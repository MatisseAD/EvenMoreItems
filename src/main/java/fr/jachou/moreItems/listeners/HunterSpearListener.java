package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HunterSpear;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

/**
 * Lance de Chasseur - Attaque à distance courte
 * PlayerInteractEvent: lancer un projectile trident-like
 */
public class HunterSpearListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HunterSpear.KEY_ID);

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (!event.getAction().isRightClick()) return;
        
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        
        if (item == null || !item.hasItemMeta() || 
            !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        event.setCancelled(true);
        
        // Lancer un trident
        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection().multiply(1.5);
        
        Trident trident = player.getWorld().spawn(eyeLocation, Trident.class);
        trident.setVelocity(direction);
        trident.setShooter(player);
        trident.setDamage(6.0); // Dégâts légers
        trident.setPickupStatus(Trident.PickupStatus.DISALLOWED);
        
        // Consommer durabilité
        if (item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(damageable.getDamage() + 1);
            item.setItemMeta(damageable);
        }
    }
}
