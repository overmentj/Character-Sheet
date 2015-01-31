package org.moss.charactersheet.impl;

import java.awt.Component;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Character;

import javax.swing.JTextField;

/**
 * Stores character combat information
 * @author Jacq
 *
 */
public class CombatStats {

	private int baseAttack;
	private Map<Integer, List<Object>> stats = new HashMap<>();
	private static final List<Integer> TEXT_FIELDS = Arrays.asList(0, 5, 6);
	
	public CombatStats(int baseAttack, Map<Integer, List<Object>> stats) {
		this.baseAttack = baseAttack;
		this.stats = stats;
	}

	public int getBaseAttack() {
		return baseAttack;
	}
	
	public Map<Integer, List<Object>> getStats() {
		return stats;
	}
	
	/**
	 * Uses informater provided in container to construct <code>CombatStats</code> object
	 * @param components
	 * @return <code>CombatStats</code>
	 */
	public static CombatStats createCombatStats(List<Component> components) {
		// List should only contain the one panel used to display info
		int baseAttack = 0;
		boolean baseAttackFlag = true;
		int textFieldCount = 0;
		Map<Integer, List<Object>> theseStats = new HashMap<>();
		for (Integer i = 0; i < 4; i++) {
			theseStats.put(i, new LinkedList<Object>());
		}
		for (Component comp : components) {
			if (comp instanceof JTextField) {
				JTextField tField = (JTextField) comp;
				if (baseAttackFlag) {
					baseAttack = Integer.parseInt(tField.getText());
					baseAttackFlag = false;
					continue;
				}
				String name = tField.getName();
				int weaponNum = Integer.parseInt(
						Character.toString(name.charAt(name.length()-1)));
				Object value = tField.getText();
				if (!TEXT_FIELDS.contains(textFieldCount)) {
					value = Integer.parseInt(value.toString());
				}
				if (textFieldCount == TEXT_FIELDS.get(2)) {
					textFieldCount = -1;
				}
				textFieldCount++;
				theseStats.get(weaponNum).add(value);
			}
		}
		return new CombatStats(baseAttack, theseStats);
	}
}
