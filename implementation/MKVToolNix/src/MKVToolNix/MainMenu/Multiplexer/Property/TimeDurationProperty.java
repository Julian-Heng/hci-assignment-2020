/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;


/**
 *
 * @author student
 */
public class TimeDurationProperty extends Property
{
    public TimeDurationProperty()
    {
        super();
        
        addTextField("Delay (in ms)");
        addTextField("Stretch by");
        addTextFieldDropdownMenu("Default duration/FPS",
                                 "24p", "25p", "30p", "48p", "50i", "50p", "60i",
                                 "60p", "24000/1001p", "30000/1001p", "48000/1001p",
                                 "60000/1001i", "60000/1001p");
        addFileSelector("Timestamp file");
        addCheckbox("Fix bitstream timing info");
        init();
    }
}
