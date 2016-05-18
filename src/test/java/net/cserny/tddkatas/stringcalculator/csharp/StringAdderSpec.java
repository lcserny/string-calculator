package net.cserny.tddkatas.stringcalculator.csharp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 18.05.2016.
 */
public class StringAdderSpec
{
    private int result;
    private int sum;
    private int[] numbers;

    public class WhenAddingNumbers extends ConcernFor<NumberAdder>
    {
        @Override
        protected void because()
        {
            result = subjectUnderTest.add(numbers);
        }

        @Override
        protected void context()
        {
            numbers = new int[] {1, 2, 3, 4};
            sum = 10;
        }

        @Override
        protected NumberAdder createSubjectUnderTest()
        {
            return new CalculatorAdder();
        }
    }

    @Test
    public void shouldReturnTheSumOfTheNumbers() throws Exception
    {
        new WhenAddingNumbers().runTest();
        assertThat(result, equalTo(sum));
    }
}
