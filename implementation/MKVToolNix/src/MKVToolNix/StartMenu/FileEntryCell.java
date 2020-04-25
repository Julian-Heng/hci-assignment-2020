/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.StartMenu;

import javafx.scene.control.ListCell;


/**
 *
 * @author student
 */
public class FileEntryCell extends ListCell<FileEntry>
{
    private final FileEntryController fileEntryController;


    public FileEntryCell()
    {
        fileEntryController = new FileEntryController();
    }


    @Override
    protected void updateItem(FileEntry i, boolean empty)
    {
        super.updateItem(i, empty);
        if (i == null || empty)
            setGraphic(null);
        else
        {
            fileEntryController.setFileEntry(i);
            fileEntryController.update();
            setGraphic(fileEntryController);
        }
    }
}
