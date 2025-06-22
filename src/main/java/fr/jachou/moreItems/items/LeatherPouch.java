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
 * Pouch that can store up to 64 emeralds.
 */
public class LeatherPouch implements CustomItem {
    public static final String KEY_ID = "leather_pouch";
    public static final String COUNT_TAG = "count";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LeatherPouch(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BUNDLE)
                .name(MoreItems.getInstance().getLang().get("items.leatherPouch.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.leatherPouch.description")))
                .persistentData(key, PersistentDataType.INTEGER, 0)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("CLC", "LAL", "CLC");
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('L', Material.STRING);
        recipe.setIngredient('A', Material.EMERALD);
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
