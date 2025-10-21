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
 * Respiration aquatique
 */
public class SeaSoup implements CustomItem {
    public static final String KEY_ID = "sea_soup";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SeaSoup(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.SUSPICIOUS_STEW)
                .name(MoreItems.getInstance().getLang().get("items.sea_soup.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.sea_soup.description")))
                .customModelData(310)
                .persistentData(key, PersistentDataType.STRING, "sea_soup")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" F ", " K ", " W ");
        recipe.setIngredient('F', Material.COD);
        recipe.setIngredient('K', Material.KELP);
        recipe.setIngredient('W', Material.WATER_BUCKET);
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
