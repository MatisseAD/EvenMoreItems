package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FeatherFallingPotionII;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Dure 4 minutes
 */
public class FeatherFallingPotionIIListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FeatherFallingPotionII.KEY_ID);

    // Note: La potion est déjà configurée avec la bonne durée dans l'item
    // Pas besoin de listener supplémentaire pour les potions
}
