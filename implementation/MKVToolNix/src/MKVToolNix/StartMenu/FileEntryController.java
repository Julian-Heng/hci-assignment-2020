/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.StartMenu;

import MKVToolNix.CustomAnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;


/**
 *
 * @author student
 */
public class FileEntryController extends CustomAnchorPane
{
    @FXML
    private Label txtFileName;
    @FXML
    private Text txtFileSize;
    @FXML
    private Text txtFileLength;

    private FileEntry fileEntry;


    public FileEntryController()
    {
        super("StartMenu/FileEntry.fxml");
    }


    public void setFileEntry(FileEntry e)
    {
        fileEntry = e;
    }


    public void update()
    {
        txtFileName.setText(fileEntry.getFileName());
        txtFileSize.setText(fileEntry.getFileSize());
        txtFileLength.setText(fileEntry.getFileLength());
    }
}
