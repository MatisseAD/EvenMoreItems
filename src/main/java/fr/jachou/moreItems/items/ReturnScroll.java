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
 * Teleports to the last bed used when activated.
 */
public class ReturnScroll implements CustomItem {
    public static final String KEY_ID = "return_scroll";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ReturnScroll(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.PAPER)
                .name(MoreItems.getInstance().getLang().get("items.returnScroll.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.returnScroll.description")))
                .persistentData(key, PersistentDataType.STRING, "scroll")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "PSP", " R ");
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('P', Material.PAPER);
        recipe.setIngredient('S', Material.ECHO_SHARD);
        recipe.setIngredient('R', Material.REDSTONE);
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
