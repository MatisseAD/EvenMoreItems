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
 * S'ouvre à la présence d'un joueur
 */
public class AutoTrapdoor implements CustomItem {
    public static final String KEY_ID = "auto_trapdoor";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AutoTrapdoor(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_TRAPDOOR)
                .name(MoreItems.getInstance().getLang().get("items.auto_trapdoor.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.auto_trapdoor.description")))
                .customModelData(218)
                .persistentData(key, PersistentDataType.STRING, "auto_trapdoor")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" T ", " D ", "   ");
        recipe.setIngredient('T', Material.IRON_TRAPDOOR);
        recipe.setIngredient('D', Material.OBSERVER);
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
