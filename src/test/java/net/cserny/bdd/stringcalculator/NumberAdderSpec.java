package net.cserny.bdd.stringcalculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by user on 19.05.2016.
 */
public class NumberAdderSpec
{
    private int getAdditionResult(int[] numbers) throws NegativesNotAllowedException
    {
        NumberAdder adder = new NumberAdderImpl();
        return adder.add(numbers);
    }

    @Test
    public void givenNumberArrayWhenAddingThenReturnTheirSum() throws Exception
    {
        int result = getAdditionResult(new int[] {1, 2, 3});
        assertEquals(6, result);
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void givenNegativeNumbersStringWhenAddingThenThrowNegativesNotAllowedException() throws Exception
    {
        getAdditionResult(new int[] {-1, 3, -5});
    }

    @Test
    public void givenNegativeNotAllowedExceptionWhenAddingThenMessageShouldContainInvalidNumbers() throws Exception
    {
        NumberAdder adder = new NumberAdderImpl();
        try {
            adder.add(new int[] {-1, 3, -5});
        } catch (NegativesNotAllowedException ex) {
            assertEquals("Negatives not allowed: -1 -5", ex.getMessage());
        }
    }

    @Test
    public void givenNumberInStringBiggerThan1000WhenAddingThenIgnoreIt() throws Exception
    {
        int result = getAdditionResult(new int[] {1, 2, 1003});
        assertEquals(3, result);
    }
}
