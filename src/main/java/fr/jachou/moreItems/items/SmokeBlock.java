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
 * Cache la vision, effet décoratif
 */
public class SmokeBlock implements CustomItem {
    public static final String KEY_ID = "smoke_block";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SmokeBlock(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GRAY_WOOL)
                .name(MoreItems.getInstance().getLang().get("items.smoke_block.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.smoke_block.description")))
                .customModelData(206)
                .persistentData(key, PersistentDataType.STRING, "smoke_block")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " W ", "   ");
        recipe.setIngredient('C', Material.CAMPFIRE);
        recipe.setIngredient('W', Material.COBWEB);
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
