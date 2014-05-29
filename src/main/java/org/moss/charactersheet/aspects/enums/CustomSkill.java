package org.moss.charactersheet.aspects.enums;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CustomSkill {

	private static final Map<String, CustomSkill> CUSTOM_SKILLS_MAP = new TreeMap<String, CustomSkill>();
	
	static 
	{
		CUSTOM_SKILLS_MAP.put("Craft", new CustomSkill("Craft", AbilityScore.INT));
		CUSTOM_SKILLS_MAP.put("Knowledge", new CustomSkill("Knowledge", AbilityScore.INT));
		CUSTOM_SKILLS_MAP.put("Profession", new CustomSkill("Profession", AbilityScore.WIS));
		CUSTOM_SKILLS_MAP.put("Perform", new CustomSkill("Perform", AbilityScore.CHA));
	}
	
	private String skillName;
	private AbilityScore ability;
	
	private CustomSkill(String name, AbilityScore ability)
	{
		this.setSkillName(name);
		this.ability = ability;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public AbilityScore getAbility() {
		return ability;
	}

	public void setAbility(AbilityScore ability) {
		this.ability = ability;
	}
	
	public static Set<String> getSkillNames()
	{
		return CUSTOM_SKILLS_MAP.keySet();
	}
	
	public static CustomSkill getCustomSkill(String name)
    {
        return CUSTOM_SKILLS_MAP.get(name);
    }
}
