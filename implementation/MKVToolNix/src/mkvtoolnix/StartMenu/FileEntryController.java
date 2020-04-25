/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkvtoolnix.StartMenu;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import mkvtoolnix.MKVToolNix;


/**
 *
 * @author student
 */
public class FileEntryController extends AnchorPane
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
        super();
        
        FXMLLoader loader = new FXMLLoader(MKVToolNix.class.getResource("StartMenu/FileEntry.fxml"));
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
