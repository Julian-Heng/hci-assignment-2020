/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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


    public static Stage openWindow(String fxmlPath, String title, double width, double height) throws IOException
    {
        Parent p = FXMLLoader.load(MKVToolNix.class.getResource(fxmlPath));
        return openWindow(p, title, width, height);
    }


    public static Stage openWindow(Parent parent, String title, double width, double height)
    {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(parent, width, height));
        return stage;
    }


    public static void closeWindow(AnchorPane root)
    {
        ((Stage)root.getScene().getWindow()).close();
    }


    public static void fillAnchorPane(Node n)
    {
        fillAnchorPane(n, 0.0);
    }


    public static void fillAnchorPane(Node n, double v)
    {
        AnchorPane.setTopAnchor(n, v);
        AnchorPane.setBottomAnchor(n, v);
        AnchorPane.setLeftAnchor(n, v);
        AnchorPane.setRightAnchor(n, v);
    }


    public static String getFileExtension(String fname)
    {
        return fname.substring(fname.lastIndexOf(".") + 1);
    }


    public static <T> T getRandomFromList(List<T> l)
    {
        return l.get((new Random()).nextInt(l.size()));
    }
}
