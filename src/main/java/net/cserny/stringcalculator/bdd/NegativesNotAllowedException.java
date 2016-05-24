package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 23.05.2016.
 */
public class NegativesNotAllowedException extends Exception
{
    private int[] invalidNumbers;

    public NegativesNotAllowedException(int[] invalidNumbers)
    {
        this.invalidNumbers = invalidNumbers;
    }

    @Override public String getMessage()
    {
        String message = "Negatives not allowed: ";
        for (int number : invalidNumbers) {
            message += number + " ";
        }
        return message.trim();
    }
}
