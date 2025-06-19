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
 * Boots giving players a higher jump when worn.
 */
public class JumpBoots implements CustomItem {
    public static final String KEY_ID = "jump_boots";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public JumpBoots(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEATHER_BOOTS)
                .name(MoreItems.getInstance().getLang().get("items.jumpBoots.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.jumpBoots.description")))
                .customModelData(2)
                .persistentData(key, PersistentDataType.STRING, "jump")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("F F", " L ", "F F");
        recipe.setIngredient('F', Material.FEATHER);
        recipe.setIngredient('L', Material.LEATHER_BOOTS);
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
