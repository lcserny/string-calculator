package net.cserny.stringcalculator.bdd;

import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 23.05.2016.
 */
public class StringParserImpl implements StringParser
{
    private String delimiterRegex = ",|\n";

    @Override
    public int[] parseString(String numbers)
    {
        if (numbers.isEmpty()) {
            return getEmptyArray();
        }
        return getArrayWithNumbers(numbers);
    }

    private int[] getArrayWithNumbers(String numbers)
    {
        return getSplitArray(numbers).stream().mapToInt(this::getInteger).toArray();
    }

    private List<String> getSplitArray(String numbers)
    {
        if (isCustomDelimiterSyntax(numbers)) {
            delimiterRegex = getCustomDelimiter(numbers);
            numbers = getFilteredNumbersString(numbers);
        }

        return Arrays.asList(numbers.split(delimiterRegex));
    }

    private String getFilteredNumbersString(String numbers)
    {
        return numbers.substring(numbers.indexOf("\n") + 1);
    }

    private String getCustomDelimiter(String numbers)
    {
        return String.valueOf(numbers.charAt(2));
    }

    private boolean isCustomDelimiterSyntax(String numbers)
    {
        return numbers.startsWith("//");
    }

    private Integer getInteger(String numbers)
    {
        return Integer.valueOf(numbers);
    }

    private int[] getEmptyArray()
    {
        return new int[0];
    }
}
