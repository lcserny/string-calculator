package net.cserny.stringcalculator.tdd;

import java.util.List;

/**
 * Created by user on 20.05.2016.
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
