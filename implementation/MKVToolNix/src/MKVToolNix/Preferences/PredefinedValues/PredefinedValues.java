/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences.PredefinedValues;

import MKVToolNix.CustomAnchorPane;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.cell.TextFieldListCell;


/**
 *
 * @author student
 */
public class PredefinedValues extends CustomAnchorPane
{
    private static class PredefinedValuesTab extends CustomAnchorPane
    {
        private String tabName;
        private ObservableList values;

        @FXML
        private ListView<String> listValues;
        @FXML
        private Button btnAdd;
        @FXML
        private Button btnRemove;


        public PredefinedValuesTab(String tabName, List<String> values)
        {
            super("Preferences/PredefinedValues/PredefinedValuesTab.fxml");
            this.tabName = tabName;
            this.values = values == null
                          ? FXCollections.observableArrayList()
                          : FXCollections.observableArrayList(values);
            listValues.setItems(this.values);

            listValues.setCellFactory(TextFieldListCell.forListView());
            listValues.setEditable(true);
        }


        public String getTabName()
        {
            return tabName;
        }


        @FXML
        private void handleBtnAdd(ActionEvent e)
        {
            listValues.getItems().add(listValues.getItems().size(), "New value");
        }


        @FXML
        private void handleBtnRemove(ActionEvent e)
        {
            listValues.getItems().remove(listValues.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private TabPane tabPredefinedValues;


    public PredefinedValues()
    {
        super("Preferences/PredefinedValues/PredefinedValues.fxml");

        List<String> splitSizeDefault = new ArrayList<>();
        List<String> splitDurationDefault = new ArrayList<>();

        splitSizeDefault.add("350M");
        splitSizeDefault.add("650M");
        splitSizeDefault.add("700M");
        splitSizeDefault.add("703M");
        splitSizeDefault.add("800M");
        splitSizeDefault.add("1000M");
        splitSizeDefault.add("4483M");
        splitSizeDefault.add("8142M");

        splitDurationDefault.add("01:00:00");
        splitDurationDefault.add("1800s");

        PredefinedValuesTab video = new PredefinedValuesTab("Video track names", null);
        PredefinedValuesTab audio = new PredefinedValuesTab("Audio track names", null);
        PredefinedValuesTab subtitle = new PredefinedValuesTab("Subtitle track names", null);
        PredefinedValuesTab splitSize = new PredefinedValuesTab("Split sizes", splitSizeDefault);
        PredefinedValuesTab splitDuration = new PredefinedValuesTab("Split durations", splitDurationDefault);

        tabPredefinedValues.getTabs().addAll(new Tab(video.getTabName(), video),
                                             new Tab(audio.getTabName(), audio),
                                             new Tab(subtitle.getTabName(), subtitle),
                                             new Tab(splitSize.getTabName(), splitSize),
                                             new Tab(splitDuration.getTabName(), splitDuration));
    }
}
