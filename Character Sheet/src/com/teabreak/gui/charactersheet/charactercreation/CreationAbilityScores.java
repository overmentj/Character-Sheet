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

import com.teabreak.core.DiceRolling;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CreationAbilityScores extends WizardPage {
	private Text textStr;
	private Text textDex;
	private Text textCon;
	private Text textInt;
	private Text textWis;
	private Text textCha;
	private int textLimit = 2;

	/**
	 * Create the wizard.
	 */
	public CreationAbilityScores() {
		super("wizardPage");
		setTitle("Ability Scores");
		setDescription("Select Ability Score system and set characters scores");
	}

	//TODO: Add drag and drop.
	
	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);

		Label lblStr = new Label(container, SWT.NONE);
		lblStr.setBounds(10, 41, 28, 15);
		lblStr.setText("STR");

		Label lblDex = new Label(container, SWT.NONE);
		lblDex.setText("DEX");
		lblDex.setBounds(10, 68, 28, 15);

		Label lblInt = new Label(container, SWT.NONE);
		lblInt.setText("INT");
		lblInt.setBounds(10, 125, 28, 15);

		Label lblWis = new Label(container, SWT.NONE);
		lblWis.setText("WIS");
		lblWis.setBounds(10, 152, 28, 15);

		Label lblCha = new Label(container, SWT.NONE);
		lblCha.setText("CHA");
		lblCha.setBounds(10, 179, 28, 15);

		Label lblCon = new Label(container, SWT.NONE);
		lblCon.setText("CON");
		lblCon.setBounds(10, 98, 28, 15);

		final Label lblBonStr = new Label(container, SWT.NONE);
		lblBonStr.setBounds(89, 41, 28, 15);
		lblBonStr.setText("Bon");

		final Label lblBonDex = new Label(container, SWT.NONE);
		lblBonDex.setText("Bon");
		lblBonDex.setBounds(89, 68, 28, 15);

		final Label lblBonCon = new Label(container, SWT.NONE);
		lblBonCon.setText("Bon");
		lblBonCon.setBounds(89, 95, 28, 15);

		final Label lblBonInt = new Label(container, SWT.NONE);
		lblBonInt.setText("Bon");
		lblBonInt.setBounds(89, 122, 28, 15);

		final Label lblBonWis = new Label(container, SWT.NONE);
		lblBonWis.setText("Bon");
		lblBonWis.setBounds(89, 149, 28, 15);

		final Label lblBonCha = new Label(container, SWT.NONE);
		lblBonCha.setText("Bon");
		lblBonCha.setBounds(89, 176, 28, 15);

		final Combo comboRollOptions = new Combo(container, SWT.NONE);
		comboRollOptions.setItems(new String[] { "Standard (3d6) No choice",
				"3d6 choose", "4d6 best 3", "5d6 best 3", "High Power",
				"Medium Power", "Low Power" });
		comboRollOptions.setBounds(293, 38, 139, 23);
		comboRollOptions.setText("Roll Choice");
		comboRollOptions.select(2);

		textStr = new Text(container, SWT.BORDER);
		restrictInt(textStr);
		textStr.setTextLimit(textLimit);
		textStr.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textStr.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textStr.getText());
				lblBonStr.setText(bonus(a));
				}
			}
		});
		textStr.setBounds(44, 38, 39, 21);

		textDex = new Text(container, SWT.BORDER);
		restrictInt(textDex);
		textDex.setTextLimit(textLimit);
		textDex.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textDex.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textDex.getText());
				lblBonDex.setText(bonus(a));
				}
			}
		});
		textDex.setBounds(44, 65, 39, 21);

		textCon = new Text(container, SWT.BORDER);
		restrictInt(textCon);
		textCon.setTextLimit(textLimit);
		textCon.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textCon.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textCon.getText());
				lblBonCon.setText(bonus(a));
				}
			}
		});
		textCon.setBounds(44, 92, 39, 21);

		textInt = new Text(container, SWT.BORDER);
		restrictInt(textInt);
		textInt.setTextLimit(textLimit);
		textInt.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textInt.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textInt.getText());
				lblBonInt.setText(bonus(a));
				}
			}
		});
		textInt.setBounds(44, 119, 39, 21);

		textWis = new Text(container, SWT.BORDER);
		restrictInt(textWis);
		textWis.setTextLimit(textLimit);
		textWis.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textWis.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textWis.getText());
				lblBonWis.setText(bonus(a));
				}
			}
		});
		textWis.setBounds(44, 146, 39, 21);

		textCha = new Text(container, SWT.BORDER);
		restrictInt(textCha);
		textCha.setTextLimit(textLimit);
		textCha.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if (textCha.getText().equals("")) {
				}
				else {
				int a = Integer.parseInt(textCha.getText());
				lblBonCha.setText(bonus(a));
				}
			}
		});
		textCha.setBounds(44, 173, 39, 21);

		final Button btnRollStr = new Button(container, SWT.NONE);
		btnRollStr.setBounds(123, 38, 53, 21);
		btnRollStr.setText("Roll");
		btnRollStr.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textStr.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textStr.setText(Integer.toString(a));
			}
		});

		final Button btnRollDex = new Button(container, SWT.NONE);
		btnRollDex.setText("Roll");
		btnRollDex.setBounds(123, 65, 53, 21);
		btnRollDex.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textDex.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textDex.setText(Integer.toString(a));
			}
		});

		final Button btnRollCon = new Button(container, SWT.NONE);
		btnRollCon.setText("Roll");
		btnRollCon.setBounds(123, 92, 53, 21);
		btnRollCon.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textCon.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textCon.setText(Integer.toString(a));
			}
		});

		final Button btnRollInt = new Button(container, SWT.NONE);
		btnRollInt.setText("Roll");
		btnRollInt.setBounds(123, 119, 53, 21);
		btnRollInt.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textInt.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textInt.setText(Integer.toString(a));
			}
		});

		final Button btnRollWis = new Button(container, SWT.NONE);
		btnRollWis.setText("Roll");
		btnRollWis.setBounds(123, 146, 53, 21);
		btnRollWis.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textWis.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textWis.setText(Integer.toString(a));
			}
		});

		final Button btnRollCha = new Button(container, SWT.NONE);
		btnRollCha.setText("Roll");
		btnRollCha.setBounds(123, 173, 53, 21);
		btnRollCha.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textCha.setText(Integer.toString(a));
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				String alpha = comboRollOptions.getItem(comboRollOptions
						.getSelectionIndex());
				int a = DiceRolling.rollDice(alpha);
				textCha.setText(Integer.toString(a));
			}
		});

	}
	
	//TODO: Make a seperate class for restricted entries

	private void restrictInt(Text text) {
		text.addListener(SWT.Verify, new Listener() {
			public void handleEvent(Event e) {
				String string = e.text;
				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++) {
					if (!('0' <= chars[i] && chars[i] <= '9')) {
						e.doit = false;
						return;
					}
				}
			}
		});
		
	}

	private String bonus(int a) {
		String b = "ERR";
		if (a > 0) {
			if (a == 9)
			{
				a = -1;
			}
			else
			{
			a = ((a - 10) / 2);
			}
			b = "" + a;
		} else {
			System.out.println("Error, Invalid value");
		}
		return b;
	}
}
