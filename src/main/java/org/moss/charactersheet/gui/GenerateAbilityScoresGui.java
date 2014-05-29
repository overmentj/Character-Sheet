package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.CharacterSheet;
import org.moss.charactersheet.aspects.AbilityScores;
import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.util.LabelUtils;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.WEST;

/**
 * Generator for ability scores
 * @author Jacq
 *
 */
public class GenerateAbilityScoresGui
{
    private SpringLayout layout;
    private Container tabPanel;
    private List<Component> pageComponenets = new ArrayList<Component>();

    /**
     * Creates new generator that considers given parameters
     * @param layout
     * @param panel
     * @param components
     */
    public GenerateAbilityScoresGui(SpringLayout layout, Container panel, List<Component> componenets)
    {
        this.layout = layout;
        this.tabPanel = panel;
        this.pageComponenets = componenets;
    }
    
    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @param westComponent
     * @return
     */
    public Component generate(Component westComponent)
    {
        JPanel abilityScores = new JPanel(new GridBagLayout());
        abilityScores.setBorder(BorderFactory.createTitledBorder("Ability Scores"));

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        for (int i = 0; i < AbilityScore.values().length; i++)
        {
            int index = i * 2;
            JLabel name = new JLabel(AbilityScore.values()[i].name());
            constraint.gridx = 0;
            constraint.gridy = index;
            abilityScores.add(name, constraint);

            JLabel longName = new JLabel(AbilityScore.values()[i].getAbilityName());
            longName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            abilityScores.add(longName, constraint);

            JTextField total = new JTextField(2);
            total.setEditable(false);
            total.setText("0");
            constraint.gridx = 1;
            constraint.gridy = index;
            abilityScores.add(total, constraint);

            JLabel JLabelTotal = new JLabel("Total");
            JLabelTotal.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelTotal, constraint);

            JLabel JLabelEquals = new JLabel("  =  ");
            constraint.gridx = 2;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelEquals, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField base = new JFormattedTextField();
            constraint.gridx = 3;
            constraint.gridy = index;
            abilityScores.add(base, constraint);

            JLabel JLabelBase = new JLabel(LabelUtils.multiLine("Base Score +\nRacial Mod", true));
            JLabelBase.setFont(small);
            constraint.gridx = 3;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelBase, constraint);

            JLabel JLabelPlus1 = new JLabel("  +  ");
            constraint.gridx = 4;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus1, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField enchance = new JFormattedTextField();
            constraint.gridx = 5;
            constraint.gridy = index;
            abilityScores.add(enchance, constraint);

            JLabel JLabelEnchance = new JLabel(LabelUtils.multiLine("Enhancement\nbonuses", true));
            JLabelEnchance.setFont(small);
            constraint.gridx = 5;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelEnchance, constraint);

            JLabel JLabelPlus2 = new JLabel("  +  ");
            constraint.gridx = 6;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus2, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField misc = new JFormattedTextField();
            constraint.gridx = 7;
            constraint.gridy = index;
            abilityScores.add(misc, constraint);

            JLabel JLabelMisc = new JLabel(LabelUtils.multiLine("Misc\nbonuses", true));
            JLabelMisc.setFont(small);
            constraint.gridx = 7;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMisc, constraint);

            JLabel JLabelPlus3 = new JLabel("  -  ");
            constraint.gridx = 8;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus3, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField miscNeg = new JFormattedTextField();
            constraint.gridx = 9;
            constraint.gridy = index;
            abilityScores.add(miscNeg, constraint);

            JLabel JLabelMiscNeg = new JLabel(LabelUtils.multiLine("Misc\npenalties", true));
            JLabelMiscNeg.setFont(small);
            constraint.gridx = 9;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMiscNeg, constraint);

            JTextField mod = new JTextField(2);
            mod.setEditable(false);
            mod.setText("0");
            constraint.gridx = 11;
            constraint.gridy = index;
            abilityScores.add(mod, constraint);

            JLabel JLabelMod = new JLabel("Mod");
            JLabelMod.setFont(small);
            constraint.gridx = 11;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMod, constraint);

            AbilityScores.getAbilityScores().put(AbilityScore.values()[i],
                                                 new AbilityScores(AbilityScore.values()[i], total, base, enchance,
                                                                   misc, miscNeg, mod));
        }

        pageComponenets.add(abilityScores);
        layout.putConstraint(WEST, abilityScores, 5, WEST, westComponent);
        layout.putConstraint(NORTH, abilityScores, CharacterSheet.getLineHeight() * 6 + 5, NORTH, tabPanel);

        return abilityScores;
    }
}
