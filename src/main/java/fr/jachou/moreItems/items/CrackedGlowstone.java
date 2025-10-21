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
 * Variante décorative
 */
public class CrackedGlowstone implements CustomItem {
    public static final String KEY_ID = "cracked_glowstone";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CrackedGlowstone(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GLOWSTONE)
                .name(MoreItems.getInstance().getLang().get("items.cracked_glowstone.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.cracked_glowstone.description")))
                .customModelData(208)
                .persistentData(key, PersistentDataType.STRING, "cracked_glowstone")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("GGG", "GBG", "GGG");
        recipe.setIngredient('G', Material.GLOWSTONE);
        recipe.setIngredient('B', Material.BONE_MEAL);
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
