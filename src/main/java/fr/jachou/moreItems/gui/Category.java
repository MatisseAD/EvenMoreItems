package fr.jachou.moreItems.gui;

import fr.jachou.moreItems.MoreItems;

/**
 * Simple item categories for GUI organisation.
 */
public enum Category {
    ARMOR("categories.ARMOR"),
    WEAPON("categories.WEAPON"),
    TOOL("categories.TOOL"),
    UTILITY("categories.UTILITY");

    private final String key;

    Category(String key) {
        this.key = key;
    }

    public String getDisplay() {
        return MoreItems.getInstance().getLang().get(key);
    }
}
