package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.interfaces.UpdateListener;
import org.moss.charactersheet.util.ListenerFactory;

public class SkillInfo implements UpdateListener, PropertyChangeListener {

	private JCheckBox classSkill;
    private JTextField total;
    private JTextField ability;
    private JFormattedTextField ranks;
    private JFormattedTextField misc;

    private Skill skill;
    private boolean synergyBonus;
    private int skillScore;
	
	public static final Map<Skill, SkillInfo> SKILLS_MAP = new HashMap<Skill, SkillInfo>();
	
	public SkillInfo(Skill skill, JCheckBox classSkillCB, JTextField total, JTextField ability, JFormattedTextField ranks, 
			         JFormattedTextField misc, boolean synergy)
	{
		this.skill = skill;
		this.classSkill = classSkillCB;
		this.total = total;
		this.ability = ability;
		this.ranks = ranks;
		this.misc = misc;
		this.synergyBonus = synergy;
		SKILLS_MAP.put(skill, this);
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        
        ranks.setFormatterFactory(new DefaultFormatterFactory(formatter));
        ranks.setColumns(2);
        ranks.addPropertyChangeListener("value", this);
        
        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);
        
        ListenerFactory.registerListener(skill.getAbility(), this);
	}
	
    @Override
    public void update(Object key, Object value)
    {
        if (skill.getAbility().equals(key))
        {
            this.ability.setText(value.toString());
        }
        calcBonus();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        calcBonus();
    }

    private void calcBonus()
    {
        skillScore = 0;

        if (!ability.getText().isEmpty())
        {
            skillScore += Integer.parseInt(ability.getText());
        }

        if (!ranks.getText().isEmpty())
        {
            skillScore += Integer.parseInt(ranks.getText());
        }

        if (!misc.getText().isEmpty())
        {
            skillScore += Integer.parseInt(misc.getText());
        }

        total.setText(Integer.toString(skillScore));
    }
}
