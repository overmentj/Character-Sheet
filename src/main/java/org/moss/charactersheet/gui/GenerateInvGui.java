package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class GenerateInvGui implements ActionListener{

	private List<Component> components;
	
	private JButton btnAddItem;
	private int buttonY;
	private boolean buttonCreated;
	
	private JPanel gear = new JPanel(new GridBagLayout());
	
	public GenerateInvGui(List<Component> components)
	{
		this.components = components;
	}
	
	public void generate()
	{
		addGearPanel();
		components.add(gear);
	}

	private void addGearPanel()
	{
		gear.setBorder(BorderFactory.createTitledBorder("Gear"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 10, 5, 10);
		
		constraints.gridx = 6;
		gear.add(addCcPanel(), constraints);
		
		JLabel labelItem = new JLabel("Item");
		constraints.gridy = 2;
		constraints.gridx = 2;
		gear.add(labelItem, constraints);
		
		JLabel labelLoc = new JLabel("Location");
		constraints.gridx = 4;
		gear.add(labelLoc, constraints);
		
		JLabel labelWeight = new JLabel("Weight");
		constraints.gridx = 6;
		gear.add(labelWeight, constraints);
		
		putItemOnPanel(2, 4, constraints);		
		putBtnAddItemOnPanel(2, 6, constraints);
	}

	private void putItemOnPanel(int x, int y, GridBagConstraints constraints) 
	{
		JTextField textItem = new JTextField(20);
		constraints.gridx = x;
		constraints.gridy = y;
		gear.add(textItem, constraints);
		
		JTextField textLocation = new JTextField(20);
		constraints.gridx += 2;
		gear.add(textLocation, constraints);
		
		JTextField textWeight = new JTextField(3);
		textWeight.setEditable(false);
		constraints.gridx += 2;
		gear.add(textWeight, constraints);
	}

	private JPanel addCcPanel() 
	{
		JPanel carryCapPan = new JPanel(new GridBagLayout());
		carryCapPan.setBorder(BorderFactory.createTitledBorder("Carrying Capacity"));
		
		GridBagConstraints ccConstraints = new GridBagConstraints();
		ccConstraints.insets = new Insets(5, 10, 5, 10);
		
		JLabel labelLight = new JLabel("Light Load (lb)");
		carryCapPan.add(labelLight, ccConstraints);
		
		JTextField textLight = new JTextField(3);
		textLight.setEditable(false);
		ccConstraints.gridx = 2;
		carryCapPan.add(textLight, ccConstraints);
		
		JLabel labelMed = new JLabel("Medium Load (lb)");
		ccConstraints.gridx = 0;
		ccConstraints.gridy = 2;
		carryCapPan.add(labelMed, ccConstraints);
		
		JTextField textMed = new JTextField(3);
		textMed.setEditable(false);
		ccConstraints.gridx = 2;
		carryCapPan.add(textMed, ccConstraints);
		
		JLabel labelHeavy = new JLabel("Heavy Load (lb)");
		ccConstraints.gridx = 0;
		ccConstraints.gridy = 4;
		carryCapPan.add(labelHeavy, ccConstraints);
		
		JTextField textHeavy = new JTextField(3);
		textHeavy.setEditable(false);
		ccConstraints.gridx = 2;
		carryCapPan.add(textHeavy, ccConstraints);
		
		return carryCapPan;
	}
	
	private void putBtnAddItemOnPanel(int x, int y, GridBagConstraints constraints)
	{
		if (!buttonCreated)
		{
			btnAddItem = new JButton("Add Item...");
			btnAddItem.addActionListener(this);
			btnAddItem.setActionCommand("AddItem");
			constraints.gridx = x;
			constraints.gridy = y;

			gear.add(btnAddItem, constraints);
			buttonCreated = true;
		}
			buttonY = y;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("AddItem"))
		{
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.insets = new Insets(5, 10, 5, 10);
			
			gear.remove(btnAddItem);
			gear.revalidate();
			gear.repaint();
			buttonCreated = false;
			
			putItemOnPanel(2, buttonY, constraints);

			buttonY += 2;
			putBtnAddItemOnPanel(2, buttonY, constraints);
			gear.revalidate();
			gear.repaint();
		}
	}
	
}
