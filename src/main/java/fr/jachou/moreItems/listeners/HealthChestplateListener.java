package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HealthChestplate;
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
 * Provides regeneration while wearing the chestplate.
 */
public class HealthChestplateListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HealthChestplate.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack chest = player.getInventory().getChestplate();
        boolean wearing = chest != null && chest.hasItemMeta() && chest.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);
        if (wearing) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 0, true, false));
        } else if (player.hasPotionEffect(PotionEffectType.REGENERATION)) {
            player.removePotionEffect(PotionEffectType.REGENERATION);
        }
    }
}
