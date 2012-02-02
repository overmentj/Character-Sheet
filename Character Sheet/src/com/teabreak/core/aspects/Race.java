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
	private int landSpeed = 0;
	private int flightSpeed = 0;
	private String creatureSize;
	
	private int bonusAppraise = 0;
	private int bonusBalance = 0;
	private int bonusBluff = 0;
	private int bonusClimb = 0;
	private int bonusConcentration = 0; 
	private int bonusCraftWeapon = 0;
	private int bonusCraftArmour = 0;
	private int bonusCraftTrap = 0;
	private int bonusCraftAlchemy = 0;
	private int bonusDecipherScript = 0;
	private int bonusDiplomacy = 0;
	private int bonusDisableDevice = 0;
	private int bonusDisguise = 0;
	private int bonusEscapeArtist = 0;
	private int bonusForgery = 0;
	private int bonusGatherInformation = 0;
	private int bonusHandleAnimal = 0;
	private int bonusHeal = 0;
	private int bonusHide = 0;
	private int bonusIntimidate = 0;
	private int bonusJump = 0;
	private int bonusKnowledgeArcana = 0;
	private int bonusKnowledgeArchitectureAndEngineering = 0;
	private int bonusKnowledgeDungeoneering = 0;
	private int bonusKnowledgeGeography = 0; 
	private int bonusKnowledgeHistory = 0;
	private int bonusKnowledgeLocal = 0;
	private int bonusKnowledgeNature = 0;
	private int bonusKnowledgeNobilityAndRoyalty = 0;
	private int bonusKnowledgeReligion = 0;
	private int bonusKnowledgeThePlanes = 0;
	private int bonusListen = 0;
	private int bonusMoveSilently = 0;
	private int bonusOpenLock = 0;
	private int bonusPerformAct = 0;
	private int bonusPerformComedy = 0;
	private int bonusPerformDance = 0;
	private int bonusPerformKeyboard = 0;
	private int bonusPerformOratory = 0;
	private int bonusPerformPercussion = 0;
	private int bonusPerformString = 0;
	private int bonusPerformWind = 0;
	private int bonusPerformSing = 0;
	
	
	
	private String name;
	
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
	
	public int getLandSpeed() {
		return landSpeed;
	}
	
	public int getFlightSpeed() {
		return flightSpeed;
	}
	
	public String getCreatureSize() {
		return creatureSize;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AspectsEnum getType() {
		return TYPE;
	}

	
}
