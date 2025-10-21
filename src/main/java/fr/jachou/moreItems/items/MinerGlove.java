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
 * Gant de Mineur - Ramasse automatiquement les blocs cassés
 */
public class MinerGlove implements CustomItem {
    public static final String KEY_ID = "miner_glove";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public MinerGlove(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEATHER)
                .name(MoreItems.getInstance().getLang().get("items.minerGlove.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.minerGlove.description")))
                .customModelData(113)
                .persistentData(key, PersistentDataType.STRING, "miner_glove")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" L ", "RHL", "   ");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('H', Material.HOPPER);
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
