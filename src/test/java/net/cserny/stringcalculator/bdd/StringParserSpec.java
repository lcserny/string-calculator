package net.cserny.stringcalculator.bdd;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 23.05.2016.
 */
@RunWith(NestedRunner.class)
public class StringParserSpec
{
    StringParser parser;

    public StringParserSpec()
    {
        parser = new StringParserImpl();
    }

    private void assertExpected(String passedString, int[] result)
    {
        assertThat(parser.parseString(passedString), equalTo(result));
    }

    public class WhenPassingEmptyStringToParse
    {
        @Test
        public void thenReturnEmptyNumbersArray() throws Exception
        {
            assertExpected("", new int[0]);
        }
    }

    public class WhenPassingSingleNumberStringToParse
    {
        @Test
        public void thenReturnNumbersArrayContainingPassedNumber() throws Exception
        {
            assertExpected("3", new int[]{3});
        }
    }

    public class WhenPassingCommaDelimitedNumbersStringToParse
    {
        @Test
        public void thenReturnNumbersArrayContainingPassedNumbers() throws Exception
        {
            assertExpected("3,2", new int[] {3,2});
        }
    }

    public class WhenPassingNewlineDelimitedNumbersStringToParse
    {
        @Test
        public void thenReturnNumbersArrayContainingPassedNumbers() throws Exception
        {
            assertExpected("4\n5,3", new int[] {4,5,3});
        }
    }

    public class WhenPassingCustomDelimiterSyntaxNumbersStringToParse
    {
        @Test
        public void thenReturnNumbersArrayContainingPassedNumbers() throws Exception
        {
            assertExpected("//;\n6;7;8", new int[] {6,7,8});
        }
    }
}
