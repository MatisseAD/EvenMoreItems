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
 * Lightweight anvil usable from inventory.
 */
public class PortableAnvil implements CustomItem {
    public static final String KEY_ID = "portable_anvil";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PortableAnvil(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.ANVIL)
                .name(MoreItems.getInstance().getLang().get("items.portableAnvil.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.portableAnvil.description")))
                .persistentData(key, PersistentDataType.STRING, "panvil")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", "IAI", "III");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('A', Material.ANVIL);
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
