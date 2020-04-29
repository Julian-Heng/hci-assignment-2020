/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

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
public class FileSelector extends CustomAnchorPane
{
    @FXML
    private TextField txt;
    @FXML
    private Button btn;


    public FileSelector()
    {
        super("MainMenu/Multiplexer/Property/FileSelector.fxml");

        btn.setOnAction(e ->
        {
            txt.setText((new FileChooser()).showOpenDialog(((Stage)getScene().getWindow())).getName());
        });
    }
}
