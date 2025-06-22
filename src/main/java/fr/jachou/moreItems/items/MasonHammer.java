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
 * Hammer used to polish stone blocks on right click.
 */
public class MasonHammer implements CustomItem {
    public static final String KEY_ID = "mason_hammer";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public MasonHammer(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.masonHammer.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.masonHammer.description")))
                .persistentData(key, PersistentDataType.STRING, "hammer")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("I", "S", "S");
        recipe.setIngredient('I', Material.IRON_INGOT);
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
