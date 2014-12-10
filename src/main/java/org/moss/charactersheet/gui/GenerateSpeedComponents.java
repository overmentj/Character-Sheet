package org.moss.charactersheet.gui;

import java.awt.Component;
import java.util.List;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Generator for speed etc
 * @author Jacq
 *
 */
public class GenerateSpeedComponents
{
    /**
     * Creates new generator
     */
    public GenerateSpeedComponents()
    {
    }

    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @return List
     */
    public List<Component> generate()
    {
    	List<Component> comps = new LinkedList<>();
    	
        JLabel labelSpeed = new JLabel("Speed");
        comps.add(labelSpeed);
        JTextField textSpeed = new JTextField(30);
        comps.add(textSpeed);

        JLabel labelInitMod = new JLabel("Initiative Modifier");
        comps.add(labelInitMod);
        JTextField textInitMod = new JTextField(10);
        comps.add(textInitMod);

        return comps;
    }

}
