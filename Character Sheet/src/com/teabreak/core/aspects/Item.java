package com.teabreak.core.aspects;

public class Item implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Item;
	
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
