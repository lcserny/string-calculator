package net.cserny.tddkatas.stringcalculator.csharp;

import java.util.stream.IntStream;

/**
 * Created by user on 18.05.2016.
 */
public class CalculatorAdder implements NumberAdder
{
    @Override
    public int add(int[] numbers)
    {
        return IntStream.of(numbers).sum();
    }
}
