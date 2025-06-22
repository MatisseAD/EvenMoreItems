package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SurvivalRation;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Provides extra saturation when eating the ration.
 */
public class SurvivalRationListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SurvivalRation.KEY_ID);

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (!event.getItem().hasItemMeta() || !event.getItem().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.getPlayer().setFoodLevel(Math.min(20, event.getPlayer().getFoodLevel() + 6));
        event.getPlayer().addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SATURATION, 200, 0));
    }
}
