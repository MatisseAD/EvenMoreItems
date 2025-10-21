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
 * Ne fond pas
 */
public class IceBrick implements CustomItem {
    public static final String KEY_ID = "ice_brick";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public IceBrick(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.PACKED_ICE)
                .name(MoreItems.getInstance().getLang().get("items.ice_brick.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.ice_brick.description")))
                .customModelData(213)
                .persistentData(key, PersistentDataType.STRING, "ice_brick")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", "IBI", "III");
        recipe.setIngredient('I', Material.PACKED_ICE);
        recipe.setIngredient('B', Material.WATER_BUCKET);
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
