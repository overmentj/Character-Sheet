package com.teabreak.core.aspects;

public class Spell implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Spell;
	
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
