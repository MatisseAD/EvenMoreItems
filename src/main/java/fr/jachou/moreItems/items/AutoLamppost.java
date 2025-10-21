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
 * Allume la nuit
 */
public class AutoLamppost implements CustomItem {
    public static final String KEY_ID = "auto_lamppost";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AutoLamppost(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LANTERN)
                .name(MoreItems.getInstance().getLang().get("items.auto_lamppost.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.auto_lamppost.description")))
                .customModelData(413)
                .persistentData(key, PersistentDataType.STRING, "auto_lamppost")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", " D ", "   ");
        recipe.setIngredient('L', Material.LANTERN);
        recipe.setIngredient('D', Material.DAYLIGHT_DETECTOR);
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
