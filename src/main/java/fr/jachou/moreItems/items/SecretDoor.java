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
 * Invisible quand fermée
 */
public class SecretDoor implements CustomItem {
    public static final String KEY_ID = "secret_door";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public SecretDoor(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_DOOR)
                .name(MoreItems.getInstance().getLang().get("items.secret_door.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.secret_door.description")))
                .customModelData(204)
                .persistentData(key, PersistentDataType.STRING, "secret_door")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("RDR", "RCR", "RRR");
        recipe.setIngredient('D', Material.IRON_DOOR);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('C', Material.COMPARATOR);
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
