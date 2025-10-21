package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CodeChest;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Coffre à Code - Coffre verrouillable avec mot de passe
 */
public class CodeChestListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CodeChest.KEY_ID);

    // Note: Implémentation complexe nécessitant GUI et PDC sur les blocs
    // À implémenter selon les besoins spécifiques du serveur
}
