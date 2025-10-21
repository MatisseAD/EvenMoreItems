package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HunterStew;
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
 * Force temporaire
 */
public class HunterStewListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HunterStew.KEY_ID);

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 300, 0, false, true));
        
        // 30% de chance d'avoir Hunger I
        if (Math.random() < 0.3) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 0, false, true));
        }
    }
}
