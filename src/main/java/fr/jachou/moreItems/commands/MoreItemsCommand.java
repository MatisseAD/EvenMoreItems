package fr.jachou.moreItems.commands;

import fr.jachou.moreItems.managers.ItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MoreItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String @NotNull [] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {return false;}

            switch (args[0].toLowerCase()) {
                case "get":
                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("speedBoots")) {
                            player.getInventory().addItem(ItemsManager.speedBoots());
                        }
                    } else {
                        player.sendMessage("§cUsage: /moreitems get <item>");
                    }
                    break;
            }
        } else {
            sender.sendMessage("§cThis command can only be used by players.");
        }

        return true;
    }
}
