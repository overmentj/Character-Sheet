package org.moss.charactersheet.actions.api;

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.moss.charactersheet.actions.SaveCharacter;
import org.moss.charactersheet.impl.AbilityStats;
import org.moss.charactersheet.impl.Character;
import org.moss.charactersheet.impl.CharacterInfo;
import org.moss.charactersheet.impl.CombatStats;

/**
 * API Class for use by CharacterSheet Saves current for to save file
 * 
 * @author Jacq
 * 
 */
public class SaveAction {

	private static final Map<String, Object> CHAR_ELEMS = new HashMap<>();
	private static final String CHAR_CLASS_NAME = CharacterInfo.class.getName();
	private static final String ABILITY_CLASS_NAME = AbilityStats.class
			.getName();
	private static final String COMBAT_CLASS_NAME = CombatStats.class.getName();

	/**
	 * Uses container information to construct character and save
	 * 
	 * @param container
	 */
	public static void save(Container container) {

		SaveCharacter action = new SaveCharacter();
		action.save(constructCharacter(container));
		JOptionPane.showMessageDialog(container, "Save Successful",
				"Save Complete", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Searches for information in container and creates constructs for
	 * character
	 * 
	 * @param container
	 * @return Character
	 */
	private static Character constructCharacter(Container container) {
		Component[] comps = container.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JPanel) {
				JPanel panel = (JPanel) comp;
				List<Component> components = Arrays.asList(panel
						.getComponents());
				if (panel.getName() == null) {
					// We have to go deeper
					return constructCharacter(panel);
				}
				if (panel.getName().equals("MetaData")) {
					CHAR_ELEMS.put(CHAR_CLASS_NAME,
							CharacterInfo.createCharacter(components));
				} else if (panel.getName().equals("AbilityScores")) {
					CHAR_ELEMS.put(ABILITY_CLASS_NAME,
							AbilityStats.createStats(components));
				} else if (panel.getName().equals("CombatOpts")) {
					CHAR_ELEMS.put(COMBAT_CLASS_NAME,
							CombatStats.createCombatStats(components));
				}
			} else if (comp instanceof Container) {
				// We have to go deeper!
				return constructCharacter((Container) comp);
			}
		}
		
		Character character = new Character();
		character.setAbilityStats((AbilityStats) CHAR_ELEMS.get(ABILITY_CLASS_NAME));
		character.setCombatStats((CombatStats) CHAR_ELEMS.get(COMBAT_CLASS_NAME));
		character.setInfo((CharacterInfo) CHAR_ELEMS.get(CHAR_CLASS_NAME));
		//character.setAbilityStats(null);
		//character.setCombatStats(null);
		//character.setInfo(null);
		character.setSaveStats(null);
		
		return character;
	}
}
