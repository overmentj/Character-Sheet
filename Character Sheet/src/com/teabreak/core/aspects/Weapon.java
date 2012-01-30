package com.teabreak.core.aspects;

public class Weapon implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Weapon;
	
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
