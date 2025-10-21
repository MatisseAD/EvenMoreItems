package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LifeAmulet;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Rend 1 cœur toutes les 30 s
 */
public class LifeAmuletListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LifeAmulet.KEY_ID);

    public LifeAmuletListener() {
        // Démarrer le scheduler pour heal périodique
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MoreItems.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ItemStack offHand = player.getInventory().getItemInOffHand();
                ItemStack mainHand = player.getInventory().getItemInMainHand();
                
                boolean hasAmulet = (offHand.hasItemMeta() && 
                                   offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                                  (mainHand.hasItemMeta() && 
                                   mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
                
                if (hasAmulet) {
                    // Vérifier si pas en combat (dernier dommage > 10s)
                    if (player.getLastDamageCause() == null || 
                        System.currentTimeMillis() - player.getLastDamageCause().getEntity().getTicksLived() > 200) {
                        
                        double health = player.getHealth();
                        double maxHealth = player.getMaxHealth();
                        if (health < maxHealth) {
                            player.setHealth(Math.min(maxHealth, health + 2.0));
                        }
                    }
                }
            }
        }, 0L, 600L); // 30 secondes = 600 ticks
    }
}
