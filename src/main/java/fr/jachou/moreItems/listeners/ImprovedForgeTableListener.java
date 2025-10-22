package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ImprovedForgeTable;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Permet les crafts spéciaux
 */
public class ImprovedForgeTableListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ImprovedForgeTable.KEY_ID);

    // Note: Nécessite GUI custom pour afficher les recettes spéciales
}
