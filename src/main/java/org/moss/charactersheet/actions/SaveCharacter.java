package org.moss.charactersheet.actions;

import java.io.FileWriter;
import java.io.IOException;

import org.moss.charactersheet.impl.Character;

import com.esotericsoftware.yamlbeans.YamlWriter;

/**
 * Handles the saving of a character to a file.
 */
public class SaveCharacter {

	public void save(Character constructCharacter) {

		try {
			YamlWriter writer = new YamlWriter(new FileWriter("output.yml"));
			writer.getConfig().setClassTag("Character", Character.class);
			writer.write(constructCharacter);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
