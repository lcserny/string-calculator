package net.cserny.tddkatas.stringcalculator.csharp;

/**
 * Created by user on 17.05.2016.
 */
public class StringCalculator
{
    private NumbersParser parser;
    private NumberAdder adder;

    public StringCalculator(NumbersParser parser, NumberAdder adder)
    {
        this.parser = parser;
        this.adder = adder;
    }

    public int add(String expression)
    {
        int[] numbers = parser.getNumbers(expression);
        return adder.add(numbers);
    }
}
