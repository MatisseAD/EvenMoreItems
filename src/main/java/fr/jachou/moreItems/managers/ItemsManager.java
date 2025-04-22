package fr.jachou.moreItems.managers;

import fr.jachou.moreItems.MoreItems;
import fr.jachou.moreItems.items.NameSpaceKeyItems;
import fr.jachou.moreItems.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;

public class ItemsManager {

    public static ItemStack speedBoots() {
        ItemStack BootsSpeed = ItemBuilder.of(Material.LEATHER_BOOTS)
                .name(MoreItems.lang.get("items.speedBoots.name"))
                .lore(Collections.singletonList(MoreItems.lang.get("items.speedBoots.lore")))
                .customModelData(1)
                .persistentData(NameSpaceKeyItems.SPEED_BOOTS, PersistentDataType.STRING, "speed_boots")
                .build();

        return BootsSpeed;
    }

}
