package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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
            int sum = 99;
            int result = calculator.add(numbersString);

            assertThat(result, equalTo(sum));
        }
    }
}
