package org.moss.charactersheet.aspects;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.moss.charactersheet.aspects.enums.AbilityScore;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class AbilityScoresTest
{

    @Mock
    private JTextField total;
    @Mock
    private JFormattedTextField base;
    @Mock
    private JFormattedTextField enhance;
    @Mock
    private JFormattedTextField misc;
    @Mock
    private JFormattedTextField miscNeg;
    @Mock
    private JTextField mod;

    @Captor
    ArgumentCaptor<String> modCaptor;


    @Test
    public void testCalculations()
    {
        AbilityScores scores = new AbilityScores(AbilityScore.STR, total, base, enhance, misc, miscNeg, mod);

        Mockito.when(enhance.getText()).thenReturn("");
        Mockito.when(misc.getText()).thenReturn("");
        Mockito.when(miscNeg.getText()).thenReturn("");

        int modExpected = -5;
        for (int i = 1; i < 46; i++)
        {
            if ((i % 2) == 0)
            {
                modExpected++;
            }

            Mockito.when(base.getText()).thenReturn(Integer.toString(i));
            scores.propertyChange(null);

            Mockito.verify(mod, Mockito.times(i)).setText(modCaptor.capture());

            String modString = modCaptor.getValue();

            int modValue = Integer.parseInt(modString);

            assertThat(modValue, is(modExpected));
        }
    }
}
