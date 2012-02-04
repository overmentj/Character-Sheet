package com.teabreak.charactersheet;

import com.teabreak.core.aspects.enums.AlignmentEnum;
import com.teabreak.core.aspects.Class;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.enums.AbilityEnum;

public class CharacterSheet
{

	private String playerName;
	private String characterName;

	private Class charClass;
	private Race charRace;

	private int level;

	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;

	private int willSave;
	private int reflexSave;
	private int fortitudeSave;
	private String alignment;
	
	private long experience;

	private boolean levelledUp = false;

	public void addExperience(Long experienceGained)
	{
		this.experience += experienceGained;
	}

	public long getExperience()
	{

		return experience;
	}
	
	public void setCharacterAlignment(String alignment)
	{
		this.alignment = alignment;
	}
	
	public String getCharacterAlignment()
	{
		return alignment;
	}

	public int getAbilityModifier(AbilityEnum ability)
	{
		int mod = 0;
		switch (ability)
		{
		case Str:
			mod = getModifier(strength);
			break;
		case Dex:
			mod = getModifier(dexterity);
			break;
		case Con:
			mod = getModifier(constitution);
			break;
		case Int:
			mod = getModifier(intelligence);
			break;
		case Wis:
			mod = getModifier(wisdom);
			break;
		case Cha:
			mod = getModifier(charisma);
			break;
		}

		return mod;
	}

	public boolean isLevelledUp()
	{
		return this.levelledUp;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getCharacterName()
	{
		return characterName;
	}

	public void setCharacterName(String characterName)
	{
		this.characterName = characterName;
	}

	private int getModifier(int attribute)
	{
		if (attribute > 10)
		{
			return (attribute - 10) / 2;
		} else
		{
			return 0 - ((10 - attribute) / 2);
		}
	}

	private void checkLevelledUp()
	{

	}
}
