package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MagnetPickaxe;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Sends block drops to the player's inventory.
 */
public class MagnetPickaxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MagnetPickaxe.KEY_ID);

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            event.setDropItems(false);
            Block block = event.getBlock();
            for (ItemStack drop : block.getDrops(item, player)) {
                player.getInventory().addItem(drop);
            }
        }
    }
}
