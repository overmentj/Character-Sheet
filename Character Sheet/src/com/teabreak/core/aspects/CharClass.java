package com.teabreak.core.aspects;

import java.util.ArrayList;

import com.teabreak.core.aspects.enums.SaveEnum;

public class CharClass implements AspectsInterface
{

	private final AspectsEnum TYPE = AspectsEnum.Class;

	private SaveEnum.saveScore willSaveLevel;
	private SaveEnum.saveScore reflexSaveLevel;
	private SaveEnum.saveScore fortitudeSaveLevel;

	private String[] classSkills;

	private String name;
	private String description;
	private String book;

	public CharClass(SaveEnum.saveScore willSaveLevel,
			SaveEnum.saveScore reflexSaveLevel,
			SaveEnum.saveScore fortitudeSaveLevel, String name,
			String description, String[] classSkills, String book)
	{
		this.willSaveLevel = willSaveLevel;
		this.reflexSaveLevel = reflexSaveLevel;
		this.fortitudeSaveLevel = fortitudeSaveLevel;
		this.name = name;
		this.description = description;
		this.book = book;
		this.classSkills = classSkills;
	}

	public SaveEnum.saveScore getWillSaveLevel()
	{
		return willSaveLevel;
	}

	public SaveEnum.saveScore getReflexSaveLevel()
	{
		return reflexSaveLevel;
	}

	public SaveEnum.saveScore getFortitudeSaveLevel()
	{
		return fortitudeSaveLevel;
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
		return book;
	}

	public String getDescription()
	{
		return description;
	}

	public String[] getClassSkills()
	{
		return classSkills;
	}
}
