package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CreationDescription extends WizardPage
{
	private Text txtRobinMoss;
	private Text txtLupusUmbrae;
	private Text text;
	private Text txtstlb;
	private Text txtCollosul;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the wizard.
	 */
	public CreationDescription()
	{
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		txtRobinMoss = new Text(container, SWT.BORDER);
		txtRobinMoss.setText("Robin Moss");
		txtRobinMoss.setBounds(10, 31, 153, 21);

		Label lblPlayerName = new Label(container, SWT.NONE);
		lblPlayerName.setBounds(10, 10, 76, 15);
		lblPlayerName.setText("Player Name");

		txtLupusUmbrae = new Text(container, SWT.BORDER);
		txtLupusUmbrae.setText("Lupus Umbrae");
		txtLupusUmbrae.setBounds(169, 31, 153, 21);

		Label lblCharacterName = new Label(container, SWT.NONE);
		lblCharacterName.setText("Character Name");
		lblCharacterName.setBounds(169, 10, 120, 15);

		Group grpHeightWeight = new Group(container, SWT.NONE);
		grpHeightWeight.setText("Height / Weight");
		grpHeightWeight.setBounds(10, 58, 98, 109);

		text = new Text(grpHeightWeight, SWT.BORDER);
		text.setBounds(10, 21, 58, 21);
		text.setText("10' 6\"");

		txtstlb = new Text(grpHeightWeight, SWT.BORDER);
		txtstlb.setBounds(10, 48, 58, 21);
		txtstlb.setText("6st 3lb");

		Button btnGenerate = new Button(grpHeightWeight, SWT.NONE);
		btnGenerate.setBounds(10, 75, 75, 25);
		btnGenerate.setText("Generate");

		Combo combo = new Combo(container, SWT.NONE);
		combo.setItems(new String[]
		{ "Male", "Female" });
		combo.setBounds(114, 78, 76, 23);
		combo.select(0);

		Label lblGender = new Label(container, SWT.NONE);
		lblGender.setText("Gender");
		lblGender.setBounds(114, 58, 76, 15);

		Label lblSize = new Label(container, SWT.NONE);
		lblSize.setText("Size");
		lblSize.setBounds(114, 107, 76, 15);

		txtCollosul = new Text(container, SWT.BORDER);
		txtCollosul.setText("Gargantuan");
		txtCollosul.setBounds(114, 128, 76, 21);

		Label lblBackstory = new Label(container, SWT.NONE);
		lblBackstory.setText("Backstory");
		lblBackstory.setBounds(328, 10, 120, 15);

		text_1 = new Text(container, SWT.BORDER | SWT.V_SCROLL);
		text_1.setBounds(328, 31, 236, 241);

		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(10, 194, 180, 78);

		Label lblLooks = new Label(container, SWT.NONE);
		lblLooks.setText("Looks");
		lblLooks.setBounds(10, 173, 120, 15);
	}
}
