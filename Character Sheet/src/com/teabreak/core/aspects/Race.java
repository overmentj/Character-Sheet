package com.teabreak.core.aspects;

import java.util.ArrayList;
import java.util.Map;

import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.core.aspects.enums.SkillEnum;

public class Race implements AspectsInterface
{

	private final AspectsEnum TYPE = AspectsEnum.Race;

	// Ability Score Modifiers
	private Map<AbilityEnum, Integer> abilityBonuses;

	private int levelAdjustment = 0;

	// Creature Stats
	private int landSpeed = 0;
	private int flightSpeed = 0;
	private String creatureSize;

	private String name;

	/**
	 * Array of all the skill bonuses that this class has, using the skill
	 * object
	 */
	private ArrayList<Skill> skillBonuses = new ArrayList<Skill>();

	public Race(Map<AbilityEnum, Integer> abilityBonuses,
			ArrayList<Skill> skillBonuses, int landSpeed, int flightSpeed,
			String creatureSize, String name)
	{
		this.abilityBonuses = abilityBonuses;
		this.skillBonuses = skillBonuses;
		this.landSpeed = landSpeed;
		this.flightSpeed = flightSpeed;
		this.creatureSize = creatureSize;
		this.name = name;
	}

	/**
	 * Returns all the skill bonuses for this race
	 * 
	 * @return ArrayList<Skill>
	 */
	public ArrayList<Skill> getSkillBonuses()
	{
		return skillBonuses;
	}

	/**
	 * Returns skills based on inputed parameters
	 * 
	 * @param skill
	 *            SkillEnum Which skill to look for
	 * @param conditional
	 *            boolean Return conditional skills or just unconditional
	 * @return
	 */
	public ArrayList<Skill> getSkillBonuses(SkillEnum skill, boolean conditional)
	{
		ArrayList<Skill> skillBonus = new ArrayList<Skill>();
		for (Skill curSkill : skillBonus)
		{
			if (curSkill.getSkills() == skill
					&& curSkill.isConditional() == conditional)
			{
				skillBonus.add(curSkill);
			}
		}
		return skillBonuses;
	}

	public Integer getBonusAbility(AbilityEnum ability)
	{
		return abilityBonuses.get(ability);
	}

	public int getLevelAdjustment()
	{
		return levelAdjustment;
	}

	public int getLandSpeed()
	{
		return landSpeed;
	}

	public int getFlightSpeed()
	{
		return flightSpeed;
	}

	public String getCreatureSize()
	{
		return creatureSize;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public AspectsEnum getType()
	{
		return TYPE;
	}

	@Override
	public long getId()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBook()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
