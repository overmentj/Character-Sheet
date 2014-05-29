package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class GenerateInvGui implements ActionListener, PropertyChangeListener {

	private List<Component> components;
	private NumberFormatter formatter;	
	
	private JButton btnAddItem;
	private int buttonY;
	private boolean buttonCreated;
	
	private JPanel gear = new JPanel(new GridBagLayout());
	
	public GenerateInvGui(List<Component> components)
	{
		this.components = components;
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(3);
        this.formatter = new NumberFormatter(numberFormat);
        this.formatter.setAllowsInvalid(false);
        this.formatter.setCommitsOnValidEdit(true);
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
		
		constraints.gridx = 7;
		gear.add(addCcPanel(), constraints);
		
		putItemLabelsOnPanel(constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 4;
		putItemOnPanel(constraints);
		
		putBtnAddItemOnPanel(2, 6, constraints);
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
	
	private void putItemLabelsOnPanel(GridBagConstraints constraints)
	{
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
	}
	
	private void putItemOnPanel(GridBagConstraints constraints) 
	{
		JTextField textItem = new JTextField(20);
		gear.add(textItem, constraints);
		
		JTextField textLocation = new JTextField(20);
		constraints.gridx += 2;
		gear.add(textLocation, constraints);
		
		JFormattedTextField textWeight = new JFormattedTextField();
		constraints.gridx += 2;
		gear.add(textWeight, constraints);
		
		textWeight.setFormatterFactory(new DefaultFormatterFactory(formatter));
		textWeight.setColumns(3);
		textWeight.addPropertyChangeListener("value", this);
		
		JButton btnDelete = new JButton(new ImageIcon(this.getClass().getResource("/images/small-delete-icon.jpg")));
		btnDelete.setBorder(null);
		btnDelete.setBackground(null);
		btnDelete.addActionListener(this);
		btnDelete.setActionCommand("DeleteItem");
		constraints.gridx ++;
		gear.add(btnDelete, constraints);
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
			
			constraints.gridx =2;
			constraints.gridy = buttonY;
			putItemOnPanel(constraints);

			buttonY += 2;
			putBtnAddItemOnPanel(2, buttonY, constraints);
			gear.revalidate();
			gear.repaint();
		}
		else if (e.getActionCommand().equals("DeleteItem"))
		{
			JButton src = (JButton) e.getSource();
			Point srcLoc = src.getLocationOnScreen();
			gear.remove(gear.getComponentAt(srcLoc));
			gear.revalidate();
			gear.repaint();
			
			for (Component comp : gear.getComponents())
			{
				findTextFields(srcLoc, comp);
				gear.revalidate();
				gear.repaint();
			}
		}
	}

	private void findTextFields(Point srcLoc, Component comp) 
	{
		if (comp instanceof JPanel)
		{
			for (Component innerComp : ((JPanel) comp).getComponents())
			{
				findTextFields(srcLoc, innerComp);
			}
		}
		else if (comp instanceof JTextField)
		{
			removeIfInlineWithSrc(srcLoc, comp);
		}
	}

	private void removeIfInlineWithSrc(Point srcLoc, Component comp) 
	{
		Point curCompLoc = comp.getLocationOnScreen();
		
		if (curCompLoc.y == srcLoc.y)
		{
			gear.remove(gear.getComponentAt(curCompLoc));
		}
		else
		{
			int nextX = curCompLoc.x - 2;
			int nextY = curCompLoc.y - 2;
			Point nextLoc = new Point(nextX, nextY);
			comp.setLocation(nextLoc);
		}
	}
	
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
    	
    }
}