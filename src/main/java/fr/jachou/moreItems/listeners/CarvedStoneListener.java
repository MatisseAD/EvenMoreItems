package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CarvedStone;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Pierre Sculptée - Apparence de visages anciens
 */
public class CarvedStoneListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CarvedStone.KEY_ID);

    // Bloc décoratif - pas de mécanique spéciale
}
