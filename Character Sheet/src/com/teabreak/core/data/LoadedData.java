package com.teabreak.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.Class;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.datasource.DataSourceInterface;

public class LoadedData
{

	private HashMap<String, Class> classMap = new HashMap<String, Class>();
	private HashMap<String, Race> raceMap = new HashMap<String, Race>();

	@SuppressWarnings("unchecked")
	public void loadData(DataSourceInterface dataSource)
	{
		classMap.putAll((Map<String, ? extends Class>) dataSource
				.getDataSetOfType(AspectsEnum.Class));
		raceMap.putAll((Map<String, ? extends Race>) dataSource
				.getDataSetOfType(AspectsEnum.Race));
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

		default:
			break;
		}

		return object;
	}
	
	@SuppressWarnings("unchecked")
	public Set<String> getTypeKeys(AspectsEnum type){
		Set<String> keys = null;
		switch (type)
		{
		case Class:
			keys = classMap.keySet();
			break;

		case Race:
			keys = raceMap.keySet();
			break;

		default:
			break;
		}
		return keys;
	}
}
