package net.cserny.bdd.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.05.2016.
 */
public class CustomStringDelimiterParser implements StringDelimiterParser
{
    private List<String> escapeCharacters = new ArrayList<>(Arrays.asList("\\", ".", "[", "{", "(", "^", "+", "?", "*", "$", "|"));

    @Override
    public List<String> splitExpression(String expression)
    {
        String delimiter = getDelimiter(expression);
        expression = getNumbersString(expression);

        return Arrays.asList(expression.split(delimiter));
    }

    private String getNumbersString(String expression)
    {
        return expression.substring(expression.indexOf("\n") + 1);
    }

    private String getDelimiter(String expression)
    {
        int delimiterStartIndex = expression.indexOf("//") + 2;
        int delimiterEndIndex = expression.indexOf("\n");
        String delimiter = expression.substring(delimiterStartIndex, delimiterEndIndex);

        if (isMultiCharacterDelimiter(delimiter)) {
            delimiter = getMultiCharacterDelimiter(delimiter);
        }

        return delimiter;
    }

    private String getMultiCharacterDelimiter(String delimiter)
    {
        List<String> delimiterArray = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(delimiter);
        while (matcher.find()) {
            String customDelimiter = getEscapedDelimiter(matcher.group(1));
            delimiterArray.add(customDelimiter);
        }

        return String.join("|", delimiterArray);
    }

    private String getEscapedDelimiter(String customDelimiter)
    {
        for (String escDelimiter : escapeCharacters) {
            if (customDelimiter.contains(escDelimiter)) {
                customDelimiter = Pattern.quote(customDelimiter);
            }
        }
        return customDelimiter;
    }

    private boolean isMultiCharacterDelimiter(String delimiter)
    {
        return delimiter.startsWith("[") && delimiter.endsWith("]");
    }
}
