package com.teabreak.gui.charactersheet.charactercreation;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.core.dicebag.DiceRolling;

public class CreationAbilityScores extends WizardPage implements Listener
{
	private Text textStr;
	private Text textDex;
	private Text textCon;
	private Text textInt;
	private Text textWis;
	private Text textCha;
	private int textLimit = 2;

	private Label lblBonStr;
	private Label lblBonDex;
	private Label lblBonInt;
	private Label lblBonWis;
	private Label lblBonCha;
	private Label lblBonCon;

	private Label lblStr;
	private Label lblDex;
	private Label lblCon;
	private Label lblInt;
	private Label lblWis;
	private Label lblCha;

	private Button btnRollStr;
	private Button btnRollDex;
	private Button btnRollCon;
	private Button btnRollInt;
	private Button btnRollWis;
	private Button btnRollCha;

	private Button btnRollAll;

	private Combo comboRollOptions;

	/**
	 * Create the wizard.
	 */
	public CreationAbilityScores()
	{
		super("wizardPage");
		setTitle("Ability Scores");
		setDescription("Select Ability Score system and set characters scores");
	}

	// TODO: Add drag and drop.

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		// Ability Score Labels
		lblStr = new Label(container, SWT.NONE);
		lblDex = new Label(container, SWT.NONE);
		lblInt = new Label(container, SWT.NONE);
		lblWis = new Label(container, SWT.NONE);
		lblCha = new Label(container, SWT.NONE);
		lblCon = new Label(container, SWT.NONE);

		lblBonStr = new Label(container, SWT.NONE);
		lblBonDex = new Label(container, SWT.NONE);
		lblBonCon = new Label(container, SWT.NONE);
		lblBonInt = new Label(container, SWT.NONE);
		lblBonWis = new Label(container, SWT.NONE);
		lblBonCha = new Label(container, SWT.NONE);

		lblStr.setText("STR");
		lblDex.setText("DEX");
		lblCon.setText("CON");
		lblInt.setText("INT");
		lblWis.setText("WIS");
		lblCha.setText("CHA");

		lblStr.setBounds(10, 41, 28, 15);
		lblDex.setBounds(10, 68, 28, 15);
		lblInt.setBounds(10, 125, 28, 15);
		lblWis.setBounds(10, 152, 28, 15);
		lblCha.setBounds(10, 179, 28, 15);
		lblCon.setBounds(10, 98, 28, 15);

		lblBonStr.setBounds(89, 41, 28, 15);
		lblBonStr.setText("Bon");

		lblBonDex.setText("Bon");
		lblBonDex.setBounds(89, 68, 28, 15);

		lblBonCon.setText("Bon");
		lblBonCon.setBounds(89, 95, 28, 15);

		lblBonInt.setText("Bon");
		lblBonInt.setBounds(89, 122, 28, 15);

		lblBonWis.setText("Bon");
		lblBonWis.setBounds(89, 149, 28, 15);

		lblBonCha.setText("Bon");
		lblBonCha.setBounds(89, 176, 28, 15);

		comboRollOptions = new Combo(container, SWT.NONE);
		comboRollOptions.setItems(new String[]
		{ "Manual", "Standard (3d6) No choice", "3d6 choose", "4d6 best 3",
				"5d6 best 3", "High Power", "Medium Power", "Low Power" });
		comboRollOptions.setBounds(293, 38, 139, 23);
		comboRollOptions.setText("Roll Choice");
		comboRollOptions.select(3);
		comboRollOptions.addListener(SWT.Selection, this);

		textStr = new Text(container, SWT.BORDER);
		restrictInt(textStr);
		textStr.setTextLimit(textLimit);
		textStr.addListener(SWT.Modify, this);
		textStr.setBounds(44, 38, 39, 21);
		textStr.setEditable(false);

		textDex = new Text(container, SWT.BORDER);
		restrictInt(textDex);
		textDex.setTextLimit(textLimit);
		textDex.addListener(SWT.Modify, this);
		textDex.setBounds(44, 65, 39, 21);
		textDex.setEditable(false);

		textCon = new Text(container, SWT.BORDER);
		restrictInt(textCon);
		textCon.setTextLimit(textLimit);
		textCon.addListener(SWT.Modify, this);
		textCon.setBounds(44, 92, 39, 21);
		textCon.setEditable(false);

		textInt = new Text(container, SWT.BORDER);
		restrictInt(textInt);
		textInt.setTextLimit(textLimit);
		textInt.addListener(SWT.Modify, this);
		textInt.setBounds(44, 119, 39, 21);
		textInt.setEditable(false);

		textWis = new Text(container, SWT.BORDER);
		restrictInt(textWis);
		textWis.setTextLimit(textLimit);
		textWis.addListener(SWT.Modify, this);
		textWis.setBounds(44, 146, 39, 21);
		textWis.setEditable(false);

		textCha = new Text(container, SWT.BORDER);
		restrictInt(textCha);
		textCha.setTextLimit(textLimit);
		textCha.addListener(SWT.Modify, this);
		textCha.setBounds(44, 173, 39, 21);
		textCha.setEditable(false);

		btnRollStr = new Button(container, SWT.NONE);
		btnRollStr.setBounds(123, 38, 53, 21);
		btnRollStr.setText("Roll");
		btnRollStr.addListener(SWT.Selection, this);

		btnRollDex = new Button(container, SWT.NONE);
		btnRollDex.setText("Roll");
		btnRollDex.setBounds(123, 65, 53, 21);
		btnRollDex.addListener(SWT.Selection, this);

