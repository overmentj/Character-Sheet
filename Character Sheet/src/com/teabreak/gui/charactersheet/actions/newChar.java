package com.teabreak.gui.charactersheet.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;

import com.teabreak.gui.HomeUI;
import com.teabreak.gui.charactersheet.CharacterCreationWizard;

public class newChar extends Action
{

	public newChar()
	{
		super("Test Action");
	}

	@Override
	public void run()
	{
		try
		{
			WizardDialog newChar = new WizardDialog(HomeUI.getInstance(), new CharacterCreationWizard());
			newChar.open();
			HomeUI.getInstance().setVisible(false);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			HomeUI.getInstance().setVisible(true);
		}
	}
}
