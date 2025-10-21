package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.PhantomLantern;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Révèle entités invisibles
 */
public class PhantomLanternListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), PhantomLantern.KEY_ID);

    public PhantomLanternListener() {
        // Scheduler pour révéler les entités invisibles
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MoreItems.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ItemStack offHand = player.getInventory().getItemInOffHand();
                ItemStack mainHand = player.getInventory().getItemInMainHand();
                
                boolean hasLantern = (offHand.hasItemMeta() && 
                                    offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                                   (mainHand.hasItemMeta() && 
                                    mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
                
                if (hasLantern) {
                    // Révéler les entités invisibles proches
                    for (Entity entity : player.getNearbyEntities(10, 10, 10)) {
                        if (entity instanceof LivingEntity living && living.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                            living.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 60, 0, false, false));
                        }
                    }
                }
            }
        }, 0L, 200L); // Toutes les 10 secondes
    }
}
