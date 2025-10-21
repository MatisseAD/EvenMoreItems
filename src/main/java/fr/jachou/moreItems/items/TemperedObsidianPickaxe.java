package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

/**
 * Pioche en Obsidienne Trempée - Durabilité x3, lente mais incassable
 */
public class TemperedObsidianPickaxe implements CustomItem {
    public static final String KEY_ID = "tempered_obsidian_pickaxe";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public TemperedObsidianPickaxe(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.DIAMOND_PICKAXE)
                .name(MoreItems.getInstance().getLang().get("items.temperedObsidianPickaxe.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.temperedObsidianPickaxe.description")))
                .customModelData(100)
                .persistentData(key, PersistentDataType.STRING, "tempered_obsidian")
                .enchant(Enchantment.UNBREAKING, 10)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape("OOO", "OPO", "OLO");
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
        recipe.setIngredient('L', Material.LAVA_BUCKET);
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
