package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.TemperedObsidianPickaxe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Pioche en Obsidienne Trempée - Durabilité x3, lente mais incassable
 * BlockBreakEvent: empêcher la perte de durabilité, appliquer MiningFatigue I pendant minage, ignorer bedrock
 */
public class TemperedObsidianPickaxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), TemperedObsidianPickaxe.KEY_ID);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Empêcher minage de bedrock
        if (event.getBlock().getType() == Material.BEDROCK) {
            event.setCancelled(true);
            return;
        }
        
        // Appliquer Mining Fatigue I pendant le minage
        player.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 20, 0, false, false));
        
        // Empêcher la perte de durabilité en réinitialisant les dommages
        if (item.getItemMeta() instanceof Damageable damageable) {
            int currentDamage = damageable.getDamage();
            // Réduire fortement la perte de durabilité (diviser par 3)
            if (currentDamage > 0) {
                damageable.setDamage(Math.max(0, currentDamage - 2));
                item.setItemMeta(damageable);
            }
        }
    }
}
