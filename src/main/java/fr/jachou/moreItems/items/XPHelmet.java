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
 * Helmet providing extra experience gains.
 */
public class XPHelmet implements CustomItem {
    public static final String KEY_ID = "xp_helmet";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public XPHelmet(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_HELMET)
                .name(MoreItems.getInstance().getLang().get("items.xpHelmet.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.xpHelmet.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "xp")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", "I I");
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
