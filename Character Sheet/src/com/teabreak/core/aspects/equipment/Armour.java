package com.teabreak.core.aspects.equipment;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.EquipmentAbstract;


public class Armour extends EquipmentAbstract {

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
	


}
