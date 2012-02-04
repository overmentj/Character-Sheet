package com.teabreak.gui.charactersheet;

import org.eclipse.jface.wizard.Wizard;

import com.teabreak.gui.charactersheet.charactercreation.CreationAbilityScores;
import com.teabreak.gui.charactersheet.charactercreation.CreationClass;
import com.teabreak.gui.charactersheet.charactercreation.CreationRace;

public class CharacterCreationWizard extends Wizard
{

	public CharacterCreationWizard()
	{
		setWindowTitle("New Wizard");
	}

	@Override
	public void addPages()
	{
		this.addPage(new CreationRace());
		this.addPage(new CreationClass());
		this.addPage(new CreationAbilityScores());
	}

	@Override
	public boolean performFinish()
	{
		return false;
	}

}
