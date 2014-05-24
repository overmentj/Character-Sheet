package org.moss.charactersheet;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;


public class CharacterSheet extends JFrame
{

    private static final int LINE_HEIGHT = 25;

    private List<Component> guiComponenets = new ArrayList<Component>();
    private SpringLayout layout;
    private Container contentPane;


    public CharacterSheet()
    {
        init();
    }

    private void init()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Sheet");

        layout = new SpringLayout();
        contentPane = this.getContentPane();
        contentPane.setLayout(layout);
        this.getContentPane().setPreferredSize(new Dimension(500, 500));

        characterMetaData();
        abilityScores();

        for (Component comp : guiComponenets)
        {
            contentPane.add(comp);
        }
        pack();
    }

    /**
     * Generate the character meta data elements
     */
    private void characterMetaData()
    {
        // Char Name
        Label labelCharName = new Label("Character Name");
        guiComponenets.add(labelCharName);

        JTextField textCharName = new JTextField(20);
        guiComponenets.add(textCharName);

        layout.putConstraint(NORTH, textCharName, 0, SOUTH, labelCharName);
        layout.putConstraint(WEST, textCharName, 0, WEST, labelCharName);

        layout.putConstraint(NORTH, labelCharName, 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelCharName, 5, WEST, contentPane);

        // Player Name
        Label labelPlayerName = new Label("Player Name");
        guiComponenets.add(labelPlayerName);

        JTextField textPlayerName = new JTextField(20);
        guiComponenets.add(textPlayerName);

        layout.putConstraint(NORTH, textPlayerName, 0, SOUTH, labelPlayerName);
        layout.putConstraint(WEST, textPlayerName, 0, WEST, labelPlayerName);

        layout.putConstraint(NORTH, labelPlayerName, 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelPlayerName, 250, WEST, contentPane);

        // Class
        Label labelClass = new Label("Class");
        guiComponenets.add(labelClass);

        JTextField textClass = new JTextField(16);
        guiComponenets.add(textClass);

        layout.putConstraint(NORTH, textClass, 0, SOUTH, labelClass);
        layout.putConstraint(WEST, textClass, 0, WEST, labelClass);

        layout.putConstraint(NORTH, labelClass, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelClass, 5, WEST, contentPane);

        // Level
        Label labelLevel = new Label("Level");
        guiComponenets.add(labelLevel);

        JTextField textLevel = new JTextField(4);
        guiComponenets.add(textLevel);

        layout.putConstraint(NORTH, textLevel, 0, SOUTH, labelLevel);
        layout.putConstraint(WEST, textLevel, 0, WEST, labelLevel);

        layout.putConstraint(NORTH, labelLevel, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelLevel, 5, EAST, textClass);

        // ECL
        Label labelEcl = new Label("ECL");
        guiComponenets.add(labelEcl);

        JTextField textEcl = new JTextField(4);
        guiComponenets.add(textEcl);

        layout.putConstraint(NORTH, textEcl, 0, SOUTH, labelEcl);
        layout.putConstraint(WEST, textEcl, 0, WEST, labelEcl);

        layout.putConstraint(NORTH, labelEcl, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelEcl, 5, EAST, textLevel);

        // Race/Template
        Label labelRace = new Label("Race/Template");
        guiComponenets.add(labelRace);

        JTextField textRace = new JTextField(8);
        guiComponenets.add(textRace);

        layout.putConstraint(NORTH, textRace, 0, SOUTH, labelRace);
        layout.putConstraint(WEST, textRace, 0, WEST, labelRace);

        layout.putConstraint(NORTH, labelRace, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelRace, 5, EAST, textEcl);

        // Size
        Label labelSize = new Label("Size");
        guiComponenets.add(labelSize);

        JComboBox<String> comboSize =
                                      new JComboBox<String>(
                                                            new String[] { "F", "D", "T", "S", "M", "L", "H", "G", "C" });
        guiComponenets.add(comboSize);

        layout.putConstraint(NORTH, comboSize, 0, SOUTH, labelSize);
        layout.putConstraint(WEST, comboSize, 0, WEST, labelSize);

        layout.putConstraint(NORTH, labelSize, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelSize, 5, EAST, textRace);

        // Gender
        Label labelGender = new Label("Gender");
        guiComponenets.add(labelGender);

        JComboBox<String> comboGender = new JComboBox<String>(new String[] { "F", "M" });
        guiComponenets.add(comboGender);

        layout.putConstraint(NORTH, comboGender, 0, SOUTH, labelGender);
        layout.putConstraint(WEST, comboGender, 0, WEST, labelGender);

        layout.putConstraint(NORTH, labelGender, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelGender, 5, EAST, comboSize);

        // Alignment
        Label labelAlign = new Label("Alignment");
        guiComponenets.add(labelAlign);

        JComboBox<String> comboAlign =
                                       new JComboBox<String>(new String[] { "LG", "NG", "CG", "LN", "TN", "CN", "LE",
                                                                           "NE", "CE" });
        guiComponenets.add(comboAlign);

        layout.putConstraint(NORTH, comboAlign, 0, SOUTH, labelAlign);
        layout.putConstraint(WEST, comboAlign, 0, WEST, labelAlign);

        layout.putConstraint(NORTH, labelAlign, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelAlign, 5, WEST, contentPane);

        // Religion/Patron Deity
        Label labelReligion = new Label("Religion");
        guiComponenets.add(labelReligion);

        JTextField textReligion = new JTextField(12);
        guiComponenets.add(textReligion);

        layout.putConstraint(NORTH, textReligion, 0, SOUTH, labelReligion);
        layout.putConstraint(WEST, textReligion, 0, WEST, labelReligion);

        layout.putConstraint(NORTH, labelReligion, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelReligion, 5, EAST, labelAlign);

        // Height
        Label labelHeight = new Label("Height");
        guiComponenets.add(labelHeight);

        JTextField textHeight = new JTextField(5);
        guiComponenets.add(textHeight);

        layout.putConstraint(NORTH, textHeight, 0, SOUTH, labelHeight);
        layout.putConstraint(WEST, textHeight, 0, WEST, labelHeight);

        layout.putConstraint(NORTH, labelHeight, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelHeight, 5, EAST, textReligion);

        // Weight
        Label labelWeight = new Label("Weight");
        guiComponenets.add(labelWeight);

        JTextField textWeight = new JTextField(5);
        guiComponenets.add(textWeight);

        layout.putConstraint(NORTH, textWeight, 0, SOUTH, labelWeight);
        layout.putConstraint(WEST, textWeight, 0, WEST, labelWeight);

        layout.putConstraint(NORTH, labelWeight, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelWeight, 5, EAST, textHeight);

        // Looks
        Label labelLooks = new Label("Looks");
        guiComponenets.add(labelLooks);

        JTextField textLooks = new JTextField(12);
        guiComponenets.add(textLooks);

        layout.putConstraint(NORTH, textLooks, 0, SOUTH, labelLooks);
        layout.putConstraint(WEST, textLooks, 0, WEST, labelLooks);

        layout.putConstraint(NORTH, labelLooks, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelLooks, 5, EAST, textWeight);
    }

    private void abilityScores()
    {
        String[] abilityNames =
                                new String[] { "Strength", "Dexterity", "Consitution", "Intelligence", "Wisdom",
                                              "Charisma" };
        String[] abilityShort = new String[] { "STR", "DEX", "CON", "INT", "WIS", "CHA" };

        JPanel abilityScores = new JPanel(new GridBagLayout());
        abilityScores.setBorder(BorderFactory.createTitledBorder("Ability Scores"));

        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        for (int i = 0; i < abilityNames.length; i++)
        {
            int index = i * 2;
            Label name = new Label(abilityShort[i]);
            constraint.gridx = 0;
            constraint.gridy = index;
            abilityScores.add(name, constraint);

            Label longName = new Label(abilityNames[i]);
            longName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            abilityScores.add(longName, constraint);

            JTextField total = new JTextField(2);
            total.setEditable(false);
            total.setText("0");
            constraint.gridx = 1;
            constraint.gridy = index;
            abilityScores.add(total, constraint);

            Label labelTotal = new Label("Total");
            labelTotal.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 1;
            abilityScores.add(labelTotal, constraint);

            Label labelEquals = new Label("=");
            constraint.gridx = 2;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(labelEquals, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField base = new JFormattedTextField();
            constraint.gridx = 3;
            constraint.gridy = index;
            abilityScores.add(base, constraint);

            Label labelBase = new Label("Base");
            labelBase.setFont(small);
            constraint.gridx = 3;
            constraint.gridy = index + 1;
            abilityScores.add(labelBase, constraint);

            Label labelPlus1 = new Label("+");
            constraint.gridx = 4;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(labelPlus1, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField enchance = new JFormattedTextField();
            constraint.gridx = 5;
            constraint.gridy = index;
            abilityScores.add(enchance, constraint);

            Label labelEnchance = new Label("Enhance");
            labelEnchance.setFont(small);
            constraint.gridx = 5;
            constraint.gridy = index + 1;
            abilityScores.add(labelEnchance, constraint);

            Label labelPlus2 = new Label("+");
            constraint.gridx = 6;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(labelPlus2, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField misc = new JFormattedTextField();
            constraint.gridx = 7;
            constraint.gridy = index;
            abilityScores.add(misc, constraint);

            Label labelMisc = new Label("Misc");
            labelMisc.setFont(small);
            constraint.gridx = 7;
            constraint.gridy = index + 1;
            abilityScores.add(labelMisc, constraint);

            Label labelPlus3 = new Label("-");
            constraint.gridx = 8;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(labelPlus3, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField miscNeg = new JFormattedTextField();
            constraint.gridx = 9;
            constraint.gridy = index;
            abilityScores.add(miscNeg, constraint);

            Label labelMiscNeg = new Label("Misc");
            labelMiscNeg.setFont(small);
            constraint.gridx = 9;
            constraint.gridy = index + 1;
            abilityScores.add(labelMiscNeg, constraint);

            JTextField mod = new JTextField(2);
            mod.setEditable(false);
            mod.setText("0");
            constraint.gridx = 11;
            constraint.gridy = index;
            abilityScores.add(mod, constraint);

            Label labelMod = new Label("Mod");
            labelMod.setFont(small);
            constraint.gridx = 11;
            constraint.gridy = index + 1;
            abilityScores.add(labelMod, constraint);

            new AbilityScores(total, base, enchance, misc, miscNeg, mod);
        }

        guiComponenets.add(abilityScores);
        layout.putConstraint(WEST, abilityScores, 5, WEST, contentPane);
        layout.putConstraint(NORTH, abilityScores, LINE_HEIGHT * 6 + 5, NORTH, contentPane);
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CharacterSheet().setVisible(true);
            }
        });
    }
}
