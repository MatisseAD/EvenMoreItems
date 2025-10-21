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
 * Nourrit 2x plus
 */
public class VillageBread implements CustomItem {
    public static final String KEY_ID = "village_bread";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public VillageBread(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BREAD)
                .name(MoreItems.getInstance().getLang().get("items.village_bread.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.village_bread.description")))
                .customModelData(309)
                .persistentData(key, PersistentDataType.STRING, "village_bread")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" B ", " W ", "   ");
        recipe.setIngredient('B', Material.BREAD);
        recipe.setIngredient('W', Material.WHEAT);
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
