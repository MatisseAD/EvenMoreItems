package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import fr.jachou.moreItems.items.ItemCategory;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Bell that reveals nearby raiders when rung.
 */
public class PocketBell implements CustomItem {
    public static final String KEY_ID = "pocket_bell";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PocketBell(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BELL)
                .name(MoreItems.getInstance().getLang().get("items.pocketBell.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.pocketBell.description")))
                .persistentData(key, PersistentDataType.STRING, "bell")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", "GEG", " G ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('E', Material.ECHO_SHARD);
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

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.UTILITY;
    }
}
