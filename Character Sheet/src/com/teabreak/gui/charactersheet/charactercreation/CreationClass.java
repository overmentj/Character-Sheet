package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class CreationClass extends WizardPage
{
	private Text text;

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
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setItems(new String[] {"Fighter", "Bard", "Tom"});
		combo.setBounds(10, 47, 91, 23);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(107, 47, 457, 225);
	}
}
