/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences.ExecutingActions;

import MKVToolNix.CustomAnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author student
 */
public class AudioFilePane extends CustomAnchorPane
{
    @FXML
    private TextField txtFile;
    @FXML
    private Button btnFilePicker;


    public AudioFilePane()
    {
        super("Preferences/ExecutingActions/AudioFilePane.fxml");

        btnFilePicker.setOnAction(e ->
        {
            txtFile.setText((new FileChooser()).showOpenDialog(((Stage)getScene().getWindow())).getName());
        });
    }
}
