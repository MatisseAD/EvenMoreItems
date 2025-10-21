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
 * Pioche Rapide - Efficacité temporaire
 */
public class FastPickaxe implements CustomItem {
    public static final String KEY_ID = "fast_pickaxe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public FastPickaxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.GOLDEN_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.fastPickaxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.fastPickaxe.description")))
                .customModelData(106)
                .persistentData(key, PersistentDataType.STRING, "fast_pickaxe")
                .enchant(Enchantment.EFFICIENCY, 5)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" P ", "RSR", "   ");
        recipe.setIngredient('P', Material.GOLDEN_PICKAXE);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('S', Material.SUGAR);
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
