package fr.jachou.moreItems;

import fr.jachou.moreItems.managers.CommandManager;
import fr.jachou.moreItems.managers.EventManager;
import fr.jachou.moreItems.managers.ItemManager;
import fr.jachou.moreItems.managers.RecipeManager;
import fr.jachou.moreItems.utils.Lang;
import fr.jachou.moreItems.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin entry point.
 */
public final class MoreItems extends JavaPlugin {

    private static MoreItems instance;
    private Lang lang;

    public static MoreItems getInstance() {
        return instance;
    }

    public Lang getLang() {
        return lang;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;

        // language system
        lang = new Lang(this);

        // optional metrics
        new Metrics(this, 25587);

        // initialise managers
        ItemManager.init(this);
        RecipeManager.init(this);

        CommandManager.register(this);
        EventManager.register(this);
    }

    @Override
    public void onDisable() {
        // Nothing to clean up for now
    }
}
