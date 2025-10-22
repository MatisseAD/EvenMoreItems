package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FireRing;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Résistance au feu
 */
public class FireRingListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FireRing.KEY_ID);
    private final NamespacedKey cooldownKey = new NamespacedKey(MoreItems.getInstance(), "fire_ring_cooldown");

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        
        if (event.getCause() != EntityDamageEvent.DamageCause.FIRE &&
            event.getCause() != EntityDamageEvent.DamageCause.LAVA &&
            event.getCause() != EntityDamageEvent.DamageCause.FIRE_TICK) {
            return;
        }
        
        // Vérifier si le joueur porte l'anneau (main ou off-hand)
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = player.getInventory().getItemInOffHand();
        
        boolean hasRing = (mainHand.hasItemMeta() && 
                          mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                         (offHand.hasItemMeta() && 
                          offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
        
        if (!hasRing) {
            return;
        }
        
        // Vérifier cooldown
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long currentTime = System.currentTimeMillis();
        
        if (pdc.has(cooldownKey, PersistentDataType.LONG)) {
            long lastUse = pdc.get(cooldownKey, PersistentDataType.LONG);
            if (currentTime - lastUse < 30000) {
                return;
            }
        }
        
        // Appliquer Fire Resistance
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0, false, true));
        player.sendActionBar(Component.text("§6Anneau de Feu activé!"));
        pdc.set(cooldownKey, PersistentDataType.LONG, currentTime);
    }
}
