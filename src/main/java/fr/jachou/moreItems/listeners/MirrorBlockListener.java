package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MirrorBlock;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Réfléchit la lumière
 */
public class MirrorBlockListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MirrorBlock.KEY_ID);

    // Bloc décoratif - pas de mécanique spéciale
}
