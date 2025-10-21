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
 * Révèle entités invisibles
 */
public class PhantomLantern implements CustomItem {
    public static final String KEY_ID = "phantom_lantern";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PhantomLantern(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LANTERN)
                .name(MoreItems.getInstance().getLang().get("items.phantom_lantern.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.phantom_lantern.description")))
                .customModelData(510)
                .persistentData(key, PersistentDataType.STRING, "phantom_lantern")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", " E ", "   ");
        recipe.setIngredient('L', Material.LANTERN);
        recipe.setIngredient('E', Material.SPIDER_EYE);
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
