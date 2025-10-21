package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MinerGlove;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Gant de Mineur - Ramasse automatiquement les blocs cassés
 * BlockDropItemEvent: auto-pickup
 */
public class MinerGloveListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MinerGlove.KEY_ID);

    @EventHandler
    public void onBlockDrop(BlockDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Téléporter les items vers l'inventaire du joueur
        for (Item droppedItem : event.getItems()) {
            ItemStack itemStack = droppedItem.getItemStack();
            
            // Essayer d'ajouter à l'inventaire
            if (player.getInventory().firstEmpty() != -1) {
                player.getInventory().addItem(itemStack);
                droppedItem.remove();
            }
            // Si inventaire plein, laisser tomber normalement
        }
    }
}
