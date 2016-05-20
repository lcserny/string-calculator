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
public class NumbersAdderSpec
{
    NumbersAdder adder = new NumbersAdderImpl();

    private void assertExpected(int[] numbers, int sum)
    {
        assertThat(adder.getSum(numbers), equalTo(sum));
    }

    public class GivenNumbersWhenAdding
    {
        @Test
        public void shouldReturnTheirSum() throws Exception
        {
            assertExpected(new int[] {1,2,3,4,5}, 15);
        }
    }

    public class GivenNumbersBiggerThan1000WhenAdding
    {
        @Test
        public void shouldBeIgnored() throws Exception
        {
            assertExpected(new int[] {1,2,1005}, 3);
        }
    }
}
