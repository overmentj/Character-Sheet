package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class CreationRace extends WizardPage
{

	/**
	 * Create the wizard.
	 */
	public CreationRace()
	{
		super("wizardPage");
		setTitle("Race Selection");
		setDescription("Select a race from below");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
	}

}
