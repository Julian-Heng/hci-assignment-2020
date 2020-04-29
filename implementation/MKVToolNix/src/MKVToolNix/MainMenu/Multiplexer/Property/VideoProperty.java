/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

import MKVToolNix.Misc.Pair;


/**
 *
 * @author student
 */
public class VideoProperty extends Property
{
    public VideoProperty()
    {
        super();

        addRadioChoice(new Pair<>("Set aspect ratio", new AspectRatioView()), new Pair<>("Display width/height", new ResolutionView()));
        addTextField("Cropping");
        addDropdownMenu("Stereoscopy", "", "mono");
        addDropdownMenu("NALU size length", "Don't change", "Force 2 bytes", "Force 4 bytes");

        init();
    }
}
