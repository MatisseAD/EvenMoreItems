package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.RunicFloor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Multiplie la vitesse
 */
public class RunicFloorListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), RunicFloor.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block blockBelow = player.getLocation().subtract(0, 1, 0).getBlock();
        
        // Vérifier si le joueur marche sur un sol runique (utiliser quartz comme proxy)
        if (blockBelow.getType() == Material.QUARTZ_BLOCK) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0, false, false));
            // Particules
            player.getWorld().spawnParticle(Particle.ENCHANT, 
                player.getLocation(), 5, 0.5, 0.1, 0.5, 0);
        }
    }
}
