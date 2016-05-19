package net.cserny.bdd.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by user on 18.05.2016.
 */
public class NumberAdderImpl implements NumberAdder
{
    private InvalidItemsChecker itemsChecker = new StandardInvalidItemsChecker();

    @Override
    public int add(int[] numbers) throws NegativesNotAllowedException
    {
        List<Integer> checkedNumbers = itemsChecker.checkItems(numbers);
        return checkedNumbers.stream().mapToInt(value -> value).sum();
    }
}
