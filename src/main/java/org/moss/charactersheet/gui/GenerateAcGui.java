package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.aspects.ArmourClass;
import org.moss.charactersheet.util.LabelUtils;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;

/**
 * Generator for armour class
 * @author Jacq
 *
 */
public class GenerateAcGui
{
    private SpringLayout layout;
    private List<Component> pageComponents = new ArrayList<Component>();

    /**
     * Creates new generator that considers given parameters
     * @param layout
     * @param components
     */
    public GenerateAcGui(SpringLayout layout, List<Component> components)
    {
        this.layout = layout;
        this.pageComponents = components;
    }

    /**
     * Generates the components required and adds them to the list.
     * Also builds on the layout.
     * @param northComponent
     * @param westComponent
     * @return
     */
    public Component generate(Component northComponent, Component westComponent)
    {
        JPanel armourClass = new JPanel(new GridBagLayout());

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel name = new JLabel("AC");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(name, constraint);

        constraint.gridheight = 1;

        JTextField total = new JTextField(2);
        total.setEditable(false);
        total.setText("0");
        constraint.gridx = 1;
        constraint.gridy = 0;
        armourClass.add(total, constraint);

        JLabel JLabelTotal = new JLabel("Total");
        JLabelTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 1;
        armourClass.add(JLabelTotal, constraint);

        JLabel JLabelEquals = new JLabel("  =  ");
        constraint.gridx = 2;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelEquals, constraint);

        constraint.gridheight = 1; // reset

        JTextField base = new JTextField(2);
        base.setText("10");
        base.setEditable(false);
        constraint.gridx = 3;
        constraint.gridy = 0;
        armourClass.add(base, constraint);

        JLabel JLabelPlus1 = new JLabel("  +  ");
        constraint.gridx = 4;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus1, constraint);

        constraint.gridheight = 1;

        JFormattedTextField textArmour = new JFormattedTextField();
        constraint.gridx = 5;
        constraint.gridy = 0;
        armourClass.add(textArmour, constraint);

        JLabel JLabelArmour = new JLabel(LabelUtils.multiLine("Armour\nBonus", true));
        JLabelArmour.setFont(small);
        constraint.gridx = 5;
        constraint.gridy = 1;
        armourClass.add(JLabelArmour, constraint);

        JLabel JLabelPlus2 = new JLabel("  +  ");
        constraint.gridx = 6;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus2, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textShield = new JFormattedTextField();
        constraint.gridx = 7;
        constraint.gridy = 0;
        armourClass.add(textShield, constraint);

        JLabel labelShield = new JLabel(LabelUtils.multiLine("Shield\nBonus", true));
        labelShield.setFont(small);
        constraint.gridx = 7;
        constraint.gridy = 1;
        armourClass.add(labelShield, constraint);

        JLabel labelPlus3 = new JLabel("  +  ");
        constraint.gridx = 8;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(labelPlus3, constraint);

        constraint.gridheight = 1; // reset

        JTextField textDex = new JTextField(2);
        textDex.setEditable(false);
        constraint.gridx = 9;
        constraint.gridy = 0;
        armourClass.add(textDex, constraint);

        JLabel labelDex = new JLabel(LabelUtils.multiLine("Dex\nmodifier", true));
        labelDex.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 1;
        armourClass.add(labelDex, constraint);

        JLabel labelPlus4 = new JLabel("  +  ");
        constraint.gridx = 10;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(labelPlus4, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textSize = new JFormattedTextField();
        constraint.gridx = 11;
        constraint.gridy = 0;
        armourClass.add(textSize, constraint);

        JLabel labelSize = new JLabel(LabelUtils.multiLine("Size\nmodifier", true));
        labelSize.setFont(small);
        constraint.gridx = 11;
        constraint.gridy = 1;
        armourClass.add(labelSize, constraint);

        JLabel JLabelPlus5 = new JLabel("  +  ");
        constraint.gridx = 12;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus5, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textNatrual = new JFormattedTextField();
        constraint.gridx = 13;
        constraint.gridy = 0;
        armourClass.add(textNatrual, constraint);

        JLabel labelNatural = new JLabel(LabelUtils.multiLine("Natural\nArmour", true));
        labelNatural.setFont(small);
        constraint.gridx = 13;
        constraint.gridy = 1;
        armourClass.add(labelNatural, constraint);

        JLabel JLabelPlus6 = new JLabel("  +  ");
        constraint.gridx = 14;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus6, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textDeflection = new JFormattedTextField();
        constraint.gridx = 15;
        constraint.gridy = 0;
        armourClass.add(textDeflection, constraint);

        JLabel labelDeflection = new JLabel(LabelUtils.multiLine("Deflection\nModifier", true));
        labelDeflection.setFont(small);
        constraint.gridx = 15;
        constraint.gridy = 1;
        armourClass.add(labelDeflection, constraint);

        JLabel JLabelPlus7 = new JLabel("  +  ");
        constraint.gridx = 16;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus7, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textMisc = new JFormattedTextField();
        constraint.gridx = 17;
        constraint.gridy = 0;
        armourClass.add(textMisc, constraint);

        JLabel labelMisc = new JLabel(LabelUtils.multiLine("Misc\nModifier", true));
        labelMisc.setFont(small);
        constraint.gridx = 17;
        constraint.gridy = 1;
        armourClass.add(labelMisc, constraint);

        JLabel labelTouch = new JLabel("Touch AC");
        labelMisc.setFont(small);
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 3;
        armourClass.add(labelTouch, constraint);
        constraint.gridwidth = 1;

        JTextField textTouch = new JTextField(2);
        textTouch.setEditable(false);
        constraint.gridx = 4;
        constraint.gridy = 2;
        armourClass.add(textTouch, constraint);

        JLabel labelFlat = new JLabel("Flat-Footed AC");
        constraint.gridx = 5;
        constraint.gridy = 2;
        constraint.gridwidth = 5;
        armourClass.add(labelFlat, constraint);
        constraint.gridwidth = 1;

        JTextField textFlat = new JTextField(2);
        textFlat.setEditable(false);
        constraint.gridx = 10;
        constraint.gridy = 2;
        armourClass.add(textFlat, constraint);

        layout.putConstraint(WEST, armourClass, 5, WEST, westComponent);
        layout.putConstraint(NORTH, armourClass, 5, SOUTH, northComponent);
        pageComponents.add(armourClass);

        new ArmourClass(total, textArmour, textShield, textDex, textSize, textNatrual, textDeflection, textMisc,
                        textFlat, textTouch);

        return armourClass;
    }
}
