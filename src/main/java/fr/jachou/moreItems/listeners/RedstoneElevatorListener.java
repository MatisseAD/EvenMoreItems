package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.RedstoneElevator;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

/**
 * Monte/descend automatiquement
 */
public class RedstoneElevatorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), RedstoneElevator.KEY_ID);

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (event.getClickedBlock() == null) return;
        
        Player player = event.getPlayer();
        
        // Vérifier si clic sur bloc d'ascenseur (pressure plate ou button)
        if (event.getClickedBlock().getType() == Material.STONE_PRESSURE_PLATE ||
            event.getClickedBlock().getType().name().contains("BUTTON")) {
            
            // Chercher autres plateformes verticalement
            Location current = player.getLocation();
            Location up = null, down = null;
            
            // Chercher vers le haut
            for (int y = 1; y <= 10; y++) {
                Location check = current.clone().add(0, y, 0);
                if (check.getBlock().getType() == Material.STONE_PRESSURE_PLATE) {
                    up = check;
                    break;
                }
            }
            
            // Chercher vers le bas
            for (int y = 1; y <= 10; y++) {
                Location check = current.clone().subtract(0, y, 0);
                if (check.getBlock().getType() == Material.STONE_PRESSURE_PLATE) {
                    down = check;
                    break;
                }
            }
            
            // Téléporter selon le shift
            if (player.isSneaking() && down != null) {
                player.teleport(down.add(0, 1, 0));
                player.sendActionBar(Component.text("§aDescendu!"));
            } else if (!player.isSneaking() && up != null) {
                player.teleport(up.add(0, 1, 0));
                player.sendActionBar(Component.text("§aMonté!"));
            }
        }
    }
}
