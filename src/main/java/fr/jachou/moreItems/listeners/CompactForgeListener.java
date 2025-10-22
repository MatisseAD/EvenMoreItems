package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CompactForge;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Fait fondre les métaux sans charbon (avec lave)
 */
public class CompactForgeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CompactForge.KEY_ID);

    @EventHandler
    public void onBurn(FurnaceBurnEvent event) {
        // Note: Double efficacité si carburant = seau de lave
        // Nécessite vérification du type de carburant et ajustement du burn time
    }
}
