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
 * Rend 8 points de faim
 */
public class SteakSandwich implements CustomItem {
    public static final String KEY_ID = "steak_sandwich";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SteakSandwich(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BREAD)
                .name(MoreItems.getInstance().getLang().get("items.steak_sandwich.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.steak_sandwich.description")))
                .customModelData(300)
                .persistentData(key, PersistentDataType.STRING, "steak_sandwich")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" B ", " S ", "   ");
        recipe.setIngredient('B', Material.BREAD);
        recipe.setIngredient('S', Material.COOKED_BEEF);
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
