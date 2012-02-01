package com.teabreak.core.aspects;

import com.teabreak.core.aspects.equipment.EquipmentEnum;

public abstract class EquipmentAbstract implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Equipment;
	
	@Override
	public AspectsEnum getType(){
		return TYPE;
	}
	
	public abstract EquipmentEnum getEquipmentType();
}
