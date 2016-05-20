package net.cserny.stringcalculator.bdd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 20.05.2016.
 */
public class ArrayConverterImpl implements ArrayConverter
{
    @Override
    public int[] convert(String[] parts) throws NegativesNotAllowedException
    {
        List<String> newParts = Arrays.asList(parts);
        List<String> invalidNumbers = getInvalidNumbers(newParts);
        if (invalidNumbers.size() > 0) {
            throw new NegativesNotAllowedException(invalidNumbers);
        }

        return newParts.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<String> getInvalidNumbers(List<String> newParts)
    {
        return newParts.stream().filter(s -> s.contains("-")).collect(Collectors.toList());
    }
}
