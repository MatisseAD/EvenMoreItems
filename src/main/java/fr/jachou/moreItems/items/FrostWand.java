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
 * Wand that freezes water into ice when used.
 */
public class FrostWand implements CustomItem {
    public static final String KEY_ID = "frost_wand";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FrostWand(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BLAZE_ROD)
                .name(MoreItems.getInstance().getLang().get("items.frostWand.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.frostWand.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "frost")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", " B ", " I ");
        recipe.setIngredient('I', Material.ICE);
        recipe.setIngredient('B', Material.BLAZE_ROD);
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
