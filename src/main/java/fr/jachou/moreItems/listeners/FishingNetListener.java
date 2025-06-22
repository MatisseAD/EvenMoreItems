package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FishingNet;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Spawns fish when the thrown net lands in water.
 */
public class FishingNetListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FishingNet.KEY_ID);

    @EventHandler
    public void onThrow(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        Player player = event.getPlayer();
        player.launchProjectile(FishHook.class).getPersistentDataContainer().set(key, PersistentDataType.STRING, "net");
        if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1); else player.getInventory().removeItem(item);
        event.setCancelled(true);
    }

    @EventHandler
    public void onLand(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof FishHook hook)) return;
        if (!hook.getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        if (hook.getLocation().getBlock().getType() == Material.WATER) {
            int amount = ThreadLocalRandom.current().nextInt(3, 7);
            hook.getWorld().dropItem(hook.getLocation(), new ItemStack(Material.COD, amount)).setVelocity(new Vector());
        }
        hook.remove();
    }
}
