package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Generator for Feats and Special Abilities
 * @author Jacq
 *
 */
public class GenerateFeatsGui implements GenerateGui {

	private JPanel featsEtc = new JPanel(new GridBagLayout());
	private GridBagConstraints consts = new GridBagConstraints();
	private List<Component> pageComponents;
	
	/**
	 * Creates generator for Feats and SA with list of given components to build on
	 * @param pageComponents
	 */
	public GenerateFeatsGui(List<Component> pageComponents) {
		this.pageComponents = pageComponents;
	}

	/**
	 * Generates GUI by adding components to previously provided list
	 */
	@Override
	public void generate() {
		addFeats();
		addSpecialAbilities();
		pageComponents.add(featsEtc);
	}

	private void addFeats() {
		JPanel feats = new JPanel(new GridBagLayout());
		feats.setBorder(BorderFactory.createTitledBorder("Feats"));
		GridBagConstraints fCons = new GridBagConstraints();
		fCons.insets = new Insets(2,0,0,0);
		
		JLabel lblFeats = new JLabel("Feat");
		feats.add(lblFeats);
		for (int i = 1; i <= 11; i++) {
			fCons.gridy = i;
			JTextField textFeat = new JTextField(30);
			feats.add(textFeat, fCons);
		}
		
		fCons.gridx = 1;
		fCons.gridy = 0;
		JLabel lblEffects = new JLabel("Effect");
		feats.add(lblEffects);
		for (int i = 1; i <= 11; i++) {
			fCons.gridy = i;
			JTextField textEff = new JTextField(30);
			feats.add(textEff, fCons);
		}
		
		featsEtc.add(feats);
	}

	private void addSpecialAbilities() {
		JPanel specAbs = new JPanel(new GridBagLayout());
		specAbs.setBorder(BorderFactory.createTitledBorder("Special Abilities"));
		GridBagConstraints saCons = new GridBagConstraints();
		saCons.insets = new Insets(2,0,0,0);
		
		JLabel lblAbility = new JLabel("Ability Name");
		specAbs.add(lblAbility);
		for (int i = 1; i <= 11; i++) {
			saCons.gridy = i;
			JTextField textFeat = new JTextField(30);
			specAbs.add(textFeat, saCons);
		}
		
		saCons.gridx = 1;
		saCons.gridy = 0;
		JLabel lblEffects = new JLabel("Effect");
		specAbs.add(lblEffects);
		for (int i = 1; i <= 11; i++) {
			saCons.gridy = i;
			JTextField textEff = new JTextField(30);
			specAbs.add(textEff, saCons);
		}
		
		consts.gridy = 1;
		featsEtc.add(specAbs, consts);
	}
}
