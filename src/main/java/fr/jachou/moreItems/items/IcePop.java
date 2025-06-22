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
 * Restores a heart and applies slowness when eaten.
 */
public class IcePop implements CustomItem {
    public static final String KEY_ID = "ice_pop";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public IcePop(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SNOWBALL)
                .name(MoreItems.getInstance().getLang().get("items.icePop.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.icePop.description")))
                .persistentData(key, PersistentDataType.STRING, "ice")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("B", "S", " ");
        recipe.setIngredient('B', Material.SWEET_BERRIES);
        recipe.setIngredient('S', Material.STICK);
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
