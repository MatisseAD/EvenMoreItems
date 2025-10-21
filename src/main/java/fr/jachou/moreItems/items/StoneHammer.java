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
 * Marteau de Pierre - Casse 3x3 blocs de pierre
 */
public class StoneHammer implements CustomItem {
    public static final String KEY_ID = "stone_hammer";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public StoneHammer(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.STONE_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.stoneHammer.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.stoneHammer.description")))
                .customModelData(102)
                .persistentData(key, PersistentDataType.STRING, "stone_hammer")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("CCC", "CSC", " S ");
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('S', Material.STICK);
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
