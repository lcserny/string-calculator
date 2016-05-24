package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 23.05.2016.
 */
@RunWith(NestedRunner.class) public class NumbersAdderSpec
{
    NumbersAdder adder;

    public NumbersAdderSpec()
    {
        adder = new NumbersAdderImpl();
    }

    public class WhenPassingNumbersToAdd
    {
        int[] numbers = new int[] {1,2,3,4,5};

        @Test public void thenReturnTheirSum() throws Exception
        {
            int sum = 15;

            int result = adder.getSum(numbers);

            assertThat(result, equalTo(sum));
        }
    }

    public class WhenPassingNegativeNumbersToAdd
    {
        int numbers[] = new int[] {-1,4,-5};

        @Test(expected = NegativesNotAllowedException.class)
        public void thenThrowNegativesNotAllowedException() throws Exception
        {
            adder.getSum(numbers);
        }

        @Test public void thenNegativesNotAllowedExceptionMessageShouldContainTheNegativeNumbers() throws Exception
        {
            try {
                adder.getSum(numbers);
            } catch (NegativesNotAllowedException ex) {
                assertThat(ex.getMessage(), equalTo("Negatives not allowed: -1 -5"));
            }
        }
    }
}
