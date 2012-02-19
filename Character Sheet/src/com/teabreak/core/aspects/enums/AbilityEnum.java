package com.teabreak.core.aspects.enums;

public enum AbilityEnum
{
	Str("Strength"), Dex("Dexterity"), Con("Constitution"), Int("Intelegence"), Wis("Wisdom"), Cha("Charisma");
	private String name;

	private AbilityEnum(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	/**
	 * Calculate the modifier for the given score
	 * @param score Total ability score
	 * @return modifier
	 */
	public static int getModifier(int score){
		if (score > 10)
		{
			return (score - 10) / 2;
		} else
		{
			return 0 - ((10 - score) / 2);
		}
	}
}
