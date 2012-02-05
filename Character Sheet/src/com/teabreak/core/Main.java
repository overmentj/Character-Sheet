package com.teabreak.core;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.teabreak.charactersheet.CharacterSheet;

public class Main
{

	private Logger logger = Logger.getLogger("com.teabreak.core");
	private CharacterSheet charSheet = null;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args)
	{

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

}
