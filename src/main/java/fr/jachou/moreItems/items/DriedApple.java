package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import fr.jachou.moreItems.items.ItemCategory;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Simple dried apple snack.
 */
public class DriedApple implements CustomItem {
    public static final String KEY_ID = "dried_apple";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public DriedApple(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.APPLE)
                .name(MoreItems.getInstance().getLang().get("items.driedApple.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.driedApple.description")))
                .persistentData(key, PersistentDataType.STRING, "apple")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("A", "S", " ");
        recipe.setIngredient('A', Material.APPLE);
        recipe.setIngredient('S', Material.SMOKER);
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public ItemStack getItem() {
        return item.clone();
    }

    @Override
    public ShapedRecipe getRecipe() {
        return recipe;
    }

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.FOOD;
    }
}
