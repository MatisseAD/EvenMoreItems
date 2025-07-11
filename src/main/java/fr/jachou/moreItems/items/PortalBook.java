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
 * Book used to set anchors and teleport between them.
 */
public class PortalBook implements CustomItem {
    public static final String KEY_ID = "portal_book";

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;

    public PortalBook(Plugin plugin) {
        this.key = new NamespacedKey(plugin, KEY_ID);
        this.item = ItemBuilder.of(Material.BOOK)
                .name(MoreItems.getInstance().getLang().get("items.portalBook.name"))
                .lore(Collections.singletonList(MoreItems.getInstance().getLang().get("items.portalBook.description")))
                .persistentData(key, PersistentDataType.STRING, "pbook")
                .build();

        this.recipe = new ShapedRecipe(key, item);
        recipe.shape(" E ", "EBE", " E ");
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.BOOK);
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
