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
 * Couteau de Chasseur - Double le loot des animaux
 */
public class HunterKnife implements CustomItem {
    public static final String KEY_ID = "hunter_knife";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HunterKnife(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_SWORD)
                .name(MoreItems.getInstance().getLang().get("items.hunterKnife.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.hunterKnife.description")))
                .customModelData(104)
                .persistentData(key, PersistentDataType.STRING, "hunter_knife")
                .enchant(Enchantment.LOOTING, 3)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", "SB ", " S ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.BONE);
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
