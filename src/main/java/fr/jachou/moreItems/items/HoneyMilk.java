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
 * Soigne et donne résistance
 */
public class HoneyMilk implements CustomItem {
    public static final String KEY_ID = "honey_milk";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HoneyMilk(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.MILK_BUCKET)
                .name(MoreItems.getInstance().getLang().get("items.honey_milk.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.honey_milk.description")))
                .customModelData(305)
                .persistentData(key, PersistentDataType.STRING, "honey_milk")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" M ", " H ", "   ");
        recipe.setIngredient('M', Material.MILK_BUCKET);
        recipe.setIngredient('H', Material.HONEY_BOTTLE);
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
