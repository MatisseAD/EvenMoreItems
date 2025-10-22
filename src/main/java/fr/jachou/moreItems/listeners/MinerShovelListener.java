package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MinerShovel;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Set;

/**
 * Pelle de Mineur - Double la vitesse dans la terre/sable
 * BlockBreakEvent: appliquer Haste I au joueur 3s, augmenter vitesse de casse
 */
public class MinerShovelListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MinerShovel.KEY_ID);
    
    private static final Set<Material> FAST_BLOCKS = Set.of(
        Material.DIRT, Material.COARSE_DIRT, Material.PODZOL, Material.MYCELIUM,
        Material.SAND, Material.RED_SAND, Material.GRAVEL, Material.CLAY,
        Material.SOUL_SAND, Material.SOUL_SOIL
    );

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        if (FAST_BLOCKS.contains(event.getBlock().getType())) {
            // Appliquer Haste I pendant 3 secondes
            player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 60, 0, false, false));
        }
    }
}
