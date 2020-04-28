/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.MainMenu.Multiplexer.Multiplexer;
import MKVToolNix.Misc.NotImplemented;
import MKVToolNix.Utils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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

    private ToggleButton active = null;

    private Map<String, ToggleButton> btnMap;
    private Map<String, CustomAnchorPane> menuEntries;
    private Map<String, List<MenuItem>> menuDropdown;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        List<MenuItem> menu;
        //List<MenuItem> subMenu;
        Menu subMenu;

        btnMap = new HashMap<>();

        btnMap.put(tglbtnMultiplexer.getText(), tglbtnMultiplexer);
        btnMap.put(tglbtnInfoTool.getText(), tglbtnInfoTool);
        btnMap.put(tglbtnHeaderEditor.getText(), tglbtnHeaderEditor);
        btnMap.put(tglbtnChapterEditor.getText(), tglbtnChapterEditor);
        btnMap.put(tglbtnJobQueue.getText(), tglbtnJobQueue);
        btnMap.put(tglbtnJobOutput.getText(), tglbtnJobOutput);

        menuEntries = new HashMap<>();

        menuEntries.put(tglbtnMultiplexer.getText(), new Multiplexer());
        menuEntries.put(tglbtnInfoTool.getText(), new NotImplemented("resources/stubs/Info-Tool.png"));
        menuEntries.put(tglbtnHeaderEditor.getText(), new NotImplemented("resources/stubs/Header-Editor.png"));
        menuEntries.put(tglbtnChapterEditor.getText(), new NotImplemented("resources/stubs/Chapter-Editor.png"));
        menuEntries.put(tglbtnJobQueue.getText(), new NotImplemented("resources/stubs/Job-Queue.png"));
        menuEntries.put(tglbtnJobOutput.getText(), new NotImplemented("resources/stubs/Job-Output.png"));

        menuDropdown = new HashMap<>();

        // Multiplexer dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("New", "resources/icons/16x16/document-new.png"));
        menu.add(makeMenuItem("Open settings", "resources/icons/16x16/document-open.png"));
        menu.add(makeMenuItem("Save settings", "resources/icons/16x16/document-save.png"));
        menu.add(makeMenuItem("Save settings as", "resources/icons/16x16/document-save-as.png"));
        menu.add(makeMenuItem("Create option file"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Start multiplexing", "resources/icons/16x16/media-playback-start.png"));
        menu.add(makeMenuItem("Add to job queue", "resources/icons/16x16/task-delegate.png"));
        menu.add(makeMenuItem());

        subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save settings", "resources/icons/16x16/document-save.png"),
                makeMenuItem(),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"),
                makeMenuItem(),
                makeMenuItem("Start multiplexing", "resources/icons/16x16/media-playback-start.png"),
                makeMenuItem("Add to job queue", "resources/icons/16x16/task-delegate.png"));
        menu.add(subMenu);

        menu.add(makeMenuItem("Show command line", "resources/icons/16x16/utilities-terminal.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Copy first source file's name to file title"));
        menu.add(makeMenuItem("Copy destination file's name to file title"));
        menu.add(makeMenuItem("Copy file title to destination file name"));

        menuDropdown.put(tglbtnMultiplexer.getText(), menu);

        // Info Tool dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("Open Matroska or WebM file", "resources/icons/16x16/document-open-folder.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close all tabs", "resources/icons/16x16/document-close.png"));

        menuDropdown.put(tglbtnInfoTool.getText(), menu);

        // Header editor dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("Open Matroska or WebM file", "resources/icons/16x16/document-open-folder.png"));
        menu.add(makeMenuItem("Reload", "resources/icons/16x16/document-revert.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Validate values", "resources/icons/16x16/dialog-ok-apply.png"));
        menu.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(makeMenuItem());
        subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save", "resources/icons/16x16/document-save.png"),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(subMenu);

        menuDropdown.put(tglbtnHeaderEditor.getText(), menu);

        // Chapter editor dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("New", "resources/icons/16x16/document-new.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Open Matroska, WebM or chapter file", "resources/icons/16x16/document-open-file.png"));
        menu.add(makeMenuItem("Append chapters from Matroska, WebM or chapter file"));
        menu.add(makeMenuItem("Reload", "resources/icons/16x16/document-revert.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menu.add(makeMenuItem("Save as XML file"));
        menu.add(makeMenuItem("Save as Matroska or WebM file"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(makeMenuItem());
        subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save", "resources/icons/16x16/document-save.png"),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(subMenu);
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Remove chapters from existing Matroska file"));

        menuDropdown.put(tglbtnChapterEditor.getText(), menu);

        // Job queue dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("Start all pending jobs", "resources/icons/16x16/media-playback-start.png"));
        menu.add(makeMenuItem());
        subMenu = new Menu("Stop job queue", Utils.makeImageView("resources/icons/16x16/media-playback-stop.png"));
        subMenu.getItems().addAll(
                makeMenuItem("Stop after all running jobs have finished"),
                makeMenuItem("Abort all running jobs and stop immediately"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Remove successfully completed jobs"));
        menu.add(makeMenuItem("Remove completed jobs"));
        menu.add(makeMenuItem("Remove all jobs", "resources/icons/16x16/archive-remove.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Acknowledge all warnings"));
        menu.add(makeMenuItem("Acknowledge all errors"));
        menu.add(makeMenuItem("Acknowledge all warnings and errors", "resources/icons/16x16/dialog-ok-apply.png"));

        menuDropdown.put(tglbtnJobQueue.getText(), menu);

        // Job output dropdown
        menu = new ArrayList<>();

        menu.add(makeMenuItem("Save", "resources/icons/16x16/document-save.png"));
        menu.add(makeMenuItem());
        menu.add(makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        subMenu = new Menu("Actions for all tabs");
        subMenu.getItems().addAll(
                makeMenuItem("Save", "resources/icons/16x16/document-save.png"),
                makeMenuItem("Close", "resources/icons/16x16/document-close.png"));
        menu.add(subMenu);

        menuDropdown.put(tglbtnJobOutput.getText(), menu);

        setActive(tglbtnMultiplexer);
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

        setActive(btnMap.get(key));
    }


    private MenuItem makeMenuItem()
    {
        return new SeparatorMenuItem();
    }


    private MenuItem makeMenuItem(String text)
    {
        return new MenuItem(text);
    }


    private MenuItem makeMenuItem(String text, String imgPath)
    {
        return new MenuItem(text, Utils.makeImageView(imgPath));
    }


    private void setActive(ToggleButton newActive)
    {
        String key = newActive.getText();
        AnchorPane pane = menuEntries.get(key);

        paneMenu.getChildren().clear();
        AnchorPane.setTopAnchor(pane, 0.0);
        AnchorPane.setBottomAnchor(pane, 0.0);
        AnchorPane.setLeftAnchor(pane, 0.0);
        AnchorPane.setRightAnchor(pane, 0.0);
        paneMenu.getChildren().add(pane);

        if (active != null)
            active.setStyle("-fx-background-color: black");

        active = newActive;
        active.setStyle("-fx-background-color: #0093ff");

        menuTool.setText(key);
        menuTool.getItems().clear();
        menuTool.getItems().addAll(menuDropdown.get(key));
    }
}
