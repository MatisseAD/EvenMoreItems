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
 * Casse et replante
 */
public class AutoHarvester implements CustomItem {
    public static final String KEY_ID = "auto_harvester";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AutoHarvester(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.PISTON)
                .name(MoreItems.getInstance().getLang().get("items.auto_harvester.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.auto_harvester.description")))
                .customModelData(406)
                .persistentData(key, PersistentDataType.STRING, "auto_harvester")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" P ", " H ", " R ");
        recipe.setIngredient('P', Material.PISTON);
        recipe.setIngredient('H', Material.IRON_HOE);
        recipe.setIngredient('R', Material.REDSTONE);
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
