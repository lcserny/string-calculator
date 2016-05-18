package net.cserny.tddkatas.stringcalculator.csharp;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by user on 18.05.2016.
 */
public class StringCalculatorSpec
{
    private NumbersParser numbersParser;
    private NumberAdder numberAdder;
    private int result;
    private int sum;
    private String expression;
    private int[] numbers;

    public class WhenGivenAStringToAdd extends ConcernFor<StringCalculator>
    {
        @Override
        protected void context()
        {
            numbersParser = Mockito.mock(NumbersParser.class);
            numberAdder = Mockito.mock(NumberAdder.class);
            expression = "(some mumbers)";
            numbers = new int[] {1, 2, 3, 4};
            sum = 42;

            when(numbersParser.getNumbers(expression)).thenReturn(numbers);
            when(numberAdder.add(numbers)).thenReturn(sum);
        }

        @Override
        protected StringCalculator createSubjectUnderTest()
        {
            return new StringCalculator(numbersParser, numberAdder);
        }

        @Override
        protected void because()
        {
            result = subjectUnderTest.add(expression);
        }
    }

    @Test
    public void shouldReturnTheResultOfAddingTogetherAllNumbersInAString() throws Exception
    {
        new WhenGivenAStringToAdd().runTest();
        assertThat(result, equalTo(sum));
    }
}
