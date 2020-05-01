/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.StartMenu;

import MKVToolNix.MKVToolNix;
import MKVToolNix.MainMenu.MainMenuController;
import MKVToolNix.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author student
 */
public class StartMenuController implements Initializable
{
    @FXML
    private AnchorPane root;
    @FXML
    private CheckBox chkSkip;
    @FXML
    private ListView<FileEntry> listRecentFiles;
    private ObservableList<FileEntry> observeRecentFiles;
    @FXML
    private Button btnMultiplexer;
    @FXML
    private Button btnInfoTool;
    @FXML
    private Button btnHeaderEditor;
    @FXML
    private Button btnChapterEditor;
    @FXML
    private Button btnJobQueue;
    @FXML
    private Button btnJobOutput;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        observeRecentFiles = FXCollections.observableArrayList();
        observeRecentFiles.addAll(
                new FileEntry("File1.mkv", "40 MB", "1:30.23"),
                new FileEntry("File2.mp3", "8.90 MB", "3:23.01"),
                new FileEntry("File3.ogg", "2.30 MB", "1:21.53")
        );

        listRecentFiles.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listRecentFiles.setItems(observeRecentFiles);
        listRecentFiles.setCellFactory((ListView<FileEntry> p) ->
        {
            try
            {
                return new FileEntryCell();
            }
            catch (Exception e)
            {
                return null;
            }
        });
    }


    @FXML
    private void handleBtns(ActionEvent e) throws IOException
    {
        Button src = (Button)e.getSource();

        Stage s;
        FXMLLoader loader;
        MainMenuController c;
        Parent p;

        loader = new FXMLLoader(MKVToolNix.class.getResource("MainMenu/MainMenu.fxml"));
        p = loader.load();
        c = loader.getController();
        c.setActive(src.getText());

        Utils.closeWindow(root);
        s = Utils.openWindow(p, "MKVToolNix - Gooey Edition", 900.0, 700.0);
        s.setOnCloseRequest(ev -> MKVToolNix.die(0));
        s.show();
    }
}
