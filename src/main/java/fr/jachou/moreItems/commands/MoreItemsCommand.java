package fr.jachou.moreItems.commands;

import fr.jachou.moreItems.managers.ItemManager;
import fr.jachou.moreItems.items.CustomItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Simple command to give custom items.
 */
public class MoreItemsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }

        if (args.length < 2 || !args[0].equalsIgnoreCase("get")) {
            player.sendMessage("Usage: /moreitems get <id>");
            return true;
        }

        String id = args[1].toLowerCase();
        for (CustomItem item : ItemManager.all()) {
            if (item.getKey().getKey().equalsIgnoreCase(id)) {
                player.getInventory().addItem(item.getItem());
                player.sendMessage("You received " + id + ".");
                return true;
            }
        }

        player.sendMessage("Unknown item: " + id);
        return true;
    }
}
