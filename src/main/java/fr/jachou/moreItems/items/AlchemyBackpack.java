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
 * Simple backpack to store potions.
 */
public class AlchemyBackpack implements CustomItem {
    public static final String KEY_ID = "alchemy_backpack";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AlchemyBackpack(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SHULKER_BOX)
                .name(MoreItems.getInstance().getLang().get("items.alchemyBackpack.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.alchemyBackpack.description")))
                .persistentData(key, PersistentDataType.STRING, "abag")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("LLL", "LBL", "LLL");
        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('B', Material.BREWING_STAND);
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
