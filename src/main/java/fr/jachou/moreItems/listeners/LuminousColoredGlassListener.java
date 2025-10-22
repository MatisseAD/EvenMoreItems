package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LuminousColoredGlass;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Verre teinté + brillance
 */
public class LuminousColoredGlassListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LuminousColoredGlass.KEY_ID);

    // Bloc décoratif lumineux - light level configuré dans l'item
}
