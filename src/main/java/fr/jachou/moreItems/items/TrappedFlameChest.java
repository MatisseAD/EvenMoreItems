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
 * Explose à l'ouverture
 */
public class TrappedFlameChest implements CustomItem {
    public static final String KEY_ID = "trapped_flame_chest";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public TrappedFlameChest(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.TRAPPED_CHEST)
                .name(MoreItems.getInstance().getLang().get("items.trapped_flame_chest.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.trapped_flame_chest.description")))
                .customModelData(209)
                .persistentData(key, PersistentDataType.STRING, "trapped_flame_chest")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" C ", " T ", "   ");
        recipe.setIngredient('C', Material.TRAPPED_CHEST);
        recipe.setIngredient('T', Material.TNT);
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
