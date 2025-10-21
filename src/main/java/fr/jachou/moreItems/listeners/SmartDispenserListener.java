package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SmartDispenser;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Trie automatiquement les items
 */
public class SmartDispenserListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SmartDispenser.KEY_ID);

    // Note: Nécessite InventoryMoveItemEvent et logique de tri complexe
}
