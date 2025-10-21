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
 * Hache de Bûcheron - Coupe les arbres entiers
 */
public class LumberjackAxe implements CustomItem {
    public static final String KEY_ID = "lumberjack_axe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LumberjackAxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_AXE)
                .name(MoreItems.getInstance().getLang().get("items.lumberjackAxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.lumberjackAxe.description")))
                .customModelData(105)
                .persistentData(key, PersistentDataType.STRING, "lumberjack_axe")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" A ", "CAC", " C ");
        recipe.setIngredient('A', Material.IRON_AXE);
        recipe.setIngredient('C', Material.CHAIN);
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
