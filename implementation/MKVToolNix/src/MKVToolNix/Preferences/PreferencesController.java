/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences;

import MKVToolNix.Misc.NotImplemented;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
        paneLeft.getChildren().add(new PreferencesList(paneRight));
        //paneRight.getChildren().add(new NotImplemented());
    }


    @FXML
    private void handleBtnOK(ActionEvent e)
    {
        Platform.exit();
        System.exit(0);
    }


    @FXML
    private void handleBtnCancel(ActionEvent e)
    {
        Platform.exit();
        System.exit(0);
    }
}
