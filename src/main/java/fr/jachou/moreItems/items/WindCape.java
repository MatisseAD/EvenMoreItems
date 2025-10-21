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
 * Vitesse + saut
 */
public class WindCape implements CustomItem {
    public static final String KEY_ID = "wind_cape";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public WindCape(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.ELYTRA)
                .name(MoreItems.getInstance().getLang().get("items.wind_cape.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.wind_cape.description")))
                .customModelData(501)
                .persistentData(key, PersistentDataType.STRING, "wind_cape")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "FEF", "   ");
        recipe.setIngredient('E', Material.ELYTRA);
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
