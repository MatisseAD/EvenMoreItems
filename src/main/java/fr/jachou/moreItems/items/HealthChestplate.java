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
 * Chestplate granting regeneration while worn.
 */
public class HealthChestplate implements CustomItem {
    public static final String KEY_ID = "health_chestplate";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HealthChestplate(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_CHESTPLATE)
                .name(MoreItems.getInstance().getLang().get("items.healthChestplate.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.healthChestplate.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "regen")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("I I", "III", "III");
        recipe.setIngredient('I', Material.IRON_INGOT);
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
