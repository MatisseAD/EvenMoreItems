package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.EnderCompass;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Pointeur vers le Stronghold
 */
public class EnderCompassListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), EnderCompass.KEY_ID);

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
        
        // Trouver le stronghold le plus proche
        Location stronghold = player.getWorld().locateNearestStructure(
            player.getLocation(),
            org.bukkit.generator.structure.StructureType.STRONGHOLD,
            100,
            false
        );
        
        if (stronghold != null) {
            // Définir la cible de la boussole
            player.setCompassTarget(stronghold);
            
            // Afficher la direction
            double distance = player.getLocation().distance(stronghold);
            player.sendActionBar(Component.text(String.format("§aStronghold trouvé! Distance: %.0f blocs", distance)));
        } else {
            player.sendActionBar(Component.text("§cAucun Stronghold trouvé à proximité"));
        }
    }
}
