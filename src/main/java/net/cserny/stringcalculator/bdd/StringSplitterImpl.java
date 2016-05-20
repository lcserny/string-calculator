package net.cserny.stringcalculator.bdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 20.05.2016.
 */
public class StringSplitterImpl implements StringSplitter
{
    private DelimiterParser delimiterParser;

    @Override
    public String[] split(String expression)
    {
        DelimiterParser delimiterParser = getDelimiterParser(expression);
        DelimitedExpression delimitedExpression = delimiterParser.getDelimitedExpression(expression);

        return delimitedExpression.getNumbersString().split(String.join("|", delimitedExpression.getDelimiters()));
    }

    private DelimiterParser getDelimiterParser(String expression)
    {
        if (expression.startsWith("//")) {
            return new CustomDelimiterParser();
        }
        return new StandardDelimiterParser();
    }
}
