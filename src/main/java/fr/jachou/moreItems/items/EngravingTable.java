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
 * Permet de renommer blocs décoratifs
 */
public class EngravingTable implements CustomItem {
    public static final String KEY_ID = "engraving_table";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public EngravingTable(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CRAFTING_TABLE)
                .name(MoreItems.getInstance().getLang().get("items.engraving_table.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.engraving_table.description")))
                .customModelData(219)
                .persistentData(key, PersistentDataType.STRING, "engraving_table")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " B ", " A ");
        recipe.setIngredient('C', Material.CRAFTING_TABLE);
        recipe.setIngredient('B', Material.BOOK);
        recipe.setIngredient('A', Material.ANVIL);
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
