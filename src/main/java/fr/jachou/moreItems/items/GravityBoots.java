package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Bottes Gravitantes - Annulent les dégâts de chute
 */
public class GravityBoots implements CustomItem {
    public static final String KEY_ID = "gravity_boots";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public GravityBoots(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_BOOTS)
                .name(MoreItems.getInstance().getLang().get("items.gravityBoots.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.gravityBoots.description")))
                .customModelData(111)
                .persistentData(key, PersistentDataType.STRING, "gravity_boots")
                .enchant(Enchantment.FEATHER_FALLING, 10)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("F F", "BFB", "F F");
        recipe.setIngredient('B', Material.IRON_BOOTS);
        recipe.setIngredient('F', Material.FEATHER);
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
