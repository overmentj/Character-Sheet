package com.teabreak.core.datasource.json;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.datasource.DataSourceInterface;
import com.teabreak.core.datasource.PutData;

/**
 * Used to export to JSON file
 * 
 * @author Robin
 *
 */
public class ExportJson{


	String fileName;
	FileWriter writer;
	

	public boolean putDataOfType(String fileName, Object object) {
		if (fileName == null)
		{
			fileName = "default.json";
		}
		else
		{
			this.fileName = fileName;
		}
		
		Gson gson = new Gson();
		
		try {
			writer = new FileWriter(fileName);
		} catch (IOException e) {
			System.out.println("Error creating export");
			e.printStackTrace();
			return false;
		}
		try {
		gson.toJson(object, writer);
		} catch (JsonSyntaxException e)
		{
			System.out.println("Error writing Json file");
			return false;
		}
		return true;
	}



}
