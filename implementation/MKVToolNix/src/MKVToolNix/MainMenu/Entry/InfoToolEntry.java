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
public class InfoToolEntry extends MenuEntry
{
    public InfoToolEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu)
    {
        super(name, btn, pane, menu, new NotImplemented("resources/stubs/Info-Tool.png"));

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(makeMenuItem("Open Matroska or WebM file", "resources/icons/16x16/document-open-folder.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Close all tabs", "resources/icons/16x16/document-close.png"));

        setMenuItems(menuItems);
    }
}
