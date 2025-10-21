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
 * Bouclier Réfléchissant - Renvoie flèches et tridents
 */
public class ReflectiveShield implements CustomItem {
    public static final String KEY_ID = "reflective_shield";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ReflectiveShield(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SHIELD)
                .name(MoreItems.getInstance().getLang().get("items.reflectiveShield.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.reflectiveShield.description")))
                .customModelData(107)
                .persistentData(key, PersistentDataType.STRING, "reflective_shield")
                .enchant(Enchantment.THORNS, 3)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", "GIG", " G ");
        recipe.setIngredient('S', Material.SHIELD);
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
