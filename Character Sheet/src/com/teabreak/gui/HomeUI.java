package com.teabreak.gui;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.teabreak.gui.charactersheet.CharacterCreationWizard;
import com.teabreak.gui.charactersheet.CharacterSheetUI;

public class HomeUI extends Shell
{
	private static HomeUI instance = null;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		try
		{
			Display display = Display.getDefault();
			HomeUI shell = new HomeUI(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createShell(){
		
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public HomeUI(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		this.instance = this;

		Button btnCharacterSheet = new Button(this, SWT.NONE);
		btnCharacterSheet.setBounds(10, 10, 120, 25);
		btnCharacterSheet.setText("Character Sheet");
		btnCharacterSheet.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent event)
			{
				try
				{
					CharacterSheetUI window = new CharacterSheetUI();
					window.setBlockOnOpen(true);
					window.open();
					HomeUI.getInstance().setVisible(false);
				} catch (Exception e)
				{
					e.printStackTrace();
				} finally
				{
					HomeUI.getInstance().setVisible(true);
				}
			}
		});
		
		Button btnNewChar = new Button(this, SWT.NONE);
		btnNewChar.setBounds(10, 48, 75, 25);
		btnNewChar.setText("New Char");
		btnNewChar.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent event)
			{
				try
				{
					WizardDialog newChar = new WizardDialog(HomeUI.getInstance(), new CharacterCreationWizard());
					newChar.open();
					HomeUI.getInstance().setVisible(false);
				} catch (Exception e)
				{
					e.printStackTrace();
				} finally
				{
					HomeUI.getInstance().setVisible(true);
				}
			}
		});
		
		createContents();
	}
	
	public static HomeUI getInstance(){
		return instance;
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents()
	{
		setText("D&D App");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

}
