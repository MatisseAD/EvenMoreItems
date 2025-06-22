package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MasonHammer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Converts stone blocks to their polished variant on right click.
 */
public class MasonHammerListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MasonHammer.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        Block block = event.getClickedBlock();
        if (block == null) return;
        Material newMat = switch (block.getType()) {
            case STONE -> Material.POLISHED_ANDESITE;
            case COBBLESTONE -> Material.MOSSY_COBBLESTONE;
            case STONE_BRICKS -> Material.POLISHED_DIORITE;
            default -> null;
        };
        if (newMat != null) {
            block.setType(newMat);
            event.setCancelled(true);
        }
    }
}
