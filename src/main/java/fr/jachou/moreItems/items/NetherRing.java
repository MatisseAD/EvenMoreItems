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
 * Immunité au feu 5 s après passage portail
 */
public class NetherRing implements CustomItem {
    public static final String KEY_ID = "nether_ring";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public NetherRing(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GOLD_INGOT)
                .name(MoreItems.getInstance().getLang().get("items.nether_ring.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.nether_ring.description")))
                .customModelData(513)
                .persistentData(key, PersistentDataType.STRING, "nether_ring")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", " O ", "   ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('O', Material.OBSIDIAN);
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
