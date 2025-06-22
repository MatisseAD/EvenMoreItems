package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Registers custom crafting recipes for all items.
 */
public final class RecipeManager {

    private static final Map<NamespacedKey, ShapedRecipe> RECIPES = new HashMap<>();
    private static Plugin plugin;

    private RecipeManager() {
    }

    public static void init(Plugin pl) {
        plugin = pl;
        for (CustomItem item : ItemManager.all()) {
            ShapedRecipe recipe = item.getRecipe();
            if (recipe != null) {
                register(item, recipe);
            }
        }
    }

    private static void register(CustomItem item, ShapedRecipe recipe) {
        RECIPES.put(item.getKey(), recipe);
        plugin.getServer().addRecipe(recipe);
    }

    public static ShapedRecipe get(CustomItem item) {
        return RECIPES.get(item.getKey());
    }

    public static void update(CustomItem item, ShapedRecipe recipe) {
        plugin.getServer().removeRecipe(item.getKey());
        register(item, recipe);
    }
}
