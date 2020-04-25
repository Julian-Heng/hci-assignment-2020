/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public abstract class CustomAnchorPane extends AnchorPane
{
    public CustomAnchorPane(String resource)
    {
        super();
        FXMLLoader loader = new FXMLLoader(MKVToolNix.class.getResource(resource));
        loader.setRoot(this);
        loader.setController(this);

        try
        {
            loader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
