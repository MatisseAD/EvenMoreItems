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
 * Fait fondre 2x plus vite
 */
public class DoubleFurnace implements CustomItem {
    public static final String KEY_ID = "double_furnace";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public DoubleFurnace(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.FURNACE)
                .name(MoreItems.getInstance().getLang().get("items.double_furnace.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.double_furnace.description")))
                .customModelData(403)
                .persistentData(key, PersistentDataType.STRING, "double_furnace")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("FIF", "FIF", "III");
        recipe.setIngredient('F', Material.FURNACE);
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
