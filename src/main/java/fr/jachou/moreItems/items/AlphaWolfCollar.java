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
 * Tous les loups proches suivent et attaquent
 */
public class AlphaWolfCollar implements CustomItem {
    public static final String KEY_ID = "alpha_wolf_collar";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AlphaWolfCollar(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEAD)
                .name(MoreItems.getInstance().getLang().get("items.alpha_wolf_collar.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.alpha_wolf_collar.description")))
                .customModelData(509)
                .persistentData(key, PersistentDataType.STRING, "alpha_wolf_collar")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", " B ", "   ");
        recipe.setIngredient('L', Material.LEAD);
        recipe.setIngredient('B', Material.BONE);
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
