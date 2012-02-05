package com.teabreak.core.aspects;

public class Class implements AspectsInterface
{

	private final AspectsEnum TYPE = AspectsEnum.Class;

	private String willSaveLevel;
	private String reflexSaveLevel;
	private String fortitudeSaveLevel;

	private String name;

	public Class(String willSaveLevel, String reflexSaveLevel,
			String fortitudeSaveLevel, String name)
	{
		this.willSaveLevel = willSaveLevel;
		this.reflexSaveLevel = reflexSaveLevel;
		this.fortitudeSaveLevel = fortitudeSaveLevel;
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public AspectsEnum getType()
	{
		return TYPE;
	}

	@Override
	public long getId()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBook()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
