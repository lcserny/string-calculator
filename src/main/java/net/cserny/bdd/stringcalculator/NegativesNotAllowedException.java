package net.cserny.bdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class NegativesNotAllowedException extends Exception
{
    private List<String> invalidNumbers;

    public NegativesNotAllowedException(List<String> invalidNumbers)
    {
        this.invalidNumbers = invalidNumbers;
    }

    @Override
    public String getMessage()
    {
        return String.format("Negatives not allowed: %s", String.join(" ", invalidNumbers));
    }
}