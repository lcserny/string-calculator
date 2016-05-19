package net.cserny.bdd.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by user on 19.05.2016.
 */
public class NumberAdderSpec
{
    @Test
    public void givenNumberArrayWhenAddingThenReturnTheirSum() throws Exception
    {
        int sum = 6;
        int[] numbers = {1, 2, 3};

        NumberAdder adder = new NumberAdderImpl();
        int result = adder.add(numbers);

        assertEquals(sum, result);
    }
}
