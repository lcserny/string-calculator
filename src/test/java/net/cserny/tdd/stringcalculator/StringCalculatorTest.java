package net.cserny.tdd.stringcalculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 13.05.2016.
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
    public void addingEmptyStringShouldReturnZero() throws Exception
    {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addingNumberStringShouldReturnNumber() throws Exception
    {
        assertEquals(2, calculator.add("2"));
    }

    @Test
    public void addingTwoNumbersStringCommaDelimitedShouldReturnTheirSum() throws Exception
    {
        assertEquals(4, calculator.add("1,3"));
    }

    @Test
    public void addingUnknownAmountOfNumbersStringShouldReturnTheirSum() throws Exception
    {
        assertEquals(6, calculator.add("1,1,2,2"));
    }

    @Test
    public void addingNumbersStringDelimitedByNewlineShouldBeAllowed() throws Exception
    {
        assertEquals(5, calculator.add("1,2\n2"));
    }

    @Test
    public void addingNumbersStringUsingCustomDelimiterSyntaxShouldBeAllowed() throws Exception
    {
        assertEquals(7, calculator.add("//;\n2;2;3"));
    }

    @Test
    public void addingUsingCustomDelimiterSyntaxShouldAllowRegexSpecialCharsAlso() throws Exception
    {
        assertEquals(7, calculator.add("//[***-\n2[***-2[***-3"));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void addingNegativeNumbersThrowsException() throws Exception
    {
        calculator.add("1,-2,1");
    }

    @Test
    public void addingNegativesExceptionShouldReturnTheInvalidNumbersInMessage() throws Exception
    {
        try {
            calculator.add("-1,3,1,-5");
        } catch (NegativesNotAllowedException ex) {
            assertEquals("Negative amounts are not allowed: -1 -5", ex.getMessage());
        }
    }

    @Test
    public void addingNumbersBiggerThan1000ShouldBeIgnored() throws Exception
    {
        assertEquals(2, calculator.add("2,1001"));
    }

    @Test
    public void addingNumbersStringShouldSupportMultipleCustomDelimitersSyntax() throws Exception
    {
        assertEquals(7, calculator.add("//[%--][--*]\n2--*2%--3"));
    }
}
