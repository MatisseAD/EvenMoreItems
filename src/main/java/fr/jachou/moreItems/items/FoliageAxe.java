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
 * Hache de Feuillage - Coupe les feuilles instantanément
 */
public class FoliageAxe implements CustomItem {
    public static final String KEY_ID = "foliage_axe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FoliageAxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.STONE_AXE)
                .name(MoreItems.getInstance().getLang().get("items.foliageAxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.foliageAxe.description")))
                .customModelData(112)
                .persistentData(key, PersistentDataType.STRING, "foliage_axe")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" A ", "SAS", " S ");
        recipe.setIngredient('A', Material.STONE_AXE);
        recipe.setIngredient('S', Material.SHEARS);
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
