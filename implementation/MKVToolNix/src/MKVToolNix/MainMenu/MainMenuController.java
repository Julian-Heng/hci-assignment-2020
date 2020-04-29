/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu;

import MKVToolNix.MainMenu.Entry.ChapterEditorEntry;
import MKVToolNix.MainMenu.Entry.HeaderEditorEntry;
import MKVToolNix.MainMenu.Entry.InfoToolEntry;
import MKVToolNix.MainMenu.Entry.JobOutputEntry;
import MKVToolNix.MainMenu.Entry.JobQueueEntry;
import MKVToolNix.MainMenu.Entry.MenuEntry;
import MKVToolNix.MainMenu.Entry.MultiplexerEntry;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author student
 */
public class MainMenuController implements Initializable
{
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

        (active = menus.get(tglbtnMultiplexer.getText())).activate();
    }


    @FXML
    private void handleExitMenuOption(ActionEvent e)
    {
        Platform.exit();
        System.exit(0);
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

        if (active != null)
            active.deactivate();
        active = menus.get(key);
        active.activate();
    }
}
