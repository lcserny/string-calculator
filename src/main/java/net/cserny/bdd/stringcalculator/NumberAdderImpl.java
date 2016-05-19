package net.cserny.bdd.stringcalculator;

import java.util.stream.IntStream;

/**
 * Created by user on 18.05.2016.
 */
public class NumberAdderImpl implements NumberAdder
{
    @Override
    public int add(int[] numbers)
    {
        return IntStream.of(numbers).sum();
    }
}
