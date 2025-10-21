package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.GolemTalisman;
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
 * Résistance accrue
 */
public class GolemTalismanListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), GolemTalisman.KEY_ID);
    private final NamespacedKey cooldownKey = new NamespacedKey(MoreItems.getInstance(), "golem_talisman_cooldown");

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        
        if (event.getDamage() < 2.0) {
            return;
        }
        
        // Vérifier si le joueur porte le talisman
        ItemStack offHand = player.getInventory().getItemInOffHand();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        
        boolean hasTalisman = (offHand.hasItemMeta() && 
                              offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                             (mainHand.hasItemMeta() && 
                              mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
        
        if (!hasTalisman) {
            return;
        }
        
        // Vérifier cooldown
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long currentTime = System.currentTimeMillis();
        
        if (pdc.has(cooldownKey, PersistentDataType.LONG)) {
            long lastUse = pdc.get(cooldownKey, PersistentDataType.LONG);
            if (currentTime - lastUse < 20000) {
                return;
            }
        }
        
        // Appliquer Resistance I
        player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 100, 0, false, true));
        player.sendActionBar(Component.text("§aTalisman du Golem activé!"));
        pdc.set(cooldownKey, PersistentDataType.LONG, currentTime);
    }
}
