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
 * Pelle de Mineur - Double la vitesse dans la terre/sable
 */
public class MinerShovel implements CustomItem {
    public static final String KEY_ID = "miner_shovel";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public MinerShovel(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.IRON_SHOVEL)
                .name(MoreItems.getInstance().getLang().get("items.minerShovel.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.minerShovel.description")))
                .customModelData(103)
                .persistentData(key, PersistentDataType.STRING, "miner_shovel")
                .enchant(Enchantment.EFFICIENCY, 5)
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" S ", " P ", " R ");
        recipe.setIngredient('S', Material.IRON_SHOVEL);
        recipe.setIngredient('P', Material.PISTON);
        recipe.setIngredient('R', Material.REDSTONE);
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
