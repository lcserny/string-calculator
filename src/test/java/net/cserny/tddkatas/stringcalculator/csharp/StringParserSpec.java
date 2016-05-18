package net.cserny.tddkatas.stringcalculator.csharp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 18.05.2016.
 */
public class StringParserSpec
{
    private String numbersString;
    private int[] result;

    public abstract class Concern extends ConcernFor<NumbersParser>
    {
        @Override
        protected void because()
        {
            result = subjectUnderTest.getNumbers(numbersString);
        }

        @Override
        protected NumbersParser createSubjectUnderTest()
        {
            return new CalculatorParser();
        }
    }

    public class WhenParsingAnEmptyString extends Concern
    {
        @Override
        protected void context()
        {
            numbersString = "";
        }
    }

    @Test
    public void shouldReturnZero() throws Exception
    {
        new WhenParsingAnEmptyString().runTest();
        assertThat(result, equalTo(new int[] {}));
    }

    public class WhenParsingAStringContainingASingleNumber extends Concern
    {
        @Override
        protected void context()
        {
            numbersString = "2";
        }
    }

    @Test
    public void shouldReturnTheNumberPassed() throws Exception
    {
        new WhenParsingAStringContainingASingleNumber().runTest();
        assertThat(result, equalTo(new int[] {2}));
    }

    public class WhenParsingAStringContainingMultipleNumberDelimitedByComma extends Concern
    {
        @Override
        protected void context()
        {
            numbersString = "2,3";
        }
    }

    @Test
    public void shouldReturnTheSumOfTheCommaDelimitedNumbers() throws Exception
    {
        new WhenParsingAStringContainingMultipleNumberDelimitedByComma().runTest();
        assertThat(result, equalTo(new int[] {2, 3}));
    }

    public class WhenParsingAStringContainingMultipleNumberDelimitedByNewline extends Concern
    {
        @Override
        protected void context()
        {
            numbersString = "3,3\n1";
        }
    }

    @Test
    public void shouldReturnTheSumOfTheNewlineDelimitedNumbers() throws Exception
    {
        new WhenParsingAStringContainingMultipleNumberDelimitedByNewline().runTest();
        assertThat(result, equalTo(new int[] {3, 3, 1}));
    }
}
