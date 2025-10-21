package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CrackedGlowstone;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Variante décorative
 */
public class CrackedGlowstoneListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CrackedGlowstone.KEY_ID);

    // Bloc décoratif avec light level réduit configuré dans l'item
}
