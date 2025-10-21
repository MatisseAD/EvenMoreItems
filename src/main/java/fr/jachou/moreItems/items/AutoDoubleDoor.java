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
 * S'ouvre en détectant joueur
 */
public class AutoDoubleDoor implements CustomItem {
    public static final String KEY_ID = "auto_double_door";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public AutoDoubleDoor(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.OAK_DOOR)
                .name(MoreItems.getInstance().getLang().get("items.auto_double_door.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.auto_double_door.description")))
                .customModelData(411)
                .persistentData(key, PersistentDataType.STRING, "auto_double_door")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("DDD", " O ", "DDD");
        recipe.setIngredient('D', Material.OAK_DOOR);
        recipe.setIngredient('O', Material.OBSERVER);
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
