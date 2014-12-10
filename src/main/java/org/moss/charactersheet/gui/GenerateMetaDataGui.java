package org.moss.charactersheet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Generator for character meta data
 * @author Jacq
 *
 */
public class GenerateMetaDataGui
{
	private JPanel metaData = new JPanel(new GridBagLayout());
	private GridBagConstraints mdConsts = new GridBagConstraints();
	
    /**
     * Creates new generator
     */
    public GenerateMetaDataGui()
    {
    }

    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @return JPanel
     */
    public JPanel generate()
    {
    	addLineOne();
        addLineTwo();
        addLineThree();	
        return metaData;
    }

	private void addLineOne() {
		JPanel lineOne = new JPanel(new GridBagLayout());
        GridBagConstraints lOneConstraints = new GridBagConstraints();
        
        // Char Name
        JLabel labelCharName = new JLabel("Character Name");
        lineOne.add(labelCharName, lOneConstraints);

        JTextField textCharName = new JTextField(20);
        lOneConstraints.gridy = 1;
        lineOne.add(textCharName, lOneConstraints);

        // Player Name
        JLabel labelPlayerName = new JLabel("Player Name");
        lOneConstraints.gridx = 1;
        lOneConstraints.gridy = 0;
        lineOne.add(labelPlayerName, lOneConstraints);

        JTextField textPlayerName = new JTextField(20);
        lOneConstraints.gridy = 1;
        lineOne.add(textPlayerName, lOneConstraints);

        metaData.add(lineOne);		
	}
	
	private void addLineTwo() {
		JPanel lineTwo = new JPanel(new GridBagLayout());
        GridBagConstraints lTwoConstraints = new GridBagConstraints();
        
        // Class
        JLabel labelClass = new JLabel("Class");
        lineTwo.add(labelClass, lTwoConstraints);

        JTextField textClass = new JTextField(16);
        lTwoConstraints.gridy = 1;
        lineTwo.add(textClass, lTwoConstraints);

        // Level
        JLabel labelLevel = new JLabel("Level");
        lTwoConstraints.gridx = 1;
        lTwoConstraints.gridy = 0;
        lineTwo.add(labelLevel, lTwoConstraints);

        JTextField textLevel = new JTextField(4);
        lTwoConstraints.gridy = 1;
        lineTwo.add(textLevel, lTwoConstraints);

        // ECL
        JLabel labelEcl = new JLabel("ECL");
        lTwoConstraints.gridx = 2;
        lTwoConstraints.gridy = 0;
        lineTwo.add(labelEcl, lTwoConstraints);

        JTextField textEcl = new JTextField(4);
        lTwoConstraints.gridy = 1;
        lineTwo.add(textEcl, lTwoConstraints);

        // Race/Template
        JLabel labelRace = new JLabel("Race/Template");
        lTwoConstraints.gridx = 3;
        lTwoConstraints.gridy = 0;
        lineTwo.add(labelRace, lTwoConstraints);

        JTextField textRace = new JTextField(8);
        lTwoConstraints.gridy = 1;
        lineTwo.add(textRace, lTwoConstraints);

        // Size
        JLabel labelSize = new JLabel("Size");
        lTwoConstraints.gridx = 4;
        lTwoConstraints.gridy = 0;
        lineTwo.add(labelSize, lTwoConstraints);

        JComboBox<String> comboSize = 
        		new JComboBox<String>
                      (new String[] { "F", "D", "T", "S", "M", "L", "H", "G", "C" });
        lTwoConstraints.gridy = 1;
        lineTwo.add(comboSize, lTwoConstraints);
        
        // Gender
        JLabel labelGender = new JLabel("Gender");
        lTwoConstraints.gridx = 5;
        lTwoConstraints.gridy = 0;
        lineTwo.add(labelGender, lTwoConstraints);

        JComboBox<String> comboGender = new JComboBox<String>(new String[] { "F", "M" });
        lTwoConstraints.gridy = 1;
        lineTwo.add(comboGender, lTwoConstraints);
        
        mdConsts.gridy = 1;
        metaData.add(lineTwo, mdConsts);
	}
	
	private void addLineThree() {
		JPanel lineThree = new JPanel(new GridBagLayout());
        GridBagConstraints lThreeConstraints = new GridBagConstraints();
        
        // Alignment
        JLabel labelAlign = new JLabel("Alignment");
        lineThree.add(labelAlign, lThreeConstraints);

        JComboBox<String> comboAlign =
        		new JComboBox<String>(new String[] 
        				{ "LG", "NG", "CG", "LN", "TN", "CN", "LE","NE", "CE" });
        lThreeConstraints.gridy = 1;
        lineThree.add(comboAlign, lThreeConstraints);

        // Religion/Patron Deity
        JLabel labelReligion = new JLabel("Religion");
        lThreeConstraints.gridx = 1;
        lThreeConstraints.gridy = 0;
        lineThree.add(labelReligion, lThreeConstraints);

        JTextField textReligion = new JTextField(12);
        lThreeConstraints.gridy = 1;
        lineThree.add(textReligion, lThreeConstraints);

        // Height
        JLabel labelHeight = new JLabel("Height");
        lThreeConstraints.gridx = 2;
        lThreeConstraints.gridy = 0;
        lineThree.add(labelHeight, lThreeConstraints);

        JTextField textHeight = new JTextField(5);
        lThreeConstraints.gridy = 1;
        lineThree.add(textHeight, lThreeConstraints);

        // Weight
        JLabel labelWeight = new JLabel("Weight");
        lThreeConstraints.gridx = 3;
        lThreeConstraints.gridy = 0;
        lineThree.add(labelWeight, lThreeConstraints);

        JTextField textWeight = new JTextField(5);
        lThreeConstraints.gridy = 1;
        lineThree.add(textWeight, lThreeConstraints);

        // Looks
        JLabel labelLooks = new JLabel("Looks");
        lThreeConstraints.gridx = 4;
        lThreeConstraints.gridy = 0;
        lineThree.add(labelLooks, lThreeConstraints);

        JTextField textLooks = new JTextField(12);
        lThreeConstraints.gridy = 1;
        lineThree.add(textLooks, lThreeConstraints);
        
        mdConsts.gridy = 2;
        metaData.add(lineThree, mdConsts);
	}
}
