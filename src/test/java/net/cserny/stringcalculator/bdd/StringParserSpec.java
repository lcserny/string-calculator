package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class StringParserSpec
{
    StringParser parser = new StringParserImpl();

    private void assertExpected(String numbersString, int[] numbers) throws NegativesNotAllowedException
    {
        assertThat(parser.getNumbers(numbersString), equalTo(numbers));
    }

    public class GivenEmptyStringWhenGettingNumbers
    {
        @Test
        public void shouldReturnEmptyArray() throws Exception
        {
            assertExpected("", new int[0]);
        }
    }

    public class GivenOneNumberStringWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumber() throws Exception
        {
            assertExpected("2", new int[] {2});
        }
    }

    public class GivenCommaDelimitedNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("2,3", new int[] {2,3});
        }
    }

    public class GivenNewlineDelimitedNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("3\n4\n5", new int[] {3,4,5});
        }
    }

    public class GivenCommaAndNewlineDelimiterSyntaxNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("7,8\n9", new int[] {7,8,9});
        }
    }

    public class GivenCustomDelimiterSyntaxNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("//;\n2;3;4", new int[] {2,3,4});
        }
    }

    public class GivenCustomDelimiterOfVaryingLengthSyntaxNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("//[***]\n3***4***5", new int[] {3,4,5});
        }
    }

    public class GivenMultipleCustomDelimiterOfVaryingLengthSyntaxNumbersWhenParsing
    {
        @Test
        public void shouldReturnArrayWithNumbers() throws Exception
        {
            assertExpected("//[%*%][@@][---]\n1@@4%*%5---8", new int[] {1,4,5,8});
        }
    }

    public class GivenNegativeNumbersStringWhenParsing
    {
        String numbersString = "-1,3,-5";

        @Test(expected = NegativesNotAllowedException.class)
        public void throwsNegativesNotAllowedException() throws Exception
        {
            parser.getNumbers(numbersString);
        }

        @Test
        public void thenNegativesNotAllowedExceptionMessageShouldContainTheNegativeNumbers() throws Exception
        {
            try {
                parser.getNumbers(numbersString);
            } catch (NegativesNotAllowedException ex) {
                assertThat(ex.getMessage(), equalTo("Negatives not allowed: -1 -5"));
            }
        }
    }
}
