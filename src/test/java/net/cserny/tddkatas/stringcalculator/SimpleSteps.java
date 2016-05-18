package net.cserny.tddkatas.stringcalculator;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

/**
 * Created by user on 18.05.2016.
 */
public class SimpleSteps extends Steps
{
    int x;

    @Given("a variable x with value $value")
    public void givenXValue(@Named("value") int value)
    {
        x = value;
    }

    @When("I multiply x by $value")
    public void whenImultiplyXBy(@Named("value") int value)
    {
        x = x * value;
    }

    @Then("x should equal $value")
    public void thenXshouldBe(@Named("value") int value)
    {
        if (value != x) {
            throw new RuntimeException("x is " + x + ", but should be " + value);
        }
    }
}
