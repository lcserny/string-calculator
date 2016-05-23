package net.cserny.stringcalculator.bdd;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by user on 23.05.2016.
 */
public class NumbersAdderImpl implements NumbersAdder
{
    @Override
    public int getSum(int[] numbers) throws NegativesNotAllowedException
    {
        List<Integer> numbersStream = getIntegersList(numbers);
        checkForNegatives(numbersStream);

        return numbersStream.stream().filter(value -> value > 0).mapToInt(Integer::valueOf).sum();
    }

    private List<Integer> getIntegersList(int[] numbers)
    {
        return IntStream.of(numbers).boxed().collect(Collectors.toList());
    }

    private void checkForNegatives(List<Integer> numbers) throws NegativesNotAllowedException
    {
        int[] invalidNumbers = numbers.stream().filter(value -> value < 0).mapToInt(Integer::valueOf).toArray();
        if (invalidNumbers.length > 0) {
            throw new NegativesNotAllowedException(invalidNumbers);
        }
    }
}
