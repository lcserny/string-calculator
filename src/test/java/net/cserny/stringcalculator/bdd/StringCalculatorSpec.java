package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by user on 23.05.2016.
 */
@RunWith(NestedRunner.class) public class StringCalculatorSpec
{
    StringCalculator calculator;
    StringParser parser;
    NumbersAdder adder;

    public StringCalculatorSpec()
    {
        parser = Mockito.mock(StringParser.class);
        adder = Mockito.mock(NumbersAdder.class);
        calculator = new StringCalculator(parser, adder);
    }

    public class WhenPassingStringToAdd
    {
        String passedString = "some numbers";

        @Test public void shouldReturnProcessedAmount() throws Exception
        {
            int[] numbers = {1, 2, 3, 4, 5};
            int sum = 999;
            when(parser.parseString(passedString)).thenReturn(numbers);
            when(adder.getSum(numbers)).thenReturn(sum);

            int result = calculator.add(passedString);

            assertThat(result, equalTo(sum));
        }
    }
}
