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
 * Verre teinté + brillance
 */
public class LuminousColoredGlass implements CustomItem {
    public static final String KEY_ID = "luminous_colored_glass";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LuminousColoredGlass(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BLUE_STAINED_GLASS)
                .name(MoreItems.getInstance().getLang().get("items.luminous_colored_glass.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.luminous_colored_glass.description")))
                .customModelData(216)
                .persistentData(key, PersistentDataType.STRING, "luminous_colored_glass")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("GGG", "GDG", "GGG");
        recipe.setIngredient('G', Material.BLUE_STAINED_GLASS);
        recipe.setIngredient('D', Material.GLOWSTONE_DUST);
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
