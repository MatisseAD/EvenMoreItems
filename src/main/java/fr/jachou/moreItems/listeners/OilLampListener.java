package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.OilLamp;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Source de lumière portable
 */
public class OilLampListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), OilLamp.KEY_ID);

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack newItem = player.getInventory().getItem(event.getNewSlot());
        
        // Vérifier si le nouvel item est une lampe à huile
        if (newItem != null && newItem.hasItemMeta() &&
            newItem.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            // Donner Night Vision simulée
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0, false, false));
        }
    }
}
