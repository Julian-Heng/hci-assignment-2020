/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.Misc;

import MKVToolNix.CustomAnchorPane;


/**
 *
 * @author student
 */
public class NotImplemented extends CustomAnchorPane
{
    public static NotImplemented instance = null;


    private NotImplemented()
    {
        super("Misc/NotImplemented.fxml");
    }


    public static NotImplemented getInstance()
    {
        return ((instance == null ? new NotImplemented() : instance));
    }
}
