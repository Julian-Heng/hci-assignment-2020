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
public class ChapterEditorEntry extends MenuEntry
{
    public ChapterEditorEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu)
    {
        super(name, btn, pane, menu, new NotImplemented("resources/stubs/Chapter-Editor.png"));

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(makeMenuItem("New", "resources/icons/16x16/document-new.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Open Matroska, WebM or chapter file", "resources/icons/16x16/document-open-file.png"));
        menuItems.add(makeMenuItem("Append chapters from Matroska, WebM or chapter file"));
        menuItems.add(makeMenuItem("Reload", "resources/icons/16x16/document-revert.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menuItems.add(makeMenuItem("Save as XML file"));
        menuItems.add(makeMenuItem("Save as Matroska or WebM file"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(
                makeMenuItem("Actions for all tabs",
                             makeMenuItem("Save", "resources/icons/16x16/document-save.png"),
                             makeMenuItem("Close", "resources/icons/16x16/document-close.png")
                )
        );
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Remove chapters from existing Matroska file"));

        setMenuItems(menuItems);
    }
}
