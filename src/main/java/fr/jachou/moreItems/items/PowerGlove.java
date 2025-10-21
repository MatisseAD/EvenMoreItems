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
 * Gant de Force - Casse instantanément les blocs faibles
 */
public class PowerGlove implements CustomItem {
    public static final String KEY_ID = "power_glove";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PowerGlove(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEATHER)
                .name(MoreItems.getInstance().getLang().get("items.powerGlove.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.powerGlove.description")))
                .customModelData(110)
                .persistentData(key, PersistentDataType.STRING, "power_glove")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("L L", "LIL", "   ");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('I', Material.IRON_BLOCK);
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
