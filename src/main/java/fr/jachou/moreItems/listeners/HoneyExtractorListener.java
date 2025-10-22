package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HoneyExtractor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Récolte sans casser le nid
 */
public class HoneyExtractorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HoneyExtractor.KEY_ID);

    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        Block block = event.getBlock();
        
        // Vérifier si c'est un extracteur (dispenser)
        if (block.getType() != Material.DISPENSER) {
            return;
        }
        
        if (event.getNewCurrent() > 0) {
            // Chercher ruche adjacente
            for (org.bukkit.block.BlockFace face : org.bukkit.block.BlockFace.values()) {
                Block adjacent = block.getRelative(face);
                if ((adjacent.getType() == Material.BEE_NEST || adjacent.getType() == Material.BEEHIVE) &&
                    adjacent.getBlockData() instanceof Beehive beehive) {
                    
                    if (beehive.getHoneyLevel() >= 5) {
                        // Récolter miel sans aggresser les abeilles
                        beehive.setHoneyLevel(0);
                        adjacent.setBlockData(beehive);
                        // Ajouter bouteilles de miel au dispenser
                    }
                }
            }
        }
    }
}
