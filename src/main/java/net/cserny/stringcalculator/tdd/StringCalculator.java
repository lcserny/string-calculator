package net.cserny.stringcalculator.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20.05.2016.
 */
public class StringCalculator
{
    private List<String> delimiters = initDelimiters();
    private List<String> invalidNumbers = new ArrayList<>();

    public int add(String numbers) throws NegativesNotAllowedException
    {
        if (numbers.isEmpty()) {
            return 0;
        }
        return getSum(parseCustomDelimiter(numbers));
    }

    private String parseCustomDelimiter(String numbers)
    {
        if (isCustomDelimiter(numbers)) {
            addCustomDelimiter(numbers);
            numbers = getValuesFromNumbersString(numbers);
        }
        return numbers;
    }

    private String getValuesFromNumbersString(String numbers)
    {
        return numbers.substring(numbers.indexOf("\n") + 1);
    }

    private void addCustomDelimiter(String numbers)
    {
        String delimiter = getDelimiter(numbers);
        if (isVaryingLengthDelimiter(delimiter)) {
            clearDelimiters();
            delimiter = getVaryingLengthDelimiter(delimiter);
        }

        delimiters = getCustomDelimiters(delimiter);
    }

    private List<String> getCustomDelimiters(String delimiter)
    {
        List<String> customDelimiters = new ArrayList<>();
        if (isMultipleDelimiters(delimiter)) {
            for (String customDelimiter : delimiter.split("\\]\\[")) {
                customDelimiters.add(customDelimiter);
            }
        } else {
            customDelimiters.add(delimiter);
        }

        return customDelimiters;
    }

    private boolean isMultipleDelimiters(String delimiter)
    {
        return delimiter.contains("][");
    }

    private void clearDelimiters()
    {
        delimiters = new ArrayList<>();
    }

    private String getVaryingLengthDelimiter(String delimiter)
    {
        delimiter = delimiter.substring(1, delimiter.length() - 1);
        return delimiter;
    }

    private boolean isVaryingLengthDelimiter(String delimiter)
    {
        return delimiter.startsWith("[") && delimiter.endsWith("]");
    }

    private String getDelimiter(String numbers)
    {
        int startOfDelimiterIndex = numbers.indexOf("//") + 2;
        int endOfDelimiterIndex = numbers.indexOf("\n");
        return numbers.substring(startOfDelimiterIndex, endOfDelimiterIndex);
    }

    private boolean isCustomDelimiter(String numbers)
    {
        return numbers.startsWith("//");
    }

    private int getSum(String numbers) throws NegativesNotAllowedException
    {
        String[] parts = numbers.split(getDelimiter());
        int sum = 0;
        for (String part : parts) {
            sum += getValidatedAmount(part);
        }

        validateCalculation();
        return sum;
    }

    private int getValidatedAmount(String part)
    {
        int amount = getInteger(part);
        checkForNegatives(amount);
        amount = excludeHugeAmounts(amount);

        return amount;
    }

    private int excludeHugeAmounts(int amount)
    {
        if (amount > 1000) {
            amount = 0;
        }
        return amount;
    }

    private void validateCalculation() throws NegativesNotAllowedException
    {
        if (invalidNumbers.size() > 0) {
            throw new NegativesNotAllowedException(invalidNumbers);
        }
    }

    private void checkForNegatives(int amount)
    {
        if (amount < 0) {
            invalidNumbers.add(String.valueOf(amount));
        }
    }

    private String getDelimiter()
    {
        return String.join("|", delimiters);
    }

    private List<String> initDelimiters()
    {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add("\n");
        return delimiters;
    }

    private Integer getInteger(String numbers)
    {
        return Integer.valueOf(numbers);
    }
}
