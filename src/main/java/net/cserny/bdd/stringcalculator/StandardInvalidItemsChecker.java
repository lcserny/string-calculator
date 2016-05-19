package net.cserny.bdd.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 19.05.2016.
 */
public class StandardInvalidItemsChecker implements InvalidItemsChecker
{
    @Override
    public void checkItems(List<String> items) throws NegativesNotAllowedException
    {
        List<String> invalidNumbers = items.stream().filter(s -> s.contains("-")).collect(Collectors.toList());
        if (invalidNumbers.size() > 0) {
            throw new NegativesNotAllowedException(invalidNumbers);
        }
    }
}
