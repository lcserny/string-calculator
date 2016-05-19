package net.cserny.bdd.stringcalculator

import spock.lang.Specification
import net.cserny.bdd.stringcalculator.StringCalculator;
import net.cserny.bdd.stringcalculator.NumberAdder;
import net.cserny.bdd.stringcalculator.NumberParser;

/**
 * Created by user on 19.05.2016.
 */
class StringCalculatorSpec extends Specification
{
    def "given a numbers string when adding then return the sum"()
    {
        String expression = "(some mumbers)";
        int randomSum = 42;
        int[] numbers = [1, 2, 3, 4];
        NumberParser parser = Mock() as NumberParser;
        NumberAdder adder = Mock() as NumberAdder;

        parser.getNumbers(expression) >> numbers;
        adder.add(numbers) >> randomSum;

        give:
        StringCalculator calculator = new StringCalculator(parser, adder);

        when:
        int result = calculator.add(expression);

        then:
        result == randomSum;
    }
}
