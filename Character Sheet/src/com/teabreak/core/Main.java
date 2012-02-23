package com.teabreak.core;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.teabreak.charactersheet.CharacterSheet;
import com.teabreak.core.data.LoadedData;
import com.teabreak.core.datasource.DataSourceInterface;
import com.teabreak.core.datasource.TestDataSource;

public class Main
{

	private Logger logger = Logger.getLogger("com.teabreak.core");
	private CharacterSheet charSheet = null;
	private DataSourceInterface dataSource;

	private LoadedData data = new LoadedData();

	private static Main instance = null;

	public static Main getInstace()
	{
		if (instance == null)
		{
			instance = new Main();
			instance.dataSource = new TestDataSource();
			instance.data.loadData(instance.dataSource);
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
		main.data.loadData(main.dataSource);
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

	public LoadedData getData()
	{
		return data;
	}

	public DataSourceInterface getDataSource(){
		return dataSource;
	}
}