		btnRollCon = new Button(container, SWT.NONE);
		btnRollCon.setText("Roll");
		btnRollCon.setBounds(123, 92, 53, 21);
		btnRollCon.addListener(SWT.Selection, this);

		btnRollInt = new Button(container, SWT.NONE);
		btnRollInt.setText("Roll");
		btnRollInt.setBounds(123, 119, 53, 21);
		btnRollInt.addListener(SWT.Selection, this);

		btnRollWis = new Button(container, SWT.NONE);
		btnRollWis.setText("Roll");
		btnRollWis.setBounds(123, 146, 53, 21);
		btnRollWis.addListener(SWT.Selection, this);

		btnRollCha = new Button(container, SWT.NONE);
		btnRollCha.setText("Roll");
		btnRollCha.setBounds(123, 173, 53, 21);
		btnRollCha.addListener(SWT.Selection, this);

		btnRollAll = new Button(container, SWT.NONE);
		btnRollAll.setText("Roll All");
		btnRollAll.setBounds(123, 200, 53, 21);
		btnRollAll.addListener(SWT.Selection, this);

	}

	// TODO: Make a seperate class for restricted entries

	private void restrictInt(Text text)
	{
		text.addListener(SWT.Verify, new Listener()
		{
			public void handleEvent(Event e)
			{
				String string = e.text;
				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++)
				{
					if (!('0' <= chars[i] && chars[i] <= '9'))
					{
						e.doit = false;
						return;
					}
				}
			}
		});

	}

	private String calcBonus(int score)
	{
		String bonus = "ERR";
		if (score > 0)
		{
			if (score <= 9)
			{
				if (score % 2 == 1)
				{
					score--;
				}
			}
			score = ((score - 10) / 2);
			bonus = "" + score;
		} else
		{
			System.out.println("Error, Invalid value");
		}
		return bonus;
	}

	private void enableManual(boolean enable)
	{
		textStr.setEditable(enable);
		textDex.setEditable(enable);
		textCon.setEditable(enable);
		textInt.setEditable(enable);
		textWis.setEditable(enable);
		textCha.setEditable(enable);
	}

	private void updateModifier(Widget widget)
	{
		Text text = (Text) widget;

		if (!text.getText().equals(""))
		{
			int score = Integer.parseInt(text.getText());
			String bonus = calcBonus(score);
			CharacterCreationWizard wizard = (CharacterCreationWizard) getWizard();
			// Update the correct label for modifier
			if (text == textStr)
			{
				lblBonStr.setText(bonus);
				wizard.model.strength = score;
			} else if (text == textDex)
			{
				lblBonDex.setText(bonus);
				wizard.model.dexterity = score;
			} else if (text == textCon)
			{
				lblBonCon.setText(bonus);
				wizard.model.constitution = score;
			} else if (text == textInt)
			{
				lblBonInt.setText(bonus);
				wizard.model.intelligence = score;
			} else if (text == textWis)
			{
				lblBonWis.setText(bonus);
				wizard.model.wisdom = score;
			} else if (text == textCha)
			{
				lblBonCha.setText(bonus);
				wizard.model.charisma = score;
			}
		}
	}

	private Integer rollDice()
	{
		DiceRolling dice = new DiceRolling();
		int roll = 0;
		// Find system first
		switch (comboRollOptions.getSelectionIndex())
		{
		case 1:
		case 2:
			// Roll 3d6
			roll = dice.rollDice(6, 3, 0);
			break;
		case 3:
			// roll 4d6 best 3
			roll = dice.rollDice(6, 3, 0, 3);
			break;
		case 4:
			// roll 5d6 best 3
			roll = dice.rollDice(6, 5, 0, 3);
			break;
		default:
			// and the rest but can't be bothered
			break;
		}
		return roll;
	}

	private void abilityScore(Widget widget)
	{
		if (widget == btnRollAll)
		{
			this.textStr.setText(rollDice().toString());
			this.textDex.setText(rollDice().toString());
			this.textCon.setText(rollDice().toString());
			this.textInt.setText(rollDice().toString());
			this.textWis.setText(rollDice().toString());
			this.textCha.setText(rollDice().toString());
		} else if (widget == btnRollStr)
		{
			this.textStr.setText(rollDice().toString());
		} else if (widget == btnRollDex)
		{
			this.textDex.setText(rollDice().toString());
		} else if (widget == btnRollCon)
		{
			this.textCon.setText(rollDice().toString());
		} else if (widget == btnRollInt)
		{
			this.textInt.setText(rollDice().toString());
		} else if (widget == btnRollWis)
		{
			this.textWis.setText(rollDice().toString());
		} else if (widget == btnRollCha)
		{
			this.textCha.setText(rollDice().toString());
		}
	}

	private void pageCompeted()
	{
		if (textStr.getText() != "" && textDex.getText() != ""
				&& textCon.getText() != "" && textInt.getText() != ""
				&& textWis.getText() != "" && textCha.getText() != "")
		{
			setPageComplete(true);
		}

	}

	@Override
	public void handleEvent(Event event)
	{
		if (event.type == SWT.Modify)
		{
			updateModifier(event.widget);
		} else if (event.type == SWT.Selection
				&& event.widget == comboRollOptions)
		{
			// Enable the text areas else disable
			if (comboRollOptions.getSelectionIndex() == 0)
			{
				enableManual(true);
			} else
			{
				enableManual(false);
			}

		} else if (event.type == SWT.Selection)
		{
			abilityScore(event.widget);
		} else
		{

		}
		pageCompeted();
	}
}
