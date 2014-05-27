package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.interfaces.UpdateListener;
import org.moss.charactersheet.util.ListenerFactory;


public class AbilityScores implements PropertyChangeListener
{

    private JTextField total;
    private JFormattedTextField base;
    private JFormattedTextField enhance;
    private JFormattedTextField misc;
    private JFormattedTextField miscNeg;
    private JTextField mod;

    private AbilityScore ability;

    private int totalScore = 0;

    private int modScore = 0;


    public int getTotalScore()
    {
        return totalScore;
    }

    public int getModScore()
    {
        return modScore;
    }


    private Set<UpdateListener> listeners = new HashSet<>();


    public AbilityScores(AbilityScore ability, JTextField total, JFormattedTextField base, JFormattedTextField enhance,
                         JFormattedTextField misc, JFormattedTextField miscNeg, JTextField mod)
    {
        this.total = total;
        this.base = base;
        this.enhance = enhance;
        this.misc = misc;
        this.miscNeg = miscNeg;
        this.mod = mod;
        this.ability = ability;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        base.setFormatterFactory(new DefaultFormatterFactory(formatter));
        base.setColumns(2);
        base.addPropertyChangeListener("value", this);

        enhance.setFormatterFactory(new DefaultFormatterFactory(formatter));
        enhance.setColumns(2);
        enhance.addPropertyChangeListener("value", this);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        miscNeg.setFormatterFactory(new DefaultFormatterFactory(formatter));
        miscNeg.setColumns(2);
        miscNeg.addPropertyChangeListener("value", this);

        ListenerFactory.registerCaller(ability);

    }

    public void createGui()
    {

    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        totalScore = 0;
        if (!base.getText().isEmpty())
        {
            totalScore += Integer.parseInt(base.getText());
        }

        if (!enhance.getText().isEmpty())
        {
            totalScore += Integer.parseInt(enhance.getText());
        }

        if (!misc.getText().isEmpty())
        {
            totalScore += Integer.parseInt(misc.getText());
        }

        if (!miscNeg.getText().isEmpty())
        {
            totalScore -= Integer.parseInt(miscNeg.getText());
        }

        total.setText(Integer.toString(totalScore));

        modScore = 0;
        if (totalScore > 0)
        {
            if (totalScore > 10)
            {
                modScore = (int) Math.floor((totalScore - 10) / 2.0);
            }
            else if (totalScore < 10)
            {

                modScore = (int) Math.floor((totalScore - 10) / 2.0);
            }
        }
        mod.setText(Integer.toString(modScore));

        ListenerFactory.callback(this.ability, modScore);
    }
}
