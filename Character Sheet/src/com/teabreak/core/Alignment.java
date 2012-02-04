package com.teabreak.core;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.teabreak.core.aspects.AlignmentEnum;

public class Alignment implements SelectionListener{
	
	String selectedOrder = "z";
	String selectedMorality = "z";
	boolean update = false;
	String alignment = "Choose an alignment";
	
	public Alignment(){
		load();
	}
	
	private void load() {
		boolean listening = true;
		while (listening)
		{
			if (update = true)
			{
			if (selectedOrder != "z" && selectedMorality != "z")
			{
				String key = selectedOrder + selectedMorality;
				for (AlignmentEnum a :AlignmentEnum.values())
				{
					if (key.equals(a))
					{
						alignment = a.getEnumAlignmentText();
					}
				}
			}
			update = false;
			}
		}

		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		String ToolItem = arg0.widget.toString();
		assign(ToolItem);
		update = true;
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		String ToolItem = arg0.widget.toString();
		assign(ToolItem);
		update = true;
		
	}


private void assign(String toolItem) {
	
	if (toolItem.matches("tltmGood"))
	{
		selectedMorality = "G";
	}
	else if (toolItem.matches("tltmNeutral"))
	{
		selectedMorality = "N";
	}
	else if (toolItem.matches("tltmEvil"))
	{
		selectedMorality = "E";
	}
	else if (toolItem.matches("tltmLawful"))
	{
		selectedOrder = "L";
	}
	else if (toolItem.matches("tltmNeutral_1"))
	{
		selectedOrder = "N";
	}
	else if (toolItem.matches("tltmChaotic"))
	{
		selectedOrder = "C";
	}
	else 
	{
		System.out.println("Error");
	}
	
}

public String getAlignment() {
	return alignment;
}

}