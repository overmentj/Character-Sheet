package com.teabreak.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.CharClass;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.Skill;
import com.teabreak.core.datasource.DataSourceInterface;

public class LoadedData
{

	private HashMap<String, CharClass> classMap = new HashMap<String, CharClass>();
	private HashMap<String, Race> raceMap = new HashMap<String, Race>();
	private HashMap<String, Skill> skillMap = new HashMap<String, Skill>();

	@SuppressWarnings("unchecked")
	public void loadData(DataSourceInterface dataSource)
	{
		classMap.putAll((Map<String, ? extends CharClass>) dataSource
				.getDataSetOfType(AspectsEnum.Class));
		raceMap.putAll((Map<String, ? extends Race>) dataSource
				.getDataSetOfType(AspectsEnum.Race));
		skillMap.putAll((Map<? extends String, ? extends Skill>) dataSource
				.getDataSetOfType(AspectsEnum.Skill));
	}

	public HashMap<String, ? extends AspectsInterface> getDataSetOfType(AspectsEnum type)
	{
		switch (type)
		{
		case Class:
			return classMap;

		case Race:
			return raceMap;

		case Skill:
			return skillMap;

		default:
			return null;
		}

	}

	public AspectsInterface getSingleObjectOfType(AspectsEnum type, String name)
	{
		AspectsInterface object = null;
		switch (type)
		{
		case Class:
			object = classMap.get(name);
			break;

		case Race:
			object = raceMap.get(name);
			break;

		case Skill:
			object = skillMap.get(name);
			break;

		default:
			break;
		}

		return object;
	}

	@SuppressWarnings("unchecked")
	public Set<String> getTypeKeys(AspectsEnum type)
	{
		Set<String> keys = null;
		switch (type)
		{
		case Class:
			keys = classMap.keySet();
			break;

		case Race:
			keys = raceMap.keySet();
			break;
		case Skill:
			keys = skillMap.keySet();
			break;
		default:
			break;
		}
		return keys;
	}
}
