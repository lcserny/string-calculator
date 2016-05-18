package net.cserny.tddkatas.stringcalculator;

import org.jbehave.core.junit.JUnitStories;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 18.05.2016.
 */
public class SimpleJBehave extends JUnitStories
{
    public SimpleJBehave()
    {
        super();
        this.configuredEmbedder().candidateSteps().add(new SimpleSteps());
    }

    @Override
    protected List<String> storyPaths()
    {
        return Collections.singletonList("stories/test_jbehave.story");
    }
}
