package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.EnergySoup;
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
 * Régénération + vitesse
 */
public class EnergySoupListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), EnergySoup.KEY_ID);

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0, false, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0, false, true));
    }
}
