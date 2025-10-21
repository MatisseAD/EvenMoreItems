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
 * Pointeur vers le Stronghold
 */
public class EnderCompass implements CustomItem {
    public static final String KEY_ID = "ender_compass";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public EnderCompass(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.COMPASS)
                .name(MoreItems.getInstance().getLang().get("items.ender_compass.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.ender_compass.description")))
                .customModelData(514)
                .persistentData(key, PersistentDataType.STRING, "ender_compass")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " E ", "   ");
        recipe.setIngredient('C', Material.COMPASS);
        recipe.setIngredient('E', Material.ENDER_EYE);
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
