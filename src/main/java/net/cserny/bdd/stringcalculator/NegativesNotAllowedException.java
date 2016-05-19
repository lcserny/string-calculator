package net.cserny.bdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class NegativesNotAllowedException extends Exception
{
    private List<Integer> invalidNumbers;

    public NegativesNotAllowedException(List<Integer> invalidNumbers)
    {
        this.invalidNumbers = invalidNumbers;
    }

    @Override
    public String getMessage()
    {
        String message = "Negatives not allowed: ";
        for (Integer number : invalidNumbers) {
            message += String.valueOf(number) + " ";
        }

        return message.trim();
    }
}
