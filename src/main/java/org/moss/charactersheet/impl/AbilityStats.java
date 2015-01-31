package org.moss.charactersheet.impl;

import java.awt.Component;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.AbilityScore;

/**
 * Stores all ability scores for character
 * @author Jacq
 *
 */
public class AbilityStats {

	private Map<String, List<Integer>> stats = new HashMap<>();

	public AbilityStats(Map<String, List<Integer>> stats) {
		this.stats = stats;
	}

	public Map<String, List<Integer>> getStats() {
		return stats;
	}

	/**
	 * Uses information in provided components to construct <code>AbilityStats</code> object
	 * @param components
	 * @return <code>AbilityStats</code>
	 */
	public static AbilityStats createStats(List<Component> components) {
		// List should only contain the one panel used to display info
		Map<String, List<Integer>> theseStats = new HashMap<>();
		for (AbilityScore ability : AbilityScore.values()) {
			theseStats.put(ability.name(), new LinkedList<Integer>());
		}
		for (Component comp : components) {
			if (comp instanceof JTextField) {
				JTextField tField = ((JTextField) comp);
				String name = tField.getName();
				String abilityName = name.substring(0, 3);
				theseStats.get(abilityName).add(Integer.parseInt(tField.getText()));
			}
		}
		return new AbilityStats(theseStats);
	}
}
