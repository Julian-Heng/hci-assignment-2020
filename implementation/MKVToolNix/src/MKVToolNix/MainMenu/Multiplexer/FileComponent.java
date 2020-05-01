/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer;


/**
 *
 * @author student
 */
public class FileComponent
{
    private String codec;
    private String type;
    private Boolean copy;
    private String language;
    private String name;
    private Integer ID;
    private Boolean defaultTrackOutput;
    private Boolean forced;
    private String charSet;
    private String properties;
    private String sourceFile;
    private String sourceDir;
    private String program;
    private String delay;


    public FileComponent(String name)
    {
        type = name;
    }


    public FileComponent(String codec, String type, Boolean copy, String language, String name, int ID, Boolean defaultTrackOutput, Boolean forced, String charSet, String properties, String sourceFile, String sourceDir, String program, String delay)
    {
        this.codec = codec;
        this.type = type;
        this.copy = copy;
        this.language = language;
        this.name = name;
        this.ID = ID;
        this.defaultTrackOutput = defaultTrackOutput;
        this.forced = forced;
        this.charSet = charSet;
        this.properties = properties;
        this.sourceFile = sourceFile;
        this.sourceDir = sourceDir;
        this.program = program;
        this.delay = delay;
    }


    public String getCodec()
    {
        return codec;
    }


    public String getType()
    {
        return type;
    }


    public Boolean getCopy()
    {
        return copy;
    }


    public String getLanguage()
    {
        return language;
    }


    public String getName()
    {
        return name;
    }


    public Integer getID()
    {
        return ID;
    }


    public Boolean getDefaultTrackOutput()
    {
        return defaultTrackOutput;
    }


    public Boolean getForced()
    {
        return forced;
    }


    public String getCharSet()
    {
        return charSet;
    }


    public String getProperties()
    {
        return properties;
    }


    public String getSourceFile()
    {
        return sourceFile;
    }


    public String getSourceDir()
    {
        return sourceDir;
    }


    public String getProgram()
    {
        return program;
    }


    public String getDelay()
    {
        return delay;
    }
}
