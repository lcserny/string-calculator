package net.cserny.tdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 13.05.2016.
 */
public class NegativesNotAllowedException extends Exception
{
    private List<Integer> invalidAmounts;

    public NegativesNotAllowedException(List<Integer> invalidAmounts)
    {
        this.invalidAmounts = invalidAmounts;
    }

    @Override
    public String getMessage()
    {
        String message = "Negative amounts are not allowed: ";
        for (Integer amount : invalidAmounts) {
            message += amount + " ";
        }
        return message.trim();
    }
}
