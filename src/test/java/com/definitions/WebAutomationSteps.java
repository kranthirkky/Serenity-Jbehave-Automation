package com.definitions;

import com.pages.WebAutomationPage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.jbehave.core.annotations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WebAutomationSteps extends PageObject {

    @Steps
    WebAutomationPage webAutomationPage;

    @Given("user has launched facebook url")
    public void launchGoogleUrl() {
        webAutomationPage.launchUrlInChrome();
    }

    @When("user validates the page title")
    public void validatePageTitle() {
        webAutomationPage.verifyPageTitle();
    }

    @Then("user validates the search in google")
    public void validateGoogleSearch() {
        assertThat(webAutomationPage.validateFacebookLogin()).isTrue();
    }
}
