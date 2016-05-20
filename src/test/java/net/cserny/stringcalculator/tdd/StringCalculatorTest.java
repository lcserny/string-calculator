package net.cserny.stringcalculator.tdd;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 20.05.2016.
 */
public class StringCalculatorTest
{
    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception
    {
        calculator = new StringCalculator();
    }

    @Test
    public void givenEmptyStringWhenAddingThenReturnZero() throws Exception
    {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void givenOneNumberWhenAddingThenReturnNumber() throws Exception
    {
        assertEquals(2, calculator.add("2"));
    }

    @Test
    public void givenTwoNumbersWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(5, calculator.add("2,3"));
    }

    @Test
    public void givenMultipleNumbersWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void givenNewlineDelimitedNumbersStringWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(7, calculator.add("1,2\n3\n1"));
    }

    @Test
    public void givenCustomDelimitedSyntaxNumbersStringWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(6, calculator.add("//;\n1;1;1;3"));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void givenNegativeNumbersStringWhenAddingThrowException() throws Exception
    {
        calculator.add("-1,3,-2");
    }

    @Test
    public void giveNegativesNotAllowedExceptionWhenAddingShouldHaveMessageWithNegativeNumbers() throws Exception
    {
        try {
            calculator.add("-2,5,-8");
        } catch (NegativesNotAllowedException ex) {
            assertEquals("Negatives not allowed: -2 -8", ex.getMessage());
        }
    }

    @Test
    public void givenNumberBiggerThan100WhenAddingThenIgnoreIt() throws Exception
    {
        assertEquals(3, calculator.add("1,1\n1\n1005"));
    }

    @Test
    public void givenCustomDelimiterSyntaxVaryingLengthWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(4, calculator.add("//[@@@]\n1@@@2@@@1"));
    }

    @Test
    public void givenMultipleDelimitersOfVaryingLengthWhenAddingThenReturnTheirSum() throws Exception
    {
        assertEquals(6, calculator.add("//[@@][--]\n1--2@@3"));
    }
}
