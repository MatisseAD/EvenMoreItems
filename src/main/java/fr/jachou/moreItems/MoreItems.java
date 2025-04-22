package fr.jachou.moreItems;

import fr.jachou.moreItems.managers.CommandManagers;
import fr.jachou.moreItems.managers.EventManagers;
import fr.jachou.moreItems.utils.Lang;
import fr.jachou.moreItems.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreItems extends JavaPlugin {

    private static MoreItems instance;
    public static Lang lang;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveConfig();

        // Initialize instance
        instance = this;

        // Initialize language
        lang = new Lang(this);

        int pluginID = 25587;
        Metrics metrics = new Metrics(this, pluginID);

        // Register commands
        CommandManagers.registerCommands(this);

        // Register events
        EventManagers.registerEvents(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MoreItems getInstance() {
        return instance;
    }
}
