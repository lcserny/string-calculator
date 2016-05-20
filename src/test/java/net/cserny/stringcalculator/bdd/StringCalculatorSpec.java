package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class StringCalculatorSpec
{
    StringCalculator calculator = new StringCalculator();

    public class WhenGivenStringToAdd
    {
        String numbersString = "some numbers";

        @Test
        public void shouldReturnProcessedAmount() throws Exception
        {
            assertThat(calculator.add(numbersString), equalTo(999999));
        }
    }
}
