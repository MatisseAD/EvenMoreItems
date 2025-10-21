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
 * Lance de Chasseur - Attaque à distance courte
 */
public class HunterSpear implements CustomItem {
    public static final String KEY_ID = "hunter_spear";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HunterSpear(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.TRIDENT)
                .name(MoreItems.getInstance().getLang().get("items.hunterSpear.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.hunterSpear.description")))
                .customModelData(108)
                .persistentData(key, PersistentDataType.STRING, "hunter_spear")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", " S ", "S  ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);
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
