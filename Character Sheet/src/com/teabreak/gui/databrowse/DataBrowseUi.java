package com.teabreak.gui.databrowse;

import java.util.ArrayList;
import java.util.SortedMap;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.teabreak.core.Main;
import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.Skill;
import org.eclipse.swt.widgets.TableItem;

public class DataBrowseUi extends ApplicationWindow implements Listener
{
	private Table table;

	/**
	 * Create the application window.
	 */
	public DataBrowseUi()
	{
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
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

		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 81, 679, 360);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.addListener(SWT.Selection, this);
		btnNewButton.setBounds(95, 38, 75, 25);
		btnNewButton.setText("New Button");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions()
	{
		// Create the actions
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
		return new Point(715, 562);
	}

	@Override
	public void handleEvent(Event event)
	{
		SortedMap<String, Skill> skills = (SortedMap<String, Skill>) Main
				.getInstace().getData().getDataSetOfType(AspectsEnum.Skill);
		ArrayList<TableColumn> columns = new ArrayList<TableColumn>();
		String[] columnNames = new String[]
		{ "Name", "Conditional", "Untrained", "Ability Mod" };
		for (String columnName : columnNames)
		{
			TableColumn column = new TableColumn(table, SWT.None);
			column.setWidth(100);
			column.setText(columnName);
			columns.add(column);
		}

		ArrayList<TableItem> items = new ArrayList<TableItem>();
		for (Skill skill : skills.values())
		{
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[]
			{ skill.getName(), String.valueOf(skill.isConditional()),
					String.valueOf(skill.isUntrained()),
					skill.getAbilityModifier().toString() });
			items.add(item);
		}
	}

}
