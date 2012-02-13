package com.teabreak.gui.charactersheet;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import com.teabreak.charactersheet.CharacterSheet;
import com.teabreak.core.Main;
import com.teabreak.core.aspects.Alignment;
import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.gui.SWTResourceManager;
import com.teabreak.gui.charactersheet.actions.newChar;

public class CharacterSheetUI extends ApplicationWindow
{
	private Text txtCharacterName;
	private Text txtCharacterName_1;
	Alignment alignment;
	CharacterSheet charSheet = null;
	private Text text;
	
	// Create all the character sheet objects
	Label lblStrBase;
	Label lblDexBase;
	Label lblConBase;
	Label lblIntBase;
	Label lblWisBase;
	Label lblChaBase;
	
	/**
	 * Create the application window.
	 */
	public CharacterSheetUI()
	{
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();


		alignment = new Alignment(charSheet);
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(null);

		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setBounds(0, 136, 1068, 488);

		TabItem tbtmPage = new TabItem(tabFolder, SWT.NONE);
		tbtmPage.setText("Page 1");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmPage.setControl(composite);

		Group grpAbilityScores = new Group(composite, SWT.NONE);
		grpAbilityScores.setText("Ability Scores");
		grpAbilityScores.setBounds(10, 10, 256, 185);

		Label lblStrength = new Label(grpAbilityScores, SWT.NONE);
		lblStrength.setFont(SWTResourceManager
				.getFont("Segoe UI", 10, SWT.BOLD));
		lblStrength.setBounds(10, 60, 25, 15);
		lblStrength.setText("Str");

		Label lblDex = new Label(grpAbilityScores, SWT.NONE);
		lblDex.setText("Dex");
		lblDex.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDex.setBounds(10, 83, 25, 15);

		Label lblCon = new Label(grpAbilityScores, SWT.NONE);
		lblCon.setText("Con");
		lblCon.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblCon.setBounds(10, 104, 25, 15);

		Label lblInt = new Label(grpAbilityScores, SWT.NONE);
		lblInt.setText("Int");
		lblInt.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInt.setBounds(10, 125, 25, 15);

		Label lblWis = new Label(grpAbilityScores, SWT.NONE);
		lblWis.setText("Wis");
		lblWis.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblWis.setBounds(10, 146, 25, 15);

		Label lblCha = new Label(grpAbilityScores, SWT.NONE);
		lblCha.setText("Cha");
		lblCha.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblCha.setBounds(10, 167, 25, 15);

		Label lblNewLabel = new Label(grpAbilityScores, SWT.NONE);
		lblNewLabel.setBounds(41, 60, 15, 15);
		lblNewLabel.setText("20");

		Label label = new Label(grpAbilityScores, SWT.NONE);
		label.setText("20");
		label.setBounds(41, 102, 15, 15);

		Label label_1 = new Label(grpAbilityScores, SWT.NONE);
		label_1.setText("20");
		label_1.setBounds(41, 123, 15, 15);

		Label label_2 = new Label(grpAbilityScores, SWT.NONE);
		label_2.setText("20");
		label_2.setBounds(41, 144, 15, 15);

		Label label_3 = new Label(grpAbilityScores, SWT.NONE);
		label_3.setText("20");
		label_3.setBounds(41, 165, 15, 15);

		Label label_4 = new Label(grpAbilityScores, SWT.NONE);
		label_4.setText("20");
		label_4.setBounds(41, 81, 15, 15);

		Label label_5 = new Label(grpAbilityScores, SWT.NONE);
		label_5.setText("=");
		label_5.setBounds(62, 60, 15, 15);

		Label label_6 = new Label(grpAbilityScores, SWT.NONE);
		label_6.setText("=");
		label_6.setBounds(62, 83, 15, 15);

		Label label_7 = new Label(grpAbilityScores, SWT.NONE);
		label_7.setText("=");
		label_7.setBounds(62, 104, 15, 15);

		Label label_8 = new Label(grpAbilityScores, SWT.NONE);
		label_8.setText("=");
		label_8.setBounds(62, 125, 15, 15);

		Label label_9 = new Label(grpAbilityScores, SWT.NONE);
		label_9.setText("=");
		label_9.setBounds(62, 146, 15, 15);

		Label label_10 = new Label(grpAbilityScores, SWT.NONE);
		label_10.setText("=");
		label_10.setBounds(62, 167, 15, 15);

		lblChaBase = new Label(grpAbilityScores, SWT.NONE);
		lblChaBase.setText("20");
		lblChaBase.setBounds(82, 167, 15, 15);

		lblWisBase = new Label(grpAbilityScores, SWT.NONE);
		lblWisBase.setText("20");
		lblWisBase.setBounds(82, 146, 15, 15);

		lblIntBase = new Label(grpAbilityScores, SWT.NONE);
		lblIntBase.setText("20");
		lblIntBase.setBounds(82, 125, 15, 15);

		lblConBase = new Label(grpAbilityScores, SWT.NONE);
		lblConBase.setText("20");
		lblConBase.setBounds(82, 104, 15, 15);

		lblDexBase = new Label(grpAbilityScores, SWT.NONE);
		lblDexBase.setText("20");
		lblDexBase.setBounds(82, 83, 15, 15);

		lblStrBase = new Label(grpAbilityScores, SWT.NONE);
		lblStrBase.setText("20");
		lblStrBase.setBounds(82, 62, 15, 15);

		Label label_23 = new Label(grpAbilityScores, SWT.NONE);
		label_23.setText("+");
		label_23.setBounds(103, 167, 15, 15);

		Label label_24 = new Label(grpAbilityScores, SWT.NONE);
		label_24.setText("+");
		label_24.setBounds(103, 146, 15, 15);

		Label label_25 = new Label(grpAbilityScores, SWT.NONE);
		label_25.setText("+");
		label_25.setBounds(103, 125, 15, 15);

		Label label_26 = new Label(grpAbilityScores, SWT.NONE);
		label_26.setText("+");
		label_26.setBounds(103, 104, 15, 15);

		Label label_27 = new Label(grpAbilityScores, SWT.NONE);
		label_27.setText("+");
		label_27.setBounds(103, 83, 15, 15);

		Label label_28 = new Label(grpAbilityScores, SWT.NONE);
		label_28.setText("+");
		label_28.setBounds(103, 60, 15, 15);

		Label label_29 = new Label(grpAbilityScores, SWT.NONE);
		label_29.setText("20");
		label_29.setBounds(118, 167, 15, 15);

		Label label_30 = new Label(grpAbilityScores, SWT.NONE);
		label_30.setText("20");
		label_30.setBounds(118, 146, 15, 15);

		Label label_31 = new Label(grpAbilityScores, SWT.NONE);
		label_31.setText("20");
		label_31.setBounds(118, 125, 15, 15);

		Label label_32 = new Label(grpAbilityScores, SWT.NONE);
		label_32.setText("20");
		label_32.setBounds(118, 104, 15, 15);

		Label label_33 = new Label(grpAbilityScores, SWT.NONE);
		label_33.setText("20");
		label_33.setBounds(118, 83, 15, 15);

		Label label_34 = new Label(grpAbilityScores, SWT.NONE);
		label_34.setText("20");
		label_34.setBounds(118, 62, 15, 15);

		Label label_35 = new Label(grpAbilityScores, SWT.NONE);
		label_35.setText("20");
		label_35.setBounds(154, 167, 15, 15);

		Label label_36 = new Label(grpAbilityScores, SWT.NONE);
		label_36.setText("20");
		label_36.setBounds(154, 146, 15, 15);

		Label label_37 = new Label(grpAbilityScores, SWT.NONE);
		label_37.setText("20");
		label_37.setBounds(154, 125, 15, 15);

		Label label_38 = new Label(grpAbilityScores, SWT.NONE);
		label_38.setText("20");
		label_38.setBounds(154, 104, 15, 15);

		Label label_39 = new Label(grpAbilityScores, SWT.NONE);
		label_39.setText("20");
		label_39.setBounds(154, 83, 15, 15);

		Label label_40 = new Label(grpAbilityScores, SWT.NONE);
		label_40.setText("20");
		label_40.setBounds(154, 62, 15, 15);

		Label label_41 = new Label(grpAbilityScores, SWT.NONE);
		label_41.setText("+");
		label_41.setBounds(139, 167, 15, 15);

		Label label_42 = new Label(grpAbilityScores, SWT.NONE);
		label_42.setText("+");
		label_42.setBounds(139, 146, 15, 15);

		Label label_43 = new Label(grpAbilityScores, SWT.NONE);
		label_43.setText("+");
		label_43.setBounds(139, 125, 15, 15);

		Label label_44 = new Label(grpAbilityScores, SWT.NONE);
		label_44.setText("+");
		label_44.setBounds(139, 104, 15, 15);

		Label label_45 = new Label(grpAbilityScores, SWT.NONE);
		label_45.setText("+");
		label_45.setBounds(139, 83, 15, 15);

		Label label_46 = new Label(grpAbilityScores, SWT.NONE);
		label_46.setText("+");
		label_46.setBounds(139, 60, 15, 15);

		Label label_47 = new Label(grpAbilityScores, SWT.NONE);
		label_47.setText("20");
		label_47.setBounds(190, 167, 15, 15);

		Label label_48 = new Label(grpAbilityScores, SWT.NONE);
		label_48.setText("20");
		label_48.setBounds(190, 146, 15, 15);

		Label label_49 = new Label(grpAbilityScores, SWT.NONE);
		label_49.setText("20");
		label_49.setBounds(190, 125, 15, 15);

		Label label_50 = new Label(grpAbilityScores, SWT.NONE);
		label_50.setText("20");
		label_50.setBounds(190, 104, 15, 15);

		Label label_51 = new Label(grpAbilityScores, SWT.NONE);
		label_51.setText("20");
		label_51.setBounds(190, 83, 15, 15);

		Label label_52 = new Label(grpAbilityScores, SWT.NONE);
		label_52.setText("20");
		label_52.setBounds(190, 62, 15, 15);

		Label label_53 = new Label(grpAbilityScores, SWT.NONE);
		label_53.setText("-");
		label_53.setBounds(175, 167, 15, 15);

		Label label_54 = new Label(grpAbilityScores, SWT.NONE);
		label_54.setText("-");
		label_54.setBounds(175, 146, 15, 15);

		Label label_55 = new Label(grpAbilityScores, SWT.NONE);
		label_55.setText("-");
		label_55.setBounds(175, 125, 15, 15);

		Label label_56 = new Label(grpAbilityScores, SWT.NONE);
		label_56.setText("-");
		label_56.setBounds(175, 104, 15, 15);

		Label label_57 = new Label(grpAbilityScores, SWT.NONE);
		label_57.setText("-");
		label_57.setBounds(175, 83, 15, 15);

		Label label_58 = new Label(grpAbilityScores, SWT.NONE);
		label_58.setText("-");
		label_58.setBounds(175, 60, 15, 15);

		Label label_59 = new Label(grpAbilityScores, SWT.NONE);
		label_59.setText("20");
		label_59.setBounds(226, 167, 15, 15);

		Label label_60 = new Label(grpAbilityScores, SWT.NONE);
		label_60.setText("20");
		label_60.setBounds(226, 146, 15, 15);

		Label label_61 = new Label(grpAbilityScores, SWT.NONE);
		label_61.setText("20");
		label_61.setBounds(226, 125, 15, 15);

		Label label_62 = new Label(grpAbilityScores, SWT.NONE);
		label_62.setText("20");
		label_62.setBounds(226, 104, 15, 15);

		Label label_63 = new Label(grpAbilityScores, SWT.NONE);
		label_63.setText("20");
		label_63.setBounds(226, 83, 15, 15);

		Label label_64 = new Label(grpAbilityScores, SWT.NONE);
		label_64.setText("20");
		label_64.setBounds(226, 62, 15, 15);

		Group grpSavingThrows = new Group(composite, SWT.NONE);
		grpSavingThrows.setText("Saving Throws");
		grpSavingThrows.setBounds(10, 201, 270, 111);

		Label lblFortitude = new Label(grpSavingThrows, SWT.NONE);
		lblFortitude.setFont(SWTResourceManager.getFont("Segoe UI", 10,
				SWT.BOLD));
		lblFortitude.setBounds(10, 44, 60, 15);
		lblFortitude.setText("Fortitude");

		Label lblReflex = new Label(grpSavingThrows, SWT.NONE);
		lblReflex.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblReflex.setText("Reflex");
		lblReflex.setBounds(10, 65, 60, 15);

		Label lblWill = new Label(grpSavingThrows, SWT.NONE);
		lblWill.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblWill.setText("Will");
		lblWill.setBounds(10, 86, 60, 15);

		Label label_17 = new Label(grpSavingThrows, SWT.NONE);
		label_17.setBounds(76, 44, 15, 15);
		label_17.setText("00");

		Label label_18 = new Label(grpSavingThrows, SWT.NONE);
		label_18.setText("00");
		label_18.setBounds(76, 65, 15, 15);

		Label label_19 = new Label(grpSavingThrows, SWT.NONE);
		label_19.setText("00");
		label_19.setBounds(76, 86, 15, 15);

		Label label_20 = new Label(grpSavingThrows, SWT.NONE);
		label_20.setText("=");
		label_20.setBounds(97, 86, 15, 15);

		Label label_21 = new Label(grpSavingThrows, SWT.NONE);
		label_21.setText("=");
		label_21.setBounds(97, 65, 15, 15);

		Label label_22 = new Label(grpSavingThrows, SWT.NONE);
		label_22.setText("=");
		label_22.setBounds(97, 44, 15, 15);

		Label label_65 = new Label(grpSavingThrows, SWT.NONE);
		label_65.setText("00");
		label_65.setBounds(118, 86, 15, 15);

		Label label_66 = new Label(grpSavingThrows, SWT.NONE);
		label_66.setText("00");
		label_66.setBounds(118, 65, 15, 15);

		Label label_67 = new Label(grpSavingThrows, SWT.NONE);
		label_67.setText("00");
		label_67.setBounds(118, 44, 15, 15);

		Label label_68 = new Label(grpSavingThrows, SWT.NONE);
		label_68.setText("+");
		label_68.setBounds(139, 86, 15, 15);

		Label label_69 = new Label(grpSavingThrows, SWT.NONE);
		label_69.setText("+");
		label_69.setBounds(139, 65, 15, 15);

		Label label_70 = new Label(grpSavingThrows, SWT.NONE);
		label_70.setText("+");
		label_70.setBounds(139, 44, 15, 15);

		Label label_71 = new Label(grpSavingThrows, SWT.NONE);
		label_71.setText("00");
		label_71.setBounds(149, 86, 15, 15);

		Label label_72 = new Label(grpSavingThrows, SWT.NONE);
		label_72.setText("00");
		label_72.setBounds(149, 65, 15, 15);

		Label label_73 = new Label(grpSavingThrows, SWT.NONE);
		label_73.setText("00");
		label_73.setBounds(149, 44, 15, 15);

		Label label_74 = new Label(grpSavingThrows, SWT.NONE);
		label_74.setText("+");
		label_74.setBounds(170, 44, 15, 15);

		Label label_75 = new Label(grpSavingThrows, SWT.NONE);
		label_75.setText("00");
		label_75.setBounds(180, 44, 15, 15);

		Label label_76 = new Label(grpSavingThrows, SWT.NONE);
		label_76.setText("+");
		label_76.setBounds(170, 65, 15, 15);

		Label label_77 = new Label(grpSavingThrows, SWT.NONE);
		label_77.setText("00");
		label_77.setBounds(180, 65, 15, 15);

		Label label_78 = new Label(grpSavingThrows, SWT.NONE);
		label_78.setText("+");
		label_78.setBounds(170, 86, 15, 15);

		Label label_79 = new Label(grpSavingThrows, SWT.NONE);
		label_79.setText("00");
		label_79.setBounds(180, 86, 15, 15);

		Label label_80 = new Label(grpSavingThrows, SWT.NONE);
		label_80.setText("+");
		label_80.setBounds(201, 44, 15, 15);

		Label label_81 = new Label(grpSavingThrows, SWT.NONE);
		label_81.setText("00");
		label_81.setBounds(211, 44, 15, 15);

		Label label_82 = new Label(grpSavingThrows, SWT.NONE);
		label_82.setText("+");
		label_82.setBounds(201, 65, 15, 15);

		Label label_83 = new Label(grpSavingThrows, SWT.NONE);
		label_83.setText("00");
		label_83.setBounds(211, 65, 15, 15);

		Label label_84 = new Label(grpSavingThrows, SWT.NONE);
		label_84.setText("+");
		label_84.setBounds(201, 86, 15, 15);

		Label label_85 = new Label(grpSavingThrows, SWT.NONE);
		label_85.setText("00");
		label_85.setBounds(211, 86, 15, 15);

		Label label_86 = new Label(grpSavingThrows, SWT.NONE);
		label_86.setText("+");
		label_86.setBounds(232, 44, 15, 15);

		Label label_87 = new Label(grpSavingThrows, SWT.NONE);
		label_87.setText("00");
		label_87.setBounds(242, 44, 15, 15);

		Label label_88 = new Label(grpSavingThrows, SWT.NONE);
		label_88.setText("+");
		label_88.setBounds(232, 65, 15, 15);

		Label label_89 = new Label(grpSavingThrows, SWT.NONE);
		label_89.setText("00");
		label_89.setBounds(242, 65, 15, 15);

		Label label_90 = new Label(grpSavingThrows, SWT.NONE);
		label_90.setText("+");
		label_90.setBounds(232, 86, 15, 15);

		Label label_91 = new Label(grpSavingThrows, SWT.NONE);
		label_91.setText("00");
		label_91.setBounds(242, 86, 15, 15);

		Button button = new Button(composite, SWT.NONE);
		button.setBounds(272, 71, 40, 15);
		button.setText("Roll");

		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setText("Roll");
		button_1.setBounds(272, 92, 40, 15);

		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setText("Roll");
		button_2.setBounds(272, 113, 40, 15);

		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setText("Roll");
		button_3.setBounds(272, 134, 40, 15);

		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setText("Roll");
		button_4.setBounds(272, 155, 40, 15);

		Button button_5 = new Button(composite, SWT.NONE);
		button_5.setText("Roll");
		button_5.setBounds(272, 176, 40, 15);

		Group grpCharacter = new Group(composite, SWT.NONE);
		grpCharacter.setText("Character");
		grpCharacter.setBounds(318, 10, 290, 302);

		txtCharacterName = new Text(grpCharacter, SWT.BORDER);
		txtCharacterName.setText("Player Name");
		txtCharacterName.setBounds(150, 49, 130, 21);

		Label lblPlayerName = new Label(grpCharacter, SWT.NONE);
		lblPlayerName.setBounds(150, 28, 86, 15);
		lblPlayerName.setText("Player Name");

		Label lblSize = new Label(grpCharacter, SWT.NONE);
		lblSize.setBounds(10, 80, 34, 15);
		lblSize.setText("Size");

		Label lblGender = new Label(grpCharacter, SWT.NONE);
		lblGender.setBounds(141, 80, 44, 15);
		lblGender.setText("Gender");

		Label lblNewLabel_1 = new Label(grpCharacter, SWT.NONE);
		lblNewLabel_1.setBounds(10, 110, 55, 15);
		lblNewLabel_1.setText("Morality");

		Label lblOrder = new Label(grpCharacter, SWT.NONE);
		lblOrder.setBounds(10, 160, 55, 15);
		lblOrder.setText("Order");

		final Combo combo = new Combo(grpCharacter, SWT.NONE);
		combo.setItems(new String[]
		{ "Good", "Neutral", "Evil" });
		combo.setBounds(10, 131, 91, 23);
		combo.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				int a = combo.getSelectionIndex();
				if (a >= 0)
					alignment.assign(combo.getItem(a), 'M');
				//update(text);
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{
				int a = combo.getSelectionIndex();
				if (a >= 0)
					alignment.assign(combo.getItem(a), 'M');
				//update(text);
			}
		});

		final Combo combo_1 = new Combo(grpCharacter, SWT.NONE);
		combo_1.setItems(new String[]
		{ "Lawful", "Neutral", "Chaotic" });
		combo_1.setBounds(10, 181, 91, 23);

		text = new Text(grpCharacter, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP
				| SWT.V_SCROLL);
		text.setBounds(109, 107, 171, 185);

		Combo combo_2 = new Combo(grpCharacter, SWT.NONE);
		combo_2.setItems(new String[]
		{ "Fine", "Diminuitive", "Tiny", "Small", "Medium", "Large", "Huge",
				"Gargantuan", "Colossal" });
		combo_2.setBounds(39, 76, 91, 23);
		combo_2.select(4);
		
		Combo combo_3 = new Combo(grpCharacter, SWT.NONE);
		combo_3.setItems(new String[] {"Male", "Female", "Nondescript"});
		combo_3.setBounds(189, 76, 91, 23);
		
				txtCharacterName_1 = new Text(grpCharacter, SWT.BORDER);
				txtCharacterName_1.setBounds(14, 49, 130, 21);
				txtCharacterName_1.setText("Character Name");
				
						Label lblCharacterName = new Label(grpCharacter, SWT.NONE);
						lblCharacterName.setBounds(14, 28, 96, 15);
						lblCharacterName.setText("Character Name");
		
		Group grpAttackBonus = new Group(composite, SWT.NONE);
		grpAttackBonus.setText("Attack Bonus");
		grpAttackBonus.setBounds(10, 318, 270, 95);
		
		Label lblBaseAttackBonus = new Label(grpAttackBonus, SWT.NONE);
		lblBaseAttackBonus.setBounds(10, 21, 97, 15);
		lblBaseAttackBonus.setText("Base Attack Bonus");
		
		Label lblWeapon = new Label(grpAttackBonus, SWT.NONE);
		lblWeapon.setBounds(10, 42, 55, 15);
		lblWeapon.setText("Weapon");
		
		Label lblWeapon_1 = new Label(grpAttackBonus, SWT.NONE);
		lblWeapon_1.setBounds(10, 63, 55, 15);
		lblWeapon_1.setText("Weapon1");
		
		Label label_92 = new Label(grpAttackBonus, SWT.NONE);
		label_92.setBounds(127, 21, 115, 15);
		label_92.setText("+20 / +15 / +10 / +5");
		
		Label label_93 = new Label(grpAttackBonus, SWT.NONE);
		label_93.setBounds(113, 21, 8, 15);
		label_93.setText("=");
		
		Label label_94 = new Label(grpAttackBonus, SWT.NONE);
		label_94.setText("=");
		label_94.setBounds(113, 42, 8, 15);
		
		Label label_95 = new Label(grpAttackBonus, SWT.NONE);
		label_95.setText("=");
		label_95.setBounds(113, 63, 8, 15);

		combo_1.addSelectionListener(new SelectionListener()
		{

			public void widgetSelected(SelectionEvent event)
			{
				int a = combo_1.getSelectionIndex();
				if (a >= 0)
					alignment.assign(combo_1.getItem(a), 'O');
				//update(text);
			}

			public void widgetDefaultSelected(SelectionEvent event)
			{
				int a = combo_1.getSelectionIndex();
				if (a >= 0)
					alignment.assign(combo_1.getItem(a), 'O');
				//update(text);
			}
		});

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions()
	{
		{
			new Action("New Character")
			{

			};
		}
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager()
	{
		MenuManager menuManager = new MenuManager("menu");
		{
			MenuManager menuManager_1 = new MenuManager("File");
			menuManager.add(menuManager_1);
			menuManager_1.add(new newChar());
		}
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style)
	{
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager()
	{
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
//	public static void main(String args[])
//	{
//		try
//		{
//			CharacterSheetUI window = new CharacterSheetUI();
//			window.setBlockOnOpen(true);
//			window.open();
//			Display.getCurrent().dispose();
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(994, 713);
	}

	public void update()
	{
		this.charSheet = Main.getInstace().getCharSheet();
		//text.setText(alignment.getAlignmentText());
		if(charSheet != null){
			lblStrBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Str)));
			lblDexBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Dex))); 
			lblConBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Con))); 
			lblIntBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Int))); 
			lblWisBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Wis))); 
			lblChaBase.setText(Integer.toString(charSheet.getAbilityScore(AbilityEnum.Cha))); 					
		}
	}
}
