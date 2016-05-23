package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 23.05.2016.
 */
public class StringCalculator
{
    private final StringParser parser;
    private final NumbersAdder adder;

    public StringCalculator(StringParser parser, NumbersAdder adder)
    {
        this.parser = parser;
        this.adder = adder;
    }

    public int add(String numbers) throws NegativesNotAllowedException
    {
        int[] parsedNumbers = parser.parseString(numbers);
        return adder.getSum(parsedNumbers);
    }
}
