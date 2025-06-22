package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SpeedBoots;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Adjusts player walking speed when wearing the SpeedBoots item.
 */
public class SpeedBootsListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SpeedBoots.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        if (boots != null && boots.hasItemMeta() &&
                boots.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            if (player.getWalkSpeed() != 0.3f) {
                player.setWalkSpeed(0.3f);
            }
        } else if (player.getWalkSpeed() != 0.2f) {
            player.setWalkSpeed(0.2f);
        }
    }
}
