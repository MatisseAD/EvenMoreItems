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
 * Shovel that transforms blocks into sand when used.
 */
public class SandWand implements CustomItem {
    public static final String KEY_ID = "sand_wand";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SandWand(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.DIAMOND_SHOVEL)
                .name(MoreItems.getInstance().getLang().get("items.sandWand.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sandWand.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "sand")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", " D ", " S ");
        recipe.setIngredient('S', Material.SAND);
        recipe.setIngredient('D', Material.DIAMOND_SHOVEL);
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
