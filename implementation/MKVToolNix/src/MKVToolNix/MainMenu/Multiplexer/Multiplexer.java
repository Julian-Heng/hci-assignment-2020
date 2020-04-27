/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.Misc.NotImplemented;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


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


        public MultiplexerJob()
        {
            super("MainMenu/Multiplexer/MultiplexerJob.fxml");

            tabInput.setContent(new MultiplexerInput());
            tabOutput.setContent(NotImplemented.getInstance());
            tabAttachment.setContent(NotImplemented.getInstance());
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
