package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AutoDoubleDoor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * S'ouvre en détectant joueur
 */
public class AutoDoubleDoorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AutoDoubleDoor.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        // Chercher portes proches
        for (Block block : getNearbyBlocks(player.getLocation(), 3)) {
            if (block.getType().name().contains("DOOR") && 
                block.getBlockData() instanceof Openable openable) {
                
                // Ouvrir si joueur proche
                if (player.getLocation().distance(block.getLocation()) < 3) {
                    if (!openable.isOpen()) {
                        openable.setOpen(true);
                        block.setBlockData(openable);
                    }
                } else {
                    if (openable.isOpen()) {
                        openable.setOpen(false);
                        block.setBlockData(openable);
                    }
                }
            }
        }
    }
    
    private java.util.List<Block> getNearbyBlocks(org.bukkit.Location location, int radius) {
        java.util.List<Block> blocks = new java.util.ArrayList<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    blocks.add(location.clone().add(x, y, z).getBlock());
                }
            }
        }
        return blocks;
    }
}
