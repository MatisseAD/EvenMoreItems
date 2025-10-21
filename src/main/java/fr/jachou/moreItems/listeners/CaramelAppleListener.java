package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CaramelApple;
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
 * Restaure la vie instantanément
 */
public class CaramelAppleListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CaramelApple.KEY_ID);

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Player player = event.getPlayer();
        // Heal 2 cœurs (4 HP)
        double currentHealth = player.getHealth();
        double maxHealth = player.getMaxHealth();
        player.setHealth(Math.min(maxHealth, currentHealth + 4.0));
        
        // Absorption I pendant 30s
        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 0, false, true));
    }
}
