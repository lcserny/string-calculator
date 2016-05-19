package net.cserny.bdd.stringcalculator;

/**
 * Created by user on 18.05.2016.
 */
public class StringCalculator
{
    private final NumberParser numbersParser;
    private final NumberAdder numberAdder;

    public StringCalculator(NumberParser numbersParser, NumberAdder numberAdder)
    {
        this.numbersParser = numbersParser;
        this.numberAdder = numberAdder;
    }

    public int add(String expression) throws NegativesNotAllowedException
    {
        int[] numbers = numbersParser.getNumbers(expression);
        return numberAdder.add(numbers);
    }
}
