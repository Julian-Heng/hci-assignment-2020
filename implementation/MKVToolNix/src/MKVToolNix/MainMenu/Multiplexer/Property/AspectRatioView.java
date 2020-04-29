/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

import MKVToolNix.CustomAnchorPane;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


/**
 *
 * @author student
 */
public class AspectRatioView extends CustomAnchorPane
{
    @FXML
    private ComboBox boxItems;


    public AspectRatioView()
    {
        super("MainMenu/Multiplexer/Property/AspectRatioView.fxml");

        boxItems.getItems().addAll(Arrays.<String>asList("", "4/3", "1.66", "16/9",
                                                         "1.85", "2.00", "2.21",
                                                         "2.35", "2.40"));
    }
}
