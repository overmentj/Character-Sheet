package com.teabreak.gui.charactersheet.charactercreation;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.wb.swt.SWTResourceManager;

import com.teabreak.core.Main;
import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.Skill;

public class CreationSkills extends WizardPage implements Listener
{
	private Text text;
	private Text text_1;

	HashMap<String, ArrayList<Widget>> skillsWidgets = new HashMap<String, ArrayList<Widget>>();

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
	@Override
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(null);

		Composite compositeSkills = new Composite(container, SWT.V_SCROLL);
		compositeSkills.setBounds(0, 0, 254, 282);

		text = new Text(container, SWT.BORDER);
		text.setBounds(325, 0, 249, 282);

		Label lblPointsLeft = new Label(container, SWT.NONE);
		lblPointsLeft.setBounds(260, 3, 59, 15);
		lblPointsLeft.setText("Points Left:");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setText("0");
		text_1.setBounds(284, 24, 35, 21);

		Integer yPos = 10;

		@SuppressWarnings("unchecked")
		HashMap<String, Skill> skillsMap = (HashMap<String, Skill>) Main
				.getInstace().getData().getDataSetOfType(AspectsEnum.Skill);
		for (Skill skill : skillsMap.values())
		{
			ArrayList<Widget> skillRow = new ArrayList<Widget>();

			Label classSkill = new Label(container, SWT.NONE);
			classSkill.setText("Y"); // TODO: Do this correctly
			classSkill.setBounds(10, yPos, 15, 15);
			skillRow.add(classSkill);

			Label skillName = new Label(compositeSkills, SWT.NONE);
			skillName.setBounds(30, yPos, 130, 15);
			skillName.setText(skill.getName());
			skillRow.add(skillName);

			Button minus = new Button(compositeSkills, SWT.NONE);
			minus.setBounds(165, yPos, 15, 15);
			minus.setText("-");
			minus.setToolTipText(skill.getName() + " minus");
			minus.addListener(SWT.Selection, this);
			skillRow.add(minus);

			Text rank = new Text(compositeSkills, SWT.BORDER);
			rank.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
			rank.setText("0");
			rank.setBounds(180, yPos, 25, 15);
			skillRow.add(rank);

			Button add = new Button(compositeSkills, SWT.NONE);
			add.setBounds(210, yPos, 15, 15);
			add.setText("+");
			add.setToolTipText(skill.getName() + " add");
			add.addListener(SWT.Selection, this);
			skillRow.add(add);

			skillsWidgets.put(skill.getName(), skillRow);
			yPos += 20;
		}

		/*
		 * For each loop for skills - Create the following options (add to
		 * map/hashmap/what ever) -- Skill Label -- Remove rank -- Ranks -- Add
		 * rank Set tooltips of labels to skill name, this can be the key to the
		 * map? Think of a better better way to do this? extend the label
		 * widget? or something else?
		 */
	}

	@Override
	public void handleEvent(Event event)
	{
		if (event.type == SWT.Selection && event.widget instanceof Button)
		{
			Button button = (Button) event.widget;
			if (button.getToolTipText() != null
					&& button.getToolTipText() != "")
			{
				String[] tooltip = button.getToolTipText().split(" ");
				if (tooltip[1].matches("minus"))
				{
					reduceRank(tooltip[0]);
				} else
				{
					increaseRank(tooltip[0]);
				}
			}
		}

	}

	private void reduceRank(String skill)
	{
		ArrayList<Widget> widgets = skillsWidgets.get(skill);
		Text rank = (Text) widgets.get(3);
		Integer ranks = Integer.parseInt(rank.getText());
		ranks--;
		rank.setText(ranks.toString());
	}

	private void increaseRank(String skill)
	{
		ArrayList<Widget> widgets = skillsWidgets.get(skill);
		Text rank = (Text) widgets.get(3);
		Integer ranks = Integer.parseInt(rank.getText());
		ranks++;
		rank.setText(ranks.toString());
	}
}
