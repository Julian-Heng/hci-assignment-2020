/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

import MKVToolNix.MainMenu.Multiplexer.FileComponent;


/**
 *
 * @author student
 */
public class AudioProperty extends Property
{
    public AudioProperty()
    {
        super();

        addDropdownMenu("AAC is SBR/HE-AAC/AAC+", "Determine automatically");
        addCheckbox("Reduce to core");
        addCheckbox("Remove dialog normalization gain");

        init();
    }


    @Override
    public void update(FileComponent f)
    {
        if (f.getType().equals("Video"))
            setDisabled(true);
        else if (f.getType().equals("Audio"))
            setDisabled(false);
        else
            setDisabled(true);
    }
}
