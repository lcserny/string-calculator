package net.cserny.stringcalculator.bdd;

import java.util.List;

/**
 * Created by user on 20.05.2016.
 */
public interface DelimiterParser
{
    public DelimitedExpression getDelimitedExpression(String expression);
}
