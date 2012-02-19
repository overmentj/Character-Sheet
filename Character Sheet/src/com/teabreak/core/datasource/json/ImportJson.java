package com.teabreak.core.datasource.json;

import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.equipment.EquipmentImport;
import com.teabreak.core.datasource.GetData;

/**
 * Use to read in all JSON files
 * 
 * @author Robin
 * 
 */
public class ImportJson implements GetData
{
	String file;

	@Override
	public <T> AspectsInterface getDataOfType(String file, Class<T> classOfT)
	{
		Gson gson = new GsonBuilder().create();
		if (file == null)
		{
			file = "default.json";
		} else
		{
			this.file = file;
		}

		Reader reader = new InputStreamReader(
				EquipmentImport.class.getResourceAsStream(file));

		return (AspectsInterface) gson.fromJson(reader, classOfT);
	}

}
