package com.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;

public class WebAutomationPage extends PageObject {

    String facebookUrl = "https://www.facebook.com/";

    @FindBy(xpath = "//input[@name='email']")
    WebElementFacade emailInputTextBox;

    @FindBy(xpath = "//input[@name='pass']")
    WebElementFacade passwordInputTextBox;

    @FindBy(xpath = "//button[@name='login']")
    WebElementFacade loginButton;

    @FindBy(xpath = "//div[contains(text(),\"The email address you entered isn't connected to an account. \")]")
    WebElementFacade errorMessage;

    public void launchUrlInChrome() {
        WebDriverManager.chromedriver().setup();
        getDriver().get(facebookUrl);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
    }

    public void verifyPageTitle() {
        System.out.println("INFO!!: Page Title : " + getDriver().getTitle());
    }

    public boolean validateFacebookLogin() {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(60000));
        emailInputTextBox.waitUntilVisible().waitUntilClickable().click();
        emailInputTextBox.sendKeys("webautomation@gmail.com");
        passwordInputTextBox.waitUntilVisible().waitUntilClickable().click();
        passwordInputTextBox.sendKeys("WebAutomation123");
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
        loginButton.waitUntilClickable().click();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
        return errorMessage.waitUntilVisible().isDisplayed();
    }
}