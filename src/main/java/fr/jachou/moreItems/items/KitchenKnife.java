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
 * Couteau de Cuisine - Coupe la nourriture crue sans four
 */
public class KitchenKnife implements CustomItem {
    public static final String KEY_ID = "kitchen_knife";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public KitchenKnife(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_SWORD)
                .name(MoreItems.getInstance().getLang().get("items.kitchenKnife.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.kitchenKnife.description")))
                .customModelData(115)
                .persistentData(key, PersistentDataType.STRING, "kitchen_knife")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", "SP ", "   ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.SHEARS);
        recipe.setIngredient('P', Material.OAK_PLANKS);
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
