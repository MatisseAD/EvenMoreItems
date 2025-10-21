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
 * Force + flou
 */
public class PumpkinBeer implements CustomItem {
    public static final String KEY_ID = "pumpkin_beer";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PumpkinBeer(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.POTION)
                .name(MoreItems.getInstance().getLang().get("items.pumpkin_beer.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.pumpkin_beer.description")))
                .customModelData(313)
                .persistentData(key, PersistentDataType.STRING, "pumpkin_beer")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" P ", " B ", " S ");
        recipe.setIngredient('P', Material.PUMPKIN);
        recipe.setIngredient('B', Material.POTION);
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
