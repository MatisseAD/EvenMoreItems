package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SelectiveDynamite;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Spawns TNT that only breaks selected block types.
 */
public class SelectiveDynamiteListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SelectiveDynamite.KEY_ID);

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        Material target = event.getClickedBlock() != null ? event.getClickedBlock().getType() : Material.STONE;
        Location spawn = event.getClickedBlock() != null ? event.getClickedBlock().getLocation().add(0.5, 1, 0.5) : event.getPlayer().getLocation();
        TNTPrimed tnt = (TNTPrimed) spawn.getWorld().spawnEntity(spawn, EntityType.TNT);
        tnt.getPersistentDataContainer().set(key, PersistentDataType.STRING, target.name());
        if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1); else event.getPlayer().getInventory().removeItem(item);
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        if (!(event.getEntity() instanceof TNTPrimed tnt)) return;
        String type = tnt.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        if (type == null) return;
        Material mat = Material.matchMaterial(type);
        event.blockList().removeIf(b -> b.getType() != mat);
    }
}
