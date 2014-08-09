package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import org.moss.charactersheet.util.LabelUtils;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;

public class GenerateMagicGui
{

    private List<Component> components;
    private SpringLayout parentLayout;
    private Font small;


    public GenerateMagicGui(List<Component> components, SpringLayout parentLayout)
    {
        this.components = components;
        this.parentLayout = parentLayout;
        small = new Font("Verdana", Font.BOLD, 8);
    }

    public void generate(int x, int y, Component anchor)
    {

        JPanel magicPanel = generateMagicBox(x, y, anchor);

        x += 320;

        JPanel spellPanel = generateSpellBox(x, y, anchor);

        x = 0;

        /*
         * Spell List
         */
        generateSpellList(x, anchor, spellPanel);
        
    }

    private void generateSpellList(int x, Component anchor, JPanel spellPanel)
    {
        JPanel spellListPanel = new JPanel();
        GridBagLayout spellListLayout = new GridBagLayout();
        GridBagConstraints spellListConstraints = new GridBagConstraints();
        components.add(spellListPanel);

        spellListPanel.setBorder(BorderFactory.createTitledBorder("Spell List"));
        spellListPanel.setLayout(spellListLayout);

        parentLayout.putConstraint(NORTH, spellListPanel, 5, SOUTH, spellPanel);
        parentLayout.putConstraint(WEST, spellListPanel, x, WEST, anchor);
        
        JLabel labelSpellz = new JLabel("Bobby");
        spellListConstraints.gridx = 0;
        spellListConstraints.gridy = 0;
        spellListPanel.add(labelSpellz, spellListConstraints);
    }

    private JPanel generateSpellBox(int x, int y, Component anchor)
    {
        /*
         * Spell block
         */
        JPanel spellsPanel = new JPanel();
        GridBagLayout spellsLayout = new GridBagLayout();
        GridBagConstraints spellConstraints = new GridBagConstraints();
        components.add(spellsPanel);

        spellsPanel.setBorder(BorderFactory.createTitledBorder("Spells"));
        spellsPanel.setLayout(spellsLayout);

        parentLayout.putConstraint(NORTH, spellsPanel, y, NORTH, anchor);
        parentLayout.putConstraint(WEST, spellsPanel, x, WEST, anchor);

        spellConstraints.insets = new Insets(0, 0, 4, 0);

        JLabel labelSpellSave = new JLabel("Spell Save");
        spellConstraints.gridx = 0;
        spellConstraints.gridy = 0;
        spellConstraints.gridwidth = 2;
        spellsPanel.add(labelSpellSave, spellConstraints);

        JTextField textSpellSave = new JTextField(8);
        spellConstraints.gridx = 2;
        spellConstraints.gridy = 0;
        spellConstraints.gridwidth = 3;
        spellsPanel.add(textSpellSave, spellConstraints);

        JLabel labelDcMod = new JLabel(LabelUtils.multiLine("DC\nMOD", true));
        labelDcMod.setFont(small);
        spellConstraints.gridx = 2;
        spellConstraints.gridy = 0;
        spellsPanel.add(labelDcMod, spellConstraints);

        JTextArea areaConditionalModifiers = new JTextArea(3, 24);
        areaConditionalModifiers.setBorder(BorderFactory.createTitledBorder("Conditional Mods"));
        spellConstraints.gridx = 0;
        spellConstraints.gridy = 1;
        spellConstraints.gridwidth = 11;
        spellsPanel.add(areaConditionalModifiers, spellConstraints);

        int xPos;
        int index;
        int level;
        spellConstraints.gridwidth = 1;
        JPanel panelDailySpells = new JPanel(new GridBagLayout());

        spellConstraints.gridx = 0;
        spellConstraints.gridy = 2;
        spellConstraints.gridwidth = 11;
        spellsPanel.add(panelDailySpells, spellConstraints);

        GridBagConstraints dailySpellConstraints = new GridBagConstraints();
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                xPos = i * 5;
                index = j;
                level = j;
                if (i > 0)
                {
                    level += 5;
                }

                JTextField textSpellsKnown = new JTextField(2);
                dailySpellConstraints.gridx = xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsKnown, dailySpellConstraints);

