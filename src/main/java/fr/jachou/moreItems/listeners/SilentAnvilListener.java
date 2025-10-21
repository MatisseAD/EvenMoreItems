package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SilentAnvil;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Pas de bruit lors de l'utilisation
 */
public class SilentAnvilListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SilentAnvil.KEY_ID);

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        // Note: Empêcher les sons nécessite l'interception d'événements sonores
        // ou l'utilisation de packet manipulation
    }
}
