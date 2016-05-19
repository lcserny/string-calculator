package net.cserny.bdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class NumberParserImpl implements NumberParser
{
    private StringDelimiterParser stringDelimiterParser = new StandardStringDelimiterParser();
    private InvalidItemsChecker itemsChecker = new StandardInvalidItemsChecker();

    @Override
    public int[] getNumbers(String expression) throws NegativesNotAllowedException
    {
        if (expression.isEmpty()) {
            return new int[0];
        }

        checkDelimiterParser(expression);

        return getInts(expression);
    }

    private int[] getInts(String expression) throws NegativesNotAllowedException
    {
        List<String> ints = stringDelimiterParser.splitExpression(expression);
        itemsChecker.checkItems(ints);

        return ints.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void checkDelimiterParser(String expression)
    {
        if (expression.startsWith("//")) {
            stringDelimiterParser = new CustomStringDelimiterParser();
        }
    }
}
