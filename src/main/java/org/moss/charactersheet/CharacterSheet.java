package org.moss.charactersheet;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.gui.GenerateAnimalGui;
import org.moss.charactersheet.gui.GenerateCharInfoGui;
import org.moss.charactersheet.gui.GenerateFeatsGui;
import org.moss.charactersheet.gui.GenerateInvGui;
import org.moss.charactersheet.gui.GenerateMagicGui;
import org.moss.charactersheet.gui.GenerateSkillsGui;


public class CharacterSheet extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private static final int LINE_HEIGHT = 25;

    public static int getLineHeight()
    {
        return LINE_HEIGHT;
    }

    private List<Component> page1Components = new ArrayList<Component>();
    private List<Component> page2Components = new ArrayList<Component>();
    private List<Component> page3Components = new ArrayList<Component>();
    private List<Component> page4Components = new ArrayList<Component>();
    private List<Component> page5Components = new ArrayList<Component>();
    private List<Component> page6Components = new ArrayList<Component>();

    private SpringLayout layout;
    /** Page 1 */
    private Container tabPanel1;
    /** Page 2 */
    private Container tabPanel2;
    /** Page 3 */
    private Container tabPanel3;
    /** Page 4 */
    private Container tabPanel4;
    /** Page 5 */
    private Container tabPanel5;
    /** Page 6 */
    private Container tabPanel6;

    public CharacterSheet()
    {
        init();
    }

    private void init()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Sheet");

        layout = new SpringLayout();
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPanel = new JTabbedPane();

        tabPanel1 = new JPanel(layout);
        tabPanel2 = new JPanel(layout);
        tabPanel3 = new JPanel(layout);
        tabPanel4 = new JPanel(layout);
        tabPanel5 = new JPanel(layout);
        tabPanel6 = new JPanel(layout);

        JScrollPane pane1 = new JScrollPane();
        tabPanel1.setPreferredSize(new Dimension(700, 1000));
        pane1.setViewportView(tabPanel1);

        JScrollPane pane2 = new JScrollPane();
        tabPanel2.setPreferredSize(new Dimension(815, Skill.getValues().size()*25));
        pane2.setViewportView(tabPanel2);

        tabbedPanel.addTab("Overview", pane1);
        tabbedPanel.addTab("Skills", pane2);
        tabbedPanel.addTab("Feats and Special Abilities", tabPanel3);
        tabbedPanel.addTab("Inventory", tabPanel4);
        tabbedPanel.addTab("Magic", tabPanel5);
        tabbedPanel.addTab("Animals", tabPanel6);

        contentPane.add(tabbedPanel);

        this.setPreferredSize(new Dimension(850, 1000));

        /*
         * Generate components for first page
         */
        GenerateCharInfoGui charInfoGen = new GenerateCharInfoGui(page1Components);
        charInfoGen.generate();

        /*
         * Generate components for second page
         */
        GenerateSkillsGui skillsGen = new GenerateSkillsGui(page2Components);
        skillsGen.generate();
        
        /*
         * Generate components for third page
         */
        GenerateFeatsGui featsGen = new GenerateFeatsGui(page3Components);
        featsGen.generate();
        
        /*
         * Generate components for fourth page
         */
        GenerateInvGui invGen = new GenerateInvGui(page4Components);
        invGen.generate();
        
        /*
         * Generate components for fifth page
         */
        GenerateMagicGui magicGui = new GenerateMagicGui(page5Components);
        magicGui.generate();
        
        /*
         * Generate components for sixth page
         */
        GenerateAnimalGui animGui = new GenerateAnimalGui(page6Components);
        animGui.generate();
        
        /*
         * Add all components to appropriate tab panels
         */
        addAllComponents();
    }

    private void addAllComponents()
    {
        for (Component curComp : page1Components)
        {
            tabPanel1.add(curComp);
        }

        for (Component curComp : page2Components)
        {
            tabPanel2.add(curComp);
        }

        for (Component curComp : page3Components)
        {
            tabPanel3.add(curComp);
        }

        for (Component curComp : page4Components)
        {
            tabPanel4.add(curComp);
        }

        for (Component curComp : page5Components)
        {
            tabPanel5.add(curComp);
        }
        
        for (Component curComp : page6Components)
        {
        	tabPanel6.add(curComp);
        }
        pack();
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CharacterSheet().setVisible(true);
            }
        });
    }
}
