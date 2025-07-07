package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.PortalBook;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Handles teleport anchors for the portal book.
 */
public class PortalBookListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), PortalBook.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        var container = item.getItemMeta().getPersistentDataContainer();
        if (event.getPlayer().isSneaking() && event.getClickedBlock() != null) {
            Location loc = event.getClickedBlock().getLocation();
            container.set(key, PersistentDataType.STRING, loc.getWorld().getName()+","+loc.getBlockX()+","+loc.getBlockY()+","+loc.getBlockZ());
            item.setItemMeta(item.getItemMeta());
            return;
        }
        String data = container.get(key, PersistentDataType.STRING);
        if (data == null || !data.contains(",")) return;
        String[] parts = data.split(",");
        World world = event.getPlayer().getServer().getWorld(parts[0]);
        if (world == null) return;
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int z = Integer.parseInt(parts[3]);
        event.getPlayer().teleport(new Location(world, x + 0.5, y + 1, z + 0.5));
    }
}
