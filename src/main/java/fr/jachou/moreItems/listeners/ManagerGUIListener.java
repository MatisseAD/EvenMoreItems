package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.gui.ManagerGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Handles clicks in the ManagerGUI.
 */
public class ManagerGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        ManagerGUI.handle(event);
    }
}
