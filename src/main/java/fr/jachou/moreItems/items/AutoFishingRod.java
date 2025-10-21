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
 * Canne de Pêche Automatique - Ramène le poisson plus vite
 */
public class AutoFishingRod implements CustomItem {
    public static final String KEY_ID = "auto_fishing_rod";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AutoFishingRod(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.FISHING_ROD)
                .name(MoreItems.getInstance().getLang().get("items.autoFishingRod.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.autoFishingRod.description")))
                .customModelData(109)
                .persistentData(key, PersistentDataType.STRING, "auto_fishing")
                .enchant(Enchantment.LURE, 3)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", " R ", " P ");
        recipe.setIngredient('F', Material.FISHING_ROD);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('P', Material.PISTON);
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
