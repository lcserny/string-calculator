package net.cserny.bdd.stringcalculator;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by user on 19.05.2016.
 */
public class StringCalculatorSpec
{
    @Test
    public void givenNumbersStringWhenAddingThenReturnResultOfAddingTogetherAllNumbers() throws Exception
    {
        String numbersString = "{some numbers}";
        int sum = 999999;
        int[] numbers = {1, 2, 3, 4};

        NumberParser parser = Mockito.mock(NumberParser.class);
        when(parser.getNumbers(numbersString)).thenReturn(numbers);

        NumberAdder adder = Mockito.mock(NumberAdder.class);
        when(adder.add(numbers)).thenReturn(sum);

        StringCalculator calculator = new StringCalculator(parser, adder);
        int result = calculator.add(numbersString);

        assertThat(result, equalTo(sum));
    }
}
