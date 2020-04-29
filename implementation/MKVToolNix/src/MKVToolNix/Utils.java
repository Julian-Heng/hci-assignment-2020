/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author student
 */
public class Utils
{
    public static Image makeImage(String path)
    {
        return new Image(new File(path).toURI().toString());
    }


    public static ImageView makeImageView(String path)
    {
        return new ImageView(makeImage(path));
    }


    public static void openWindow(String fxmlPath, String title, double width, double height) throws IOException
    {
        Parent root = FXMLLoader.load(MKVToolNix.class.getResource(fxmlPath));
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }


    public static void closeWindow(AnchorPane root)
    {
        ((Stage)root.getScene().getWindow()).close();
    }
}
