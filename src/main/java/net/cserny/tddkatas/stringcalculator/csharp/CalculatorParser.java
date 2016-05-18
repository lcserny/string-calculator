package net.cserny.tddkatas.stringcalculator.csharp;

import java.util.Arrays;

/**
 * Created by user on 18.05.2016.
 */
public class CalculatorParser implements NumbersParser
{
    private String delimiters = ",|\n";

    @Override
    public int[] getNumbers(String numbers)
    {
        if (numbers.isEmpty()) {
            return new int[0];
        }
        return Arrays.asList(numbers.split(delimiters)).stream().mapToInt(Integer::valueOf).toArray();
    }
}
