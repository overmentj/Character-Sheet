package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.interfaces.UpdateListener;


public class Grapple implements PropertyChangeListener, UpdateListener
{

    private JTextField total;
    private JTextField base;
    private JTextField strength;
    private JTextField size;
    private JFormattedTextField misc;

    private AbilityScores strengthAbility;


    public Grapple(JTextField total, JTextField base, JTextField strength, JTextField size, JFormattedTextField misc,
                   AbilityScores updateCaller)
    {
        this.total = total;
        this.base = base;
        this.strength = strength;
        this.size = size;
        this.misc = misc;
        
        strengthAbility = updateCaller;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        updateCaller.register(this);
    }

    @Override
    public void update()
    {
        strength.setText(Integer.toString(strengthAbility.getModScore()));

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        // TODO Auto-generated method stub

    }

}
