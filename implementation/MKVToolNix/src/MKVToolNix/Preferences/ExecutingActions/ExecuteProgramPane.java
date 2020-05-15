/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences.ExecutingActions;

import MKVToolNix.CustomAnchorPane;
import java.util.stream.Stream;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author student
 */
public class ExecuteProgramPane extends CustomAnchorPane
{
    @FXML
    private TextArea txtHelp;
    @FXML
    private TextField txtCommand;
    @FXML
    private Button btnAddCommand;


    public ExecuteProgramPane()
    {
        super("Preferences/ExecutingActions/ExecuteProgramPane.fxml");

        Stream.of(
                "Usage and examples\n",
                "  - The command line here uses Unix-style shell escaping via the backslash character even on Windows. This means that either backslashes must be doubled or the whole argument must be enclosed in single quotes. See below for examples.\n",
                "  - Always use full path names even if the application is located in the same directory as the GUI.\n",
                "  - Start file types other than executable files via xdg-open. See below for examples.\n",
                "\n",
                "\n",
                "Examples\n",
                "  - Play a WAV file with the default application:  /usr/bin/xdg-open /home/janedoe/Audio/signal.wav\n",
                "  - Shut down the system in one minute:  /usr/bin/sudo /sbin/shutdown --poweroff +1\n",
                "  - Open the multiplexed file with a player:\n",
                "        /usr/bin/vlc '<MTX_DESTINATION_FILE_NAME>'"
        ).forEach(i -> txtHelp.appendText(i));

        btnAddCommand.setOnAction(e ->
        {
            txtCommand.setText((new FileChooser()).showOpenDialog(((Stage)getScene().getWindow())).getName());
        });
    }
}
