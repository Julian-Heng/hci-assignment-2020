/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences;

import MKVToolNix.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public class PreferencesController implements Initializable
{
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane paneLeft;
    @FXML
    private AnchorPane paneRight;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        AnchorPane list = new PreferencesList(paneRight);
        Utils.fillAnchorPane(list);
        paneLeft.getChildren().add(list);
    }


    @FXML
    private void handleBtnOK(ActionEvent e)
    {
        Utils.closeWindow(root);
    }


    @FXML
    private void handleBtnCancel(ActionEvent e)
    {
        Utils.closeWindow(root);
    }
}
