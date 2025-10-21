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
 * Résistance au feu
 */
public class LavaStew implements CustomItem {
    public static final String KEY_ID = "lava_stew";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LavaStew(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SUSPICIOUS_STEW)
                .name(MoreItems.getInstance().getLang().get("items.lava_stew.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.lava_stew.description")))
                .customModelData(308)
                .persistentData(key, PersistentDataType.STRING, "lava_stew")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" M ", " S ", "   ");
        recipe.setIngredient('M', Material.MAGMA_CREAM);
        recipe.setIngredient('S', Material.MUSHROOM_STEW);
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
