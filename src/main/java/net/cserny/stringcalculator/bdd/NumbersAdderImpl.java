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
        return IntStream.of(numbers).filter(value -> value <= 1000).sum();
    }
}
