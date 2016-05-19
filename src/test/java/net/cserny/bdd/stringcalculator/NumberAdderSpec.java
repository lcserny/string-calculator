package net.cserny.bdd.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19.05.2016.
 */
public class NumberAdderSpec
{
    private int getSum(int[] numbers) throws NegativesNotAllowedException
    {
        NumberAdder adder = new NumberAdderImpl();
        return adder.add(numbers);
    }

    @Test
    public void givenNumberArrayWhenAddingThenReturnTheirSum() throws Exception
    {
        int result = getSum(new int[]{1, 2, 3});
        assertEquals(6, result);
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void givenNegativeNumbersStringWhenAddingThenThrowNegativesNotAllowedException() throws Exception
    {
        getSum(new int[]{-1, 3, -5});
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
        int result = getSum(new int[]{1, 2, 1003});
        assertEquals(3, result);
    }
}
