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
 * Rend 1 cœur toutes les 30 s
 */
public class LifeAmulet implements CustomItem {
    public static final String KEY_ID = "life_amulet";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LifeAmulet(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GOLD_INGOT)
                .name(MoreItems.getInstance().getLang().get("items.life_amulet.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.life_amulet.description")))
                .customModelData(502)
                .persistentData(key, PersistentDataType.STRING, "life_amulet")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", " A ", "   ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('A', Material.GOLDEN_APPLE);
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
