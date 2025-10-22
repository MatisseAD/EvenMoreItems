package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AutoLamppost;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Allume la nuit
 */
public class AutoLamppostListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AutoLamppost.KEY_ID);

    // Note: Nécessite scheduler pour allumer/éteindre selon l'heure (TimeSkipEvent)
}
