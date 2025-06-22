package fr.jachou.moreItems.gui;

import org.bukkit.ChatColor;

/**
 * Simple item categories for GUI organisation.
 */
public enum Category {
    ARMOR(ChatColor.AQUA + "Armure"),
    WEAPON(ChatColor.RED + "Armes"),
    TOOL(ChatColor.GOLD + "Outils"),
    UTILITY(ChatColor.GREEN + "Divers");

    private final String display;

    Category(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
