package net.cserny.bdd.stringcalculator;

import java.util.List;

/**
 * Created by user on 19.05.2016.
 */
public interface InvalidItemsChecker
{
    public List<Integer> checkItems(int[] numbers) throws NegativesNotAllowedException;
}
