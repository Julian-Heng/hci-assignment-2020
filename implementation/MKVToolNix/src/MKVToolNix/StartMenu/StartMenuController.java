/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.StartMenu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author student
 */
public class StartMenuController implements Initializable
{
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

        listRecentFiles.setItems(observeRecentFiles);
        listRecentFiles.setCellFactory(new Callback<ListView<FileEntry>, ListCell<FileEntry>>()
        {
            @Override
            public ListCell<FileEntry> call(ListView<FileEntry> p)
            {
                try
                {
                    return new FileEntryCell();
                }
                catch (Exception e)
                {
                    return null;
                }
            }
        });
    }
}
