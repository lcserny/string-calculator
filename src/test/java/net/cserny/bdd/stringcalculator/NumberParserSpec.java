package net.cserny.bdd.stringcalculator;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19.05.2016.
 */
public class NumberParserSpec
{
    private String numbersString = "";
    private int[] expected = new int[0];
    private int[] result;

    private void parseExpected() throws NegativesNotAllowedException
    {
        NumberParser parser = new NumberParserImpl();
        result = parser.getNumbers(numbersString);
    }

    private void assertExpectedNumbers() throws NegativesNotAllowedException
    {
        parseExpected();
        assertArrayEquals(expected, result);
    }

    private void assertExpectedNumbers(String numbersString, int[] expected) throws NegativesNotAllowedException
    {
        this.numbersString = numbersString;
        this.expected = expected;

        assertExpectedNumbers();
    }

    @Test
    public void givenEmptyStringWhenGettingNumbersThenReturnEmptyArray() throws Exception
    {
        assertExpectedNumbers();
    }

    @Test
    public void givenOneNumberStringWhenGettingNumbersThenReturnArrayWithTheNumber() throws Exception
    {
        assertExpectedNumbers("2", new int[] {2});
    }

    @Test
    public void givenTwoNumbersStringCommaDelimitedWhenGettingNumbersThenReturnArrayWithTheNumbers() throws Exception
    {
        assertExpectedNumbers("2,3", new int[] {2, 3});
    }

    @Test
    public void givenUnknownAmountOfNumbersStringCommaDelimitedWhenGettingNumbersThenReturnArrayWithTheNumbers() throws Exception
    {
        assertExpectedNumbers("2,3,5", new int[] {2, 3, 5});
    }

    @Test
    public void givenNewlineDelimitedNumbersStringWhenGettingNumbersThenReturnArrayWithNumbers() throws Exception
    {
        assertExpectedNumbers("1\n3,3", new int[] {1, 3, 3});
    }

    @Test
    public void givenNumbersStringWithCustomDelimiterSyntaxWhenAddingThenReturnArrayWithNumbers() throws Exception
    {
        assertExpectedNumbers("//;\n2;3;4", new int[] {2, 3, 4});
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void givenNegativeNumbersStringWhenAddingThenThrowNegativesNotAllowedException() throws Exception
    {
        numbersString = "-1,3,-5";
        parseExpected();
    }
}
