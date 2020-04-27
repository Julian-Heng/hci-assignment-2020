/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Preferences.ExecutingActions;

import MKVToolNix.CustomAnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


/**
 *
 * @author student
 */
public class ExecuteProgramPane extends CustomAnchorPane
{
    @FXML
    private TextArea txtHelp;


    public ExecuteProgramPane()
    {
        super("Preferences/ExecutingActions/ExecuteProgramPane.fxml");

        txtHelp.appendText("Usage and examples\n");
        txtHelp.appendText("  - The command line here uses Unix-style shell escaping via the backslash character even on Windows. This means that either backslashes must be doubled or the whole argument must be enclosed in single quotes. See below for examples.\n");
        txtHelp.appendText("  - Always use full path names even if the application is located in the same directory as the GUI.\n");
        txtHelp.appendText("  - Start file types other than executable files via xdg-open. See below for examples.\n");
        txtHelp.appendText("\n");
        txtHelp.appendText("\n");
        txtHelp.appendText("Examples\n");
        txtHelp.appendText("  - Play a WAV file with the default application:  /usr/bin/xdg-open /home/janedoe/Audio/signal.wav\n");
        txtHelp.appendText("  - Shut down the system in one minute:  /usr/bin/sudo /sbin/shutdown --poweroff +1\n");
        txtHelp.appendText("  - Open the multiplexed file with a player:\n");
        txtHelp.appendText("        /usr/bin/vlc '<MTX_DESTINATION_FILE_NAME>'");
    }
}
