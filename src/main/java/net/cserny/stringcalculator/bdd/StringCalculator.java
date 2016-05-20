package net.cserny.stringcalculator.bdd;

/**
 * Created by user on 20.05.2016.
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

    public int add(String numbersString) throws NegativesNotAllowedException
    {
        int[] numbers = parser.getNumbers(numbersString);
        return adder.getSum(numbers);
    }
}
