package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FoliageAxe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;

/**
 * Hache de Feuillage - Coupe les feuilles instantanément
 * BlockBreakEvent: instant break leaves, -1 durabilité par feuille
 */
public class FoliageAxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FoliageAxe.KEY_ID);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Block block = event.getBlock();
        String typeName = block.getType().name();
        
        if (typeName.endsWith("_LEAVES")) {
            // Les feuilles se cassent instantanément (déjà le cas avec une hache)
            // Consommer durabilité
            if (item.getItemMeta() instanceof Damageable damageable) {
                damageable.setDamage(damageable.getDamage() + 1);
                item.setItemMeta(damageable);
            }
        }
    }
}
