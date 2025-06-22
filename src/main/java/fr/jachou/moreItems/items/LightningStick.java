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
 * Stick that summons lightning where the player looks.
 */
public class LightningStick implements CustomItem {
    public static final String KEY_ID = "lightning_stick";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public LightningStick(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BLAZE_ROD)
                .name(MoreItems.getInstance().getLang().get("items.lightningStick.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.lightningStick.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "lightning")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", " R ", " S ");
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('R', Material.BLAZE_ROD);
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
