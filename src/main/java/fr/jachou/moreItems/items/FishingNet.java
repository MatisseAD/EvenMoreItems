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
 * Throwable fishing net that pulls fish from water.
 */
public class FishingNet implements CustomItem {
    public static final String KEY_ID = "fishing_net";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FishingNet(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SNOWBALL)
                .name(MoreItems.getInstance().getLang().get("items.fishingNet.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.fishingNet.description")))
                .persistentData(key, PersistentDataType.STRING, "net")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", "FSF", " F ");
        recipe.setIngredient('F', Material.STRING);
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
