package net.cserny.bdd.stringcalculator;

import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by user on 20.05.2016.
 */
@RunWith(NestedRunner.class)
public class GivenStringToParser
{
    NumberParser parser = new NumberParserImpl();

    private void assertExpectedNumbers(String numbersString, int[] expected)
    {
        assertThat(expected, equalTo(parser.getNumbers(numbersString)));
    }

    public class WhenEmptyStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnEmptyIntArray() throws Exception
        {
            assertExpectedNumbers("", new int[0]);
        }
    }

    public class WhenOneNumberStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumber() throws Exception
        {
            assertExpectedNumbers("2", new int[] {2});
        }
    }

    public class WhenMultipleCommaDelimitedNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertExpectedNumbers("2,3,6,7", new int[] {2,3,6,7});
        }
    }

    public class WhenMultipleNewlineDelimitedNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertExpectedNumbers("1\n4,8\n7", new int[] {1,4,8,7});
        }
    }

    public class WhenCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertExpectedNumbers("//;\n2;3;4", new int[] {2, 3, 4});
        }
    }

    public class WhenMultiCharacterCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertExpectedNumbers("//[***]\n3***4***5", new int[] {3, 4, 5});
        }
    }

    public class WhenMultipleMultiCharacterCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertExpectedNumbers("//[%--*][&--&]\n4%--*5&--&6", new int[] {4, 5, 6});
        }
    }
}
