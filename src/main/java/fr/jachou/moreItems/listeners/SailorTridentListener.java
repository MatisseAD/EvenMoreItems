package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SailorTrident;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Trident du Marin - Augmente la vitesse sous l'eau
 * PlayerMoveEvent: appliquer Dolphin's Grace + Water Breathing
 */
public class SailorTridentListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SailorTrident.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            // Retirer les effets si le joueur ne tient plus le trident
            if (player.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE)) {
                player.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
            }
            return;
        }
        
        // Vérifier si le joueur est dans l'eau
        if (player.isInWater()) {
            // Appliquer Dolphin's Grace et Water Breathing
            player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 60, 0, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 60, 0, false, false));
        } else {
            // Retirer l'effet hors de l'eau
            if (player.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE)) {
                player.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
            }
        }
    }
}
