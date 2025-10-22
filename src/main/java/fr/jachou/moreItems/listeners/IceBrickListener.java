package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.IceBrick;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.persistence.PersistentDataType;

/**
 * Ne fond pas
 */
public class IceBrickListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), IceBrick.KEY_ID);

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        // Empêcher la glace spéciale de fondre (utiliser packed ice comme proxy)
        if (event.getBlock().getType() == Material.PACKED_ICE ||
            event.getBlock().getType() == Material.BLUE_ICE) {
            event.setCancelled(true);
        }
    }
}
