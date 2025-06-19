package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

/**
 * Registers custom crafting recipes for all items.
 */
public final class RecipeManager {

    private RecipeManager() {
    }

    public static void init(Plugin plugin) {
        for (CustomItem item : ItemManager.all()) {
            ShapedRecipe recipe = item.getRecipe();
            if (recipe != null) {
                plugin.getServer().addRecipe(recipe);
            }
        }
    }
}
