package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HoneyMilk;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Soigne et donne résistance
 */
public class HoneyMilkListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HoneyMilk.KEY_ID);

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Player player = event.getPlayer();
        // Purger tous les effets de potion
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        
        // Ajouter Resistance I
        player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 0, false, true));
    }
}
