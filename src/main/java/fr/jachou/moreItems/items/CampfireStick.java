package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import fr.jachou.moreItems.items.ItemCategory;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Places a lit campfire when used.
 */
public class CampfireStick implements CustomItem {
    public static final String KEY_ID = "campfire_stick";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CampfireStick(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.STICK)
                .name(MoreItems.getInstance().getLang().get("items.campfireStick.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.campfireStick.description")))
                .persistentData(key, PersistentDataType.STRING, "campfire")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " T ", " S ");
        recipe.setIngredient('C', Material.CHARCOAL);
        recipe.setIngredient('T', Material.TORCH);
        recipe.setIngredient('S', Material.STICK);
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

    @Override
    public ItemCategory getCategory() {
        return ItemCategory.UTILITY;
    }
}
