package com.teabreak.core.aspects;

public class Class implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Class;
	
	private String willSaveLevel;
	private String reflexSaveLevel;
	private String fortitudeSaveLevel;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AspectsEnum getType() {
		return TYPE;
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
