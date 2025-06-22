package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

/**
 * Registers custom crafting recipes for all items.
 */
public final class RecipeManager {

    private static Plugin plugin;
    private static final java.util.Map<CustomItem, Material[]> RECIPES = new java.util.HashMap<>();

    private RecipeManager() {}

    public static void init(Plugin pl) {
        plugin = pl;
        load();
        for (CustomItem item : ItemManager.all()) {
            Material[] mats = RECIPES.get(item);
            if (mats == null) {
                mats = fromRecipe(item.getRecipe());
                RECIPES.put(item, mats);
            }
            apply(item, mats);
        }
    }

    private static void load() {
        for (CustomItem item : ItemManager.all()) {
            String base = "recipes." + item.getKey().getKey() + ".";
            if (plugin.getConfig().isSet(base + "0")) {
                Material[] mats = new Material[9];
                for (int i = 0; i < 9; i++) {
                    String m = plugin.getConfig().getString(base + i, "AIR");
                    mats[i] = Material.matchMaterial(m);
                }
                RECIPES.put(item, mats);
            }
        }
    }

    private static Material[] fromRecipe(ShapedRecipe recipe) {
        Material[] mats = new Material[9];
        if (recipe == null) return mats;
        java.util.Map<Character, org.bukkit.inventory.RecipeChoice> map = recipe.getChoiceMap();
        String[] shape = recipe.getShape();
        int index = 0;
        for (String row : shape) {
            for (char c : row.toCharArray()) {
                org.bukkit.inventory.RecipeChoice choice = map.get(c);
                if (choice instanceof org.bukkit.inventory.recipe.MaterialChoice mc) {
                    mats[index] = mc.getChoices().get(0);
                } else {
                    mats[index] = Material.AIR;
                }
                index++;
            }
        }
        return mats;
    }

    private static void apply(CustomItem item, Material[] mats) {
        if (plugin == null) return;
        plugin.getServer().removeRecipe(item.getKey());
        ShapedRecipe recipe = new ShapedRecipe(item.getKey(), item.getItem());
        recipe.shape("ABC", "DEF", "GHI");
        char[] keys = {'A','B','C','D','E','F','G','H','I'};
        for (int i=0;i<9;i++) {
            if (mats[i] != null && mats[i] != Material.AIR) {
                recipe.setIngredient(keys[i], mats[i]);
            }
        }
        plugin.getServer().addRecipe(recipe);
    }

    public static void saveRecipe(CustomItem item, Material[] mats) {
        RECIPES.put(item, mats);
        String base = "recipes." + item.getKey().getKey() + ".";
        for (int i = 0; i < 9; i++) {
            plugin.getConfig().set(base + i, mats[i] == null ? Material.AIR.name() : mats[i].name());
        }
        plugin.saveConfig();
        apply(item, mats);
    }

    public static Material[] getRecipe(CustomItem item) {
        return RECIPES.getOrDefault(item, new Material[9]);
    }
}
