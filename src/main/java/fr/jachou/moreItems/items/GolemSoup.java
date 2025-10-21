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
 * Absorption temporaire
 */
public class GolemSoup implements CustomItem {
    public static final String KEY_ID = "golem_soup";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public GolemSoup(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.MUSHROOM_STEW)
                .name(MoreItems.getInstance().getLang().get("items.golem_soup.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.golem_soup.description")))
                .customModelData(314)
                .persistentData(key, PersistentDataType.STRING, "golem_soup")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" I ", " M ", "   ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('M', Material.MUSHROOM_STEW);
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
