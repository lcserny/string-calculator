package net.cserny.bdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class NumberParserImpl implements NumberParser
{
    private StringDelimiterParser stringDelimiterParser = new StandardStringDelimiterParser();

    @Override
    public int[] getNumbers(String expression)
    {
        if (expression.isEmpty()) {
            return new int[0];
        }

        checkDelimiterParser(expression);
        return getInts(expression);
    }

    private int[] getInts(String expression)
    {
        return stringDelimiterParser.splitExpression(expression).stream().mapToInt(Integer::valueOf).toArray();
    }

    private void checkDelimiterParser(String expression)
    {
        if (expression.startsWith("//")) {
            stringDelimiterParser = new CustomStringDelimiterParser();
        }
    }
}
