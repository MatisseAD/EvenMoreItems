package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.KitchenKnife;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;

/**
 * Couteau de Cuisine - Coupe la nourriture crue sans four
 * PlayerInteractEvent: convertir en version cuite
 */
public class KitchenKnifeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), KitchenKnife.KEY_ID);
    
    private static final Map<Material, Material> COOKING_MAP = Map.of(
        Material.PORKCHOP, Material.COOKED_PORKCHOP,
        Material.BEEF, Material.COOKED_BEEF,
        Material.CHICKEN, Material.COOKED_CHICKEN,
        Material.COD, Material.COOKED_COD,
        Material.SALMON, Material.COOKED_SALMON,
        Material.MUTTON, Material.COOKED_MUTTON,
        Material.RABBIT, Material.COOKED_RABBIT,
        Material.POTATO, Material.BAKED_POTATO,
        Material.KELP, Material.DRIED_KELP
    );

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (!event.getAction().isRightClick()) return;
        
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Vérifier l'item dans l'autre main
        ItemStack offHand = player.getInventory().getItemInOffHand();
        if (offHand.getType() == Material.AIR) return;
        
        Material cookedVersion = COOKING_MAP.get(offHand.getType());
        if (cookedVersion != null) {
            event.setCancelled(true);
            
            // Vérifier si le joueur a du charbon
            boolean hasCoal = player.getInventory().contains(Material.COAL, 1);
            
            if (hasCoal) {
                // Consommer 1 charbon
                player.getInventory().removeItem(new ItemStack(Material.COAL, 1));
                
                // Convertir l'item
                offHand.setType(cookedVersion);
                
                // Effets visuels et sonores
                player.getWorld().spawnParticle(Particle.FLAME, player.getLocation().add(0, 1, 0), 10, 0.5, 0.5, 0.5, 0);
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1.0f, 1.0f);
                player.sendMessage("§aNourriture cuite!");
            } else {
                player.sendMessage("§cVous avez besoin de charbon!");
            }
        }
    }
}
