package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
 */
public class DelimitedExpression
{
    private String[] delimiters;
    private String numbersString;

    public String[] getDelimiters()
    {
        return delimiters;
    }

    public void setDelimiters(String[] delimiters)
    {
        this.delimiters = delimiters;
    }

    public String getNumbersString()
    {
        return numbersString;
    }

    public void setNumbersString(String numbersString)
    {
        this.numbersString = numbersString;
    }
}
