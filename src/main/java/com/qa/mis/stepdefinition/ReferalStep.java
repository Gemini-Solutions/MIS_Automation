package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static com.qa.mis.locators.DashboardProfileLocator.*;
import static com.qa.mis.locators.ReferalLocator.*;

public class ReferalStep {


    @When("^user click on url referal$")
    public void userClickOnUrl() {
        DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username referal$")
    public void userName() {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password referal$")
    public void enterPassword() {
        DriverAction.typeText(password, "Gemini@123");
    }

    @And("^click on SignIn button referal$")
    public void signIn() {
        DriverAction.waitUntilElementAppear(signIn, 2);
        DriverAction.click(signIn);
        DriverAction.waitSec(10);
    }

    @Then("^click on close button referal$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitUntilElementAppear(popUpCloseButton, 7);
            DriverAction.click(popUpCloseButton, "close button");
            // DriverAction.click(clickOnChangeDetails,"change details button");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^verify dashboard page is loaded properly$")
    public void dashboardPageIsLoadedProperly() {
        DriverAction.waitUntilElementAppear(dashboardVisible,3);
        DriverAction.getElementText(dashboardVisible);
        String Dv = DriverAction.getElementText(dashboardVisible);
        if (Dv.equals("dashboardVisible")) {
            GemTestReporter.addTestStep("Dashboard Visible", "Dashboard page is loaded properly", STATUS.PASS, DriverAction.takeSnapShot());

        }
    }

    @Then("^verify JD window is visible$")
    public void VerifyJdWindow() {
        DriverAction.waitUntilElementAppear(verifyJdWindow,3);
        DriverAction.getElementText(verifyJdWindow);
        String Vw = DriverAction.getElementText(verifyJdWindow);
        if (Vw.equals(verifyJdWindow)) {
            GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitUntilElementAppear(verifyJdWindow,2);
        }
    }

    @And("user click on referral action")
    public void userClickOnReferralAction() {
        try {
            DriverAction.waitSec(5);
          //  DriverAction.scrollIntoView(referralAction);
            DriverAction.waitUntilElementAppear(referralAction, 7);
            DriverAction.click(referralAction,"referral action button");
            DriverAction.waitUntilElementAppear(referralAction,7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("validate referral creation")
    public void validateReferralCreation() {

        DriverAction.waitUntilElementAppear(referralAction,3);

        if(DriverAction.isExist(referralAction))
        GemTestReporter.addTestStep("referral step","referral exit is present",STATUS.PASS,DriverAction.takeSnapShot());
        else GemTestReporter.addTestStep("referral not clicked","referral table not found",STATUS.FAIL,DriverAction.takeSnapShot());
    }

    @Then("click on name under referral")
    public void clickOnNameUnderReferral() {
        try {
            DriverAction.waitUntilElementAppear(refName, 3);
            DriverAction.click(refName, "ref name under referral");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("referral window is visible")
    public void referralWindowIsVisible() {
        DriverAction.getElementText(refName);
        String referanceName=DriverAction.getElementText(refName);
        if(referanceName.equals(refName)) {
            GemTestReporter.addTestStep("Referral Name", "verify referral name under referal is visible", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @When("user checks referral section")
    public void userChecksReferralSection() {
        DriverAction.getElementText(refSection);
        String refferalSection=DriverAction.getElementText(refSection);
        if(refferalSection.equals(refSection)){
            GemTestReporter.addTestStep("verify ref section","verify ref section found",STATUS.PASS,DriverAction.takeSnapShot());
        }



        String verWindow = DriverAction.getElementText(verifyJdWindow);
        if (verWindow.equals(verifyJdWindow)) {
            GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitUntilElementAppear(verifyJdWindow,2);
        }
    }

    @And("click on email under referral")
    public void clickOnEmailUnderReferral() {
        DriverAction.waitUntilElementAppear(refEmail,3);
        DriverAction.click(refEmail,"referral email text");
    }

    @And("enter the email address")
    public void enterTheEmailAddress() {
        DriverAction.waitUntilElementAppear(refEmail,2);
        DriverAction.typeText(refEmail,"abcde");
    }

    @And("click on save")
    public void clickOnSave() {
        DriverAction.waitUntilElementAppear(refSaveButton,2);
        DriverAction.click(refSaveButton,"click on save button under referral");
    }

    @Then("verify the warning message in ref section")
    public void verifyTheWarningMessageInRefSection() {
        DriverAction.waitUntilElementAppear(refWarning,2);
        DriverAction.getElementText(refWarning);
        String referralWarning=DriverAction.getElementText(refWarning);
        if(referralWarning.equals(refWarning)) {
            GemTestReporter.addTestStep("refWarning","You have entered an invalid email address!",STATUS.PASS,DriverAction.takeSnapShot());

        }

    }
}




