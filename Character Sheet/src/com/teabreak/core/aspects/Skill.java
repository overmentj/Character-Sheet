package com.teabreak.core.aspects;

import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.core.aspects.enums.SkillEnum;

public class Skill implements AspectsInterface
{

	private int id;

	// Skill details
	private final AspectsEnum TYPE = AspectsEnum.Skill;
	private SkillEnum skills;
	private boolean conditional;
	private AbilityEnum AbilityModifier;

	// Skill Descriptions
	private String name;
	private String description;
	private String condition;

	public AspectsEnum getTYPE()
	{
		return TYPE;
	}

	public SkillEnum getSkills()
	{
		return skills;
	}

	public boolean isConditional()
	{
		return conditional;
	}

	public AbilityEnum getAbilityModifier()
	{
		return AbilityModifier;
	}

	public String getDescription()
	{
		return description;
	}

	public String getCondition()
	{
		return condition;
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public AspectsEnum getType()
	{
		return this.TYPE;
	}

	@Override
	public long getId()
	{
		return this.id;
	}

	@Override
	public String gitBook() {
		// TODO Auto-generated method stub
		return null;
	}

}
