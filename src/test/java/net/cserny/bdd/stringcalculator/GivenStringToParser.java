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

    public class WhenEmptyStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnEmptyIntArray() throws Exception
        {
            assertThat(new int[0], equalTo(parser.getNumbers("")));
        }
    }

    public class WhenOneNumberStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumber() throws Exception
        {
            assertThat(new int[] {2}, equalTo(parser.getNumbers("2")));
        }
    }

    public class WhenMultipleCommaDelimitedNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertThat(new int[] {2, 3, 6, 7}, equalTo(parser.getNumbers("2,3,6,7")));
        }
    }

    public class WhenMultipleNewlineDelimitedNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertThat(new int[] {1, 4, 8, 7}, equalTo(parser.getNumbers("1\n4,8\n7")));
        }
    }

    public class WhenCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertThat(new int[] {2, 3, 4}, equalTo(parser.getNumbers("//;\n2;3;4")));
        }
    }

    public class WhenMultiCharacterCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertThat(new int[] {3, 4, 5}, equalTo(parser.getNumbers("//[***]\n3***4***5")));
        }
    }

    public class WhenMultipleMultiCharacterCustomDelimitedSyntaxNumbersStringIsUsedWhileGettingNumbers
    {
        @Test
        public void thenReturnIntArrayContainingNumbers() throws Exception
        {
            assertThat(new int[] {4, 5, 6}, equalTo(parser.getNumbers("//[%--*][&--&]\n4%--*5&--&6")));
        }
    }
}
