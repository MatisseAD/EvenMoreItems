package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SmokeBlock;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Cache la vision, effet décoratif
 */
public class SmokeBlockListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SmokeBlock.KEY_ID);

    // Note: Nécessite un scheduler pour spawner des particules périodiquement
    // et appliquer Blindness aux entités dans un rayon de 2 blocs
}
