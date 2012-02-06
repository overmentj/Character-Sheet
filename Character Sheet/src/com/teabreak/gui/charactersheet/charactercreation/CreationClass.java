package com.teabreak.gui.charactersheet.charactercreation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.Class;

import com.teabreak.core.Main;

public class CreationClass extends WizardPage implements Listener
{
	private Text textClassDetails;
	private Combo comboClasses;

	/**
	 * Create the wizard.
	 */
	public CreationClass()
	{
		super("wizardPage");
		setTitle("Class Selection");
		setDescription("Select a class from below");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(null);
		
		comboClasses = new Combo(container, SWT.NONE);
		comboClasses.setBounds(10, 31, 91, 23);
		comboClasses.addListener(SWT.Selection, this);
		Set<String> classes = Main.getInstace().getData().getTypeKeys(AspectsEnum.Class);
		for (String curClass : classes)
		{
			comboClasses.add(curClass);
		}
				
		textClassDetails = new Text(container, SWT.BORDER);
		textClassDetails.setEditable(false);
		textClassDetails.setEnabled(false);
		textClassDetails.setBounds(107, 31, 457, 213);
		
		Label lblClass = new Label(container, SWT.NONE);
		lblClass.setBounds(10, 10, 55, 15);
		lblClass.setText("Class");
		
		Label lblDescription = new Label(container, SWT.NONE);
		lblDescription.setBounds(107, 10, 65, 15);
		lblDescription.setText("Description");
		
		Button btnClassTable = new Button(container, SWT.NONE);
		btnClassTable.setBounds(107, 250, 75, 25);
		btnClassTable.setText("Class Table");
		
		setPageComplete(false);
	}

	@Override
	public void handleEvent(Event event)
	{
		// Update text box with race details
		if (comboClasses.getItem(comboClasses.getSelectionIndex()) != null
				|| comboClasses.getItem(comboClasses.getSelectionIndex()) != "")
		{
			setPageComplete(true);
			// Get Class object
			Class selClass = (Class) Main.getInstace().getData().getSingleObjectOfType(AspectsEnum.Class, comboClasses.getItem(comboClasses
					.getSelectionIndex()));
			
			CharacterCreationWizard wizard = (CharacterCreationWizard) getWizard();
			wizard.model.charRace = selClass.getName();
			textClassDetails.setText(selClass.getDescription());
			setPageComplete(true);
		}else{
			setPageComplete(false);
		}
	}
}
