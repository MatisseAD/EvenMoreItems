package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.listeners.SpeedBootsEvent;
import org.bukkit.plugin.Plugin;

public class EventManagers {

    public static void registerEvents(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new SpeedBootsEvent(), plugin);
    }

}
