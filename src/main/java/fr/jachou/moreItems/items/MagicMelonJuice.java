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
 * Régénération rapide
 */
public class MagicMelonJuice implements CustomItem {
    public static final String KEY_ID = "magic_melon_juice";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public MagicMelonJuice(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.MELON_SLICE)
                .name(MoreItems.getInstance().getLang().get("items.magic_melon_juice.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.magic_melon_juice.description")))
                .customModelData(307)
                .persistentData(key, PersistentDataType.STRING, "magic_melon_juice")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" M ", " G ", "   ");
        recipe.setIngredient('M', Material.MELON_SLICE);
        recipe.setIngredient('G', Material.GOLD_INGOT);
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
