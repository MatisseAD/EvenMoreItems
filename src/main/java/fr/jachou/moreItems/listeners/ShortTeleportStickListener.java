package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.ShortTeleportStick;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.RayTraceResult;

/**
 * TP sur 10 blocs
 */
public class ShortTeleportStickListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), ShortTeleportStick.KEY_ID);

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (!event.getAction().isRightClick()) return;
        
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        
        if (item == null || !item.hasItemMeta() ||
            !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        event.setCancelled(true);
        
        // Raytrace pour trouver la destination (max 10 blocs)
        RayTraceResult result = player.getWorld().rayTraceBlocks(
            player.getEyeLocation(),
            player.getEyeLocation().getDirection(),
            10.0
        );
        
        if (result != null && result.getHitBlock() != null) {
            Location destination = result.getHitPosition().toLocation(player.getWorld());
            
            // Vérifier que la destination est sûre
            if (destination.getBlock().getType() == Material.AIR) {
                player.teleport(destination);
                player.sendActionBar(Component.text("§aTéléportation réussie!"));
            } else {
                player.sendActionBar(Component.text("§cDestination bloquée!"));
            }
        } else {
            player.sendActionBar(Component.text("§cAucune destination trouvée!"));
        }
    }
}
