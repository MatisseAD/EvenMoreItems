package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.PowerGlove;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

/**
 * Gant de Force - Casse instantanément les blocs faibles
 * BlockBreakEvent: instant break pour verre, feuilles, laine
 */
public class PowerGloveListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), PowerGlove.KEY_ID);
    
    private static final Set<Material> FRAGILE_BLOCKS = Set.of(
        Material.GLASS, Material.GLASS_PANE, Material.WHITE_STAINED_GLASS, Material.ORANGE_STAINED_GLASS,
        Material.MAGENTA_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.YELLOW_STAINED_GLASS,
        Material.LIME_STAINED_GLASS, Material.PINK_STAINED_GLASS, Material.GRAY_STAINED_GLASS,
        Material.LIGHT_GRAY_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.PURPLE_STAINED_GLASS,
        Material.BLUE_STAINED_GLASS, Material.BROWN_STAINED_GLASS, Material.GREEN_STAINED_GLASS,
        Material.RED_STAINED_GLASS, Material.BLACK_STAINED_GLASS,
        Material.OAK_LEAVES, Material.BIRCH_LEAVES, Material.SPRUCE_LEAVES, Material.JUNGLE_LEAVES,
        Material.ACACIA_LEAVES, Material.DARK_OAK_LEAVES, Material.MANGROVE_LEAVES, Material.CHERRY_LEAVES,
        Material.WHITE_WOOL, Material.ORANGE_WOOL, Material.MAGENTA_WOOL, Material.LIGHT_BLUE_WOOL,
        Material.YELLOW_WOOL, Material.LIME_WOOL, Material.PINK_WOOL, Material.GRAY_WOOL,
        Material.LIGHT_GRAY_WOOL, Material.CYAN_WOOL, Material.PURPLE_WOOL, Material.BLUE_WOOL,
        Material.BROWN_WOOL, Material.GREEN_WOOL, Material.RED_WOOL, Material.BLACK_WOOL
    );

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Block block = event.getBlock();
        if (FRAGILE_BLOCKS.contains(block.getType())) {
            // Le bloc se casse instantanément (pas besoin de modifier l'événement)
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
        }
    }
}
