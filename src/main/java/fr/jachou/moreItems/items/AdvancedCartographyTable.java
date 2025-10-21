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
 * Permet de copier les maps sans encre
 */
public class AdvancedCartographyTable implements CustomItem {
    public static final String KEY_ID = "advanced_cartography_table";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AdvancedCartographyTable(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CARTOGRAPHY_TABLE)
                .name(MoreItems.getInstance().getLang().get("items.advanced_cartography_table.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.advanced_cartography_table.description")))
                .customModelData(205)
                .persistentData(key, PersistentDataType.STRING, "advanced_cartography_table")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" T ", " B ", "   ");
        recipe.setIngredient('T', Material.CARTOGRAPHY_TABLE);
        recipe.setIngredient('B', Material.BOOK);
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
