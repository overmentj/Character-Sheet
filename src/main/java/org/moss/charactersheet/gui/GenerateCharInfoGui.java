package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Generates all components for the overall character information
 * Includes:
 * <ul>
 * <li> Meta data </li>
 * <li> Ability scores </li>
 * <li> Combat options </li>
 * <li> Speed and Initiative </li>
 * <li> Grapple </li>
 * <li> Saves </li>
 * <li> AC </li>
 * </ul>
 * @author Jacq
 *
 */
public class GenerateCharInfoGui implements GenerateGui {

	private List<Component> pageComponents = new ArrayList<Component>();
    private JPanel charInfo = new JPanel(new GridBagLayout());
    private GridBagConstraints ciConstraints = new GridBagConstraints();
    
    public GenerateCharInfoGui(List<Component> components)
    {
        this.pageComponents = components;
        this.ciConstraints.insets = new Insets(2, 0, 0, 0);
    }
    
    /**
     * Generates entire Character Info GUI and adds to previously provided list
     */
    @Override
    public void generate() {
    	charInfo.setBorder(BorderFactory.createTitledBorder("Character Information"));
        addMetaData();
        addAbilityAndCombat();
        addSpeed();
        addGrapple();
        addSaves();
        addAC();
        pageComponents.add(charInfo);
    }
    
    private void addMetaData() {
    	GenerateMetaDataGui metaGUI = new GenerateMetaDataGui();
    	charInfo.add(metaGUI.generate());
	}

	private void addAbilityAndCombat() {
		GenerateAbilityScoresGui asGUI = new GenerateAbilityScoresGui();
		GenerateCombatOptionsGui coGUI = new GenerateCombatOptionsGui();
		JPanel miniPanel = new JPanel();
		GridBagConstraints consts = new GridBagConstraints();
		consts.gridx = 0;
		consts.gridy = 0;
		miniPanel.add(asGUI.generate(), consts);
		consts.gridx++;
		miniPanel.add(coGUI.generate(), consts);
		ciConstraints.gridy = 1;
		charInfo.add(miniPanel, ciConstraints);
	}
	
	private void addSpeed() {
		GenerateSpeedComponents speedGUI = new GenerateSpeedComponents();
		List<Component> speedComps = speedGUI.generate();
		
		// [Speed] [Initiative]
		JPanel miniPanel = new JPanel(new GridBagLayout());
		GridBagConstraints consts = new GridBagConstraints();
		consts.gridx = 0;
		consts.gridy = 0;
		for (Component comp : speedComps) {
			if (consts.gridy != 0 && consts.gridy % 2 == 0) {
				consts.gridx++;
				consts.gridy = 0;
			}
			miniPanel.add(comp, consts);
			consts.gridy++;
		}
		ciConstraints.gridy++;
		charInfo.add(miniPanel, ciConstraints);
	}
	
	private void addGrapple() {
		GenerateGrappleGui grapGUI = new GenerateGrappleGui();
		ciConstraints.gridx = 0;
		ciConstraints.gridy = 3;
		charInfo.add(grapGUI.generate(), ciConstraints);
	}
	
	private void addSaves() {
		GenerateSavesGui saveGUI = new GenerateSavesGui();
		ciConstraints.gridy = 4;
		charInfo.add(saveGUI.generate(), ciConstraints);
	}
	
	private void addAC() {
		GenerateAcGui acGUI = new GenerateAcGui();
		ciConstraints.gridy = 5;
		charInfo.add(acGUI.generate(), ciConstraints);
	}
}
