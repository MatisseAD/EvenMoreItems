package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SailorMedallion;
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
 * Respiration aquatique
 */
public class SailorMedallionListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SailorMedallion.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        // Vérifier si le joueur porte le médaillon
        ItemStack offHand = player.getInventory().getItemInOffHand();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        
        boolean hasMedallion = (offHand.hasItemMeta() && 
                               offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                              (mainHand.hasItemMeta() && 
                               mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
        
        if (hasMedallion && player.isInWater()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 60, 0, false, false));
        }
    }
}
