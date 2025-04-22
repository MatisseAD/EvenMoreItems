package fr.jachou.moreItems.items;

import fr.jachou.moreItems.MoreItems;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public class NameSpaceKeyItems {

    private Plugin plugin = MoreItems.getInstance();

    public static NamespacedKey SPEED_BOOTS = new NamespacedKey(MoreItems.getInstance(), "speed_boots");
}
