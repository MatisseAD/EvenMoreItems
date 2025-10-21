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
 * Force temporaire
 */
public class HunterStew implements CustomItem {
    public static final String KEY_ID = "hunter_stew";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HunterStew(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SUSPICIOUS_STEW)
                .name(MoreItems.getInstance().getLang().get("items.hunter_stew.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.hunter_stew.description")))
                .customModelData(303)
                .persistentData(key, PersistentDataType.STRING, "hunter_stew")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" R ", " C ", " P ");
        recipe.setIngredient('R', Material.ROTTEN_FLESH);
        recipe.setIngredient('C', Material.CARROT);
        recipe.setIngredient('P', Material.POTATO);
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
