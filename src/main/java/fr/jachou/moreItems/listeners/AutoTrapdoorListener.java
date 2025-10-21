package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AutoTrapdoor;
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
 * S'ouvre à la présence d'un joueur
 */
public class AutoTrapdoorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AutoTrapdoor.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block below = player.getLocation().subtract(0, 1, 0).getBlock();
        Block above = player.getLocation().add(0, 1, 0).getBlock();
        
        // Vérifier les trappes proches
        for (Block block : new Block[]{below, above}) {
            if (block.getType().name().contains("TRAPDOOR") && 
                block.getBlockData() instanceof Openable openable) {
                
                // Ouvrir si joueur proche
                if (player.getLocation().distance(block.getLocation()) < 2) {
                    openable.setOpen(true);
                    block.setBlockData(openable);
                }
            }
        }
    }
}
