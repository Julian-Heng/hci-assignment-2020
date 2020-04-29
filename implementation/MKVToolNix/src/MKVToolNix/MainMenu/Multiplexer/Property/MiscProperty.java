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
public class MiscProperty extends Property
{
    public MiscProperty()
    {
        super();
        
        addDropdownMenu("Indexing (cues)", "Determine automatically",
                        "Only from I frames", "For all frames", "No cues");
        addTextField("Additional options");
        
        init();
    }
}
