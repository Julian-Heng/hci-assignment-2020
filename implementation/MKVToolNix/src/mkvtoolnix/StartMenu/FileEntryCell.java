/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkvtoolnix.StartMenu;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import mkvtoolnix.MKVToolNix;


/**
 *
 * @author student
 */
public class FileEntryCell extends ListCell<FileEntry>
{
    private AnchorPane content;


    public FileEntryCell()
    {
        content = new AnchorPane();
    }


    @Override
    protected void updateItem(FileEntry i, boolean empty)
    {
        super.updateItem(i, empty);
        if (i == null || empty)
            setGraphic(null);
        else
        {
            try
            {
                AnchorPane cell = FXMLLoader.load(MKVToolNix.class.getResource("StartMenu/FileEntry.fxml"));
                content.getChildren().clear();
                content.getChildren().add(cell);
                setGraphic(content);
            }
            catch (IOException e)
            {
                setGraphic(null);
            }
        }
    }
}
