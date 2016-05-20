package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
 */
public interface StringParser
{
    public int[] getNumbers(String numbersString) throws NegativesNotAllowedException;
}
