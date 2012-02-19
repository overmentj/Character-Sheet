package com.teabreak.gui.charactersheet.charactercreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

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
	private Composite compositeSkills;
	

	private CharacterCreationWizard wizard;

	SortedMap<String, ArrayList<Widget>> skillsWidgets = new TreeMap<String, ArrayList<Widget>>();
	private Integer points;

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

		compositeSkills = new Composite(container, SWT.V_SCROLL);
		compositeSkills.setBounds(0, 0, 254, 282);

		text = new Text(container, SWT.BORDER);
		text.setBounds(325, 0, 249, 282);

		Label lblPointsLeft = new Label(container, SWT.NONE);
		lblPointsLeft.setBounds(260, 3, 59, 15);
		lblPointsLeft.setText("Points Left:");

		text_1 = new Text(container, SWT.BORDER);
		text_1.setText("0");
		text_1.setBounds(284, 24, 35, 21);

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

	/**
	 * Decrements the sent skills rank, returning the points
	 * @param skill String Key in skillsWidget
	 */
	private void reduceRank(String skill)
	{
		ArrayList<Widget> widgets = skillsWidgets.get(skill);
		Text rank = (Text) widgets.get(3);
		Integer ranks = Integer.parseInt(rank.getText());
		ranks--;
		rank.setText(ranks.toString());
	}

	/**
	 * Increments the sent skills rank, if their is enough points
	 * @param skill String Key in skillsWidget
	 */
	private void increaseRank(String skill)
	{
		ArrayList<Widget> widgets = skillsWidgets.get(skill);
		Text rank = (Text) widgets.get(3);
		Integer ranks = Integer.parseInt(rank.getText());
		ranks++;
		rank.setText(ranks.toString());
	}

	/**
	 * Updates the page contents, this uses data from the wizard model
	 */
	public void updatePage()
	{
		wizard = (CharacterCreationWizard) getWizard();
		Integer yPos = 10;

		if (!skillsWidgets.isEmpty())
		{
			removeOldSkills();
		}

		@SuppressWarnings("unchecked")
		SortedMap<String, Skill> skillsMap = (SortedMap<String, Skill>) Main
				.getInstace().getData().getDataSetOfType(AspectsEnum.Skill);

		String[] classSkills = wizard.model.charClass.getClassSkills();

		for (Skill skill : skillsMap.values())
		{
			ArrayList<Widget> skillRow = new ArrayList<Widget>();
			boolean isClassSkill = false;
			boolean isUntrained = skill.isUntrained();

			if (Arrays.asList(classSkills).contains(skill.getName()))
			{
				isClassSkill = true;
			}

			Label classSkill = new Label(compositeSkills, SWT.NONE);
			if (isClassSkill)
			{
				classSkill.setText("Y");
			} else
			{
				classSkill.setText("N");
			}

			classSkill.setBounds(10, yPos, 15, 15);

			Label skillName = new Label(compositeSkills, SWT.NONE);
			skillName.setBounds(30, yPos, 130, 15);
			skillName.setText(skill.getName());

			Button minus = new Button(compositeSkills, SWT.NONE);
			minus.setBounds(165, yPos, 15, 15);
			minus.setText("-");
			minus.setToolTipText(skill.getName() + " minus");
			minus.addListener(SWT.Selection, this);

			Text rank = new Text(compositeSkills, SWT.BORDER);
			rank.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
			rank.setText("0");
			rank.setBounds(180, yPos, 25, 15);

			Button add = new Button(compositeSkills, SWT.NONE);
			add.setBounds(210, yPos, 15, 15);
			add.setText("+");
			add.setToolTipText(skill.getName() + " add");
			add.addListener(SWT.Selection, this);

			if (!isUntrained && !isClassSkill)
			{
				minus.setEnabled(false);
				add.setEnabled(false);
			}

			skillRow.add(classSkill);
			skillRow.add(skillName);
			skillRow.add(minus);
			skillRow.add(rank);
			skillRow.add(add);

			skillsWidgets.put(skill.getName(), skillRow);
			yPos += 20;
		}
	}

	/**
	 * This is needed if someone swaps class, removes the old widgets.
	 */
	private void removeOldSkills()
	{
		for (ArrayList<Widget> widgets : skillsWidgets.values())
		{
			for (Widget widget : widgets)
			{
				widget.dispose();
			}
		}
	}
}
