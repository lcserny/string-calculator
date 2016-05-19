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

    private void parseExpected()
    {
        NumberParser parser = new NumberParserImpl();
        result = parser.getNumbers(numbersString);
    }

    private void assertExpectedNumbers()
    {
        parseExpected();
        assertArrayEquals(expected, result);
    }

    private void assertExpectedNumbers(String numbersString, int[] expected)
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
    public void givenNumbersStringWithCustomDelimiterSyntaxWhenGettingNumbersThenReturnArrayWithNumbers() throws Exception
    {
        assertExpectedNumbers("//;\n2;3;4", new int[] {2, 3, 4});
    }

    @Test
    public void givenMultiCharacterCustomDelimiterSyntaxWhenGettingNumbersThenReturnArrayWithNumbers() throws Exception
    {
        assertExpectedNumbers("//[***]\n3***4***5", new int[] {3, 4, 5});
    }

    @Test
    public void givenMultipleMultiCharacterCustomDelimiterSyntaxWhenGettingNumbersThenReturnArrayWithNumbers() throws Exception
    {
        assertExpectedNumbers("//[%][&]\n4%5&6", new int[] {4, 5, 6});
    }
}
