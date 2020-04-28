/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author student
 */
public class Utils
{
    public static ImageView makeImage(String path)
    {
        return new ImageView(new Image(new File(path).toURI().toString()));
    }
}
