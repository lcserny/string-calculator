package net.cserny.tddkatas.stringcalculator.csharp;

/**
 * Created by user on 18.05.2016.
 */
public class DelimitedNumbersExpression
{
    private final String numbersExpression;
    private final String[] delimiters;

    public DelimitedNumbersExpression(String numbersExpression, String[] delimiters)
    {
        this.numbersExpression = numbersExpression;
        this.delimiters  = delimiters;
    }
}
