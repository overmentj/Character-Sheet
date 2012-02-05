package com.teabreak.core.aspects.equipment;

import com.teabreak.core.aspects.EquipmentAbstract;

public class Weapon extends EquipmentAbstract {

	private final EquipmentEnum EQUIPMENT_TYPE = EquipmentEnum.Weapon;
	
	private int damageSmall = 0;
	private int damageMed = 0;
	private int critical = 0;
	private boolean critMultiple = false;
	private int rangeInc = 0;
	private int weight = 0;
	private boolean bludgeoning = false;
	private boolean slashing = false;
	private boolean piercing = false;
	
	private String name;
	
	public int getDamageSmall() {
		return damageSmall;
	}
	
	public int getDamageMed() {
		return damageMed;
	}
	
	public int getCritical() {
		return critical;
	}
	
	public boolean getCritMultiple() {
		return critMultiple;
	}
	
	public int getRangeInc() {
		return rangeInc;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public boolean getBludgeoning() {
		return bludgeoning;
	}
	
	public boolean getSlashing() {
		return slashing;
	}
	
	public boolean getPiercing() {
		return piercing;
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


	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBook() {
		// TODO Auto-generated method stub
		return null;
	}


}
