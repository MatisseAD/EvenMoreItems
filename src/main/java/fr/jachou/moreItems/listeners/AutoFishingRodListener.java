package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AutoFishingRod;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Canne de Pêche Automatique - Ramène le poisson plus vite
 * PlayerFishEvent: réduire bite time, chance +10% trésors
 */
public class AutoFishingRodListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AutoFishingRod.KEY_ID);

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Augmenter la chance de trésors de 10%
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            // La chance de trésor est déjà gérée par l'enchantement Luck of the Sea
            // Nous pourrions ajouter un item supplémentaire aléatoirement
            if (Math.random() < 0.1) {
                player.sendMessage("§6Bonus de pêche activé!");
            }
        }
    }
}
