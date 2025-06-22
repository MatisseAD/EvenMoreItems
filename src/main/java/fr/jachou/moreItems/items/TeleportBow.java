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
 * Bow that teleports the shooter to the arrow's landing spot.
 */
public class TeleportBow implements CustomItem {
    public static final String KEY_ID = "teleport_bow";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public TeleportBow(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BOW)
                .name(MoreItems.getInstance().getLang().get("items.teleportBow.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.teleportBow.description")))
                .customModelData(1)
                .persistentData(key, PersistentDataType.STRING, "teleport")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "EBE", " E ");
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.BOW);
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
