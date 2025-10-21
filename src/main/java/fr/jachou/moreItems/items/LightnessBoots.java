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
 * Réduit les dégâts de chute
 */
public class LightnessBoots implements CustomItem {
    public static final String KEY_ID = "lightness_boots";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LightnessBoots(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEATHER_BOOTS)
                .name(MoreItems.getInstance().getLang().get("items.lightness_boots.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.lightness_boots.description")))
                .customModelData(503)
                .persistentData(key, PersistentDataType.STRING, "lightness_boots")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" B ", " F ", "   ");
        recipe.setIngredient('B', Material.LEATHER_BOOTS);
        recipe.setIngredient('F', Material.FEATHER);
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
