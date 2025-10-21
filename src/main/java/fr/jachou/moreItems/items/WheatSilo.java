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
 * Stocke les récoltes
 */
public class WheatSilo implements CustomItem {
    public static final String KEY_ID = "wheat_silo";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public WheatSilo(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CHEST)
                .name(MoreItems.getInstance().getLang().get("items.wheat_silo.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.wheat_silo.description")))
                .customModelData(409)
                .persistentData(key, PersistentDataType.STRING, "wheat_silo")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " B ", " H ");
        recipe.setIngredient('C', Material.CHEST);
        recipe.setIngredient('B', Material.BARREL);
        recipe.setIngredient('H', Material.HAY_BLOCK);
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
