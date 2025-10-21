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
 * Bloc de Verre Renforcé - Résiste à la TNT
 */
public class ReinforcedGlass implements CustomItem {
    public static final String KEY_ID = "reinforced_glass";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ReinforcedGlass(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GLASS)
                .name(MoreItems.getInstance().getLang().get("items.reinforcedGlass.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.reinforcedGlass.description")))
                .customModelData(200)
                .persistentData(key, PersistentDataType.STRING, "reinforced_glass")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("GGG", "GIG", "GGG");
        recipe.setIngredient('G', Material.GLASS);
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
