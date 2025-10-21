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
 * Régénération légère
 */
public class PlainsTea implements CustomItem {
    public static final String KEY_ID = "plains_tea";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PlainsTea(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.POTION)
                .name(MoreItems.getInstance().getLang().get("items.plains_tea.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.plains_tea.description")))
                .customModelData(311)
                .persistentData(key, PersistentDataType.STRING, "plains_tea")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" D ", " P ", "   ");
        recipe.setIngredient('D', Material.DANDELION);
        recipe.setIngredient('P', Material.POTION);
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
