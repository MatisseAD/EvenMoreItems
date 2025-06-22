package fr.jachou.moreItems.listeners;

import fr.jachou.moreItems.gui.RecipeEditorGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Handles clicks in the recipe editor GUI.
 */
public class RecipeEditorGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        RecipeEditorGUI.handle(event);
    }
}
