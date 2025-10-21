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
 * Multiplie la vitesse
 */
public class RunicFloor implements CustomItem {
    public static final String KEY_ID = "runic_floor";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public RunicFloor(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.QUARTZ_BLOCK)
                .name(MoreItems.getInstance().getLang().get("items.runic_floor.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.runic_floor.description")))
                .customModelData(211)
                .persistentData(key, PersistentDataType.STRING, "runic_floor")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" Q ", "RQR", " R ");
        recipe.setIngredient('Q', Material.QUARTZ_BLOCK);
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
