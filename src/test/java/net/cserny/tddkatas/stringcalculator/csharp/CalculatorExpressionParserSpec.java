package net.cserny.tddkatas.stringcalculator.csharp;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by user on 18.05.2016.
 */
public class CalculatorExpressionParserSpec
{
    private String expression;
    private String numbersExpression;
    private String[] delimiters;
    private CalculatorExpressionParser parser;
    private NumberParserFactory numberParserFactory;
    private int[] result;

    public class WhenParsingExpression extends ConcernFor<CalculatorExpressionParser>
    {

        @Override
        protected void context()
        {
            expression = "//;\n1;2;3";
            numbersExpression = "1;2;3";
            delimiters = new String[] {";"};
            parser = Mockito.mock(CalculatorExpressionParser.class);

            when(parser.getNumbers(expression)).thenAnswer(new Answer<DelimitedNumbersExpression>()
            {
                @Override
                public DelimitedNumbersExpression answer(InvocationOnMock invocation) throws Throwable
                {
                    return new DelimitedNumbersExpression(expression, delimiters);
                }
            });

            numberParserFactory = Mockito.mock(NumberParserFactory.class);

        }

        @Override
        protected CalculatorExpressionParser createSubjectUnderTest()
        {
            return new CalculatorExpressionParserImpl();
        }

        @Override
        protected void because()
        {
            result = subjectUnderTest.getNumbers(expression);
        }
    }

    @Test
    public void shouldParseNumbersUsingCustomDelimiter() throws Exception
    {
        assertThat(result, equalTo(new int[] {1, 2, 3}));
    }
}
