package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.InvisibilityHood;
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
 * Grants invisibility while wearing the hood.
 */
public class InvisibilityHoodListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), InvisibilityHood.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        boolean wearing = helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);
        if (wearing) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 40, 0, true, false));
        } else if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }
}
