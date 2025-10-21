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
 * Arc Renforcé - +25% de portée
 */
public class ReinforcedBow implements CustomItem {
    public static final String KEY_ID = "reinforced_bow";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public ReinforcedBow(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BOW)
                .name(MoreItems.getInstance().getLang().get("items.reinforcedBow.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.reinforcedBow.description")))
                .customModelData(101)
                .persistentData(key, PersistentDataType.STRING, "reinforced")
                .enchant(Enchantment.POWER, 1)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" BI", "BSI", " BI");
        recipe.setIngredient('B', Material.BOW);
        recipe.setIngredient('S', Material.STRING);
        recipe.setIngredient('I', Material.IRON_INGOT);
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
