package com.teabreak.core.aspects;

public class CharClass implements AspectsInterface
{

	private final AspectsEnum TYPE = AspectsEnum.Class;

	private String willSaveLevel;
	private String reflexSaveLevel;
	private String fortitudeSaveLevel;

	private String name;
	private String description;

	public CharClass(String willSaveLevel, String reflexSaveLevel,
			String fortitudeSaveLevel, String name, String description)
	{
		this.willSaveLevel = willSaveLevel;
		this.reflexSaveLevel = reflexSaveLevel;
		this.fortitudeSaveLevel = fortitudeSaveLevel;
		this.name = name;
		this.description = description;
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
	
	public String getDescription(){
		return description;
	}
}
