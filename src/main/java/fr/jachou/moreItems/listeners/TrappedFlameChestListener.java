package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.TrappedFlameChest;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataType;

/**
 * Explose à l'ouverture
 */
public class TrappedFlameChestListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), TrappedFlameChest.KEY_ID);

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (!(event.getPlayer() instanceof Player player)) {
            return;
        }
        
        Inventory inventory = event.getInventory();
        
        // Vérifier si c'est un coffre piégé à flammes
        // Note: nécessite PDC sur le bloc du coffre
        if (!player.isSneaking() && inventory.getHolder() != null) {
            // Déclencher explosion contrôlée
            player.getWorld().createExplosion(
                player.getLocation(), 
                2.0f, // puissance
                false, // ne pas casser les blocs
                false  // ne pas causer de feu
            );
            
            // Enflammer les entités proches
            player.setFireTicks(60);
        }
    }
}
