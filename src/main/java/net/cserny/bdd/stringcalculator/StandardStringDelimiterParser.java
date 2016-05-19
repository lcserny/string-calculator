package net.cserny.bdd.stringcalculator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class StandardStringDelimiterParser implements StringDelimiterParser
{
    @Override
    public List<String> splitExpression(String expression)
    {
        return Arrays.asList(expression.split(",|\n"));
    }
}
