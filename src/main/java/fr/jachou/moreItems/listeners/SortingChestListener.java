package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SortingChest;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Trie les items par type
 */
public class SortingChestListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SortingChest.KEY_ID);

    // Note: Nécessite InventoryClick/Move et routing vers coffres connectés
}
