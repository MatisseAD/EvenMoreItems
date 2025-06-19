package fr.jachou.moreItems.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * Represents an item provided by the plugin.
 */
public interface CustomItem {

    /**
     * Namespaced key used for recipes and PDC storage.
     */
    NamespacedKey getKey();

    /**
     * Base item stack.
     */
    ItemStack getItem();

    /**
     * Optional recipe to craft the item.
     */
    ShapedRecipe getRecipe();
}
