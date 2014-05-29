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
import org.moss.charactersheet.gui.GenerateAbilityScoresGui;
import org.moss.charactersheet.gui.GenerateAcGui;
import org.moss.charactersheet.gui.GenerateCombatOptionsGui;
import org.moss.charactersheet.gui.GenerateGrappleGui;
import org.moss.charactersheet.gui.GenerateMetaDataGui;
import org.moss.charactersheet.gui.GenerateSavesGui;
import org.moss.charactersheet.gui.GenerateSkillsGui;
import org.moss.charactersheet.gui.GenerateSpeedEtcGui;


public class CharacterSheet extends JFrame
{
    private static final int LINE_HEIGHT = 25;

    public static int getLineHeight()
    {
        return LINE_HEIGHT;
    }

    private List<Component> page1Componenets = new ArrayList<Component>();
    private List<Component> page2Componenets = new ArrayList<Component>();
    private List<Component> page3Componenets = new ArrayList<Component>();
    private List<Component> page4Componenets = new ArrayList<Component>();
    private List<Component> page5Components = new ArrayList<Component>();

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

        JScrollPane pane1 = new JScrollPane();
        tabPanel1.setPreferredSize(new Dimension(700, 1000));
        pane1.setViewportView(tabPanel1);

        JScrollPane pane5 = new JScrollPane();
        tabPanel5.setPreferredSize(new Dimension(815, Skill.getValues().size()*25));
        pane5.setViewportView(tabPanel5);

        tabbedPanel.addTab("Overview", pane1);
        tabbedPanel.addTab("Inventory", tabPanel2);
        tabbedPanel.addTab("Magic", tabPanel3);
        tabbedPanel.addTab("Animals", tabPanel4);
        tabbedPanel.addTab("Skills", pane5);

        contentPane.add(tabbedPanel);

        this.setPreferredSize(new Dimension(800, 1000));

        Component comp;

        /*
         * Generate components for first page
         */
        GenerateMetaDataGui metaDataGen = new GenerateMetaDataGui(layout, tabPanel1, page1Componenets);
        metaDataGen.generate();

        GenerateAbilityScoresGui scoreGen = new GenerateAbilityScoresGui(layout, tabPanel1, page1Componenets);
        comp = scoreGen.generate(tabPanel1);

        GenerateCombatOptionsGui combatGen = new GenerateCombatOptionsGui(layout, tabPanel1, page1Componenets);
        combatGen.generate(comp, 6);

        GenerateSpeedEtcGui speedGen = new GenerateSpeedEtcGui(layout, tabPanel1, page1Componenets);
        comp = speedGen.generate(comp);

        GenerateGrappleGui grappleGen = new GenerateGrappleGui(layout, page1Componenets);
        comp = grappleGen.generate(comp, tabPanel1);

        GenerateSavesGui savesGen = new GenerateSavesGui(layout, page1Componenets);
        comp = savesGen.generate(comp, tabPanel1);

        GenerateAcGui acGen = new GenerateAcGui(layout, page1Componenets);
        comp = acGen.generate(comp, tabPanel1);

        /*
         * Generate components for fifth page
         */
        GenerateSkillsGui skillsGen = new GenerateSkillsGui(layout, page5Components, tabPanel5, this);
        skillsGen.generate(tabPanel5);

        /*
         * Add all components to appropriate tab panels
         */
        addAllComponents();
    }

    private void addAllComponents()
    {
        for (Component curComp : page1Componenets)
        {
            tabPanel1.add(curComp);
        }

        for (Component curComp : page2Componenets)
        {
            tabPanel2.add(curComp);
        }

        for (Component curComp : page3Componenets)
        {
            tabPanel3.add(curComp);
        }

        for (Component curComp : page4Componenets)
        {
            tabPanel4.add(curComp);
        }

        for (Component curComp : page5Components)
        {
            tabPanel5.add(curComp);
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
