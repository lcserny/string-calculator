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

    @Test
    public void givenEmptyStringWhenGettingNumbersThenReturnEmptyArray() throws Exception
    {
        assertExpectedNumbers();
    }

    @Test
    public void givenOneNumberStringWhenGettingNumbersThenReturnArrayWithTheNumber() throws Exception
    {
        numbersString = "2";
        expected = new int[] {2};

        assertExpectedNumbers();
    }

    @Test
    public void givenTwoNumbersStringCommaDelimitedWhenGettingNumbersThenReturnArrayWithTheNumbers() throws Exception
    {
        numbersString = "2,3";
        expected = new int[] {2, 3};

        assertExpectedNumbers();
    }

    @Test
    public void givenUnknownAmountOfNumbersStringCommaDelimitedWhenGettingNumbersThenReturnArrayWithTheNumbers() throws Exception
    {
        numbersString = "2,3,5";
        expected = new int[] {2, 3, 5};

        assertExpectedNumbers();
    }

    @Test
    public void givenNewlineDelimitedNumbersStringWhenGettingNumbersThenReturnArrayWithNumbers() throws Exception
    {
        numbersString = "1\n3,3";
        expected = new int[] {1, 3, 3};

        assertExpectedNumbers();
    }

    @Test
    public void givenNumbersStringWithCustomDelimiterSyntaxWhenAddingThenReturnArrayWithNumbers() throws Exception
    {
        numbersString = "//;\n2;3;4";
        expected = new int[] {2, 3, 4};

        assertExpectedNumbers();
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void givenNegativeNumbersStringWhenAddingThenThrowNegativesNotAllowedException() throws Exception
    {
        numbersString = "-1,3,-5";
        parseExpected();
    }
}
