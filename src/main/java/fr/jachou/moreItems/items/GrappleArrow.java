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
 * Arrow that pulls the shooter to its landing point.
 */
public class GrappleArrow implements CustomItem {
    public static final String KEY_ID = "grapple_arrow";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public GrappleArrow(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.ARROW)
                .name(MoreItems.getInstance().getLang().get("items.grappleArrow.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.grappleArrow.description")))
                .persistentData(key, PersistentDataType.STRING, "grapple")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", "FIF", " B ");
        recipe.setIngredient('L', Material.VINE);
        recipe.setIngredient('I', Material.ARROW);
        recipe.setIngredient('F', Material.STRING);
        recipe.setIngredient('B', Material.STICK);
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
        return ItemCategory.UTILITY;
    }
}
