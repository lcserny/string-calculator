package net.cserny.stringcalculator.bdd;

import java.util.regex.Pattern;

/**
 * Created by user on 20.05.2016.
 */
public class CustomDelimiterParser implements DelimiterParser
{
    private String[] invalidCharacters = new String[] {"\\", ".", "[", "{", "(", "*", "+", "?", "^", "$", "|"};

    @Override
    public DelimitedExpression getDelimitedExpression(String expression)
    {
        DelimitedExpression delimitedExpression = new DelimitedExpression();
        delimitedExpression.setNumbersString(getSubstring(expression));
        delimitedExpression.setDelimiters(getDelimiters(expression));

        return delimitedExpression;
    }

    private String[] getDelimiters(String expression)
    {
        String delimiter = expression.substring(2, expression.indexOf("\n"));
        if (isOfVaryingLength(delimiter)) {
            delimiter = delimiter.substring(1, delimiter.length() - 1);
        }

        String[] parts = getMultipleDelimiters(delimiter);
        if (parts != null) return parts;

        return new String[] {escapeCharacters(delimiter)};
    }

    private String[] getMultipleDelimiters(String delimiter)
    {
        if (delimiter.contains("][")) {
            String[] parts = delimiter.split("\\]\\[");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = escapeCharacters(parts[i]);
            }
            return parts;
        }
        return null;
    }

    private String escapeCharacters(String delimiter)
    {
        for (String invCharacter : invalidCharacters) {
            if (delimiter.contains(invCharacter)) {
                delimiter = Pattern.quote(delimiter);
                break;
            }
        }

        return delimiter;
    }

    private boolean isOfVaryingLength(String substring)
    {
        return substring.startsWith("[");
    }

    private String getSubstring(String expression)
    {
        return expression.substring(expression.indexOf("\n") + 1);
    }
}
