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
 * Pierre Sculptée - Apparence de visages anciens
 */
public class CarvedStone implements CustomItem {
    public static final String KEY_ID = "carved_stone";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CarvedStone(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CHISELED_STONE_BRICKS)
                .name(MoreItems.getInstance().getLang().get("items.carvedStone.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.carvedStone.description")))
                .customModelData(201)
                .persistentData(key, PersistentDataType.STRING, "carved_stone")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", "SSS", " S ");
        recipe.setIngredient('S', Material.STONE_BRICKS);
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
