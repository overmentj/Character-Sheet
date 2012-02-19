package com.teabreak.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.teabreak.gui.charactersheet.CharacterSheetUI;

public class HomeUI extends Shell
{
	private static HomeUI instance = null;
	private CharacterSheetUI characterSheet = null;

	public CharacterSheetUI getCharacterSheetUi()
	{
		return characterSheet;
	}

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

	public void createShell()
	{

	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public HomeUI(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		HomeUI.instance = this;

		Button btnCharacterSheet = new Button(this, SWT.NONE);
		btnCharacterSheet.setBounds(10, 10, 120, 25);
		btnCharacterSheet.setText("Character Sheet");

		Button btnNpcSheet = new Button(this, SWT.NONE);
		btnNpcSheet.setBounds(10, 41, 120, 25);
		btnNpcSheet.setText("NPC Sheet");

		Button btnDataBrowse = new Button(this, SWT.NONE);
		btnDataBrowse.setBounds(10, 72, 120, 25);
		btnDataBrowse.setText("Browse Data");
		btnCharacterSheet.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				try
				{
					characterSheet = new CharacterSheetUI();
					characterSheet.setBlockOnOpen(true);
					characterSheet.open();
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

	public static HomeUI getInstance()
	{
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
