package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.IvyWall;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

/**
 * Mur végétalisé
 */
public class IvyWallListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), IvyWall.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock();
        
        // Vérifier si le joueur est contre un mur de lierre (utiliser vines comme proxy)
        if (block.getType() == Material.VINE || 
            block.getRelative(0, 1, 0).getType() == Material.VINE) {
            
            // Permettre au joueur de grimper
            if (player.isSneaking()) {
                Vector velocity = player.getVelocity();
                velocity.setY(0); // Rester en place
                player.setVelocity(velocity);
            } else if (player.isJumping() || player.getLocation().getPitch() < -45) {
                Vector velocity = player.getVelocity();
                velocity.setY(0.2); // Monter lentement
                player.setVelocity(velocity);
            }
        }
    }
}
