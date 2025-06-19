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
 * Sword that ignites targets on hit.
 */
public class FireSword implements CustomItem {
    public static final String KEY_ID = "fire_sword";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FireSword(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_SWORD)
                .name(MoreItems.getInstance().getLang().get("items.fireSword.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.fireSword.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "fire")
                .enchant(org.bukkit.enchantments.Enchantment.FIRE_ASPECT, 1)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", " F ", " S ");
        recipe.setIngredient('F', Material.BLAZE_POWDER);
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
}
