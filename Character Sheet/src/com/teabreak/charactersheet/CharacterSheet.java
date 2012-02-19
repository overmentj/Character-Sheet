package com.teabreak.charactersheet;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import com.teabreak.core.aspects.CharClass;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.core.aspects.enums.SaveEnum;

public class CharacterSheet
{

	private String playerName;
	private String characterName;

	private CharClass charClass;
	private Race charRace;

	private int level;
	private long experience;
	private boolean levelledUp = false;

	/**
	 * Map of ability scores: Total, Base, Misc+, Misc-, Modifier
	 */
	private SortedMap<AbilityEnum, ArrayList<Integer>> attrMap = new TreeMap<AbilityEnum, ArrayList<Integer>>();

	/**
	 * Map of save scores: Total, Base, Mod, Magic, Misc, Temp
	 */
	private SortedMap<SaveEnum, ArrayList<Integer>> saveMap = new TreeMap<SaveEnum, ArrayList<Integer>>();

	private SaveEnum.saveScore willSave;
	private SaveEnum.saveScore reflexSave;
	private SaveEnum.saveScore fortitudeSave;

	private String alignment;

	public CharacterSheet(Race charRace, CharClass charClass, int strength,
			int dexterity, int consitution, int intelligence, int wisdom,
			int charisma)
	{
		this.charRace = charRace;
		this.charClass = charClass;
		updateAbilityScore(AbilityEnum.Str, strength, 0, 0);
		updateAbilityScore(AbilityEnum.Dex, dexterity, 0, 0);
		updateAbilityScore(AbilityEnum.Con, consitution, 0, 0);
		updateAbilityScore(AbilityEnum.Int, intelligence, 0, 0);
		updateAbilityScore(AbilityEnum.Wis, wisdom, 0, 0);
		updateAbilityScore(AbilityEnum.Cha, charisma, 0, 0);

	}

	public void updateAbilityScore(AbilityEnum ability, int base, int posMisc,
			int negMisc)
	{
		ArrayList<Integer> attr = new ArrayList<Integer>();
		Integer total = base + posMisc - negMisc;
		attr.add(total);
		attr.add(base);
		attr.add(posMisc);
		attr.add(negMisc);
		attr.add(AbilityEnum.getModifier(total));
		attrMap.put(ability, attr);

		// Prepare for GC
		attr = null;
		total = null;
	}

	public ArrayList<Integer> getAbilityScoreList(AbilityEnum ability)
	{
		return attrMap.get(ability);
	}

	public int getAbilityScore(AbilityEnum ability)
	{
		return attrMap.get(ability).get(0);
	}

	public int getAbilityModifier(AbilityEnum ability)
	{
		return attrMap.get(ability).get(4);
	}

	public void addExperience(Long experienceGained)
	{
		this.experience += experienceGained;
		this.checkLevelledUp();
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

	private void checkLevelledUp()
	{

	}

	public CharClass getCharClass()
	{
		return charClass;
	}

	public Race getCharRace()
	{
		return charRace;
	}

	public int getLevel()
	{
		return level;
	}

}
