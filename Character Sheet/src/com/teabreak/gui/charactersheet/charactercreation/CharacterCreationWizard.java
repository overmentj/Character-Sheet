package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.Wizard;



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
		return false;
	}

}
