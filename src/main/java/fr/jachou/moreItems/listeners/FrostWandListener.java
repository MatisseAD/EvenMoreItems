package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.FrostWand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class FrostWandListener implements Listener {

    private final NamespacedKey key = new NamespacedKey(MoreItems.getInstance(), FrostWand.KEY_ID);

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            freezeAround(player.getLocation());
        }
    }

    private void freezeAround(Location center) {
        int radius = 2;
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                Location loc = center.clone().add(x, -1, z);
                if (loc.getBlock().getType() == Material.WATER && loc.clone().add(0, 1, 0).getBlock().isEmpty()) {
                    Block block = loc.getBlock();
                    block.setType(Material.FROSTED_ICE);
                    Bukkit.getScheduler().runTaskLater(MoreItems.getInstance(), () -> {
                        if (block.getType() == Material.FROSTED_ICE) {
                            block.setType(Material.WATER);
                        }
                    }, 60L);
                }
    public void onUse(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.hasItemMeta() && item.getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            Block block = event.getClickedBlock();
            if (block != null && block.getType() == Material.WATER) {
                block.setType(Material.ICE);
            }
        }
    }
}
