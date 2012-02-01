package com.teabreak.core.aspects.equipment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.*;

public class EquipmentImport {
	
	Gson gson = new GsonBuilder().create();
	String fileName = "default.json";
	
	public EquipmentImport(String fileName)
	{
		this.fileName = fileName;
	}
	
	public void Load() throws FileNotFoundException {
	Reader reader = new InputStreamReader(EquipmentImport.class.getResourceAsStream(fileName));
	
	Armour armour = gson.fromJson(reader, Armour.class);
	
	armour.sysout();

	try {
		reader.close();
	} catch (IOException e) {
		System.out.println("oops");
		e.printStackTrace();
	}
	}
	

}
