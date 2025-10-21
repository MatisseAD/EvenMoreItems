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
 * Trie par enchantement
 */
public class EnchantedBookSorter implements CustomItem {
    public static final String KEY_ID = "enchanted_book_sorter";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public EnchantedBookSorter(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CHEST)
                .name(MoreItems.getInstance().getLang().get("items.enchanted_book_sorter.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.enchanted_book_sorter.description")))
                .customModelData(412)
                .persistentData(key, PersistentDataType.STRING, "enchanted_book_sorter")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " B ", " R ");
        recipe.setIngredient('C', Material.CHEST);
        recipe.setIngredient('B', Material.BOOK);
        recipe.setIngredient('R', Material.COMPARATOR);
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
