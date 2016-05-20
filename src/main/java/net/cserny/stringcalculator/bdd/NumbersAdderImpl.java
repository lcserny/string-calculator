package net.cserny.stringcalculator.bdd;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by user on 20.05.2016.
 */
public class NumbersAdderImpl implements NumbersAdder
{
    @Override
    public int getSum(int[] numbers)
    {
        return IntStream.of(numbers).filter(this::filterAmountOver1000).sum();
    }

    public boolean filterAmountOver1000(int amount)
    {
        return amount <= 1000;
    }
}
