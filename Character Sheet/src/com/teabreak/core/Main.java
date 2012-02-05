package com.teabreak.core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.teabreak.charactersheet.CharacterSheet;
import com.teabreak.core.datasource.DataSourceInterface;
import com.teabreak.core.datasource.TestDataSource;
import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.Class;
import com.teabreak.core.aspects.Feat;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.Skill;

public class Main
{

	private Logger logger = Logger.getLogger("com.teabreak.core");
	private CharacterSheet charSheet = null;
	private DataSourceInterface dataSource;
	
	// All the amazing data we pain stakingly copy and pasted :P
	private ArrayList<Skill> skillsList = new ArrayList<Skill>();
	private ArrayList<Feat> featsList = new ArrayList<Feat>();
	private ArrayList<Class> classesList = new ArrayList<Class>();
	private ArrayList<Race> racesList = new ArrayList<Race>();
	
	private static Main instance = null;

	public static Main getInstace(){
		if(instance == null){
			instance = new Main();
			instance.dataSource = new TestDataSource();
			instance.loadData();
		}
		return instance;
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args)
	{
		Main main = Main.getInstace();
		main.dataSource = new TestDataSource();
		main.loadData();
		// Start by loading the data and opening a loading window
		
		
		// Start main window
	}

	public CharacterSheet getCharSheet()
	{
		return charSheet;
	}

	public void setCharSheet(CharacterSheet charSheet)
	{
		this.charSheet = charSheet;
	}
	
	@SuppressWarnings("unchecked")
	private void loadData(){
		// Load classes
		classesList.addAll((Collection<? extends Class>) dataSource.getDataSetOfType(AspectsEnum.Class));
		// Load Races
		racesList.addAll((Collection<? extends Race>) dataSource.getDataSetOfType(AspectsEnum.Race));
		// Load Skills
		
		// Load Feats
		
		// Load Spells
		
		// Load Equipment
	}

	public ArrayList<Skill> getSkillsList()
	{
		return skillsList;
	}

	public ArrayList<Feat> getFeatsList()
	{
		return featsList;
	}

	public ArrayList<Class> getClassesList()
	{
		return classesList;
	}

	public ArrayList<Race> getRacesList()
	{
		return racesList;
	}


}
