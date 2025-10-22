package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.VillageBread;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Nourrit 2x plus
 */
public class VillageBreadListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), VillageBread.KEY_ID);

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        Player player = event.getPlayer();
        // Ajouter 6 points de faim supplémentaires
        int currentFood = player.getFoodLevel();
        player.setFoodLevel(Math.min(20, currentFood + 6));
        player.setSaturation(player.getSaturation() + 3.0f);
    }
}
