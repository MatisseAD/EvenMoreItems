package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.EnchantedBookSorter;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Trie par enchantement
 */
public class EnchantedBookSorterListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), EnchantedBookSorter.KEY_ID);

    // Note: Nécessite InventoryClick pour lire EnchantmentStorageMeta et distribuer
}
