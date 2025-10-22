package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.WheatSilo;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Stocke les récoltes
 */
public class WheatSiloListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), WheatSilo.KEY_ID);

    // Note: Stockage massif de céréales avec compaction automatique
}
