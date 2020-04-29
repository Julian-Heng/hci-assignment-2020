/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Entry;

import MKVToolNix.Misc.NotImplemented;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public class HeaderEditorEntry extends MenuEntry
{
    public HeaderEditorEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu)
    {
        super(name, btn, pane, menu, new NotImplemented("resources/stubs/Header-Editor.png"));

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(makeMenuItem("Open Matroska or WebM file", "resources/icons/16x16/document-open-folder.png"));
        menuItems.add(makeMenuItem("Reload", "resources/icons/16x16/document-revert.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Validate values", "resources/icons/16x16/dialog-ok-apply.png"));
        menuItems.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menuItems.add(makeMenuItem());
        Menu subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save", "resources/icons/16x16/document-save.png"),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menuItems.add(subMenu);

        setMenuItems(menuItems);
    }
}
