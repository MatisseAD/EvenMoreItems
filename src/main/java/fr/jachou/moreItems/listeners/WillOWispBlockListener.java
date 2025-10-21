package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.WillOWispBlock;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Émet lumière bleue faible
 */
public class WillOWispBlockListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), WillOWispBlock.KEY_ID);

    // Note: Les particules soul et la lumière sont configurées dans le bloc
    // Un scheduler pourrait être ajouté pour des particules périodiques
}
