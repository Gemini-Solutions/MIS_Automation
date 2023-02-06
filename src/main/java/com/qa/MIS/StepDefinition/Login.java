package com.qa.MIS.StepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS.Locators.Locators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

public class Login {

    @Given("Enter username {string}")
    public void enterUsername(String uname) {
        DriverAction.typeText(Locators.username, uname);
    }

    @Then("Click on Sign In Button")
    public void clickOnSignInButton() {
        DriverAction.click(Locators.signInButton);
    }

    @Given("Enter password {string}")
    public void enterPassword(String password) {
        DriverAction.typeText(Locators.password, password);
    }

    @Then("Verify error message {string}")
    public void verifyErrorMessage(String errorMsg) {
        String actualErrorMsg = DriverAction.getElement(Locators.loginErrorMessage).getText();
        if (actualErrorMsg.equals(errorMsg))
            GemTestReporter.addTestStep("Error message", "Error message: " + actualErrorMsg, STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Error message", "Error message: " + actualErrorMsg, STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify all the elements present on Login Page")
    public void verifyAllTheElementsPresentOnLoginPage() {
        WebElement uname = DriverAction.getElement(Locators.username);
        if (uname.isDisplayed())
            GemTestReporter.addTestStep("Username", "Verify Username field visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Username", "User not able to see Username field on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement password = DriverAction.getElement(Locators.password);
        if (password.isDisplayed())
            GemTestReporter.addTestStep("Password", "Verify Password field visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Password", "User not able to see Password field on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement signInButton = DriverAction.getElement(Locators.signInButton);
        if (signInButton.isDisplayed())
            GemTestReporter.addTestStep("Sign in", "Verify Sign in button visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Sign in", "User not able to see Sign in button on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement forgotPasswordButton = DriverAction.getElement(Locators.forgotPasswordButton);
        if (forgotPasswordButton.isDisplayed())
            GemTestReporter.addTestStep("ForgotPassword", "Verify ForgotPassword link visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("ForgotPassword", "User not able to see ForgotPassword link on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement loginWithSSOButton = DriverAction.getElement(Locators.loginWithSSOButton);
        if (loginWithSSOButton.isDisplayed())
            GemTestReporter.addTestStep("Login with SS0", "Verify Login with SS0 button visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Login with SS0", "User not able to see Login with SS0 button on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement loginMsg = DriverAction.getElement(Locators.loginMsg);
        if (loginMsg.isDisplayed())
            GemTestReporter.addTestStep("LoginPage message", "Verify LoginPage message visible to user", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("LoginPage message", "User not able to see LoginPage message", STATUS.FAIL, DriverAction.takeSnapShot());

    }
}

