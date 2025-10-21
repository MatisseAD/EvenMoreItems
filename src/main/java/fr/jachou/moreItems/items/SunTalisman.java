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
 * Supprime la pluie
 */
public class SunTalisman implements CustomItem {
    public static final String KEY_ID = "sun_talisman";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SunTalisman(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GOLD_INGOT)
                .name(MoreItems.getInstance().getLang().get("items.sun_talisman.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sun_talisman.description")))
                .customModelData(511)
                .persistentData(key, PersistentDataType.STRING, "sun_talisman")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", " F ", "   ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('F', Material.SUNFLOWER);
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
