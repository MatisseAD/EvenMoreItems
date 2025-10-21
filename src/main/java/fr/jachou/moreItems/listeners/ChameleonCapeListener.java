package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ChameleonCape;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Invisibilité 10 s
 */
public class ChameleonCapeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ChameleonCape.KEY_ID);
    private final NamespacedKey cooldownKey = new NamespacedKey(MoreItems.getInstance(), "chameleon_cape_cooldown");

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        
        Player player = event.getPlayer();
        ItemStack chestplate = player.getInventory().getChestplate();
        
        if (chestplate == null || !chestplate.hasItemMeta() ||
            !chestplate.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Vérifier cooldown
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long currentTime = System.currentTimeMillis();
        
        if (pdc.has(cooldownKey, PersistentDataType.LONG)) {
            long lastUse = pdc.get(cooldownKey, PersistentDataType.LONG);
            long cooldownRemaining = 60000 - (currentTime - lastUse);
            
            if (cooldownRemaining > 0) {
                player.sendActionBar(Component.text("§cCooldown: " + (cooldownRemaining / 1000) + "s"));
                return;
            }
        }
        
        // Appliquer invisibilité
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0, false, true));
        player.sendActionBar(Component.text("§aInvisibilité activée!"));
        pdc.set(cooldownKey, PersistentDataType.LONG, currentTime);
    }
    
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) {
            return;
        }
        
        // Retirer invisibilité si attaque
        if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }
}
