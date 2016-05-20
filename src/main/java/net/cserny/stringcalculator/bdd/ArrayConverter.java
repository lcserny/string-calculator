package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
 */
public interface ArrayConverter
{
    public int[] convert(String[] parts) throws NegativesNotAllowedException;
}
