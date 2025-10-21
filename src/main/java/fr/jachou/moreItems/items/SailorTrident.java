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
 * Trident du Marin - Augmente la vitesse sous l'eau
 */
public class SailorTrident implements CustomItem {
    public static final String KEY_ID = "sailor_trident";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SailorTrident(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.TRIDENT)
                .name(MoreItems.getInstance().getLang().get("items.sailorTrident.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sailorTrident.description")))
                .customModelData(114)
                .persistentData(key, PersistentDataType.STRING, "sailor_trident")
                .enchant(Enchantment.RIPTIDE, 3)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" T ", " H ", "   ");
        recipe.setIngredient('T', Material.TRIDENT);
        recipe.setIngredient('H', Material.HEART_OF_THE_SEA);
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
