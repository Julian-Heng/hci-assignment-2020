/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu;

import MKVToolNix.MKVToolNix;
import MKVToolNix.MainMenu.Entry.ChapterEditorEntry;
import MKVToolNix.MainMenu.Entry.HeaderEditorEntry;
import MKVToolNix.MainMenu.Entry.InfoToolEntry;
import MKVToolNix.MainMenu.Entry.JobOutputEntry;
import MKVToolNix.MainMenu.Entry.JobQueueEntry;
import MKVToolNix.MainMenu.Entry.MenuEntry;
import MKVToolNix.MainMenu.Entry.MultiplexerEntry;
import MKVToolNix.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author student
 */
public class MainMenuController implements Initializable
{
    @FXML
    private MenuItem menuPreferences;

    @FXML
    private Menu menuTool;
    @FXML
    private ToggleButton tglbtnMultiplexer;
    @FXML
    private ToggleButton tglbtnInfoTool;
    @FXML
    private ToggleButton tglbtnHeaderEditor;
    @FXML
    private ToggleButton tglbtnChapterEditor;
    @FXML
    private ToggleButton tglbtnJobQueue;
    @FXML
    private ToggleButton tglbtnJobOutput;

    @FXML
    private AnchorPane paneMenu;

    private MenuEntry active = null;
    private Map<String, MenuEntry> menus;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        menus = new HashMap<>();

        menus.put(tglbtnMultiplexer.getText(), new MultiplexerEntry(tglbtnMultiplexer.getText(), tglbtnMultiplexer, paneMenu, menuTool));
        menus.put(tglbtnInfoTool.getText(), new InfoToolEntry(tglbtnInfoTool.getText(), tglbtnInfoTool, paneMenu, menuTool));
        menus.put(tglbtnHeaderEditor.getText(), new HeaderEditorEntry(tglbtnHeaderEditor.getText(), tglbtnHeaderEditor, paneMenu, menuTool));
        menus.put(tglbtnChapterEditor.getText(), new ChapterEditorEntry(tglbtnChapterEditor.getText(), tglbtnChapterEditor, paneMenu, menuTool));
        menus.put(tglbtnJobQueue.getText(), new JobQueueEntry(tglbtnJobQueue.getText(), tglbtnJobQueue, paneMenu, menuTool));
        menus.put(tglbtnJobOutput.getText(), new JobOutputEntry(tglbtnJobOutput.getText(), tglbtnJobOutput, paneMenu, menuTool));
    }


    public void setActive(String key)
    {
        if (active != null)
            active.deactivate();
        active = menus.get(key);
        active.activate();
    }


    @FXML
    private void handleExitMenuOption(ActionEvent e)
    {
        MKVToolNix.die(0);
    }


    @FXML
    private void handlePrefrenceMenuOption(ActionEvent e)
    {
        try
        {
            Stage s = Utils.openWindow("Preferences/Preferences.fxml", "Preferences", 1000.0, 600.0);
            s.show();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    @FXML
    private void handleMainBtnChange(ActionEvent e) throws Exception
    {
        AnchorPane pane;
        Object source = e.getSource();
        String key;

        if (source instanceof ToggleButton)
            key = ((ToggleButton)source).getText();
        else if (source instanceof MenuItem)
            key = ((MenuItem)source).getText();
        else
            throw new Exception("Uh oh, stinky");

        setActive(key);
    }
}
