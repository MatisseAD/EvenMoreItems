package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.WindCape;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Vitesse + saut
 */
public class WindCapeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), WindCape.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack chestplate = player.getInventory().getChestplate();
        
        if (chestplate != null && chestplate.hasItemMeta() &&
            chestplate.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            
            // Ne pas appliquer en vol (Elytra)
            if (!player.isGliding()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 60, 0, false, false));
            }
        }
    }
}
