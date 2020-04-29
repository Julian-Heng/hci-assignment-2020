/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Entry;

import MKVToolNix.Misc.NotImplemented;
import MKVToolNix.Utils;
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
public class JobQueueEntry extends MenuEntry
{
    public JobQueueEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu)
    {
        super(name, btn, pane, menu, new NotImplemented("resources/stubs/Job-Queue.png"));

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(makeMenuItem("Start all pending jobs", "resources/icons/16x16/media-playback-start.png"));
        menuItems.add(makeMenuItem());
        Menu subMenu = new Menu("Stop job queue", Utils.makeImageView("resources/icons/16x16/media-playback-stop.png"));
        subMenu.getItems().addAll(
                makeMenuItem("Stop after all running jobs have finished"),
                makeMenuItem("Abort all running jobs and stop immediately"));
        menuItems.add(subMenu);
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Remove successfully completed jobs"));
        menuItems.add(makeMenuItem("Remove completed jobs"));
        menuItems.add(makeMenuItem("Remove all jobs", "resources/icons/16x16/archive-remove.png"));
        menuItems.add(makeMenuItem());
        menuItems.add(makeMenuItem("Acknowledge all warnings"));
        menuItems.add(makeMenuItem("Acknowledge all errors"));
        menuItems.add(makeMenuItem("Acknowledge all warnings and errors", "resources/icons/16x16/dialog-ok-apply.png"));

        setMenuItems(menuItems);
    }
}
