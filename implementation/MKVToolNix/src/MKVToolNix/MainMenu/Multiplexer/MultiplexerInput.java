/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.MainMenu.Multiplexer.Property.AudioProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.GeneralProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.MiscProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.SubtitleChapterProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.TimeDurationProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.VideoProperty;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.GridPane;


/**
 *
 * @author student
 */
public class MultiplexerInput extends CustomAnchorPane
{
    private static class FileComponent
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

    @FXML
    private TreeTableView<FileComponent> treeEntries;
    @FXML
    private TreeTableColumn<FileComponent, String> colType;
    @FXML
    private TreeTableColumn<FileComponent, String> colCodec;
    @FXML
    private TreeTableColumn<FileComponent, String> colCopy;
    @FXML
    private TreeTableColumn<FileComponent, String> colLang;
    @FXML
    private TreeTableColumn<FileComponent, String> colName;
    @FXML
    private TreeTableColumn<FileComponent, String> colID;
    @FXML
    private TreeTableColumn<FileComponent, String> colDefault;
    @FXML
    private TreeTableColumn<FileComponent, String> colForced;
    @FXML
    private TreeTableColumn<FileComponent, String> colCharSet;
    @FXML
    private TreeTableColumn<FileComponent, String> colProp;
    @FXML
    private TreeTableColumn<FileComponent, String> colSourceFile;
    @FXML
    private TreeTableColumn<FileComponent, String> colSourceDir;
    @FXML
    private TreeTableColumn<FileComponent, String> colProgram;
    @FXML
    private TreeTableColumn<FileComponent, String> colDelay;

    @FXML
    private TitledPane panePropGeneral;
    @FXML
    private TitledPane panePropTimeDuration;
    @FXML
    private TitledPane panePropVideo;
    @FXML
    private TitledPane panePropAudio;
    @FXML
    private TitledPane panePropSubtitleChapter;
    @FXML
    private TitledPane panePropMisc;

    private Map<String, GridPane> properties;


    public MultiplexerInput()
    {
        super("MainMenu/Multiplexer/MultiplexerInput.fxml");

        // Tree Column View
        TreeItem<FileComponent> root = new TreeItem<>(new FileComponent(""));
        root.setExpanded(true);

        colType.setCellValueFactory(p -> makeString(p.getValue().getValue().getType()));
        colCodec.setCellValueFactory(p -> makeString(p.getValue().getValue().getCodec()));
        colCopy.setCellValueFactory(p -> makeString(p.getValue().getValue().getCopy()));
        colLang.setCellValueFactory(p -> makeString(p.getValue().getValue().getLanguage()));
        colName.setCellValueFactory(p -> makeString(p.getValue().getValue().getName()));
        colID.setCellValueFactory(p -> makeString(p.getValue().getValue().getID()));
        colDefault.setCellValueFactory(p -> makeString(p.getValue().getValue().getDefaultTrackOutput()));
        colForced.setCellValueFactory(p -> makeString(p.getValue().getValue().getForced()));
        colCharSet.setCellValueFactory(p -> makeString(p.getValue().getValue().getCharSet()));
        colProp.setCellValueFactory(p -> makeString(p.getValue().getValue().getProperties()));
        colSourceFile.setCellValueFactory(p -> makeString(p.getValue().getValue().getSourceFile()));
        colSourceDir.setCellValueFactory(p -> makeString(p.getValue().getValue().getSourceDir()));
        colProgram.setCellValueFactory(p -> makeString(p.getValue().getValue().getProgram()));
        colDelay.setCellValueFactory(p -> makeString(p.getValue().getValue().getDelay()));

        treeEntries.setRoot(root);
        treeEntries.setShowRoot(false);

        // Dummy item
        TreeItem<FileComponent> dummy = new TreeItem<>(new FileComponent("file.mkv"));
        dummy.getChildren().add(new TreeItem<>(new FileComponent("VC-1", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", "")));
        dummy.getChildren().add(new TreeItem<>(new FileComponent("PCM", "Audio", true, "eng", "", 1, true, false, "", "48000 Hz, 8 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", "")));
        root.getChildren().add(dummy);

        // Properties
        properties = new HashMap<>();
        properties.put("General", new GeneralProperty());
        properties.put("TimeDuration", new TimeDurationProperty());
        properties.put("Video", new VideoProperty());
        properties.put("Audio", new AudioProperty());
        properties.put("SubtitleChapter", new SubtitleChapterProperty());
        properties.put("Misc", new MiscProperty());

        panePropGeneral.setContent(properties.get("General"));
        panePropTimeDuration.setContent(properties.get("TimeDuration"));
        panePropVideo.setContent(properties.get("Video"));
        panePropAudio.setContent(properties.get("Audio"));
        panePropSubtitleChapter.setContent(properties.get("SubtitleChapter"));
        panePropMisc.setContent(properties.get("Misc"));
    }


    private ReadOnlyStringWrapper makeString(String s)
    {
        return new ReadOnlyStringWrapper(s);
    }


    private ReadOnlyStringWrapper makeString(Integer i)
    {
        return new ReadOnlyStringWrapper(i == null ? "" : i.toString());
    }


    private ReadOnlyStringWrapper makeString(Boolean b)
    {
        return new ReadOnlyStringWrapper(b == null ? "" : b.toString());
    }
}
