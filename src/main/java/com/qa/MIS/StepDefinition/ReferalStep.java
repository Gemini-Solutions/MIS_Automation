package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        //DriverAction.waitSec(10);
    }

    @Then("^click on close button referal$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitUntilElementAppear(popUpCloseButton, 4);
            DriverAction.click(popUpCloseButton, "close button");
            // DriverAction.click(clickOnChangeDetails,"change details button");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^verify dashboard page is loaded properly$")
    public void dashboardPageIsLoadedProperly() {
        DriverAction.getElementText(dashboardVisible);
        String Dv = DriverAction.getElementText(dashboardVisible);
        if (Dv.equals("dashboardVisible")) {
            GemTestReporter.addTestStep("Dashboard Visible", "Dashboard page is loaded properly", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @Then("^verify JD window is visible$")
    public void VerifyJdWindow() {

        DriverAction.getElementText(VerifyJdWindow);
        String Vw = DriverAction.getElementText(VerifyJdWindow);
        if (Vw.equals(VerifyJdWindow)) {
            GemTestReporter.addTestStep("VerifyJdWindow", "Verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @When("user click on referral action")
    public void userClickOnReferralAction() {
        try {
            DriverAction.waitUntilElementAppear(referralAction, 3);
            DriverAction.click(referralAction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



