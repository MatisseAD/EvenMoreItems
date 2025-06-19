package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.JumpBoots;
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
 * Gives players jump boost when wearing JumpBoots.
 */
public class JumpBootsListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), JumpBoots.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack boots = player.getInventory().getBoots();

        boolean wearing = boots != null && boots.hasItemMeta() &&
                boots.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING);

        if (wearing) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 40, 1, true, false));
        } else if (player.hasPotionEffect(PotionEffectType.JUMP_BOOST)) {
            player.removePotionEffect(PotionEffectType.JUMP_BOOST);
        }
    }
}
