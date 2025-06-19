package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.listeners.SpeedBootsListener;
import org.bukkit.plugin.Plugin;

/**
 * Registers event listeners.
 */
public final class EventManager {

    private EventManager() {
    }

    public static void register(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new SpeedBootsListener(), plugin);
    }
}
