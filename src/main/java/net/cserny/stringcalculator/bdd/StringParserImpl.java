package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
 */
public class StringParserImpl implements StringParser
{
    private StringSplitter splitter = new StringSplitterImpl();
    private ArrayConverter converter = new ArrayConverterImpl();

    @Override
    public int[] getNumbers(String numbersString) throws NegativesNotAllowedException
    {
        if (numbersString.isEmpty()) {
            return new int[0];
        }

        String[] numberParts = splitter.split(numbersString);
        return converter.convert(numberParts);
    }
}
