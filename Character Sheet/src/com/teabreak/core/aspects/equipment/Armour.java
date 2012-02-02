package com.teabreak.core.aspects.equipment;

import com.teabreak.core.aspects.EquipmentAbstract;


public class Armour extends EquipmentAbstract {
	
	public String NAME;
	public String DAMAGE;
	public String REACH;
	public String BLURB;

	private final EquipmentEnum EQUIPMENT_TYPE = EquipmentEnum.Armour;
	
	private int armorBonus = 0;
	private int maxDexBonus = 0;
	private int checkPenalty = 0;
	private int spellFailure = 0;
	private int weight = 0;
	private int maxSpeed = 0;
	private int minSpeed = 0;
	private int goldValue = 0;
	
	private String name;
	
	public int getArmorBonus() {
		return armorBonus;
	}
	
	public int getMaxDexBonus() {
		return maxDexBonus;
	}
	
	public int getCheckPenalty() {
		return checkPenalty;
	}
	
	public int getSpellFailure() {
		return spellFailure;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public int getMinSpeed() {
		return minSpeed;
	}
	
	public int getGoldValue() {
		return goldValue;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public EquipmentEnum getEquipmentType() {
		return EQUIPMENT_TYPE;
	}

	public void sysout() {
		System.out.println(NAME + " " + DAMAGE + " " + REACH + " " + BLURB);
		
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
