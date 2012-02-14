package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class CreationSkills extends WizardPage
{
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the wizard.
	 */
	public CreationSkills()
	{
		super("wizardPage");
		setTitle("Skills");
		setDescription("Skills Select Em..");
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
		container.setLayout(null);

		Composite compositeSkills = new Composite(container, SWT.V_SCROLL);
		compositeSkills.setBounds(0, 0, 254, 282);

		Label lblSkillName = new Label(compositeSkills, SWT.NONE);
		lblSkillName.setBounds(28, 13, 134, 15);
		lblSkillName.setText("Profession (Long name)");

		text_2 = new Text(compositeSkills, SWT.BORDER);
		text_2.setText("30");
		text_2.setBounds(187, 10, 24, 21);

		Label label = new Label(compositeSkills, SWT.NONE);
		label.setBounds(168, 13, 13, 15);
		label.setText("<-");

		Label label_1 = new Label(compositeSkills, SWT.NONE);
		label_1.setToolTipText("skill1");
		label_1.setText("->");
		label_1.setBounds(217, 13, 13, 15);

		Label lblO = new Label(compositeSkills, SWT.NONE);
		lblO.setText("O");
		lblO.setBounds(10, 13, 13, 15);

		text = new Text(container, SWT.BORDER);
		text.setBounds(325, 0, 249, 282);

		Label lblPointsLeft = new Label(container, SWT.NONE);
		lblPointsLeft.setBounds(260, 3, 59, 15);
		lblPointsLeft.setText("Points Left:");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setText("0");
		text_1.setBounds(284, 24, 35, 21);

		/*
		 * For each loop for skills 
		 * - Create the following options (add to map/hashmap/what ever) 
		 * -- Skill Label 
		 * -- Remove rank 
		 * -- Ranks 
		 * -- Add rank 
		 * Set tooltips of labels to skill name, this can be the key to the
		 * map? Think of a better better way to do this? extend the label
		 * widget? or something else?
		 */
	}
}
