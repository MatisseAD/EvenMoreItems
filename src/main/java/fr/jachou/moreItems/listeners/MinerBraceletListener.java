package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.MinerBracelet;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Augmente vitesse minage
 */
public class MinerBraceletListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), MinerBracelet.KEY_ID);

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack newItem = player.getInventory().getItem(event.getNewSlot());
        ItemStack oldItem = player.getInventory().getItem(event.getPreviousSlot());
        
        // Vérifier si le bracelet est tenu
        boolean hasNew = newItem != null && newItem.hasItemMeta() &&
                        newItem.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);
        boolean hadOld = oldItem != null && oldItem.hasItemMeta() &&
                        oldItem.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);
        
        if (hasNew) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, Integer.MAX_VALUE, 0, false, false));
        } else if (hadOld) {
            player.removePotionEffect(PotionEffectType.HASTE);
        }
    }
}
