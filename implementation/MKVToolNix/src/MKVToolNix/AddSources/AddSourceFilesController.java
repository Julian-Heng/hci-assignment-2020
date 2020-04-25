/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.AddSources;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;


/**
 * FXML Controller class
 *
 * @author student
 */
public class AddSourceFilesController implements Initializable
{
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;
    @FXML
    private MenuButton menuOption;
    @FXML
    private MenuItem menuAddToCurrent;
    @FXML
    private MenuItem menuCreateNewMultiplexAndAdd;
    @FXML
    private MenuItem menuCreateNewMultiplexForEach;
    @FXML
    private MenuItem menuAppendToExisting;
    @FXML
    private MenuItem menuAddAsPartsToExisting;
    @FXML
    private MenuButton menuFileList;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
    
    
    @FXML
    private void handleMenuOption(ActionEvent e)
    {
        menuOption.setText(((MenuItem)e.getSource()).getText());
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
