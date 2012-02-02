package com.teabreak.charactersheet;

import com.teabreak.core.aspects.Class;
import com.teabreak.core.aspects.Race;

public class CharacterSheet {

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

	private long experience;

	private boolean levelledUp = false;


	public void addExperience(Long experienceGained) {
		this.experience += experienceGained;
	}

	public long getExperience() {

		return experience;
	}

	public int getStrengthModifier() {
		return getModifier(strength);
	}

	public int getDexterityModifier() {
		return getModifier(dexterity);
	}

	public int getConsitituionModifier() {
		return getModifier(constitution);
	}

	public int getIntelligenceModifier() {
		return getModifier(intelligence);
	}

	public int getWisdomModifier() {
		return getModifier(wisdom);
	}

	public int getCharismaModifier() {
		return getModifier(charisma);
	}

	public boolean isLevelledUp() {
		return this.levelledUp;
	}
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	private int getModifier(int attribute) {
		if (attribute > 10) {
			return (attribute - 10) / 2;
		} else {
			return 0 - ((10 - attribute) / 2);
		}
	}

	private void checkLevelledUp() {

	}
}
