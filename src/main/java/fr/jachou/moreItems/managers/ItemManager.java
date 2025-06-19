package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.items.CustomItem;
import fr.jachou.moreItems.items.SpeedBoots;
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

    private ItemManager() {
    }

    public static void init(Plugin plugin) {
        register(new SpeedBoots(plugin));
    }

    private static void register(CustomItem item) {
        ITEMS.put(item.getKey().getKey(), item);
    }

    public static Collection<CustomItem> all() {
        return ITEMS.values();
    }

    public static CustomItem byKey(NamespacedKey key) {
        return ITEMS.get(key.getKey());
    }
}
