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
 * Émet lumière bleue faible
 */
public class WillOWispBlock implements CustomItem {
    public static final String KEY_ID = "will_o_wisp_block";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public WillOWispBlock(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SOUL_SAND)
                .name(MoreItems.getInstance().getLang().get("items.will_o_wisp_block.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.will_o_wisp_block.description")))
                .customModelData(217)
                .persistentData(key, PersistentDataType.STRING, "will_o_wisp_block")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", " T ", "   ");
        recipe.setIngredient('S', Material.SOUL_SAND);
        recipe.setIngredient('T', Material.TORCH);
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
