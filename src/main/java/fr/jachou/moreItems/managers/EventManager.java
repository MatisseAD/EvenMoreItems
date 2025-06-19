package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.listeners.*;
import org.bukkit.plugin.Plugin;

/**
 * Registers event listeners.
 */
public final class EventManager {

    private EventManager() {
    }

    public static void register(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new SpeedBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new JumpBootsListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FireSwordListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new TeleportBowListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new MagnetPickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HealthChestplateListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new XPHelmetListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new FrostWandListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ExplosivePickaxeListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new LightningStickListener(), plugin);
    }
}
