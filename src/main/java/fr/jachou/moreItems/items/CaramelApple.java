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
 * Restaure la vie instantanément
 */
public class CaramelApple implements CustomItem {
    public static final String KEY_ID = "caramel_apple";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CaramelApple(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.APPLE)
                .name(MoreItems.getInstance().getLang().get("items.caramel_apple.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.caramel_apple.description")))
                .customModelData(306)
                .persistentData(key, PersistentDataType.STRING, "caramel_apple")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" A ", " S ", " H ");
        recipe.setIngredient('A', Material.APPLE);
        recipe.setIngredient('S', Material.SUGAR);
        recipe.setIngredient('H', Material.HONEY_BOTTLE);
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
