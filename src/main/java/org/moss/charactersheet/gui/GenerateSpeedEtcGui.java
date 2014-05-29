package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;

/**
 * Generator for speed etc
 * @author Jacq
 *
 */
public class GenerateSpeedEtcGui
{
    private SpringLayout layout;
    private Container tabPanel;
    private List<Component> pageComponents = new ArrayList<Component>();

    /**
     * Creates new generator that considers given parameters
     * @param layout
     * @param panel
     * @param components
     */
    public GenerateSpeedEtcGui(SpringLayout layout, Container panel, List<Component> components)
    {
        this.layout = layout;
        this.tabPanel = panel;
        this.pageComponents = components;
    }

    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @param northComponent
     * @return
     */
    public Component generate(Component northComponent)
    {
        JLabel labelSpeed = new JLabel("Speed");
        pageComponents.add(labelSpeed);
        JTextField textSpeed = new JTextField(30);
        pageComponents.add(textSpeed);

        layout.putConstraint(NORTH, textSpeed, 0, NORTH, labelSpeed);
        layout.putConstraint(WEST, textSpeed, 2, EAST, labelSpeed);

        layout.putConstraint(NORTH, labelSpeed, 0, SOUTH, northComponent);
        layout.putConstraint(WEST, labelSpeed, 5, WEST, tabPanel);

        JLabel labelInitMod = new JLabel("Initiative Modifier");
        pageComponents.add(labelInitMod);
        JTextField textInitMod = new JTextField(10);
        pageComponents.add(textInitMod);

        layout.putConstraint(NORTH, textInitMod, 0, NORTH, labelInitMod);
        layout.putConstraint(WEST, textInitMod, 2, EAST, labelInitMod);

        layout.putConstraint(NORTH, labelInitMod, 0, SOUTH, northComponent);
        layout.putConstraint(WEST, labelInitMod, 5, EAST, textSpeed);

        return labelSpeed;
    }

}
