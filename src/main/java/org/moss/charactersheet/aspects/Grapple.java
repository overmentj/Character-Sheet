package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.util.ListenerFactory;


public class Grapple implements Aspects
{

    private JTextField total;
    private JTextField base;
    private JTextField strength;
    private JTextField size;
    private JFormattedTextField misc;

    private int totalScore;


    public Grapple(JTextField total, JTextField base, JTextField strength, JTextField size, JFormattedTextField misc)
    {
        this.total = total;
        this.base = base;
        this.strength = strength;
        this.size = size;
        this.misc = misc;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);
        ListenerFactory.registerListener(AbilityScore.STR, this);
        calculate();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        // TODO Auto-generated method stub
        calculate();
    }

    @Override
    public void update(Object key, Object value)
    {
        if (key.equals(AbilityScore.STR))
        {
            this.strength.setText(value.toString());
        }
        calculate();
    }

    private void calculate()
    {
        totalScore = 0;

        if (!base.getText().isEmpty())
        {
            totalScore += Integer.parseInt(base.getText());
        }

        if (!strength.getText().isEmpty())
        {
            totalScore += Integer.parseInt(strength.getText());
        }

        if (!size.getText().isEmpty())
        {
            totalScore += Integer.parseInt(size.getText());
        }

        if (!misc.getText().isEmpty())
        {
            totalScore += Integer.parseInt(misc.getText());
        }

        total.setText(Integer.toString(totalScore));
    }

}
