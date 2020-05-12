/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer;

import MKVToolNix.AddSources.AddSourceFilesController;
import MKVToolNix.CustomAnchorPane;
import MKVToolNix.MKVToolNix;
import MKVToolNix.Misc.NotImplemented;
import MKVToolNix.Utils;
import java.io.IOException;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author student
 */
public class Multiplexer extends CustomAnchorPane
{
    public class MultiplexerJob extends CustomAnchorPane
    {
        @FXML
        private Tab tabInput;
        @FXML
        private Tab tabOutput;
        @FXML
        private Tab tabAttachment;
        @FXML
        private TextField txtDestination;
        @FXML
        private Button btnDestination;
        @FXML
        private SplitMenuButton btnAddSources;

        private MultiplexerInput input;


        public MultiplexerJob()
        {
            super("MainMenu/Multiplexer/MultiplexerJob.fxml");

            input = new MultiplexerInput();
            tabInput.setContent(input);
            tabOutput.setContent(new NotImplemented("resources/stubs/Output.png"));
            tabAttachment.setContent(new NotImplemented("resources/stubs/Attachment.png"));
            btnDestination.setOnAction(e ->
            {
                txtDestination.setText((new FileChooser()).showOpenDialog(((Stage)getScene().getWindow())).getName());
            });

            btnAddSources.setOnAction(e ->
            {
                addEntry((new FileChooser()).showOpenDialog(((Stage)getScene().getWindow())).getName());
            });
        }


        @FXML
        private void handleFileHover(DragEvent e)
        {
            if (e.getDragboard().hasFiles())
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            e.consume();
        }


        @FXML
        private void handleFileDrop(DragEvent e) throws IOException
        {
            Dragboard db = e.getDragboard();
            Boolean success = false;

            if (!input.hasNoEntries())
            {
                Stage s;
                FXMLLoader loader;
                AddSourceFilesController c;
                Parent p;

                loader = new FXMLLoader(MKVToolNix.class.getResource("AddSources/AddSourceFiles.fxml"));
                p = loader.load();
                c = loader.getController();
                c.setJobs(tabJobs.getTabs().stream().map(Tab::getText).collect(Collectors.toList()));

                s = Utils.openWindow(p, "Adding or appending files", 346.0, 337.0);
                s.setResizable(false);
                s.showAndWait();
            }

            if (db.hasFiles())
                addEntry(db.getFiles().get(0).getAbsolutePath());

            e.setDropCompleted(success);
            e.consume();
        }


        private void addEntry(String path)
        {

            String ext = Utils.getFileExtension(path);
            ext = ext.toLowerCase();
            switch (ext)
            {
                case "mkv":
                case "mp4":
                case "webm":
                case "flv":
                case "avi":
                case "mov":
                    input.addRandomVideo(ext);
                    break;
                case "mp3":
                case "ogg":
                case "flac":
                case "wav":
                    input.addRandomAudio(ext);
                    break;
            }
        }
    }

    @FXML
    private TabPane tabJobs;


    public Multiplexer()
    {
        super("MainMenu/Multiplexer/Multiplexer.fxml");

        // Add dummy page
        tabJobs.getTabs().add(new Tab("New tab", new MultiplexerJob()));
    }
}
