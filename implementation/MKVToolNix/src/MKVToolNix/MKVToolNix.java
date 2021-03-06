/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author student
 */
public class MKVToolNix extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu/StartMenu.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("MKVToolNix - Gooey Edition");
        stage.setResizable(false);
        stage.setOnCloseRequest((e) -> MKVToolNix.die(0));

        stage.show();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }


    public static void die(int code)
    {
        Platform.exit();
        System.exit(code);
    }
}
