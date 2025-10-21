package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.LumberjackAxe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

/**
 * Hache de Bûcheron - Coupe les arbres entiers
 * BlockBreakEvent: BFS/DFS vers logs connectées, briser en cascade (cap 128), consommer durabilité = nb de logs
 */
public class LumberjackAxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), LumberjackAxe.KEY_ID);
    
    private static final Set<Material> LOG_TYPES = Set.of(
        Material.OAK_LOG, Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG,
        Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CHERRY_LOG,
        Material.OAK_WOOD, Material.BIRCH_WOOD, Material.SPRUCE_WOOD, Material.JUNGLE_WOOD,
        Material.ACACIA_WOOD, Material.DARK_OAK_WOOD, Material.MANGROVE_WOOD, Material.CHERRY_WOOD
    );

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Block startBlock = event.getBlock();
        if (!LOG_TYPES.contains(startBlock.getType())) {
            return;
        }
        
        // BFS pour trouver tous les logs connectés (max 128)
        Set<Block> visited = new HashSet<>();
        Queue<Block> queue = new LinkedList<>();
        queue.add(startBlock);
        visited.add(startBlock);
        
        int logsBroken = 0;
        while (!queue.isEmpty() && logsBroken < 128) {
            Block current = queue.poll();
            
            // Vérifier les 26 blocs adjacents
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 && y == 0 && z == 0) continue;
                        
                        Block adjacent = current.getRelative(x, y, z);
                        if (!visited.contains(adjacent) && LOG_TYPES.contains(adjacent.getType())) {
                            visited.add(adjacent);
                            queue.add(adjacent);
                            
                            if (adjacent != startBlock) {
                                adjacent.breakNaturally(item);
                                logsBroken++;
                            }
                        }
                    }
                }
            }
        }
        
        // Consommer durabilité proportionnellement
        if (logsBroken > 0 && item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(damageable.getDamage() + logsBroken);
            item.setItemMeta(damageable);
        }
    }
}
