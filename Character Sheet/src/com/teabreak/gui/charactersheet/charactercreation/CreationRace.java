package com.teabreak.gui.charactersheet.charactercreation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

import com.teabreak.core.Main;
import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.Race;

public class CreationRace extends WizardPage implements Listener
{
	private Text textRace;

	Combo comboRaces;

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

		comboRaces = new Combo(container, SWT.NONE);
		comboRaces.setBounds(10, 31, 91, 23);
		comboRaces.addListener(SWT.Selection, this);
		Set<String> races = Main.getInstace().getData().getTypeKeys(AspectsEnum.Race);
		for (String curRace : races)
		{
			comboRaces.add(curRace);
		}

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
		if (comboRaces.getItem(comboRaces.getSelectionIndex()) != null
				|| comboRaces.getItem(comboRaces.getSelectionIndex()) != "")
		{
			setPageComplete(true);
			Race selRace = (Race) Main.getInstace().getData().getSingleObjectOfType(AspectsEnum.Race, comboRaces.getItem(comboRaces
					.getSelectionIndex()));
			
			CharacterCreationWizard wizard = (CharacterCreationWizard) getWizard();
			wizard.model.charRace = selRace;
			textRace.setText(selRace.getDescription());
		}
	}

}
