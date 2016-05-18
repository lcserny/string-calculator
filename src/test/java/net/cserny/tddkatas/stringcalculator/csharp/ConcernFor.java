package net.cserny.tddkatas.stringcalculator.csharp;

import org.junit.Before;

/**
 * Created by user on 18.05.2016.
 */
public abstract class ConcernFor<T>
{
    protected T subjectUnderTest;

    public void runTest()
    {
        context();
        subjectUnderTest = createSubjectUnderTest();
        because();
    }

    protected void context()
    {

    }

    protected abstract T createSubjectUnderTest();

    protected void because()
    {

    }
}
