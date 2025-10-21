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
 * Dure 4 minutes
 */
public class FeatherFallingPotionII implements CustomItem {
    public static final String KEY_ID = "feather_falling_potion_2";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FeatherFallingPotionII(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.POTION)
                .name(MoreItems.getInstance().getLang().get("items.feather_falling_potion_2.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.feather_falling_potion_2.description")))
                .customModelData(304)
                .persistentData(key, PersistentDataType.STRING, "feather_falling_potion_2")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" P ", " S ", "   ");
        recipe.setIngredient('P', Material.POTION);
        recipe.setIngredient('S', Material.SUGAR);
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
