package fr.jachou.moreItems.items;

import org.bukkit.Material;

/**
 * Categories used to group custom items in the GUI.
 */
public enum ItemCategory {
    TOOLS(Material.DIAMOND_PICKAXE, "Tools"),
    COMBAT(Material.DIAMOND_SWORD, "Combat"),
    ARMOR(Material.DIAMOND_CHESTPLATE, "Armor"),
    UTILITY(Material.CHEST, "Utility"),
    FOOD(Material.COOKED_BEEF, "Food");

    private final Material icon;
    private final String display;

    ItemCategory(Material icon, String display) {
        this.icon = icon;
        this.display = display;
    }

    public Material getIcon() {
        return icon;
    }

    public String getDisplay() {
        return display;
    }
}
