package com.qa.MIS.StepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.Get;

import java.sql.Driver;

import static com.qa.MIS.Locators.Locators.*;

public class StepDefinition {

    @When("^user click on url$")
    public void userClickOnUrl() {
        DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username$")
    public void userName() {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password$")
    public void enterPassword() {
        DriverAction.typeText(password, "Gemini@123");
    }

    @When("^click on SignIn button$")
    public void signIn() {
        DriverAction.waitUntilElementAppear(signIn, 2);
        DriverAction.click(signIn);
        //DriverAction.waitSec(10);
    }

    @When("^user update mobile and extension number$")
    public void clickOnMobile() {
        // DriverAction.click(popUpCloseButton);
        // DriverAction.waitSec(7);
        DriverAction.waitUntilElementAppear(clickOnChangeDetails, 2);
        DriverAction.click(clickOnChangeDetails, "change details button");
        // DriverAction.waitSec(7);
    }

    @When("^Enter mobile number and ext number$")
    public void enterMobileNoAndExtNo() {
        DriverAction.waitUntilElementAppear(enterMobileNo, 2);
        DriverAction.typeText(enterMobileNo, "1234567890");
        DriverAction.waitUntilElementAppear(enterExtNo, 2);
        DriverAction.typeText(enterExtNo, "111");
    }

    @When("^click on update$")
    public void clickOnUpdate() {
        DriverAction.waitUntilElementAppear(clickOnUpdate, 1);
        DriverAction.click(clickOnUpdate);
        //   DriverAction.waitSec(5);
    }

    @When("^click on update address$")
    public void clickOnUpdateAdd() {
        //  DriverAction.waitUntilElementAppear(clickOnChangeDetails,2);
        // DriverAction.click(popUpCloseButton);
        DriverAction.waitUntilElementAppear(clickOnChangeDetails, 3);
        DriverAction.click(clickOnChangeDetails, "change details");

        DriverAction.waitUntilElementAppear(clickOnUpdateAdd, 2);
        DriverAction.click(clickOnUpdateAdd, "update address button");
        //DriverAction.waitSec(10);
    }

    @When("^enter pinCode$")
    public void clickOnPinCode() {
        DriverAction.waitUntilElementAppear(enterPincode, 2);
        DriverAction.typeText(enterPincode, "121");
        // DriverAction.waitSec(10);
        DriverAction.waitUntilElementAppear(updateButtonAdd, 3);
        DriverAction.click(updateButtonAdd, "update button in add tab");
        //DriverAction.waitSec(7);
    }

    @And("^verify invalid pincode$")
    public void enterInvalidPincode() {
        DriverAction.waitUntilElementAppear(invalidPincode, 1);
        DriverAction.getElementText(invalidPincode);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "warningText", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @When("click on change password")
    public void clickOnChangePassword() {
        // DriverAction.click(popUpCloseButton,"window close button");
        //  DriverAction.waitSec(3);

        try {
            DriverAction.waitUntilElementAppear(clickOnChangeDetails, 3);
            DriverAction.click(clickOnChangeDetails, "update details");
            DriverAction.waitUntilElementAppear(changePassword, 3);
            DriverAction.click(changePassword, "change password");

        } catch (Exception e) {
            e.printStackTrace();
        }
        // DriverAction.waitUntilElementAppear(changePassword,3);
        // DriverAction.click(changePassword, "change password");
    }

    @And("^enter old password$")
    public void enterOldPassword() {
            /*DriverAction.click(popUpCloseButton,"window close button");
            DriverAction.waitSec(3);
            DriverAction.click(clickOnChangeDetails,"update details");
            DriverAction.waitSec(10);*/

        DriverAction.typeText(enterOldPassword, "12345");
        DriverAction.waitUntilElementAppear(newPassword, 3);
        DriverAction.typeText(newPassword, "Gemini123");
        //DriverAction.waitSec(5);
        DriverAction.typeText(confirmPassword, "Gemini123");
        DriverAction.waitUntilElementAppear(updatePassword, 3);
        DriverAction.click(updatePassword, "update password");
        //DriverAction.waitSec(10);
    }

    @And("^verify the the password is incorrect$")
    public void verifyPasswordIncorrect() {
        DriverAction.getElementText(warning);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "The old password you entered is not valid. Please try again with correct password.", STATUS.PASS, DriverAction.takeSnapShot());
        }
        DriverAction.click(okButton);
    }
    /*@When("click on change password")
    public void clickOnChangePassword() {
        DriverAction.waitSec(10);
        DriverAction.click(changePassword,"change password button");
        DriverAction.waitSec(10);
    }*/

    @When("^enter new password and confirm password$")
    public void enterNewPasswordAndConfirmPassword() {
        //    DriverAction.click(popUpCloseButton,"close button");
        // DriverAction.waitSec(3);
        try {
            DriverAction.waitUntilElementAppear(clickOnChangeDetails, 7);
            DriverAction.click(clickOnChangeDetails, "change details button");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DriverAction.waitSec(3);
        try {
            DriverAction.waitUntilElementAppear(changePassword, 8);
            if (DriverAction.isExist(changePassword)) {
                DriverAction.click(changePassword, "change password button");
            } else {
                System.out.println("Element not appears");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DriverAction.waitUntilElementAppear(newPassword, 2);
        DriverAction.typeText(newPassword, "Gemini");
        DriverAction.waitUntilElementAppear(confirmPassword, 2);
        DriverAction.typeText(confirmPassword, "Gemini123");
        DriverAction.waitUntilElementAppear(updatePassword, 2);
        DriverAction.click(updatePassword, "update button");

    }

    @And("^click on update password$")
    public void clickOnUpdatePassword() {
        DriverAction.click(updatePassword, "update password button");
    }

    @Then("^verify password not match$")
    public void verifyPasswordNotMatch() {
        //DriverAction.click(passwordNotMatch);
        // DriverAction.getElementText(passwordNotMatch)
        String sl = DriverAction.getElementText(passwordNotMatch);
        if (sl.equals("Password and confirm password does not match")) ;
        GemTestReporter.addTestStep("Password and confirm password does not match", "Password and confirm password does not match", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^click on close button$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitUntilElementAppear(popUpCloseButton, 4);
            DriverAction.click(popUpCloseButton, "close button");
            // DriverAction.click(clickOnChangeDetails,"change details button");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user click on apply lunch$")
    public void userClickOnApplyLunch() {
        //   DriverAction.click(popUpCloseButton,"close button");
        //    DriverAction.waitSec(10);
        DriverAction.waitUntilElementAppear(applyLunch, 2);
        DriverAction.click(applyLunch, "apply lunch");
        //DriverAction.waitSec(5);
    }

    @And("^user click on from date and click on select from date$")
    public void userClickOnFromDate() {
        DriverAction.waitUntilElementAppear(fromDate, 2);
        DriverAction.click(fromDate, "from date");
        DriverAction.waitUntilElementAppear(selectFromDate, 2);
        DriverAction.click(selectFromDate, "select from date");

    }

    @And("^user click on till date and select till date$")
    public void userClickOnTillDate() {
        DriverAction.click(tillDate, "till date");
        DriverAction.click(selectTillDate, "select till date");
    }

    @And("^click on location container$")
    public void clickOnLocationContainer() {
        DriverAction.click(locationContainer, "location container");
    }

    @And("^select the location from the list$")
    public void selectTheLocationFromTheList() {
        DriverAction.waitUntilElementAppear(selectLocation, 2);
        DriverAction.click(selectLocation, "select location");
        //DriverAction.waitSec(5);
    }

    @Then("^click on add lunch button$")
    public void clickOnAddLunchButton() {
        DriverAction.click(addLunchButton, "add lunch button");
    }

    @Then("^verify the warning message$")
    public void verifyTheWarningMessage() {
        //DriverAction.click(warning,"warning alert message");
        DriverAction.getElementText(warning);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "You have already applied for these dates.", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }


    @Then("^verify select is blank$")
    public void verifySelectIsBlank() {
        DriverAction.getElementText(locationContainer);
        String s = DriverAction.getElementText(locationContainer);
        if (s.equals("Select")) {
            GemTestReporter.addTestStep("Select is blank", "Select is blank", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @Then("^verify the old password is blank$")
    public void verifyTheOldPasswordIsBlank() {
        DriverAction.getElementText(enterOldPassword);
        String sb = DriverAction.getElementText(enterOldPassword);
        if (sb.equals("old password")) {
            GemTestReporter.addTestStep("old password is blank", "Old password is blank", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @When("enter address in the update address tab")
    public void enterAddressInTheUpdateAddressTab() {
        DriverAction.click(clickOnChangeDetails, "change details button");
        DriverAction.click(clickOnUpdateAdd, "update add button");
        //DriverAction.waitSec(3);
        DriverAction.typeText(enterPincode, "121");
        DriverAction.click(updateButtonAdd);


    }

    @And("click on pincode")
    public void clickOnPincode() {
        DriverAction.getElementText(enterPincode);
    }

    @Then("^verify pincode is blank$")
    public void verifyPinCode() {
        String sb = DriverAction.getElementText(enterPincode);
        if (sb.equals("Pincode")) {
            GemTestReporter.addTestStep("Pincode", "Pincode is blank", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @Then("^verify password is blank$")
    public void verifyPasswordIsBlank() {
        DriverAction.getElementText(enterOldPassword);
        String op = DriverAction.getElementText(enterOldPassword);
        if (op.equals("Old Password")) {
            GemTestReporter.addTestStep("Old Password", "Old Password", STATUS.PASS, DriverAction.takeSnapShot());
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

    @And("^verify JD window is visible$")
    public void VerifyJdWindow() {

        DriverAction.getElementText(VerifyJdWindow);
        String Vw=DriverAction.getElementText(VerifyJdWindow);
        if(Vw.equals(VerifyJdWindow)){
            GemTestReporter.addTestStep("VerifyJdWindow","Verify window is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
    }

    @When("user click on referral action")
    public void userClickOnReferralAction() {
        DriverAction.click(referralAction);
    }
}

