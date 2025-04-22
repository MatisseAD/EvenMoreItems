package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.items.NameSpaceKeyItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class SpeedBootsEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        if (boots != null && boots.getItemMeta().getPersistentDataContainer().has(NameSpaceKeyItems.SPEED_BOOTS, PersistentDataType.STRING)) {
            player.setWalkSpeed(1f); // Increase speed
        } else {
            player.setWalkSpeed(0.2f); // Reset to normal speed
        }
    }

}
