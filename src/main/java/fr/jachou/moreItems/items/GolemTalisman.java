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
 * Résistance accrue
 */
public class GolemTalisman implements CustomItem {
    public static final String KEY_ID = "golem_talisman";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public GolemTalisman(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_INGOT)
                .name(MoreItems.getInstance().getLang().get("items.golem_talisman.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.golem_talisman.description")))
                .customModelData(505)
                .persistentData(key, PersistentDataType.STRING, "golem_talisman")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", " P ", "   ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('P', Material.PUMPKIN);
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
