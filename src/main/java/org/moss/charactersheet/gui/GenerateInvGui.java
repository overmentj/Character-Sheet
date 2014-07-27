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
	
	private JPanel inv = new JPanel(new GridBagLayout());
	private JPanel gear = new JPanel(new GridBagLayout());
	private JPanel misc = new JPanel(new GridBagLayout());
	
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
		addMiscPanel();
		addGearPanel();
		addMagicItemsPanel();
		components.add(inv);
	}

	private void addMiscPanel() 
	{
		addCcPanel();
		addMoneyPanel();
		inv.add(misc);
	}

	private void addCcPanel() 
	{
		JPanel carryCapPan = new JPanel(new GridBagLayout());
		carryCapPan.setBorder(BorderFactory.createTitledBorder("Carrying Capacity"));
		
		GridBagConstraints ccConstraints = new GridBagConstraints();
		ccConstraints.insets = new Insets(0, 2, 2, 0);
		
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
		
		misc.add(carryCapPan);
	}
	
	private void addMoneyPanel()
	{
		JPanel moneyPan = new JPanel(new GridBagLayout());
		moneyPan.setBorder(BorderFactory.createTitledBorder("Money Pouch"));
		
		GridBagConstraints monConstraints = new GridBagConstraints();
		monConstraints.insets = new Insets(0, 2, 2, 0);
		
		JLabel labelCopper = new JLabel("Copper");
		moneyPan.add(labelCopper, monConstraints);
		
		JTextField textCopper = new JTextField(3);
		textCopper.setEditable(false);
		monConstraints.gridx = 2;
		moneyPan.add(textCopper, monConstraints);
		
		JLabel labelSilver = new JLabel("Silver");
		monConstraints.gridx = 0;
		monConstraints.gridy = 2;
		moneyPan.add(labelSilver, monConstraints);
		
		JTextField textSilver = new JTextField(3);
		textSilver.setEditable(false);
		monConstraints.gridx = 2;
		moneyPan.add(textSilver, monConstraints);
		
		JLabel labelGold = new JLabel("Gold");
		monConstraints.gridx = 0;
		monConstraints.gridy = 4;
		moneyPan.add(labelGold, monConstraints);
		
		JTextField textGold = new JTextField(3);
		textGold.setEditable(false);
		monConstraints.gridx = 2;
		moneyPan.add(textGold, monConstraints);
		
		JLabel labelPlat = new JLabel("Platinum");
		monConstraints.gridx = 0;
		monConstraints.gridy = 6;
		moneyPan.add(labelPlat, monConstraints);
		
		JTextField textPlat = new JTextField(3);
		textPlat.setEditable(false);
		monConstraints.gridx = 2;
		moneyPan.add(textPlat, monConstraints);

		misc.add(moneyPan);
	}

	private void addGearPanel()
	{
		gear.setBorder(BorderFactory.createTitledBorder("Gear"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 2, 2, 0);
		
		putItemLabelsOnPanel(constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 4;
		putItemOnPanel(constraints);
		
		putBtnAddItemOnPanel(2, 6, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		inv.add(gear, constraints);
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
	
	private void addMagicItemsPanel() 
	{
		JPanel magicPan = new JPanel(new GridBagLayout());
		magicPan.setBorder(BorderFactory.createTitledBorder("Magical Items"));
		
		magicPan.setAlignmentX(0);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(2,0,2,0);
		
		JLabel labelHead = new JLabel("Head");
		magicPan.add(labelHead, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		JTextField textHead = new JTextField(20);
		magicPan.add(textHead, constraints);
		
		constraints.gridy = 3;
		JLabel labelEyes = new JLabel("Eyes");
		magicPan.add(labelEyes, constraints);
		
		constraints.gridy++;
		JTextField textEyes = new JTextField(20);
		magicPan.add(textEyes, constraints);
		
		constraints.gridy = 6;
		JLabel labelNeck = new JLabel("Neck");
		magicPan.add(labelNeck, constraints);
		
		constraints.gridy++;
		JTextField textNeck = new JTextField(20);
		magicPan.add(textNeck, constraints);
		
		constraints.gridy = 9;
		JLabel labelShoul = new JLabel("Shoulders");
		magicPan.add(labelShoul, constraints);
		
		constraints.gridy++;
		JTextField textShoul = new JTextField(20);
		magicPan.add(textShoul, constraints);
		
		constraints.gridy = 12;
		JLabel labelRing1 = new JLabel("Ring 1");
		magicPan.add(labelRing1, constraints);
		
		constraints.gridy++;
		JTextField textRing1 = new JTextField(20);
		magicPan.add(textRing1, constraints);
		
		constraints.gridy = 15;
		JLabel labelRing2 = new JLabel("Ring 2");
		magicPan.add(labelRing2, constraints);
		
		constraints.gridy++;
		JTextField textRing2 = new JTextField(20);
		magicPan.add(textRing2, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		JLabel labelHands = new JLabel("Hands");
		magicPan.add(labelHands, constraints);
		
		constraints.gridy++;
		JTextField textHands = new JTextField(20);
		magicPan.add(textHands, constraints);
		
		constraints.gridy = 3;
		JLabel labelArms = new JLabel("Arms/Wrists");
		magicPan.add(labelArms, constraints);
		
		constraints.gridy++;
		JTextField textArms = new JTextField(20);
		magicPan.add(textArms, constraints);
		
		constraints.gridy = 6;
		JLabel labelBody = new JLabel("Body");
		magicPan.add(labelBody, constraints);
		
		constraints.gridy++;
		JTextField textBody = new JTextField(20);
		magicPan.add(textBody, constraints);
		
		constraints.gridy = 9;
		JLabel labelTorso = new JLabel("Torso");
		magicPan.add(labelTorso, constraints);
		
		constraints.gridy++;
		JTextField textTorso = new JTextField(20);
		magicPan.add(textTorso, constraints);
		
		constraints.gridy = 12;
		JLabel labelWaist = new JLabel("Waist");
		magicPan.add(labelWaist, constraints);
		
		constraints.gridy++;
		JTextField textWaist = new JTextField(20);
		magicPan.add(textWaist, constraints);
		
		constraints.gridy = 15;
		JLabel labelFeet = new JLabel("Feet");
		magicPan.add(labelFeet, constraints);
		
		constraints.gridy++;
		JTextField textFeet = new JTextField(20);
		magicPan.add(textFeet, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		inv.add(magicPan, constraints);	
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