package net.cserny.bdd.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19.05.2016.
 */
public class NegativesNotAllowedSpec
{
    @Test
    public void givenNegativeNotAllowedExceptionWhenAddingThenMessageShouldContainInvalidNumbers() throws Exception
    {
        String numbersString = "-1,3,-5";
        NumberParser parser = new NumberParserImpl();
        try {
            parser.getNumbers(numbersString);
        } catch (NegativesNotAllowedException ex) {
            assertEquals("Negatives not allowed: -1 -5", ex.getMessage());
        }
    }
}
