package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.BreathStick;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

/**
 * Bâton du Souffle - Repousse les mobs proches
 * PlayerInteractEvent: appliquer knockback à entités proches (rayon 5), cooldown 10s
 */
public class BreathStickListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), BreathStick.KEY_ID);
    private final NamespacedKey cooldownKey = new NamespacedKey(MoreItems.getInstance(), "breath_stick_cooldown");

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
        
        // Vérifier le cooldown
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long currentTime = System.currentTimeMillis();
        
        if (pdc.has(cooldownKey, PersistentDataType.LONG)) {
            long lastUse = pdc.get(cooldownKey, PersistentDataType.LONG);
            long cooldownRemaining = 10000 - (currentTime - lastUse);
            
            if (cooldownRemaining > 0) {
                player.sendActionBar(Component.text("§cCooldown: " + (cooldownRemaining / 1000) + "s"));
                return;
            }
        }
        
        // Repousser les entités proches
        int pushed = 0;
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof LivingEntity living && entity != player) {
                Vector direction = entity.getLocation().subtract(player.getLocation()).toVector().normalize();
                direction.setY(0.5); // Légère poussée verticale
                entity.setVelocity(direction.multiply(2.0));
                pushed++;
            }
        }
        
        if (pushed > 0) {
            player.sendActionBar(Component.text("§a" + pushed + " entité(s) repoussée(s)!"));
        } else {
            player.sendActionBar(Component.text("§cAucune entité à proximité"));
        }
        
        // Définir le cooldown
        pdc.set(cooldownKey, PersistentDataType.LONG, currentTime);
    }
}
