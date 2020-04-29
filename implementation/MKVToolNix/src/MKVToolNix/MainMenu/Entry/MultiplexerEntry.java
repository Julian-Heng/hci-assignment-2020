/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Entry;

import MKVToolNix.MainMenu.Multiplexer.Multiplexer;
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
public class MultiplexerEntry extends MenuEntry
{
    public MultiplexerEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu)
    {
        super(name, btn, pane, menu, new Multiplexer());

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(makeMenuItem("New", "resources/icons/16x16/document-new.png"));
        menuItems.add(makeMenuItem("Open settings", "resources/icons/16x16/document-open.png"));
        menuItems.add(makeMenuItem("Save settings", "resources/icons/16x16/document-save.png"));
        menuItems.add(makeMenuItem("Save settings as", "resources/icons/16x16/document-save-as.png"));
        menuItems.add(makeMenuItem("Create option file"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Start multiplexing", "resources/icons/16x16/media-playback-start.png"));
        menuItems.add(makeMenuItem("Add to job queue", "resources/icons/16x16/task-delegate.png"));
        menuItems.add(makeMenuItem());

        Menu subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save settings", "resources/icons/16x16/document-save.png"),
                makeMenuItem(),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"),
                makeMenuItem(),
                makeMenuItem("Start multiplexing", "resources/icons/16x16/media-playback-start.png"),
                makeMenuItem("Add to job queue", "resources/icons/16x16/task-delegate.png"));
        menuItems.add(subMenu);

        menuItems.add(makeMenuItem("Show command line", "resources/icons/16x16/utilities-terminal.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Copy first source file's name to file title"));
        menuItems.add(makeMenuItem("Copy destination file's name to file title"));
        menuItems.add(makeMenuItem("Copy file title to destination file name"));

        setMenuItems(menuItems);
    }
}
