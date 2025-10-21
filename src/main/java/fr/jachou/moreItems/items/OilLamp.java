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
 * Source de lumière portable
 */
public class OilLamp implements CustomItem {
    public static final String KEY_ID = "oil_lamp";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public OilLamp(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LANTERN)
                .name(MoreItems.getInstance().getLang().get("items.oil_lamp.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.oil_lamp.description")))
                .customModelData(203)
                .persistentData(key, PersistentDataType.STRING, "oil_lamp")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", " B ", "   ");
        recipe.setIngredient('L', Material.LANTERN);
        recipe.setIngredient('B', Material.LAVA_BUCKET);
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
