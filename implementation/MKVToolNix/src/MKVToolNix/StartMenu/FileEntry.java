/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.StartMenu;


/**
 *
 * @author student
 */
public class FileEntry
{
    private final String fileName;
    private final String fileSize;
    private final String fileLength;


    public FileEntry(String fileName, String fileSize, String fileLength)
    {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileLength = fileLength;
    }


    public String getFileName()
    {
        return fileName;
    }


    public String getFileSize()
    {
        return fileSize;
    }


    public String getFileLength()
    {
        return fileLength;
    }
}
