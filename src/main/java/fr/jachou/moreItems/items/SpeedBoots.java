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
 * Example custom item increasing player speed when worn.
 */
public class SpeedBoots implements CustomItem {
    public static final String KEY_ID = "speed_boots";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SpeedBoots(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);

        this.item = ItemBuilder.of(Material.LEATHER_BOOTS)
                .name(MoreItems.getInstance().getLang().get("items.speedBoots.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.speedBoots.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "speed")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("S S", " L ", "S S");
        recipe.setIngredient('S', Material.SUGAR);
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
