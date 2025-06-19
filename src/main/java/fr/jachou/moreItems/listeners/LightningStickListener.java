package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LightningStick;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Summons lightning at the targeted block when used.
 */
public class LightningStickListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LightningStick.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            if (event.getClickedBlock() != null) {
                player.getWorld().strikeLightning(event.getClickedBlock().getLocation());
            } else {
                player.getWorld().strikeLightning(player.getTargetBlockExact(50).getLocation());
            }
        }
    }
}
