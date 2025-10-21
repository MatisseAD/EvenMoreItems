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
 * Respiration aquatique
 */
public class SailorMedallion implements CustomItem {
    public static final String KEY_ID = "sailor_medallion";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SailorMedallion(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GOLD_INGOT)
                .name(MoreItems.getInstance().getLang().get("items.sailor_medallion.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sailor_medallion.description")))
                .customModelData(506)
                .persistentData(key, PersistentDataType.STRING, "sailor_medallion")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", " H ", "   ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('H', Material.HEART_OF_THE_SEA);
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
