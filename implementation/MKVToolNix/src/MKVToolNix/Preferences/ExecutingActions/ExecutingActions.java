/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences.ExecutingActions;

import MKVToolNix.CustomAnchorPane;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public class ExecutingActions extends CustomAnchorPane
{
    private static class ActionEntry
    {
        private Boolean active;
        private String name;
        private String type;
        private Boolean afterJobSuccess;
        private Boolean afterJobError;
        private Boolean afterJobQueueStop;


        public ActionEntry(String name)
        {
            active = true;
            this.name = name;
            type = "Play an audio file";
            afterJobSuccess = false;
            afterJobError = false;
            afterJobQueueStop = false;
        }


        public Boolean getActive()
        {
            return active;
        }


        public String getName()
        {
            return name;
        }


        public String getType()
        {
            return type;
        }


        public Boolean getAfterJobSuccess()
        {
            return afterJobSuccess;
        }


        public Boolean getAfterJobError()
        {
            return afterJobError;
        }


        public Boolean getAfterJobQueueStop()
        {
            return afterJobQueueStop;
        }


        public void setActive(Boolean active)
        {
            this.active = active;
        }


        public void setName(String name)
        {
            this.name = name;
        }


        public void setType(String type)
        {
            this.type = type;
        }


        public void setAfterJobSuccess(Boolean afterJobSuccess)
        {
            this.afterJobSuccess = afterJobSuccess;
        }


        public void setAfterJobError(Boolean afterJobError)
        {
            this.afterJobError = afterJobError;
        }


        public void setAfterJobQueueStop(Boolean afterJobQueueStop)
        {
            this.afterJobQueueStop = afterJobQueueStop;
        }


        @Override
        public String toString()
        {
            String format = "ActionEntry(active = %s, name = %s, type = %s, afterJobSuccess = %s, afterJobError = %s, afterJobQueueStop = %s)";
            return String.format(format, active.toString(), name, type, afterJobSuccess.toString(), afterJobError.toString(), afterJobQueueStop.toString());
        }
    }

    @FXML
    private ListView<String> listActions;
    private ObservableList<String> obsListActions;

    @FXML
    private AnchorPane paneAction;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnRemove;
    @FXML
    private CheckBox chkActive;
    @FXML
    private TextField txtName;
    @FXML
    private MenuButton menuType;
    @FXML
    private CheckBox chkAfterJobSuccess;
    @FXML
    private CheckBox chkAfterJobError;
    @FXML
    private CheckBox chkAfterJobQueueStop;
    @FXML
    private Button btnExecute;
    @FXML
    private AnchorPane paneSpecific;

    private Map<String, AnchorPane> mapPaneSpecific;
    private Map<String, ActionEntry> actions;


    public ExecutingActions()
    {
        super("Preferences/ExecutingActions/ExecutingActions.fxml");

        obsListActions = FXCollections.observableArrayList();
        listActions.setItems(obsListActions);

        mapPaneSpecific = new HashMap<>();
        mapPaneSpecific.put("Execute a program", new ExecuteProgramPane());
        mapPaneSpecific.put("Play an audio file", new AudioFilePane());
        mapPaneSpecific.put("Shut down the computer", new AnchorPane());
        mapPaneSpecific.put("Hibernate the computer", new AnchorPane());
        mapPaneSpecific.put("Sleep the computer", new AnchorPane());
        mapPaneSpecific.put("Delete source files for multiplexer jobs", new AnchorPane());
        updateSpecificPane();

        actions = new HashMap<>();

        listActions.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> obs, String oldValue, String newValue) -> updateActionPane(actions.get(newValue)));
    }


    @FXML
    private void handleBtnAdd(ActionEvent e)
    {
        String base = "New value";
        String name = base;
        int i = 2;
        while (actions.containsKey(name))
            name = String.format("%s (%d)", base, i++);
        listActions.getItems().add(listActions.getItems().size(), name);
        actions.put(name, new ActionEntry(name));
    }


    @FXML
    private void handleBtnRemove(ActionEvent e)
    {
        String name = listActions.getSelectionModel().getSelectedItem();
        listActions.getItems().remove(name);
        actions.remove(name);
    }


    @FXML
    private void handleChkActive(ActionEvent e)
    {
        getSelectedEntry().setActive(chkActive.isSelected());
    }


    @FXML
    private void handleTxtName(ActionEvent e)
    {
        String name = txtName.getText();
        ActionEntry entry = actions.remove(getSelectedEntry().getName());

        if (name.isEmpty())
        {
            (new Alert(AlertType.ERROR, "Name can't be empty")).showAndWait();
            actions.put(entry.getName(), entry);
            txtName.setText(entry.getName());
            return;
        }

        if (actions.containsKey(name))
        {
            (new Alert(AlertType.ERROR, "Name already exists")).showAndWait();
            actions.put(entry.getName(), entry);
            txtName.setText(entry.getName());
            return;
        }

        for (String s : listActions.getItems())
        {
            if (s.contains(entry.getName()))
            {
                listActions.getItems().set(listActions.getItems().indexOf(s), name);
                break;
            }
        }

        entry.setName(name);
        actions.put(name, entry);
        updateActionPane(entry);
    }


    @FXML
    private void handleMenuTypeSelection(ActionEvent e)
    {
        menuType.setText(((MenuItem)e.getSource()).getText());
        getSelectedEntry().setType(menuType.getText());
        updateSpecificPane();
    }


    @FXML
    private void handleChkAfterJobSuccess(ActionEvent e)
    {
        getSelectedEntry().setAfterJobSuccess(chkAfterJobSuccess.isSelected());
    }


    @FXML
    private void handleChkAfterJobError(ActionEvent e)
    {
        getSelectedEntry().setAfterJobError(chkAfterJobError.isSelected());
    }


    @FXML
    private void handleChkAfterJobQueueStop(ActionEvent e)
    {
        getSelectedEntry().setAfterJobQueueStop(chkAfterJobQueueStop.isSelected());
    }


    @FXML
    private void handleBtnExecute(ActionEvent e)
    {
        System.out.println("Pressed \"execute now\"");
    }


    private void updateActionPane(ActionEntry e)
    {
        if (e == null)
        {
            paneAction.setDisable(true);
            return;
        }

        chkActive.setSelected(e.getActive());
        txtName.setText(e.getName());
        menuType.setText(e.getType());
        chkAfterJobSuccess.setSelected(e.getAfterJobSuccess());
        chkAfterJobError.setSelected(e.getAfterJobError());
        chkAfterJobQueueStop.setSelected(e.getAfterJobQueueStop());

        paneAction.setDisable(!e.getActive());
        updateSpecificPane();
    }


    private void updateSpecificPane()
    {
        AnchorPane pane = mapPaneSpecific.get(menuType.getText());
        paneSpecific.getChildren().clear();
        AnchorPane.setTopAnchor(pane, 0.0);
        AnchorPane.setBottomAnchor(pane, 0.0);
        AnchorPane.setLeftAnchor(pane, 0.0);
        AnchorPane.setRightAnchor(pane, 0.0);
        paneSpecific.getChildren().add(pane);
    }


    private ActionEntry getSelectedEntry()
    {
        return actions.get(listActions.getSelectionModel().getSelectedItem());
    }
}
