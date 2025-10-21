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
 * TP sur 10 blocs
 */
public class ShortTeleportStick implements CustomItem {
    public static final String KEY_ID = "short_teleport_stick";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ShortTeleportStick(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.STICK)
                .name(MoreItems.getInstance().getLang().get("items.short_teleport_stick.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.short_teleport_stick.description")))
                .customModelData(508)
                .persistentData(key, PersistentDataType.STRING, "short_teleport_stick")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", " S ", "   ");
        recipe.setIngredient('E', Material.ENDER_PEARL);
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
