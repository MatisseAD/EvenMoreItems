package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.commands.MoreItemsCommand;
import org.bukkit.plugin.Plugin;

public class CommandManagers {

    public static void registerCommands(Plugin plugin) {
        plugin.getServer().getPluginCommand("moreitems").setExecutor(new MoreItemsCommand());
    }

}
