package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AdvancedCartographyTable;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Permet de copier les maps sans encre
 */
public class AdvancedCartographyTableListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AdvancedCartographyTable.KEY_ID);

    // Note: Nécessite GUI custom pour la copie de maps
    // À implémenter selon les besoins
}
