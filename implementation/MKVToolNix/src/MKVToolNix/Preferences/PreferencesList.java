/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.Misc.NotImplemented;
import MKVToolNix.Preferences.ExecutingActions.ExecutingActions;
import MKVToolNix.Preferences.PredefinedValues.PredefinedValues;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public class PreferencesList extends CustomAnchorPane
{
    private static class PreferencesTreeItem extends TreeItem<String>
    {
        public PreferencesTreeItem()
        {
            super();
        }


        public PreferencesTreeItem(String text, String imgPath, Boolean expand)
        {
            super();

            setValue(text);
            if (imgPath != null && !imgPath.isEmpty())
                setGraphic(makeImage(imgPath));
            setExpanded(expand);
        }


        private ImageView makeImage(String path)
        {
            return new ImageView(new Image(new File(path).toURI().toString()));
        }
    }


    private static class PreferenceEntry
    {
        private PreferencesTreeItem node;
        private String imgPath;
        private Boolean expand;
        private CustomAnchorPane preferencePane;


        public PreferenceEntry(String imgPath, Boolean expand, CustomAnchorPane preferencePane)
        {
            this.imgPath = imgPath;
            this.expand = expand;
            this.preferencePane = preferencePane;
        }


        public void initNode(String s)
        {
            node = new PreferencesTreeItem(s, imgPath, expand);
        }


        public PreferencesTreeItem getNode()
        {
            return node;
        }


        public String getImgPath()
        {
            return imgPath;
        }


        public Boolean getExpand()
        {
            return expand;
        }


        public CustomAnchorPane getPreferencePane()
        {
            return preferencePane;
        }
    }

    @FXML
    private TreeView<String> treePreferences;
    private AnchorPane content;

    private Map<String, PreferenceEntry> entries = new HashMap<>();


    public PreferencesList(AnchorPane content)
    {
        super("Preferences/PreferencesList.fxml");

        this.content = content;

        PreferencesTreeItem root = new PreferencesTreeItem();
        root.setExpanded(true);

        entries.put("GUI", new PreferenceEntry("resources/icons/16x16/mkvmerge.png", true, new NotImplemented()));
        entries.put("Multiplexer", new PreferenceEntry("resources/icons/16x16/merge.png", true, new NotImplemented()));
        entries.put("Info tool", new PreferenceEntry("resources/icons/16x16/document-preview-archive.png", false, new NotImplemented()));
        entries.put("Header editor", new PreferenceEntry("resources/icons/16x16/document-edit.png", false, new NotImplemented()));
        entries.put("Chapter editor", new PreferenceEntry("resources/icons/16x16/story-editor.png", false, new NotImplemented()));
        entries.put("Jobs & job queue", new PreferenceEntry("resources/icons/16x16/view-task.png", true, new NotImplemented()));

        entries.put("Often used selections", new PreferenceEntry("", false, new NotImplemented()));

        entries.put("Predefined values", new PreferenceEntry("", false, new PredefinedValues()));
        entries.put("Default values", new PreferenceEntry("", false, new NotImplemented()));
        entries.put("Deriving track languages", new PreferenceEntry("", false, new NotImplemented()));
        entries.put("Destination file name", new PreferenceEntry("", false, new NotImplemented()));
        entries.put("Enabling items", new PreferenceEntry("", false, new NotImplemented()));
        entries.put("Playlists & Blu-rays", new PreferenceEntry("", false, new NotImplemented()));

        entries.put("Executing actions", new PreferenceEntry("", false, new ExecutingActions()));

        entries.forEach((k, v) -> v.initNode(k));

        entries.get("GUI").getNode().getChildren().add(entries.get("Often used selections").getNode());
        entries.get("Multiplexer").getNode().getChildren().addAll(
                entries.get("Predefined values").getNode(),
                entries.get("Default values").getNode(),
                entries.get("Deriving track languages").getNode(),
                entries.get("Destination file name").getNode(),
                entries.get("Enabling items").getNode(),
                entries.get("Playlists & Blu-rays").getNode()
        );
        entries.get("Jobs & job queue").getNode().getChildren().add(entries.get("Executing actions").getNode());

        root.getChildren().addAll(entries.get("GUI").getNode(),
                                  entries.get("Multiplexer").getNode(),
                                  entries.get("Info tool").getNode(),
                                  entries.get("Header editor").getNode(),
                                  entries.get("Chapter editor").getNode(),
                                  entries.get("Jobs & job queue").getNode());
        treePreferences.setRoot(root);
        treePreferences.setShowRoot(false);

        treePreferences.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends TreeItem<String>> obs, TreeItem<String> oldValue, TreeItem<String> newValue) ->
                {
                    AnchorPane pane = entries.get(newValue.getValue()).getPreferencePane();
                    content.getChildren().clear();
                    AnchorPane.setTopAnchor(pane, 0.0);
                    AnchorPane.setBottomAnchor(pane, 0.0);
                    AnchorPane.setLeftAnchor(pane, 0.0);
                    AnchorPane.setRightAnchor(pane, 0.0);
                    content.getChildren().add(pane);
                });
    }
}
