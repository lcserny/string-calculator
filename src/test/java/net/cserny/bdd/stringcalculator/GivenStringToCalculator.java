package net.cserny.bdd.stringcalculator;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class GivenStringToCalculator
{
    String numbersString = "{some numbers}";
    NumberParser parser = Mockito.mock(NumberParser.class);
    NumberAdder adder = Mockito.mock(NumberAdder.class);
    StringCalculator calculator = new StringCalculator(parser, adder);

    public class WhenAdding
    {
        @Test
        public void thenReturnProcessedAmount() throws Exception
        {
            int[] numbers = {1, 2, 3, 4};
            int sum = 999999;

            when(parser.getNumbers(numbersString)).thenReturn(numbers);
            when(adder.add(numbers)).thenReturn(sum);

            assertThat(calculator.add(numbersString), equalTo(sum));
        }
    }
}
