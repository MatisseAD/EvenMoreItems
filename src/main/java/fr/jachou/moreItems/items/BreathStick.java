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
 * Bâton du Souffle - Repousse les mobs proches
 */
public class BreathStick implements CustomItem {
    public static final String KEY_ID = "breath_stick";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public BreathStick(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.STICK)
                .name(MoreItems.getInstance().getLang().get("items.breathStick.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.breathStick.description")))
                .customModelData(116)
                .persistentData(key, PersistentDataType.STRING, "breath_stick")
                .enchant(Enchantment.KNOCKBACK, 5)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", " S ", " F ");
        recipe.setIngredient('S', Material.STICK);
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
