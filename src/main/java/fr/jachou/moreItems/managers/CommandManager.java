package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.commands.MoreItemsCommand;
import org.bukkit.plugin.Plugin;

/**
 * Handles command registration.
 */
public final class CommandManager {

    private CommandManager() {
    }

    public static void register(Plugin plugin) {
        plugin.getCommand("moreitems").setExecutor(new MoreItemsCommand());
    }
}
