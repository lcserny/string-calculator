package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
 */
public class StandardDelimiterParser implements DelimiterParser
{
    @Override
    public DelimitedExpression getDelimitedExpression(String expression)
    {
        DelimitedExpression delimitedExpression = new DelimitedExpression();
        delimitedExpression.setNumbersString(expression);
        delimitedExpression.setDelimiters(new String[] {",", "\n"});

        return delimitedExpression;
    }
}
