package org.moss.charactersheet.aspects;

import org.moss.charactersheet.aspects.enums.AbilityScore;

public class Skill {

	private String skillName;
	
	public Skill(String name) {
		this.skillName = name;
	}

	public String getSkillName() {
		return skillName;
	}
	
	public Object getAbility() {
		return AbilityScore.INT.name();
	}
}
