package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.StoneHammer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

/**
 * Marteau de Pierre - Casse 3x3 blocs de pierre
 * BlockBreakEvent: casser les 8 blocs adjacents (rayon 1) avec drops, consommer durabilité 9×
 */
public class StoneHammerListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), StoneHammer.KEY_ID);
    
    private static final Set<Material> STONE_TYPES = Set.of(
        Material.STONE, Material.COBBLESTONE, Material.ANDESITE, Material.DIORITE,
        Material.GRANITE, Material.DEEPSLATE, Material.COBBLED_DEEPSLATE,
        Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS
    );

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Block centerBlock = event.getBlock();
        if (!STONE_TYPES.contains(centerBlock.getType())) {
            return;
        }
        
        // Casser les 8 blocs adjacents (rayon 1)
        int brokenBlocks = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && y == 0 && z == 0) continue; // Skip center block
                    
                    Block block = centerBlock.getRelative(x, y, z);
                    if (STONE_TYPES.contains(block.getType())) {
                        block.breakNaturally(item);
                        brokenBlocks++;
                    }
                }
            }
        }
        
        // Consommer durabilité proportionnellement (1 + nombre de blocs supplémentaires cassés)
        if (brokenBlocks > 0 && item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(damageable.getDamage() + brokenBlocks);
            item.setItemMeta(damageable);
        }
    }
}
