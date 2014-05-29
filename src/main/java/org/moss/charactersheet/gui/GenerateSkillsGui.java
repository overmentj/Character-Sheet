package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.actions.AddSkill;
import org.moss.charactersheet.aspects.SkillInfo;
import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.util.LabelUtils;

import static javax.swing.SpringLayout.WEST;

/**
 * Generator for ability scores
 * @author Jacq
 *
 */
public class GenerateSkillsGui
{
    private SpringLayout layout;
    private List<Component> pageComponents = new ArrayList<Component>();

    /**
     * Creates new generator that considers given parameters
     * @param layout
     * @param components
     */
    public GenerateSkillsGui(SpringLayout layout, List<Component> components)
    {
        this.layout = layout;
        this.pageComponents = components;
    }

    /**
     * Generates the components required and adds them to the list.
     * Also builds on the layout.
     * @param westComponent
     */
    public void generate(Component westComponent)
    {
        JPanel skills = createSkillsOutline();
        layout.putConstraint(WEST, skills, 5, WEST, westComponent);
        addSkillsToPanel(skills);
        
        JButton addSkill = new JButton("Add New Skill...");
        addSkill.addActionListener(new AddSkill());
        addSkill.setActionCommand("enable");
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = Skill.getValues().size() + 2;
        skills.add(addSkill, constraints);
    }

    /**
     * Create border and headers for Skills table
     * 
     * @return
     */
    private JPanel createSkillsOutline()
    {
        JPanel skills = new JPanel(new GridBagLayout());
        skills.setBorder(BorderFactory.createTitledBorder("Character Skills"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 20, 0, 0);

        // CS
        JLabel labelCS = new JLabel(LabelUtils.multiLine("Class \nSkill"));
        constraints.gridx = 0;
        skills.add(labelCS, constraints);

        // Skills
        JLabel labelSkills = new JLabel("Skill Name");
        constraints.gridx = 1;
        skills.add(labelSkills, constraints);

        // Ability
        JLabel labelAbility = new JLabel(LabelUtils.multiLine("Key \nAbility"));
        constraints.gridx = 3;
        skills.add(labelAbility, constraints);

        // Skill Mod
        JLabel labelSkillMod = new JLabel(LabelUtils.multiLine("Skill \nModifier"));
        constraints.gridx = 5;
        skills.add(labelSkillMod, constraints);

        // Ability Mod
        JLabel labelAbMod = new JLabel(LabelUtils.multiLine("Ability \nModifier"));
        constraints.gridx = 7;
        skills.add(labelAbMod, constraints);

        // Ranks
        JLabel labelRanks = new JLabel("Ranks");
        constraints.gridx = 9;
        skills.add(labelRanks, constraints);

        // Misc
        JLabel labelMisc = new JLabel(LabelUtils.multiLine("Misc \nModifier"));
        constraints.gridx = 11;
        skills.add(labelMisc, constraints);

        pageComponents.add(skills);
        return skills;
    }

    /**
     * Adds all appropriate skills to view
     * 
     * @param skills
     */
    private void addSkillsToPanel(JPanel skills)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        int index = 1;
        for (String curSkill : Skill.getValues())
        {
            constraints.gridy = index;
            constraints.gridx = 0;
            constraints.insets = new Insets(2, 20, 0, 0);

            JCheckBox classSkillCB = new JCheckBox();
            skills.add(classSkillCB, constraints);

            JLabel labelSkillName = new JLabel(curSkill);
            constraints.gridx = 1;
            skills.add(labelSkillName, constraints);

            JLabel labelAbilityName = new JLabel(Skill.getSkill(curSkill).getAbility().name());
            constraints.gridx = 3;
            skills.add(labelAbilityName, constraints);

            JTextField textTotal = new JTextField(2);
            textTotal.setEditable(false);
            constraints.gridx = 5;
            skills.add(textTotal, constraints);

            JLabel labelEquals = new JLabel("  =  ");
            constraints.gridx = 6;
            skills.add(labelEquals, constraints);

            JTextField textAbility = new JTextField(2);
            textAbility.setEditable(false);
            constraints.gridx = 7;
            skills.add(textAbility, constraints);

            JLabel labelPlus2 = new JLabel("  +  ");
            constraints.gridx = 8;
            skills.add(labelPlus2, constraints);

            JFormattedTextField textRanks = new JFormattedTextField();
            constraints.gridx = 9;
            skills.add(textRanks, constraints);

            JLabel labelPlus3 = new JLabel("  +  ");
            constraints.gridx = 10;
            skills.add(labelPlus3, constraints);

            JFormattedTextField textMisc = new JFormattedTextField();
            constraints.gridx = 11;
            skills.add(textMisc, constraints);

            new SkillInfo(new Skill(curSkill, Skill.getSkill(curSkill).getAbility()), classSkillCB, textTotal,
                          textAbility, textRanks, textMisc, false);

            index++;
        }
    }
}
