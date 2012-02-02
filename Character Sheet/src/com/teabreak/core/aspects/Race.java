package com.teabreak.core.aspects;

public class Race implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Race;
	
	private int bonusStrength = 0;
	private int bonusDexterity = 0;
	private int bonusConstitution = 0;
	private int bonusIntelligence = 0;
	private int bonusWisdom = 0;
	private int bonusCharisma = 0;
	private int levelAdjustment = 0;
	
	public int getBonusStrength() {
		return bonusStrength;
	}

	public int getBonusDexterity() {
		return bonusDexterity;
	}

	public int getBonusConstitution() {
		return bonusConstitution;
	}

	public int getBonusIntelligence() {
		return bonusIntelligence;
	}

	public int getBonusWisdom() {
		return bonusWisdom;
	}

	public int getBonusCharisma() {
		return bonusCharisma;
	}
	
	public int getLevelAdjustment() {
		return levelAdjustment;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AspectsEnum getType() {
		return TYPE;
	}

	
}
