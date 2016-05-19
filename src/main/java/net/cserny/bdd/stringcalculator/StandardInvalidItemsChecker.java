package net.cserny.bdd.stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public class StandardInvalidItemsChecker implements InvalidItemsChecker
{
    List<Integer> negativeNumbers = new ArrayList<>();
    List<Integer> checkedNumbers = new ArrayList<>();

    @Override
    public List<Integer> checkItems(int[] numbers) throws NegativesNotAllowedException
    {
        for (int number : numbers) {
            if (isNegative(number)) {
                negativeNumbers.add(number);
                continue;
            }

            if (isBiggerThan1000(number)) {
                continue;
            }

            checkedNumbers.add(number);
        }

        validateNegatives();
        return checkedNumbers;
    }

    private void validateNegatives() throws NegativesNotAllowedException
    {
        if (negativeNumbers.size() > 0) {
            throw new NegativesNotAllowedException(negativeNumbers);
        }
    }

    private boolean isBiggerThan1000(int number)
    {
        return number > 1000;
    }

    private boolean isNegative(int number)
    {
        return number < 0;
    }
}
