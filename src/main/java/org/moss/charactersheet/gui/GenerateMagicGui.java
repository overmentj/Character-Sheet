package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;


public class GenerateMagicGui
{

    private List<Component> components;


    public GenerateMagicGui(List<Component> components, SpringLayout parentLayout)
    {
        this.components = components;
    }

    public void generate(int x, int y, Component anchor)
    {

        Font small = new Font("Verdana", Font.BOLD, 8);

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

        JTextField textSpellFailure = new JTextField(6);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 9;
        magicPanel.add(textSpellFailure, magicConstraints);

        x += magicPanel.getWidth();

        /*
         * Spell block
         */
        JPanel spellsPanel = new JPanel();
        GridBagLayout spellsLayout = new GridBagLayout();
        GridBagConstraints spellConstraints = new GridBagConstraints();
        components.add(spellsPanel);

        spellsPanel.setBorder(BorderFactory.createTitledBorder("Spells"));
        spellsPanel.setLayout(spellsLayout);
        
        /*
         * Spell List
         */
        JPanel spellListPanel = new JPanel();
        GridBagLayout spellListLayout = new GridBagLayout();
    }

}
