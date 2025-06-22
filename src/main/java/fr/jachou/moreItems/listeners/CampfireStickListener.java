package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.CampfireStick;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Places a campfire when right-clicking a block.
 */
public class CampfireStickListener implements Listener {
    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), CampfireStick.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND || event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        Block block = event.getClickedBlock().getRelative(event.getBlockFace());
        if (block.isEmpty()) {
            block.setType(Material.CAMPFIRE);
            if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1); else event.getPlayer().getInventory().removeItem(item);
        }
        event.setCancelled(true);
    }
}
