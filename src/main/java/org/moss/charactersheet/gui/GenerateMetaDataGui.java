package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.CharacterSheet;

import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;

/**
 * Generator for character meta data
 * @author Jacq
 *
 */
public class GenerateMetaDataGui
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
    public GenerateMetaDataGui(SpringLayout layout, Container panel, List<Component> components)
    {
        this.layout = layout;
        this.tabPanel = panel;
        this.pageComponents = components;
    }

    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     */
    public void generate()
    {
        // Char Name
        JLabel labelCharName = new JLabel("Character Name");
        pageComponents.add(labelCharName);

        JTextField textCharName = new JTextField(20);
        pageComponents.add(textCharName);

        layout.putConstraint(NORTH, textCharName, 0, SOUTH, labelCharName);
        layout.putConstraint(WEST, textCharName, 0, WEST, labelCharName);

        layout.putConstraint(NORTH, labelCharName, 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelCharName, 5, WEST, tabPanel);

        // Player Name
        JLabel labelPlayerName = new JLabel("Player Name");
        pageComponents.add(labelPlayerName);

        JTextField textPlayerName = new JTextField(20);
        pageComponents.add(textPlayerName);

        layout.putConstraint(NORTH, textPlayerName, 0, SOUTH, labelPlayerName);
        layout.putConstraint(WEST, textPlayerName, 0, WEST, labelPlayerName);

        layout.putConstraint(NORTH, labelPlayerName, 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelPlayerName, 250, WEST, tabPanel);

        // Class
        JLabel labelClass = new JLabel("Class");
        pageComponents.add(labelClass);

        JTextField textClass = new JTextField(16);
        pageComponents.add(textClass);

        layout.putConstraint(NORTH, textClass, 0, SOUTH, labelClass);
        layout.putConstraint(WEST, textClass, 0, WEST, labelClass);

        layout.putConstraint(NORTH, labelClass, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelClass, 5, WEST, tabPanel);

        // Level
        JLabel labelLevel = new JLabel("Level");
        pageComponents.add(labelLevel);

        JTextField textLevel = new JTextField(4);
        pageComponents.add(textLevel);

        layout.putConstraint(NORTH, textLevel, 0, SOUTH, labelLevel);
        layout.putConstraint(WEST, textLevel, 0, WEST, labelLevel);

        layout.putConstraint(NORTH, labelLevel, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelLevel, 5, EAST, textClass);

        // ECL
        JLabel labelEcl = new JLabel("ECL");
        pageComponents.add(labelEcl);

        JTextField textEcl = new JTextField(4);
        pageComponents.add(textEcl);

        layout.putConstraint(NORTH, textEcl, 0, SOUTH, labelEcl);
        layout.putConstraint(WEST, textEcl, 0, WEST, labelEcl);

        layout.putConstraint(NORTH, labelEcl, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelEcl, 5, EAST, textLevel);

        // Race/Template
        JLabel labelRace = new JLabel("Race/Template");
        pageComponents.add(labelRace);

        JTextField textRace = new JTextField(8);
        pageComponents.add(textRace);

        layout.putConstraint(NORTH, textRace, 0, SOUTH, labelRace);
        layout.putConstraint(WEST, textRace, 0, WEST, labelRace);

        layout.putConstraint(NORTH, labelRace, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelRace, 5, EAST, textEcl);

        // Size
        JLabel labelSize = new JLabel("Size");
        pageComponents.add(labelSize);

        JComboBox<String> comboSize =
                                      new JComboBox<String>(
                                                            new String[] { "F", "D", "T", "S", "M", "L", "H", "G", "C" });
        pageComponents.add(comboSize);

        layout.putConstraint(NORTH, comboSize, 0, SOUTH, labelSize);
        layout.putConstraint(WEST, comboSize, 0, WEST, labelSize);

        layout.putConstraint(NORTH, labelSize, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelSize, 5, EAST, textRace);

        // Gender
        JLabel labelGender = new JLabel("Gender");
        pageComponents.add(labelGender);

        JComboBox<String> comboGender = new JComboBox<String>(new String[] { "F", "M" });
        pageComponents.add(comboGender);

        layout.putConstraint(NORTH, comboGender, 0, SOUTH, labelGender);
        layout.putConstraint(WEST, comboGender, 0, WEST, labelGender);

        layout.putConstraint(NORTH, labelGender, CharacterSheet.getLineHeight() * 2 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelGender, 5, EAST, comboSize);

        // Alignment
        JLabel labelAlign = new JLabel("Alignment");
        pageComponents.add(labelAlign);

        JComboBox<String> comboAlign =
                                       new JComboBox<String>(new String[] { "LG", "NG", "CG", "LN", "TN", "CN", "LE",
                                                                           "NE", "CE" });
        pageComponents.add(comboAlign);

        layout.putConstraint(NORTH, comboAlign, 0, SOUTH, labelAlign);
        layout.putConstraint(WEST, comboAlign, 0, WEST, labelAlign);

        layout.putConstraint(NORTH, labelAlign, CharacterSheet.getLineHeight() * 4 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelAlign, 5, WEST, tabPanel);

        // Religion/Patron Deity
        JLabel labelReligion = new JLabel("Religion");
        pageComponents.add(labelReligion);

        JTextField textReligion = new JTextField(12);
        pageComponents.add(textReligion);

        layout.putConstraint(NORTH, textReligion, 0, SOUTH, labelReligion);
        layout.putConstraint(WEST, textReligion, 0, WEST, labelReligion);

        layout.putConstraint(NORTH, labelReligion, CharacterSheet.getLineHeight() * 4 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelReligion, 5, EAST, labelAlign);

        // Height
        JLabel labelHeight = new JLabel("Height");
        pageComponents.add(labelHeight);

        JTextField textHeight = new JTextField(5);
        pageComponents.add(textHeight);

        layout.putConstraint(NORTH, textHeight, 0, SOUTH, labelHeight);
        layout.putConstraint(WEST, textHeight, 0, WEST, labelHeight);

        layout.putConstraint(NORTH, labelHeight, CharacterSheet.getLineHeight() * 4 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelHeight, 5, EAST, textReligion);

        // Weight
        JLabel labelWeight = new JLabel("Weight");
        pageComponents.add(labelWeight);

        JTextField textWeight = new JTextField(5);
        pageComponents.add(textWeight);

        layout.putConstraint(NORTH, textWeight, 0, SOUTH, labelWeight);
        layout.putConstraint(WEST, textWeight, 0, WEST, labelWeight);

        layout.putConstraint(NORTH, labelWeight, CharacterSheet.getLineHeight() * 4 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelWeight, 5, EAST, textHeight);

        // Looks
        JLabel labelLooks = new JLabel("Looks");
        pageComponents.add(labelLooks);

        JTextField textLooks = new JTextField(12);
        pageComponents.add(textLooks);

        layout.putConstraint(NORTH, textLooks, 0, SOUTH, labelLooks);
        layout.putConstraint(WEST, textLooks, 0, WEST, labelLooks);

        layout.putConstraint(NORTH, labelLooks, CharacterSheet.getLineHeight() * 4 + 5, NORTH, tabPanel);
        layout.putConstraint(WEST, labelLooks, 5, EAST, textWeight);
    }
}
