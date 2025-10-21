package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Régénère la faim sur la durée
 */
public class SpicyHoney implements CustomItem {
    public static final String KEY_ID = "spicy_honey";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SpicyHoney(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.HONEY_BOTTLE)
                .name(MoreItems.getInstance().getLang().get("items.spicy_honey.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.spicy_honey.description")))
                .customModelData(312)
                .persistentData(key, PersistentDataType.STRING, "spicy_honey")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" H ", " B ", "   ");
        recipe.setIngredient('H', Material.HONEY_BOTTLE);
        recipe.setIngredient('B', Material.SWEET_BERRIES);
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
}
