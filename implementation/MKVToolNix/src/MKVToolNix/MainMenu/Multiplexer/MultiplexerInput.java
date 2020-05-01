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
import MKVToolNix.MainMenu.Multiplexer.Property.Property;
import MKVToolNix.MainMenu.Multiplexer.Property.SubtitleChapterProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.TimeDurationProperty;
import MKVToolNix.MainMenu.Multiplexer.Property.VideoProperty;
import MKVToolNix.Utils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;


/**
 *
 * @author student
 */
public class MultiplexerInput extends CustomAnchorPane
{
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

    private Map<String, Property> properties;

    private List<String> fakeTitles;
    private List<FileComponent> fakeVideoFiles;
    private List<FileComponent> fakeAudioFiles;


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

        treeEntries.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends TreeItem<FileComponent>> obs, TreeItem<FileComponent> oldValue, TreeItem<FileComponent> newValue) ->
                {
                    properties.forEach((k, v) -> v.update(newValue.getValue()));
                });

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

        fakeTitles = Arrays.<String>asList("File1", "File2", "File3", "File4", "File5", "Fil1", "Fil2", "Fil3", "Fil4", "Fil5");
        fakeVideoFiles = Arrays.<FileComponent>asList(
                new FileComponent("VC-1", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("MP4", "Video", true, "eng", "", 0, true, false, "", "1600x900 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("VC-1", "Video", true, "fre", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("VC-2", "Video", true, "rus", "", 0, true, false, "", "1440x900 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("VC-3", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("VC-2", "Video", true, "chn", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("AVI", "Video", true, "eng", "", 0, true, false, "", "1280x720 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("Microsoft", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("Apple", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("HEVC", "Video", true, "eng", "", 0, true, false, "", "1920x1080 pixels", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", "")
        );
        fakeAudioFiles = Arrays.<FileComponent>asList(
                new FileComponent("PCM", "Audio", true, "eng", "", 1, true, false, "", "48000 Hz, 8 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("MP3", "Audio", true, "jpn", "", 1, true, false, "", "24000 Hz, 7 channels, 8 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("MP3", "Audio", true, "jpn", "", 1, true, false, "", "48000 Hz, 6 channels, 8 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("PCM", "Audio", true, "eng", "", 1, true, false, "", "96000 Hz, 5 channels, 4 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("OGG", "Audio", true, "rus", "", 1, true, false, "", "48000 Hz, 4 channels, 4 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("OGG", "Audio", true, "ger", "", 1, true, false, "", "48000 Hz, 3 channels, 32 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("OPUS", "Audio", true, "eng", "", 1, true, false, "", "48000 Hz, 2 channels, 64 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("MP3", "Audio", true, "eng", "", 1, true, false, "", "48000 Hz, 1 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("MP2", "Audio", true, "esp", "", 1, true, false, "", "48000 Hz, 1 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("PCM", "Audio", true, "swe", "", 1, true, false, "", "8000 Hz, 1 channels, 128 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("PCM", "Audio", true, "eng", "", 1, true, false, "", "16000 Hz, 2 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", ""),
                new FileComponent("PCM", "Audio", true, "eng", "", 1, true, false, "", "48000 Hz, 8 channels, 16 bits per sample", "VC1-1080p23.976-LPCM7.1.mkv", "/dev/null", "", "")
        );
    }


    public Boolean hasNoEntries()
    {
        return treeEntries.getRoot().getChildren().isEmpty();
    }


    public void addRandomVideo(String ext)
    {
        addEntry(
                new FileComponent(Utils.<String>getRandomFromList(fakeTitles) + "." + ext),
                Utils.<FileComponent>getRandomFromList(fakeVideoFiles),
                Utils.<FileComponent>getRandomFromList(fakeAudioFiles)
        );
    }


    public void addRandomAudio(String ext)
    {
        addEntry(
                new FileComponent(Utils.<String>getRandomFromList(fakeTitles) + "." + ext),
                Utils.<FileComponent>getRandomFromList(fakeAudioFiles)
        );
    }


    private void addEntry(FileComponent rootEntry, FileComponent... children)
    {
        TreeItem<FileComponent> e = new TreeItem<>(rootEntry);
        e.getChildren().addAll(Arrays.<FileComponent>asList(children).stream().map(TreeItem<FileComponent>::new).collect(Collectors.toList()));
        e.setExpanded(true);
        treeEntries.getRoot().getChildren().add(e);
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
