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
 * Mur végétalisé
 */
public class IvyWall implements CustomItem {
    public static final String KEY_ID = "ivy_wall";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public IvyWall(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.OAK_FENCE)
                .name(MoreItems.getInstance().getLang().get("items.ivy_wall.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.ivy_wall.description")))
                .customModelData(212)
                .persistentData(key, PersistentDataType.STRING, "ivy_wall")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("VVV", "VSV", "VVV");
        recipe.setIngredient('V', Material.VINE);
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
