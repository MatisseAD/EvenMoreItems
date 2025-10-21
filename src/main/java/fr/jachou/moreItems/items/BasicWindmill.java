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
 * Produit redstone par vent (esthétique)
 */
public class BasicWindmill implements CustomItem {
    public static final String KEY_ID = "basic_windmill";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public BasicWindmill(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.OAK_PLANKS)
                .name(MoreItems.getInstance().getLang().get("items.basic_windmill.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.basic_windmill.description")))
                .customModelData(404)
                .persistentData(key, PersistentDataType.STRING, "basic_windmill")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("PWP", "WPW", "PWP");
        recipe.setIngredient('P', Material.OAK_PLANKS);
        recipe.setIngredient('W', Material.WHITE_WOOL);
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
