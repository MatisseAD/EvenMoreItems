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
 * Pickaxe that sends block drops directly to the player's inventory.
 */
public class MagnetPickaxe implements CustomItem {
    public static final String KEY_ID = "magnet_pickaxe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public MagnetPickaxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.magnetPickaxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.magnetPickaxe.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "magnet")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", " S ", " S ");
        recipe.setIngredient('I', Material.IRON_INGOT);
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
