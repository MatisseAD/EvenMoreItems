package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.EngravingTable;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Permet de renommer blocs décoratifs
 */
public class EngravingTableListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), EngravingTable.KEY_ID);

    // Note: Nécessite GUI custom pour saisir le nom et appliquer aux blocs
}
