package org.moss.charactersheet.impl;

/**
 * Holds all character information:
 * <li><code>CharacterInfo</code></li>
 * <li><code>AbilityStats</code></li>
 * <li><code>CombatStats</code></li>
 * <li><code>SaveStats</code></li>
 * 
 * @author Jacq
 *
 */
public class Character {

	private CharacterInfo info;
	private AbilityStats abilityStats;
	private CombatStats combatStats;
	private SaveStats saveStats;
	
	public Character(CharacterInfo info, AbilityStats abilityStats, CombatStats combatStats, SaveStats saveStats) {
		this.info = info;
		this.abilityStats = abilityStats;
		this.combatStats = combatStats;
		this.saveStats = saveStats;
	}
	
	public CharacterInfo getCharInfo() {
		return info;
	}
	
	public AbilityStats getAbilityStats() {
		return abilityStats;
	}
	
	public CombatStats getCombatStat() {
		return combatStats;
	}
	
	public SaveStats getSaveStats() {
		return saveStats;
	}
}
