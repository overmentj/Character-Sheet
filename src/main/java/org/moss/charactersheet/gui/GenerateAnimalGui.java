package org.moss.charactersheet.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.AbilityScore;

/**
 * Generate GUI for Animal Companion
 * @author Jacq
 *
 */
public class GenerateAnimalGui implements GenerateGui {

	List<Component> pageComponents;
	JPanel animalInfo = new JPanel(new GridBagLayout());
	GridBagConstraints animCons = new GridBagConstraints();
	
	/**
	 * Create new generator with a given list of components to build the GUI
	 * @param components
	 */
	public GenerateAnimalGui(List<Component> components) {
		this.pageComponents = components;
	}
	
	/**
	 * Build Animal Companion GUI using previously provided component list
	 */
	@Override
	public void generate() {
		addBasicInfo();
		addStats();
		addAC();
		addAttackStats();
		addSkills();
		pageComponents.add(animalInfo);
	}

	private void addBasicInfo() {
		JPanel basicInfo = new JPanel(new GridBagLayout());
		
		JLabel lblName = new JLabel("Name");
		JTextField textName = new JTextField(30);
		JLabel lblType = new JLabel("Creature Type");
		JTextField textType = new JTextField(30);
		
		basicInfo.add(lblName);
		basicInfo.add(textName);
		basicInfo.add(lblType);
		basicInfo.add(textType);
		
		animalInfo.add(basicInfo);
	}

	private void addStats() {
		JPanel stats = new JPanel(new GridBagLayout());
		GridBagConstraints statCons = new GridBagConstraints();
		statCons.insets = new Insets(0, 2, 0, 4);
		
		// Abilities
		JPanel abilities = new JPanel(new GridBagLayout());
		GridBagConstraints absCons = new GridBagConstraints();
		
		absCons.gridx = 0;
		for (AbilityScore skill : AbilityScore.values()) {
			absCons.gridy = 0;
			JLabel lblSkill = new JLabel(skill.toString());
			JTextField textScore = new JTextField(2);
			abilities.add(lblSkill, absCons);
			absCons.gridy++;
			abilities.add(textScore, absCons);
			absCons.gridx++;
		}
		stats.add(abilities);
		
		// Speed and Initiative
		JPanel speed = new JPanel(new GridBagLayout());
		GridBagConstraints spCons = new GridBagConstraints();
		speed.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblInit = new JLabel("Initiative");
		JTextField textInit = new JTextField(30);
		JLabel lblSpeed = new JLabel("Speed");
		JTextField textSpeed = new JTextField(30);
		
		spCons.gridx = 0;
		spCons.gridy = 0;
		speed.add(lblInit, spCons);
		spCons.gridx = 1;
		speed.add(textInit, spCons);
		spCons.gridx = 0;
		spCons.gridy = 1;
		speed.add(lblSpeed, spCons);
		spCons.gridx = 1;
		speed.add(textSpeed, spCons);
		
		statCons.gridx = 1;
		stats.add(speed, statCons);
		
		JPanel hitPoints = new JPanel(new GridBagLayout());
		JTextArea textHP = new JTextArea(3, 20);
		textHP.setBorder(BorderFactory.createTitledBorder("Hit Points"));
		hitPoints.add(textHP);
		
		statCons.gridx++;
		stats.add(hitPoints, statCons);
		
		animCons.gridy = 1;
		animalInfo.add(stats, animCons);
	}

	private void addAC() {
		GenerateAcGui acGUI = new GenerateAcGui();
		animCons.gridy = 2;
		animalInfo.add(acGUI.generate(), animCons);		
	}

	private void addAttackStats() {
		// TODO Auto-generated method stub
		
	}

	private void addSkills() {
		// TODO Auto-generated method stub
		addAbilities();
	}

	private void addAbilities() {
		// TODO Auto-generated method stub
		// Feats, Abilities, Tricks
	}

}
