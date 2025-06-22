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
 * Pickaxe that causes small explosions when breaking blocks.
 */
public class ExplosivePickaxe implements CustomItem {
    public static final String KEY_ID = "explosive_pickaxe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ExplosivePickaxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.DIAMOND_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.explosivePickaxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.explosivePickaxe.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "explode")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("TDT", " S ", " S ");
        recipe.setIngredient('T', Material.TNT);
        recipe.setIngredient('D', Material.DIAMOND_PICKAXE);
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
