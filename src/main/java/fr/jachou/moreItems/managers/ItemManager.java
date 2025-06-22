package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.items.*;
import fr.jachou.moreItems.items.ItemCategory;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Keeps track of all custom items.
 */
public final class ItemManager {

    private static final Map<String, CustomItem> ITEMS = new HashMap<>();
    private static final Map<ItemCategory, java.util.List<CustomItem>> BY_CATEGORY = new java.util.EnumMap<>(ItemCategory.class);

    private ItemManager() {
    }

    public static void init(Plugin plugin) {
        for (ItemCategory cat : ItemCategory.values()) {
            BY_CATEGORY.put(cat, new java.util.ArrayList<>());
        }
        register(new SpeedBoots(plugin));
        register(new JumpBoots(plugin));
        register(new FireSword(plugin));
        register(new TeleportBow(plugin));
        register(new MagnetPickaxe(plugin));
        register(new HealthChestplate(plugin));
        register(new XPHelmet(plugin));
        register(new FrostWand(plugin));
        register(new ExplosivePickaxe(plugin));
        register(new LightningStick(plugin));
        register(new SandWand(plugin));
        register(new LeatherPouch(plugin));
        register(new GrappleArrow(plugin));
        register(new MasonHammer(plugin));
        register(new FishingNet(plugin));
        register(new PocketBell(plugin));
        register(new SurvivalRation(plugin));
        register(new DriedApple(plugin));
        register(new CampfireStick(plugin));
        register(new ReturnScroll(plugin));
        register(new IcePop(plugin));
    }

    private static void register(CustomItem item) {
        ITEMS.put(item.getKey().getKey(), item);
        BY_CATEGORY.get(item.getCategory()).add(item);
    }

    public static Collection<CustomItem> all() {
        return ITEMS.values();
    }

    public static java.util.List<CustomItem> byCategory(ItemCategory category) {
        return BY_CATEGORY.get(category);
    }

    public static CustomItem byKey(NamespacedKey key) {
        return ITEMS.get(key.getKey());
    }

    public static CustomItem fromItem(org.bukkit.inventory.ItemStack stack) {
        if (stack == null || !stack.hasItemMeta()) return null;
        org.bukkit.inventory.meta.ItemMeta meta = stack.getItemMeta();
        for (CustomItem item : ITEMS.values()) {
            if (meta.getPersistentDataContainer().has(item.getKey(), org.bukkit.persistence.PersistentDataType.STRING)) {
                return item;
            }
        }
        return null;
    }
}
