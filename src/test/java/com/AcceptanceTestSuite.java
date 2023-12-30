package com;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.EmbedderControls;
import org.openqa.selenium.WebDriver;

public class AcceptanceTestSuite extends SerenityStories {

    @Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    WebDriver driver;

    private Configuration configuration;

    public AcceptanceTestSuite() {
        super();
        EmbedderControls embedderControls = configuredEmbedder().embedderControls();
        String executionThreadCount = System.getProperty("executionThreadCount");

        configuration = new Configuration() {
        };

        embedderControls.doGenerateViewAfterStories(true);
        embedderControls.doIgnoreFailureInStories(true);
        embedderControls.doIgnoreFailureInView(true);
        embedderControls.doVerboseFiltering(true);
        embedderControls.doFailOnStoryTimeout(false);
        embedderControls.useThreads(Integer.parseInt(executionThreadCount));
        embedderControls.useStoryTimeouts("7secs");
    }

    public static void main(String[] args) {
        new AcceptanceTestSuite().run();
    }
}
