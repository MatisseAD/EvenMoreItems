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
 * Hood granting invisibility while worn.
 */
public class InvisibilityHood implements CustomItem {
    public static final String KEY_ID = "invisibility_hood";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public InvisibilityHood(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.LEATHER_HELMET)
                .name(MoreItems.getInstance().getLang().get("items.invisibilityHood.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.invisibilityHood.description")))
                .persistentData(key, PersistentDataType.STRING, "hood")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("LLL", "L L", "   ");
        recipe.setIngredient('L', Material.LEATHER);
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
