package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.IcePop;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Applies slowness and heals when consuming an Ice Pop.
 */
public class IcePopListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), IcePop.KEY_ID);

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (!event.getItem().hasItemMeta() || !event.getItem().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.getPlayer().setHealth(Math.min(event.getPlayer().getMaxHealth(), event.getPlayer().getHealth() + 2.0));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
    }
}
