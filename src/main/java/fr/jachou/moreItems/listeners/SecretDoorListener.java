package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SecretDoor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Invisible quand fermée
 */
public class SecretDoorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SecretDoor.KEY_ID);

    // Note: Implémentation complexe nécessitant manipulation de packet pour camouflage
    // À implémenter selon les besoins spécifiques du serveur
}
