package org.moss.charactersheet.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.moss.charactersheet.actions.api.CustomFileFilter;
import org.moss.charactersheet.impl.Character;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Saves character in JSON format
 * @author Jacq
 *
 */
public class SaveCharacter {

	private File saveLocation;
	private final String fileExt = CustomFileFilter.getFileExtension();
	
	public SaveCharacter(File file) {
		if (!file.getPath().toLowerCase().endsWith(".sav")) {
			file = new File(file.getPath() + fileExt);
		}
		this.saveLocation = file;
	}
	
	/**
	 * Saves a character to .sav in JSON format
	 * @param character
	 */
	public void save(Character character) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(saveLocation));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String info = gson.toJson(character, character.getClass());
			writer.write(info);
		} catch (IOException e) {
			System.out.println("Unable to save. Cause: " + e.getMessage());
		}
		finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException x) {
					System.out.println("Unable to close writer. Cause: " + x.getMessage());
				}
			}
		}
	}
	
	public File getSaveLocation() {
		return saveLocation;
	}
}
