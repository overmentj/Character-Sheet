package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.Wizard;

import com.teabreak.charactersheet.CharacterSheet;
import com.teabreak.core.Main;
import com.teabreak.gui.HomeUI;

public class CharacterCreationWizard extends Wizard
{

	CharacterModel model;

	public CharacterCreationWizard()
	{
		setWindowTitle("New Wizard");
		model = new CharacterModel();
	}

	@Override
	public void addPages()
	{
		CreationRace charRace = new CreationRace();
		CreationClass charClass = new CreationClass();
		CreationAbilityScores charScores = new CreationAbilityScores();
		CreationFeats charFeats = new CreationFeats();
		CreationSkills charSkills = new CreationSkills();
		CreationDescription charDesc = new CreationDescription();

		this.addPage(charRace);
		this.addPage(charClass);
		this.addPage(charScores);
		this.addPage(charFeats);
		this.addPage(charSkills);
		this.addPage(charDesc);
	}

	@Override
	public boolean performFinish()
	{
		// Make sure everything's set.. this will be long
		if (model.charClass != null && model.charRace != null
				&& model.strength != 0 && model.dexterity != 0
				&& model.constitution != 0 && model.intelligence != 0
				&& model.wisdom != 0 && model.charisma != 0)
		{

			Main.getInstace().setCharSheet(
					new CharacterSheet(model.charRace, model.charClass,
							model.strength, model.dexterity,
							model.constitution, model.intelligence,
							model.wisdom, model.charisma));
			HomeUI.getInstance().getCharacterSheetUi().update();
			return true;
		}
		return false;
	}
}
