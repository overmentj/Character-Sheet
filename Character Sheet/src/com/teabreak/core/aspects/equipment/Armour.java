package com.teabreak.core.aspects.equipment;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.EquipmentAbstract;


public class Armour extends EquipmentAbstract {
	
	public String NAME;
	public String DAMAGE;
	public String REACH;
	public String BLURB;

	private final EquipmentEnum EQUIPMENT_TYPE = EquipmentEnum.Armour;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentEnum getEquipmentType() {
		return EQUIPMENT_TYPE;
	}

	public void sysout() {
		System.out.println(NAME + " " + DAMAGE + " " + REACH + " " + BLURB);
		
	}
	


}
