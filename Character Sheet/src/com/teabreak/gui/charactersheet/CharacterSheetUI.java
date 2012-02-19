package com.teabreak.gui.charactersheet;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;

public class CharacterSheetUI extends ApplicationWindow
{
	Alignment alignment;
	CharacterSheet charSheet = null;

	// Create all the character sheet objects

	/**
	 * Attributes maps: Total, Base, Misc+, Misc-, mod
	 */
	SortedMap<AbilityEnum, ArrayList<Label>> attrMap = new TreeMap<AbilityEnum, ArrayList<Label>>();
	SortedMap<String, Label> saveMap = new TreeMap<String, Label>();

	/**
	 * Create the application window.
	 */
	public CharacterSheetUI()
	{
		super(null);
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
		// This integer is used for auto label generation
		Integer yPos = 0;

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(null);

		TabFolder tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setBounds(0, 136, 1068, 488);

		TabItem tbtmPage = new TabItem(tabFolder, SWT.NONE);
		tbtmPage.setText("Page 1");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmPage.setControl(composite);

		// Display Ability Scores
		Group grpAbilityScores = new Group(composite, SWT.NONE);
		grpAbilityScores.setText("Ability Scores");
		grpAbilityScores.setBounds(10, 10, 256, 185);

		yPos = 40;
		// 0trength
		String[] attributeNames = new String[]
		{ "Strength", "Dexterity", "Consitution", "Inteligence", "Wisdom",
				"Charisma" };
		for (AbilityEnum attrName : AbilityEnum.values())
		{
			ArrayList<Label> attrRow = new ArrayList<Label>();

			Label lbl = new Label(grpAbilityScores, SWT.NONE);
			Label lblTotal = new Label(grpAbilityScores, SWT.NONE);
			Label lblEqual = new Label(grpAbilityScores, SWT.NONE);
			Label lblBase = new Label(grpAbilityScores, SWT.NONE);
			Label lblPlus = new Label(grpAbilityScores, SWT.NONE);
			Label lblPosMisc = new Label(grpAbilityScores, SWT.NONE);
			Label lblMinus = new Label(grpAbilityScores, SWT.NONE);
			Label lblNegMisc = new Label(grpAbilityScores, SWT.NONE);
			Label lblMod = new Label(grpAbilityScores, SWT.NONE);

			lbl.setBounds(10, yPos, 25, 15);
			lblTotal.setBounds(40, yPos, 15, 15);
			lblEqual.setBounds(55, yPos, 10, 15);
			lblBase.setBounds(70, yPos, 15, 15);
			lblPlus.setBounds(85, yPos, 10, 15);
			lblPosMisc.setBounds(100, yPos, 15, 15);
			lblMinus.setBounds(115, yPos, 10, 15);
			lblNegMisc.setBounds(130, yPos, 15, 15);
			lblMod.setBounds(155, yPos, 15, 15);

			lbl.setText(attrName.toString().substring(0, 3));
			lblTotal.setText("0");
			lblEqual.setText("=");
			lblBase.setText("0");
			lblPlus.setText("+");
			lblPosMisc.setText("0");
			lblMinus.setText("-");
			lblNegMisc.setText("0");
			lblMod.setText("0");
			yPos += 20;

			attrRow.add(lblTotal);
			attrRow.add(lblBase);
			attrRow.add(lblPosMisc);
			attrRow.add(lblNegMisc);
			attrRow.add(lblMod);
			attrMap.put(attrName, attrRow);
		}

		Group grpSavingThrows = new Group(composite, SWT.NONE);
		grpSavingThrows.setText("Saving Throws");
		grpSavingThrows.setBounds(10, 201, 256, 111);

		Label lblFortitude = new Label(grpSavingThrows, SWT.NONE);
		lblFortitude.setFont(SWTResourceManager.getFont("Segoe UI",
				10,
				SWT.BOLD));
		lblFortitude.setBounds(10, 44, 30, 15);
		lblFortitude.setText("Fort");

		Label lblReflex = new Label(grpSavingThrows, SWT.NONE);
		lblReflex.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblReflex.setText("Ref");
		lblReflex.setBounds(10, 65, 30, 15);

		Label lblWill = new Label(grpSavingThrows, SWT.NONE);
		lblWill.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblWill.setText("Will");
		lblWill.setBounds(10, 86, 30, 15);

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


		Group grpAttackBonus = new Group(composite, SWT.NONE);
		grpAttackBonus.setText("Attack Bonus");
		grpAttackBonus.setBounds(277, 10, 270, 95);

		Label lblBaseAttackBonus = new Label(grpAttackBonus, SWT.NONE);
		lblBaseAttackBonus.setBounds(10, 21, 97, 15);
		lblBaseAttackBonus.setText("");

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

		Label lblCharacterName = new Label(container, SWT.NONE);
		lblCharacterName.setBounds(10, 10, 95, 15);
		lblCharacterName.setText("Character Name: ");
		lblCharacterName.setText("Character Name");
		
		Label lblCharname = new Label(container, SWT.NONE);
		lblCharname.setBounds(111, 10, 200, 15);
		lblCharname.setText("CharName");
		
		Label lblPlayerName = new Label(container, SWT.NONE);
		lblPlayerName.setText("Player Name: ");
		lblPlayerName.setBounds(317, 10, 95, 15);
		
		Label lblPlayername = new Label(container, SWT.NONE);
		lblPlayername.setText("PlayerName");
		lblPlayername.setBounds(418, 10, 200, 15);

		return container;
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager()
	{
		MenuManager menuManager = new MenuManager("m34u");
		{
			MenuManager menuManager_1 = new MenuManager("File");
			menuManager.add(menuManager_1);
			newChar newChar_ = new newChar();
			newChar_.setText("New Character");
			menuManager_1.add(newChar_);
		}
		return menuManager;
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

	/**
	 * Updates the Character sheet with data from a character sheet class
	 */
	public void updatePage()
	{
		this.charSheet = Main.getInstace().getCharSheet();
		// text.setText(alignment.getAlignmentText());
		if (charSheet != null)
		{
			updateAttr();
		}
	}

	private void updateAttr()
	{
		for (AbilityEnum ability : AbilityEnum.values())
		{
			// Total, Base, Misc+, Misc-, Modifier
			ArrayList<Integer> scores = charSheet.getAbilityScoreList(ability);
			// Total, Base, Misc+, Misc-, mod
			ArrayList<Label> labels = attrMap.get(ability);

			labels.get(0).setText(scores.get(0).toString());
			labels.get(1).setText(scores.get(1).toString());
			labels.get(2).setText(scores.get(2).toString());
			labels.get(3).setText(scores.get(3).toString());
			labels.get(4).setText(scores.get(4).toString());

		}
	}
}
