package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

public class CreationFeats extends WizardPage
{
	private Text textFeat;

	/**
	 * Create the wizard.
	 */
	public CreationFeats()
	{
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		
		Label lblFeats = new Label(container, SWT.NONE);
		lblFeats.setText("Feats");
		lblFeats.setBounds(10, 10, 55, 15);
		
		Label lblDesc = new Label(container, SWT.NONE);
		lblDesc.setText("Description");
		lblDesc.setBounds(236, 10, 65, 15);
		
		textFeat = new Text(container, SWT.BORDER);
		textFeat.setEnabled(false);
		textFeat.setEditable(false);
		textFeat.setBounds(236, 31, 328, 241);
		
		List listCurFeats = new List(container, SWT.BORDER | SWT.V_SCROLL);
		listCurFeats.setItems(new String[] {});
		listCurFeats.setBounds(140, 30, 90, 241);
		
		List listFeats = new List(container, SWT.BORDER | SWT.V_SCROLL);
		listFeats.setBounds(10, 31, 90, 241);
		
		Button btnAddFeats = new Button(container, SWT.NONE);
		btnAddFeats.setBounds(106, 109, 28, 25);
		btnAddFeats.setText(">");
		
		Button btnRemoveFeat = new Button(container, SWT.NONE);
		btnRemoveFeat.setText("<");
		btnRemoveFeat.setBounds(106, 140, 28, 25);
		
		Label lblCurrentFeats = new Label(container, SWT.NONE);
		lblCurrentFeats.setText("Current Feats");
		lblCurrentFeats.setBounds(140, 10, 90, 15);
	}
}
