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
public class GeneralProperty extends Property
{
    public GeneralProperty()
    {
        super();

        addDropdownMenu("Copy this item", "Yes", "No");
        addTextFieldDropdownMenu("Track name");
        addDropdownMenu("Language", "English (eng)", "Other");
        addDropdownMenu("\"Default track\" flag", 1, "Determine automatically", "Yes", "No");
        addDropdownMenu("\"Forced track\" flag", "Yes", "No");
        addDropdownMenu("Compression", "Determine automatically", "No extra compression", "zlib");
        addFileSelector("Tags");

        init();
    }
}
