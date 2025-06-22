package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.DriedApple;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Restores a small amount of hunger when eaten.
 */
public class DriedAppleListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), DriedApple.KEY_ID);

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (!event.getItem().hasItemMeta() || !event.getItem().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.getPlayer().setFoodLevel(Math.min(20, event.getPlayer().getFoodLevel() + 2));
    }
}
