package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ExplosivePickaxe;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Creates a small explosion when breaking blocks with the pickaxe.
 */
public class ExplosivePickaxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ExplosivePickaxe.KEY_ID);

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            player.getWorld().createExplosion(event.getBlock().getLocation(), 2f, false, false, player);
        }
    }
}
