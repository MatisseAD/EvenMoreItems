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
 * Trie automatiquement les items
 */
public class SmartDispenser implements CustomItem {
    public static final String KEY_ID = "smart_dispenser";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SmartDispenser(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.DISPENSER)
                .name(MoreItems.getInstance().getLang().get("items.smart_dispenser.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.smart_dispenser.description")))
                .customModelData(400)
                .persistentData(key, PersistentDataType.STRING, "smart_dispenser")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" D ", " C ", "   ");
        recipe.setIngredient('D', Material.DISPENSER);
        recipe.setIngredient('C', Material.COMPARATOR);
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
