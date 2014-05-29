package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public interface GenerateGui
{
	SpringLayout layout = new SpringLayout();
	Container panel = new JPanel();
	List<Component> pageComponents = new ArrayList<Component>();
	
    public abstract Component generate(int x, int y, Component anchor);
}