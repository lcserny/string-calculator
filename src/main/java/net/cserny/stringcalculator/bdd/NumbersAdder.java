package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 23.05.2016.
 */
public interface NumbersAdder
{
    public int getSum(int[] numbers) throws NegativesNotAllowedException;
}
