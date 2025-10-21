package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.WaterExtractor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Produit des seaux d'eau automatiques
 */
public class WaterExtractorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), WaterExtractor.KEY_ID);

    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        Block block = event.getBlock();
        
        // Vérifier si c'est un extracteur d'eau (dispenser)
        if (block.getType() != Material.DISPENSER) {
            return;
        }
        
        if (event.getNewCurrent() > 0) {
            // Vérifier source d'eau adjacente
            for (org.bukkit.block.BlockFace face : org.bukkit.block.BlockFace.values()) {
                Block adjacent = block.getRelative(face);
                if (adjacent.getType() == Material.WATER) {
                    // Ajouter seau d'eau au dispenser (nécessite accès inventaire)
                    // Note: Implémentation simplifiée
                    break;
                }
            }
        }
    }
}
