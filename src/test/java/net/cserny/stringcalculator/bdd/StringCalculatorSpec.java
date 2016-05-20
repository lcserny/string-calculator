package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class StringCalculatorSpec
{
    StringCalculator calculator;

    StringParser parser;
    NumbersAdder adder;

    @Before
    public void setUp() throws Exception
    {
        parser = Mockito.mock(StringParser.class);
        adder = Mockito.mock(NumbersAdder.class);
        calculator = new StringCalculator(parser, adder);
    }

    public class GivenStringWhenAdding
    {
        String numbersString = "some numbers";

        @Test
        public void shouldReturnProcessedAmount() throws Exception
        {
            int[] numbers = new int[] {1,2,3,4,5};
            when(parser.getNumbers(numbersString)).thenReturn(numbers);
            int sum = 99999;
            when(adder.getSum(numbers)).thenReturn(sum);

            assertThat(calculator.add(numbersString), equalTo(sum));
        }
    }
}
