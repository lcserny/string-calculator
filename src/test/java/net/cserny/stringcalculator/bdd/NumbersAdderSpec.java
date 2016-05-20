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

    public class GivenNumbersWhenAdding
    {
        int[] numbers = new int[] {1,2,3,4,5};

        @Test
        public void shouldReturnTheirSum() throws Exception
        {
            assertThat(adder.getSum(numbers), equalTo(15));
        }
    }

    public class GivenNumbersBiggerThan1000WhenAdding
    {
        int[] numbers = new int[] {1,2,1005};

        @Test
        public void shouldBeIgnored() throws Exception
        {
            assertThat(adder.getSum(numbers), equalTo(3));
        }
    }
}
