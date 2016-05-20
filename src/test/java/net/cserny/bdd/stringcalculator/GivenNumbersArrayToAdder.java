package net.cserny.bdd.stringcalculator;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class GivenNumbersArrayToAdder
{
    NumberAdder adder = new NumberAdderImpl();

    public class WhenAdding
    {
        @Test
        public void thenReturnTheirSum() throws Exception
        {
            assertThat(6, equalTo(adder.add(new int[]{1, 2, 3})));
        }
    }

    public class WhenNumbersContainNegativesWhileAdding
    {
        @Test(expected = NegativesNotAllowedException.class)
        public void thenThrowNegativesNotAllowedException() throws Exception
        {
            adder.add(new int[]{-1, 3, -5});
        }

        @Test
        public void thenExceptionMessageShouldContainInvalidNumbers() throws Exception
        {
            try {
                adder.add(new int[] {-1, 3, -5});
            } catch (NegativesNotAllowedException ex) {
                assertThat("Negatives not allowed: -1 -5", equalTo(ex.getMessage()));
            }
        }
    }

    public class WhenNumbersAreBiggerThan100WhileAdding
    {
        @Test
        public void thenIgnoreThem() throws Exception
        {
            assertThat(3, equalTo(adder.add(new int[]{1, 2, 1003})));
        }
    }
}
