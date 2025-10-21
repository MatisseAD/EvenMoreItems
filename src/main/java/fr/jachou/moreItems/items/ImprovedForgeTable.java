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
 * Permet les crafts spéciaux
 */
public class ImprovedForgeTable implements CustomItem {
    public static final String KEY_ID = "improved_forge_table";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ImprovedForgeTable(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SMITHING_TABLE)
                .name(MoreItems.getInstance().getLang().get("items.improved_forge_table.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.improved_forge_table.description")))
                .customModelData(214)
                .persistentData(key, PersistentDataType.STRING, "improved_forge_table")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("III", "ITI", "III");
        recipe.setIngredient('T', Material.SMITHING_TABLE);
        recipe.setIngredient('I', Material.IRON_INGOT);
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
