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
 * Pas de bruit lors de l'utilisation
 */
public class SilentAnvil implements CustomItem {
    public static final String KEY_ID = "silent_anvil";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SilentAnvil(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.ANVIL)
                .name(MoreItems.getInstance().getLang().get("items.silent_anvil.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.silent_anvil.description")))
                .customModelData(215)
                .persistentData(key, PersistentDataType.STRING, "silent_anvil")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" A ", "WAW", "   ");
        recipe.setIngredient('A', Material.ANVIL);
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
