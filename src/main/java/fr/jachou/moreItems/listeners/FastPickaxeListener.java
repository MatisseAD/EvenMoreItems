package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FastPickaxe;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Pioche Rapide - Efficacité temporaire
 * PlayerInteractEvent: appliquer Haste II 10s + cooldown 60s
 */
public class FastPickaxeListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FastPickaxe.KEY_ID);
    private final NamespacedKey cooldownKey = new NamespacedKey(MoreItems.getInstance(), "fast_pickaxe_cooldown");

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
        
        // Vérifier le cooldown
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        long currentTime = System.currentTimeMillis();
        
        if (pdc.has(cooldownKey, PersistentDataType.LONG)) {
            long lastUse = pdc.get(cooldownKey, PersistentDataType.LONG);
            long cooldownRemaining = 60000 - (currentTime - lastUse);
            
            if (cooldownRemaining > 0) {
                player.sendActionBar(Component.text("§cCooldown: " + (cooldownRemaining / 1000) + "s"));
                return;
            }
        }
        
        // Appliquer Haste II pendant 10 secondes
        player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 200, 1, false, true));
        player.sendActionBar(Component.text("§aHaste II activé!"));
        
        // Définir le cooldown
        pdc.set(cooldownKey, PersistentDataType.LONG, currentTime);
    }
}
