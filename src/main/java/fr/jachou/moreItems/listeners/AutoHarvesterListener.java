package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AutoHarvester;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Casse et replante
 */
public class AutoHarvesterListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AutoHarvester.KEY_ID);

    @EventHandler
    public void onGrow(BlockGrowEvent event) {
        Block block = event.getBlock();
        
        // Vérifier si la plante est à maturité
        if (block.getBlockData() instanceof Ageable ageable) {
            if (ageable.getAge() == ageable.getMaximumAge()) {
                // Récolter et replanter (nécessite proximité d'un auto-harvester)
                // Note: Implémentation simplifiée
            }
        }
    }
}
