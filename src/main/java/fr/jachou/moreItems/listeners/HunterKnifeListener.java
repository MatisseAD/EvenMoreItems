package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.HunterKnife;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Couteau de Chasseur - Double le loot des animaux
 * EntityDeathEvent: multiplier drops ×2
 */
public class HunterKnifeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), HunterKnife.KEY_ID);

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        
        // Vérifier que c'est un animal passif
        if (!(entity instanceof Animals)) {
            return;
        }
        
        // Vérifier que le tueur est un joueur avec le couteau
        if (!(entity.getKiller() instanceof Player killer)) {
            return;
        }
        
        ItemStack item = killer.getInventory().getItemInMainHand();
        if (!item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        // Doubler les drops
        List<ItemStack> drops = new ArrayList<>(event.getDrops());
        for (ItemStack drop : drops) {
            event.getDrops().add(drop.clone());
        }
    }
}
