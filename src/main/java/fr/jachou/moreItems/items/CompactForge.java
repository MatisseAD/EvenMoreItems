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
 * Fait fondre les métaux sans charbon (avec lave)
 */
public class CompactForge implements CustomItem {
    public static final String KEY_ID = "compact_forge";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CompactForge(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.FURNACE)
                .name(MoreItems.getInstance().getLang().get("items.compact_forge.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.compact_forge.description")))
                .customModelData(408)
                .persistentData(key, PersistentDataType.STRING, "compact_forge")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", " L ", "   ");
        recipe.setIngredient('F', Material.FURNACE);
        recipe.setIngredient('L', Material.LAVA_BUCKET);
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
