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
 * Portable furnace opening a furnace interface on use.
 */
public class PortableFurnace implements CustomItem {
    public static final String KEY_ID = "portable_furnace";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PortableFurnace(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.FURNACE)
                .name(MoreItems.getInstance().getLang().get("items.portableFurnace.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.portableFurnace.description")))
                .persistentData(key, PersistentDataType.STRING, "pfurnace")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", "IFI", "III");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('F', Material.FURNACE);
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
