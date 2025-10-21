package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MossyBrick;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Décoration naturelle
 */
public class MossyBrickListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MossyBrick.KEY_ID);

    // Bloc décoratif - pas de mécanique spéciale
}
