package net.cserny.tdd.stringcalculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by user on 13.05.2016.
 */
public class StringCalculator
{
    private List<String> delimiters = new ArrayList<>();
    private List<Integer> invalidAmounts = new ArrayList<>();

    public StringCalculator()
    {
        initDelimiters();
    }

    public int add(String amounts) throws NegativesNotAllowedException
    {
        if (amounts.isEmpty()) {
            return 0;
        }

        amounts = parseAmountsForCustomDelimiter(amounts);

        return getFilteredSumFrom(amounts);
    }

    private void initDelimiters()
    {
        delimiters.add(",");
        delimiters.add("\n");
    }

    private String parseAmountsForCustomDelimiter(String amounts)
    {
        if (hasCustomDelimiterSyntax(amounts)) {
            handleCustomDelimiterFor(amounts);
            amounts = getTrimmedAmountsString(amounts);
        }
        return amounts;
    }

    private String getTrimmedAmountsString(String amounts)
    {
        return amounts.substring(getIndexOfDelimiterClosingSyntax(amounts) + 1);
    }

    private void handleCustomDelimiterFor(String amounts)
    {
        String customDelimiter = getCustomDelimiter(amounts);
        if (isMultipleCustomDelimiters(customDelimiter)) {
            addMultipleCustomDelimiters(customDelimiter);
        } else {
            delimiters.add(customDelimiter);
        }
    }

    private void addMultipleCustomDelimiters(String customDelimiter)
    {
        String regex = "\\[(.*?)\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customDelimiter);

        while (matcher.find()) {
            delimiters.add(matcher.group(1));
        }
    }

    private boolean isMultipleCustomDelimiters(String customDelimiter)
    {
        return customDelimiter.startsWith("[") && customDelimiter.endsWith("]");
    }

    private String getCustomDelimiter(String amounts)
    {
        return amounts.substring(2, getIndexOfDelimiterClosingSyntax(amounts));
    }

    private int getIndexOfDelimiterClosingSyntax(String amounts)
    {
        return amounts.indexOf("\n");
    }

    private boolean hasCustomDelimiterSyntax(String amounts)
    {
        return amounts.startsWith("//");
    }

    private int getFilteredSumFrom(String amounts) throws NegativesNotAllowedException
    {
        String[] chunks = amounts.split(getDelimitersSplitRegex());
        int sum = 0;
        for (String chunk : chunks) {
            sum += getAmountFrom(chunk);
        }

        checkForInvalidAmounts();

        return sum;
    }

    private void checkForInvalidAmounts() throws NegativesNotAllowedException
    {
        if (!invalidAmounts.isEmpty()) {
            throw new NegativesNotAllowedException(invalidAmounts);
        }
    }

    private String getDelimitersSplitRegex()
    {
        return String.join("|", getRegexCleanedDelimiters());
    }

    private List<String> getRegexCleanedDelimiters()
    {
        return delimiters.stream().map(Pattern::quote).collect(Collectors.toList());
    }

    private Integer getAmountFrom(String chunk)
    {
        int amount = Integer.valueOf(chunk);
        return handleInvalidAmount(chunk, amount);
    }

    private int handleInvalidAmount(String chunk, int amount)
    {
        handleNegativeAmount(chunk, amount);
        return filterAmountGreaterThan1000(amount);
    }

    private int filterAmountGreaterThan1000(int amount)
    {
        if (amount > 1000) {
            amount = 0;
        }
        return amount;
    }

    private void handleNegativeAmount(String chunk, int amount)
    {
        if (chunk.contains("-")) {
            invalidAmounts.add(amount);
        }
    }
}
