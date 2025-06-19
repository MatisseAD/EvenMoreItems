package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.XPHelmet;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Doubles experience gained while wearing the helmet.
 */
public class XPHelmetListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), XPHelmet.KEY_ID);

    @EventHandler
    public void onExp(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.hasItemMeta() && helmet.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            event.setAmount(event.getAmount() * 2);
        }
    }
}
