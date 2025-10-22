package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.DoubleFurnace;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Fait fondre 2x plus vite
 */
public class DoubleFurnaceListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), DoubleFurnace.KEY_ID);

    @EventHandler
    public void onSmelt(FurnaceSmeltEvent event) {
        // Note: Diviser le temps de cuisson nécessite manipulation du cook time
        // Peut nécessiter un scheduler pour vérifier périodiquement
    }
}
