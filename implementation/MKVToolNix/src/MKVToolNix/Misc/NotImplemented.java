/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Misc;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.Utils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public class NotImplemented extends CustomAnchorPane
{
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView img;


    public NotImplemented(String path)
    {
        super("Misc/NotImplemented.fxml");

        img.setImage(Utils.makeImage(path));
        img.fitWidthProperty().bind(anchorPane.widthProperty());
        img.fitHeightProperty().bind(anchorPane.heightProperty());
    }
}
