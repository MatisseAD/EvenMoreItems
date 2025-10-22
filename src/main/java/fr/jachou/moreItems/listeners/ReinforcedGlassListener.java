package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ReinforcedGlass;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Iterator;

/**
 * Bloc de Verre Renforcé - Résiste à la TNT
 */
public class ReinforcedGlassListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ReinforcedGlass.KEY_ID);

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        Iterator<Block> blockIterator = event.blockList().iterator();
        
        while (blockIterator.hasNext()) {
            Block block = blockIterator.next();
            
            // Vérifier si c'est du verre renforcé (70% de chance de résister)
            if (block.getType() == Material.GLASS && Math.random() < 0.7) {
                // Retirer ce bloc de la liste des blocs détruits
                blockIterator.remove();
            }
        }
    }
}
