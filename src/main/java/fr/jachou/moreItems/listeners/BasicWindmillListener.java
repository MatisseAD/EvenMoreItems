package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.BasicWindmill;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Produit redstone par vent (esthétique)
 */
public class BasicWindmillListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), BasicWindmill.KEY_ID);

    // Note: Nécessite scheduler pour émettre signal redstone aléatoire si altitude élevée
}
