package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class CreationRace extends WizardPage implements Listener
{
	private Text textRace;

	Combo comboRace;

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
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		textRace = new Text(container, SWT.BORDER);
		textRace.setEnabled(false);
		textRace.setEditable(false);
		textRace.setBounds(107, 31, 457, 241);

		comboRace = new Combo(container, SWT.NONE);
		comboRace.setItems(new String[]
		{ "Fighter", "Bard", "Tom" });
		comboRace.setBounds(10, 31, 91, 23);
		comboRace.addListener(SWT.Selection, this);

		Label lblRace = new Label(container, SWT.NONE);
		lblRace.setText("Race");
		lblRace.setBounds(10, 10, 55, 15);

		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setText("Description");
		lblDescription.setBounds(107, 10, 65, 15);

		setPageComplete(false);
	}

	public void handleEvent(Event e)
	{
		// Update text box with race details
		if (comboRace.getItem(comboRace.getSelectionIndex()) != null
				|| comboRace.getItem(comboRace.getSelectionIndex()) != "")
		{
			setPageComplete(true);
			CharacterCreationWizard wizard = (CharacterCreationWizard) getWizard();
			wizard.model.charRace = comboRace.getItem(comboRace
					.getSelectionIndex());
			textRace.setText("The race you've chosen is: " + comboRace.getItem(comboRace
					.getSelectionIndex()));
		}
	}

}
