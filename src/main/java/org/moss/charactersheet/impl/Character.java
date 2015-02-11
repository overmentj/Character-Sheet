package org.moss.charactersheet.impl;

/**
 * Holds all character information: <li><code>CharacterInfo</code></li> <li>
 * <code>AbilityStats</code></li> <li><code>CombatStats</code></li> <li>
 * <code>SaveStats</code></li>
 * 
 * @author Jacq
 * 
 */
public class Character {

	private CharacterInfo info;
	private AbilityStats abilityStats;
	private CombatStats combatStats;
	private SaveStats saveStats;

	public CharacterInfo getInfo() {
		return info;
	}

	public void setInfo(CharacterInfo info) {
		this.info = info;
	}

	public AbilityStats getAbilityStats() {
		return abilityStats;
	}

	public void setAbilityStats(AbilityStats abilityStats) {
		this.abilityStats = abilityStats;
	}

	public CombatStats getCombatStats() {
		return combatStats;
	}

	public void setCombatStats(CombatStats combatStats) {
		this.combatStats = combatStats;
	}

	public SaveStats getSaveStats() {
		return saveStats;
	}

	public void setSaveStats(SaveStats saveStats) {
		this.saveStats = saveStats;
	}

}
