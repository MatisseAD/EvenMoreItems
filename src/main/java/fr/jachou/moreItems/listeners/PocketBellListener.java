package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.PocketBell;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Reveals nearby raiders when using the bell.
 */
public class PocketBellListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), PocketBell.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        Location loc = event.getPlayer().getLocation();
        event.getPlayer().playSound(loc, Sound.BLOCK_BELL_USE, 1f, 1f);
        for (LivingEntity entity : loc.getWorld().getLivingEntities()) {
            if (entity.getLocation().distanceSquared(loc) <= 32 * 32 && entity.getScoreboardTags().contains("raider")) {
                entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 0));
            }
        }
    }
}
