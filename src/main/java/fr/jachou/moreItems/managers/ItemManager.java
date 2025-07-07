package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.items.*;
import fr.jachou.moreItems.gui.Category;
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
    private static final Map<String, Category> ITEM_CATEGORIES = new HashMap<>();

    private ItemManager() {
    }

    public static void init(Plugin plugin) {
        register(new SpeedBoots(plugin), Category.ARMOR);
        register(new JumpBoots(plugin), Category.ARMOR);
        register(new FireSword(plugin), Category.WEAPON);
        register(new TeleportBow(plugin), Category.WEAPON);
        register(new MagnetPickaxe(plugin), Category.TOOL);
        register(new HealthChestplate(plugin), Category.ARMOR);
        register(new XPHelmet(plugin), Category.ARMOR);
        register(new FrostWand(plugin), Category.WEAPON);
        register(new ExplosivePickaxe(plugin), Category.TOOL);
        register(new LightningStick(plugin), Category.WEAPON);
        register(new SandWand(plugin), Category.WEAPON);
        register(new LeatherPouch(plugin), Category.UTILITY);
        register(new GrappleArrow(plugin), Category.WEAPON);
        register(new MasonHammer(plugin), Category.TOOL);
        register(new FishingNet(plugin), Category.TOOL);
        register(new PocketBell(plugin), Category.UTILITY);
        register(new SurvivalRation(plugin), Category.UTILITY);
        register(new DriedApple(plugin), Category.UTILITY);
        register(new CampfireStick(plugin), Category.TOOL);
        register(new ReturnScroll(plugin), Category.UTILITY);
        register(new IcePop(plugin), Category.UTILITY);
        register(new PickupMagnet(plugin), Category.UTILITY);
        register(new PortableFurnace(plugin), Category.UTILITY);
        register(new PortableAnvil(plugin), Category.TOOL);
        register(new InvisibilityHood(plugin), Category.ARMOR);
        register(new PortalBook(plugin), Category.UTILITY);
        register(new AlchemyBackpack(plugin), Category.UTILITY);
        register(new SelectiveDynamite(plugin), Category.TOOL);
    }

    private static void register(CustomItem item, Category category) {
        ITEMS.put(item.getKey().getKey(), item);
        ITEM_CATEGORIES.put(item.getKey().getKey(), category);
    }

    public static Collection<CustomItem> all() {
        return ITEMS.values();
    }

    public static Collection<CustomItem> all(Category category) {
        return ITEMS.values().stream()
                .filter(i -> ITEM_CATEGORIES.getOrDefault(i.getKey().getKey(), Category.UTILITY) == category)
                .toList();
    }

    public static Category getCategory(CustomItem item) {
        return ITEM_CATEGORIES.getOrDefault(item.getKey().getKey(), Category.UTILITY);
    }

    public static CustomItem byKey(NamespacedKey key) {
        return ITEMS.get(key.getKey());
    }

    public static CustomItem fromItemStack(org.bukkit.inventory.ItemStack stack) {
        if (stack == null) return null;
        for (CustomItem item : ITEMS.values()) {
            if (item.getItem().isSimilar(stack)) {
                return item;
            }
        }
        return null;
    }
}
