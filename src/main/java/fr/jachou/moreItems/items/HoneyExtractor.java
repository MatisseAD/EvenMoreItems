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
 * Récolte sans casser le nid
 */
public class HoneyExtractor implements CustomItem {
    public static final String KEY_ID = "honey_extractor";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public HoneyExtractor(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.DISPENSER)
                .name(MoreItems.getInstance().getLang().get("items.honey_extractor.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.honey_extractor.description")))
                .customModelData(407)
                .persistentData(key, PersistentDataType.STRING, "honey_extractor")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" D ", " B ", " H ");
        recipe.setIngredient('D', Material.DISPENSER);
        recipe.setIngredient('B', Material.GLASS_BOTTLE);
        recipe.setIngredient('H', Material.HONEY_BOTTLE);
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
