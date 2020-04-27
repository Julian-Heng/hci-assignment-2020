/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.Misc.NotImplemented;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        btnMap = new HashMap<>();

        btnMap.put(tglbtnMultiplexer.getText(), tglbtnMultiplexer);
        btnMap.put(tglbtnInfoTool.getText(), tglbtnInfoTool);
        btnMap.put(tglbtnHeaderEditor.getText(), tglbtnHeaderEditor);
        btnMap.put(tglbtnChapterEditor.getText(), tglbtnChapterEditor);
        btnMap.put(tglbtnJobQueue.getText(), tglbtnJobQueue);
        btnMap.put(tglbtnJobOutput.getText(), tglbtnJobOutput);

        menuEntries = new HashMap<>();

        menuEntries.put(tglbtnMultiplexer.getText(), NotImplemented.getInstance());
        menuEntries.put(tglbtnInfoTool.getText(), NotImplemented.getInstance());
        menuEntries.put(tglbtnHeaderEditor.getText(), NotImplemented.getInstance());
        menuEntries.put(tglbtnChapterEditor.getText(), NotImplemented.getInstance());
        menuEntries.put(tglbtnJobQueue.getText(), NotImplemented.getInstance());
        menuEntries.put(tglbtnJobOutput.getText(), NotImplemented.getInstance());

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
    }
}
