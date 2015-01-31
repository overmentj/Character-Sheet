package org.moss.charactersheet.gui;

import java.awt.Component;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Generator for speed etc
 * @author Jacq
 *
 */
public class GenerateSpeedComponents
{
	private static final Map<String, Component> ELEMENTS = new LinkedHashMap<>();
	
	static {
		ELEMENTS.put("Speed", new JTextField(30));
		ELEMENTS.put("Initiative", new JTextField(10));
	}
	
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
        for (Entry<String, Component> elem : ELEMENTS.entrySet()) {
        	String compName = elem.getKey();
        	Component comp = elem.getValue();
        	JLabel label = new JLabel(compName);
        	comp.setName(compName);
        	comps.add(label);
        	comps.add(comp);
        }
        return comps;
    }

}
