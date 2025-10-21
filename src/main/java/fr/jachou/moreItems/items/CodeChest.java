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
 * Coffre à Code - Coffre verrouillable avec mot de passe
 */
public class CodeChest implements CustomItem {
    public static final String KEY_ID = "code_chest";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public CodeChest(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.CHEST)
                .name(MoreItems.getInstance().getLang().get("items.codeChest.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.codeChest.description")))
                .customModelData(202)
                .persistentData(key, PersistentDataType.STRING, "code_chest")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("RCR", "RLR", "RRR");
        recipe.setIngredient('C', Material.CHEST);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('L', Material.LEVER);
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
