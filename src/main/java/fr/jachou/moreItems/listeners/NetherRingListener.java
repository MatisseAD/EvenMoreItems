package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.NetherRing;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Immunité au feu 5 s après passage portail
 */
public class NetherRingListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), NetherRing.KEY_ID);

    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        
        // Vérifier si le joueur porte l'anneau
        ItemStack offHand = player.getInventory().getItemInOffHand();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        
        boolean hasRing = (offHand.hasItemMeta() && 
                          offHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) ||
                         (mainHand.hasItemMeta() && 
                          mainHand.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING));
        
        if (hasRing) {
            // Appliquer Fire Resistance pendant 5 secondes
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0, false, true));
            player.sendActionBar(Component.text("§6Anneau du Nether activé!"));
        }
    }
}
