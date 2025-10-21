package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ReinforcedGlass;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;

/**
 * Bloc de Verre Renforcé - Résiste à la TNT
 */
public class ReinforcedGlassListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ReinforcedGlass.KEY_ID);

    // TODO: Implement event handlers for ReinforcedGlass
    // Example patterns:
    // - For consumables: @EventHandler public void onConsume(PlayerItemConsumeEvent event)
    // - For wearables: @EventHandler public void onEquip(PlayerMoveEvent event) or similar
    // - For usables: @EventHandler public void onUse(PlayerInteractEvent event)
    // - For blocks: @EventHandler public void onPlace(BlockPlaceEvent event)
    // - For tools: @EventHandler public void onBreak(BlockBreakEvent event)
    //
    // Always check if the item has the key:
    // if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
}
