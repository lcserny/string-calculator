package net.cserny.bdd.stringcalculator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class CustomStringDelimiterParser implements StringDelimiterParser
{
    @Override
    public List<String> splitExpression(String expression)
    {
        int delimiterStartIndex = expression.indexOf("//") + 2;
        int delimiterEndIndex = expression.indexOf("\n");
        String delimiter = expression.substring(delimiterStartIndex, delimiterEndIndex);
        expression = expression.substring(delimiterEndIndex + 1);

        return Arrays.asList(expression.split(delimiter));
    }
}
