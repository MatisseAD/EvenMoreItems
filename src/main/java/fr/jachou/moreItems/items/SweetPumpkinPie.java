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
 * Nourrit et donne vitesse
 */
public class SweetPumpkinPie implements CustomItem {
    public static final String KEY_ID = "sweet_pumpkin_pie";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SweetPumpkinPie(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.PUMPKIN_PIE)
                .name(MoreItems.getInstance().getLang().get("items.sweet_pumpkin_pie.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sweet_pumpkin_pie.description")))
                .customModelData(302)
                .persistentData(key, PersistentDataType.STRING, "sweet_pumpkin_pie")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" P ", " S ", "   ");
        recipe.setIngredient('P', Material.PUMPKIN_PIE);
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
