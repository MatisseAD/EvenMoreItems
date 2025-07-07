package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.AlchemyBackpack;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Simple bag storing potions for each player while online.
 */
public class AlchemyBackpackListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), AlchemyBackpack.KEY_ID);
    private final Map<UUID, Inventory> inventories = new HashMap<>();

    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        ItemStack item = event.getItem();
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;
        event.setCancelled(true);
        Player player = event.getPlayer();
        Inventory inv = inventories.computeIfAbsent(player.getUniqueId(), k -> Bukkit.createInventory(player, 9, "Alchemy Bag"));
        player.openInventory(inv);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Inventory inv = inventories.get(event.getPlayer().getUniqueId());
        if (inv != null && inv.equals(event.getInventory())) {
            // nothing persisted
        }
    }
}
