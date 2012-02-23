package com.teabreak.core.datasource.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.Skill;

/**
 * Used to export to JSON file
 * 
 * @author Robin
 * 
 */
public class ExportJson
{

	String fileName;
	FileWriter writer;

	public boolean putDataOfType(String fileName, Object object)
	{
		if (fileName == null)
		{
			fileName = "default.json";
		} else
		{
			this.fileName = fileName;
		}

		Gson gson = new Gson();

		try
		{
			writer = new FileWriter(fileName);
		} catch (IOException e)
		{
			System.out.println("Error creating export");
			e.printStackTrace();
			return false;
		}
		try
		{
			gson.toJson(object, writer);
		} catch (JsonSyntaxException e)
		{
			System.out.println("Error writing Json file");
			return false;
		}
		return true;
	}

	public boolean putDataSet(String filename, SortedMap<String, ? extends AspectsInterface> dataSet)
	{
		Gson gson = new Gson();
		File file = new File(filename);
		if(file.canWrite()){
			System.out.println("I can!");
		}
		String json;
		try
		{
			writer = new FileWriter(file);
			json = gson.toJson(dataSet);
			BufferedWriter out = new BufferedWriter(writer);
			out.write(json);
			out.close();
		} catch (IOException e)
		{
			System.out.println("Error creating export");
			e.printStackTrace();
			return false;
		} catch (JsonSyntaxException e)
		{
			System.out.println("Error writing Json file");
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}

		return true;
	}

}
