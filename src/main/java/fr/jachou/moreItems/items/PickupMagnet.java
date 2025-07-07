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
 * Magnet that collects nearby dropped items on use.
 */
public class PickupMagnet implements CustomItem {
    public static final String KEY_ID = "pickup_magnet";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PickupMagnet(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.COMPASS)
                .name(MoreItems.getInstance().getLang().get("items.pickupMagnet.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.pickupMagnet.description")))
                .persistentData(key, PersistentDataType.STRING, "magnet")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("IRI", "RER", "IRI");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('E', Material.ENDER_PEARL);
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
