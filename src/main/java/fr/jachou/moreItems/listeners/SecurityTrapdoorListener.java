package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SecurityTrapdoor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Openable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityMoveEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Se ferme si mob approche
 */
public class SecurityTrapdoorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SecurityTrapdoor.KEY_ID);

    @EventHandler
    public void onEntityMove(EntityMoveEvent event) {
        Entity entity = event.getEntity();
        
        // Vérifier si c'est un mob hostile
        if (!(entity instanceof Monster)) {
            return;
        }
        
        // Chercher trappes proches
        for (Block block : getNearbyBlocks(entity.getLocation(), 3)) {
            if (block.getType().name().contains("TRAPDOOR") && 
                block.getBlockData() instanceof Openable openable) {
                
                // Fermer si mob proche
                if (entity.getLocation().distance(block.getLocation()) < 3) {
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
