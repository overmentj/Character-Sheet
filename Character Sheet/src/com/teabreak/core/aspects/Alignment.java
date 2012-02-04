package com.teabreak.core.aspects;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.teabreak.charactersheet.CharacterSheet;
import com.teabreak.core.aspects.enums.AlignmentEnum;

public class Alignment {
	
	String selectedOrder = "z";
	String selectedMorality = "z";
	boolean update = false;
	String alignment;
	CharacterSheet charSheet;
	String alignmentText = "Choose an alignment";
	
	public Alignment(CharacterSheet charSheet){
		this.charSheet = charSheet;
	}
		
public void assign(String toolItem, char morals) {
	
	if (toolItem.matches("Good"))
	{
		selectedMorality = "G";
	}
	else if (toolItem.matches("Neutral"))
	{
		if (morals == 'M'){
		selectedMorality = "N";
		}
		else
		{
			selectedOrder = "N";
		}
	}
	else if (toolItem.matches("Evil"))
	{
		selectedMorality = "E";
	}
	else if (toolItem.matches("Lawful"))
	{
		selectedOrder = "L";
	}
	else if (toolItem.matches("Chaotic"))
	{
		selectedOrder = "C";
	}
	else 
	{
		System.out.println("Error");
	}
	update();
	
}

public String getAlignment() {
	return alignment;
}

public String getAlignmentText()
{
	return alignmentText;
}

public void update()
{
	if (selectedOrder != "z" && selectedMorality != "z")
	{
		String key = selectedOrder + selectedMorality;
		for (AlignmentEnum a :AlignmentEnum.values())
		{
			if (key.matches(a.toString()))
			{
				charSheet.setCharacterAlignment(key);
				alignment = key;
				alignmentText = a.getEnumAlignmentText();
				System.out.println(alignmentText);
			}
		}
	}
}
}