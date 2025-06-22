package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SandWand;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Converts clicked blocks to sand when using the SandWand.
 */
public class SandWandListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SandWand.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() != Material.AIR) {
                block.setType(Material.SAND);
            }
        }
    }
}
