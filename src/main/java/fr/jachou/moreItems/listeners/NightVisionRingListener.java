package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.NightVisionRing;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Vision nocturne permanente
 */
public class NightVisionRingListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), NightVisionRing.KEY_ID);

    public NightVisionRingListener() {
        // Scheduler pour réappliquer Night Vision
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MoreItems.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ItemStack offHand = player.getInventory().getItemInOffHand();
                ItemStack mainHand = player.getInventory().getItemInMainHand();
                
                boolean hasRing = (offHand.hasItemMeta() && 
                                 offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                                (mainHand.hasItemMeta() && 
                                 mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
                
                if (hasRing) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0, false, false));
                }
            }
        }, 0L, 500L); // Toutes les 25 secondes
    }
}
