package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.BlockCompressor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Fusionne automatiquement blocs
 */
public class BlockCompressorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), BlockCompressor.KEY_ID);

    // Note: Nécessite InventoryMove pour convertir 9 ingots → 1 block et inverse
}
