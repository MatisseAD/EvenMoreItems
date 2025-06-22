package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.gui.CategoryGUI;
import fr.jachou.moreItems.gui.ManagerGUI;
import fr.jachou.moreItems.gui.ItemInfoGUI;
import fr.jachou.moreItems.gui.RecipeGUI;
import fr.jachou.moreItems.gui.RecipeEditorGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Handles clicks in the ManagerGUI.
 */
public class ManagerGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (CategoryGUI.handle(event)) return;
        if (ManagerGUI.handle(event)) return;
        if (ItemInfoGUI.handle(event)) return;
        if (RecipeGUI.handle(event)) return;
        if (RecipeEditorGUI.handle(event)) return;
    }
}
