package com.teabreak.core.aspects.equipment;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.EquipmentAbstract;

public class Weapon extends EquipmentAbstract {

	private final EquipmentEnum EQUIPMENT_TYPE = EquipmentEnum.Weapon;
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EquipmentEnum getEquipmentType() {
		return EQUIPMENT_TYPE;
	}


}