                JTextField textSpellsSaveDc = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsSaveDc, dailySpellConstraints);

                JLabel labelLevel = new JLabel(Integer.toString(level));
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(labelLevel, dailySpellConstraints);

                JTextField textSpellsDay = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsDay, dailySpellConstraints);

                if (i == 0)
                {
                    dailySpellConstraints.insets = new Insets(0, 0, 0, 30);
                }

                JTextField textSpellsBonus = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsBonus, dailySpellConstraints);

                dailySpellConstraints.insets = new Insets(0, 0, 0, 0);
            }
        }

        return spellsPanel;
    }

    private JPanel generateMagicBox(int x, int y, Component anchor)
    {
        /*
         * Magic box
         */
        JPanel magicPanel = new JPanel();
        GridBagLayout magicLayout = new GridBagLayout();
        GridBagConstraints magicConstraints = new GridBagConstraints();
        components.add(magicPanel);

        magicPanel.setBorder(BorderFactory.createTitledBorder("Magic"));
        magicPanel.setLayout(magicLayout);
        magicConstraints.anchor = GridBagConstraints.WEST;

        parentLayout.putConstraint(NORTH, magicPanel, y, NORTH, anchor);
        parentLayout.putConstraint(WEST, magicPanel, x, WEST, anchor);

        JLabel labelDomains = new JLabel("Domains (Cleric Only)");
        labelDomains.setHorizontalAlignment(SwingConstants.LEFT);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 0;
        magicConstraints.gridwidth = 3;
        magicPanel.add(labelDomains, magicConstraints);

        magicConstraints.gridwidth = 1;

        int index;
        for (int i = 0; i < 2; i++)
        {
            index = i * 2 + 1;
            JTextField textDomain1 = new JTextField(8);
            magicConstraints.gridx = 0;
            magicConstraints.gridy = index;
            magicPanel.add(textDomain1, magicConstraints);

            JTextField textGrantedPower1 = new JTextField(16);
            magicConstraints.gridx = 1;
            magicConstraints.gridy = index;
            magicConstraints.gridwidth = 2;
            magicPanel.add(textGrantedPower1, magicConstraints);

            magicConstraints.gridwidth = 1;

            JLabel labelDomain = new JLabel("Domain Name");
            labelDomain.setFont(small);
            magicConstraints.gridx = 0;
            magicConstraints.gridy = index + 1;
            magicPanel.add(labelDomain, magicConstraints);

            JLabel labelGranted = new JLabel("Domain Name");
            labelGranted.setFont(small);
            magicConstraints.gridx = 1;
            magicConstraints.gridy = index + 1;
            magicPanel.add(labelGranted, magicConstraints);
        }

        JLabel labelSchoolTitle = new JLabel("Speciality School (Wizards Only)");
        labelSchoolTitle.setHorizontalAlignment(SwingConstants.LEFT);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 6;
        magicConstraints.gridwidth = 3;
        magicPanel.add(labelSchoolTitle, magicConstraints);

        magicConstraints.gridwidth = 1;

        JTextField textSchool = new JTextField(8);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 7;
        magicPanel.add(textSchool, magicConstraints);

        JTextField textProhibited1 = new JTextField(8);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 7;
        magicPanel.add(textProhibited1, magicConstraints);

        JTextField textProhibited2 = new JTextField(8);
        magicConstraints.gridx = 2;
        magicConstraints.gridy = 7;
        magicPanel.add(textProhibited2, magicConstraints);

        JLabel labelSchool = new JLabel("Speciality School");
        labelSchool.setFont(small);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 8;
        magicPanel.add(labelSchool, magicConstraints);

        JLabel labelProhibited1 = new JLabel("Prohibited School");
        labelProhibited1.setFont(small);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 8;
        magicPanel.add(labelProhibited1, magicConstraints);

        JLabel labelProhibited2 = new JLabel("Prohibited School");
        labelProhibited2.setFont(small);
        magicConstraints.gridx = 2;
        magicConstraints.gridy = 8;
        magicPanel.add(labelProhibited2, magicConstraints);

        JLabel labelSpellFailure = new JLabel("Arcane Spell Failure");
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 9;
        magicPanel.add(labelSpellFailure, magicConstraints);

        JTextField textSpellFailure = new JTextField(16);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 9;
        magicConstraints.gridwidth = 2;
        magicPanel.add(textSpellFailure, magicConstraints);
        return magicPanel;
    }

}
