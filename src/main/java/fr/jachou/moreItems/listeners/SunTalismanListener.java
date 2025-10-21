package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.SunTalisman;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

/**
 * Supprime la pluie
 */
public class SunTalismanListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), SunTalisman.KEY_ID);
    private static long lastGlobalUse = 0;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (!event.getAction().isRightClick()) return;
        
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        
        if (item == null || !item.hasItemMeta() ||
            !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            return;
        }
        
        event.setCancelled(true);
        
        // Vérifier cooldown global (5 minutes)
        long currentTime = System.currentTimeMillis();
        long cooldownRemaining = 300000 - (currentTime - lastGlobalUse);
        
        if (cooldownRemaining > 0) {
            player.sendActionBar(Component.text("§cCooldown global: " + (cooldownRemaining / 1000) + "s"));
            return;
        }
        
        // Arrêter la pluie
        player.getWorld().setStorm(false);
        player.getWorld().setThundering(false);
        player.sendActionBar(Component.text("§6Talisman du Soleil activé!"));
        lastGlobalUse = currentTime;
    }
}
