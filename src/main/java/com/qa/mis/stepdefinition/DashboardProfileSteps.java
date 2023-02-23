package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.qa.mis.locators.DashboardProfileLocator.*;

public class DashboardProfileSteps {


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

    @And("^click on SignIn button$")
    public void signIn() {
        // DriverAction.waitUntilElementAppear(signIn, 2);
        DriverAction.waitSec(5);
        DriverAction.click(signIn);
        //DriverAction.waitSec(10);
    }

    @When("^user update mobile and extension number$")
    public void clickOnMobile() {
        // DriverAction.click(popUpCloseButton);
        // DriverAction.waitSec(7);
        //DriverAction.waitUntilElementAppear(clickOnChangeDetails, 2);
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "change details button");
        // DriverAction.waitSec(7);
    }

    @When("^Enter mobile number and ext number$")
    public void enterMobileNoAndExtNo() {
        //DriverAction.waitUntilElementAppear(contactNo, 2);
        DriverAction.waitSec(5);
        DriverAction.typeText(contactNo, "1234567890");
        DriverAction.waitUntilElementAppear(enterExtNo, 2);
        DriverAction.typeText(enterExtNo, "111");
    }

    @When("^click on update$")
    public void clickOnUpdate() {
        // DriverAction.waitUntilElementAppear(clickOnUpdate, 1);
        DriverAction.waitSec(5);
        DriverAction.click(clickOnUpdate);
        //   DriverAction.waitSec(5);
    }

    @And("^click on update address$")
    public void clickOnUpdateAdd() {
//       try {
//           DriverAction.waitSec(5);
//           DriverAction.click(clickOnChangeDetails, "change details");
//       }catch (Exception e) {
//           e.printStackTrace();
//       }
        try {
            //DriverAction.waitUntilElementAppear(clickOnUpdateAdd, 5);
            DriverAction.waitSec(5);
            DriverAction.click(clickOnUpdateAdd, "update address button");
            //DriverAction.waitSec(10);
        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @When("^enter pinCode$")
    public void clickOnPinCode() {
        try {
            DriverAction.waitUntilElementAppear(enterPincode, 2);
            DriverAction.typeText(enterPincode, "121");
            // DriverAction.waitSec(10);
            DriverAction.waitUntilElementAppear(updateButtonAdd, 3);
            DriverAction.click(updateButtonAdd, "update button in add tab");
            //DriverAction.waitSec(7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("^verify invalid pincode$")
    public void enterInvalidPincode() {
        try {
            DriverAction.waitUntilElementAppear(invalidPincode, 1);
            DriverAction.getElementText(invalidPincode);
            String wrng1 = DriverAction.getElementText(warning);
            if (wrng1.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "warningText", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("^click on change password$")
    public void clickOnChangePassword() {


        try {
            DriverAction.waitSec(3);
            //DriverAction.waitUntilElementAppear(changePassword, 7);
            DriverAction.click(changePassword, "change password");

        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @And("^enter old password$")
    public void enterOldPassword() {

        try {
            DriverAction.typeText(enterOldPassword, "12345");
            DriverAction.waitUntilElementAppear(newPassword, 3);
            DriverAction.typeText(newPassword, "Gemini123");
            //DriverAction.waitSec(5);
            DriverAction.typeText(confirmPassword, "Gemini123");
            DriverAction.waitUntilElementAppear(updatePassword, 3);
            DriverAction.click(updatePassword, "update password");
            //DriverAction.waitSec(10);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("^verify the the password is incorrect$")
    public void verifyPasswordIncorrect() {
        try {
            DriverAction.waitSec(5);
            DriverAction.getElementText(warning);
            String warng = DriverAction.getElementText(warning);
            if (warng.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "The old password you entered is not valid. Please try again with correct password.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.click(okButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }


    @When("^enter new password and confirm password$")
    public void enterNewPasswordAndConfirmPassword() {

        try {
            //DriverAction.waitUntilElementAppear(clickOnChangeDetails, 7);
            DriverAction.waitSec(5);
            DriverAction.click(clickOnChangeDetails, "change details button");

            DriverAction.waitSec(5); //(using this wait is mandatory step gets failled without this wait)
            //   DriverAction.waitUntilElementAppear(changePassword, 5);
            DriverAction.click(changePassword, "chg passwrd button");

            // DriverAction.waitUntilElementAppear(newPassword, 2);
            DriverAction.waitSec(5);
            DriverAction.typeText(newPassword, "Gemini");
            //DriverAction.waitUntilElementAppear(confirmPassword, 2);
            DriverAction.waitSec(5);
            DriverAction.typeText(confirmPassword, "Gemini123");
            // DriverAction.waitUntilElementAppear(updatePassword, 2);
            DriverAction.waitSec(5);
            DriverAction.click(updatePassword, "update button");

        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("^click on update password$")
    public void clickOnUpdatePassword() {
        try {
            //DriverAction.waitUntilElementAppear(updatePassword,5);
            DriverAction.waitSec(5);
            DriverAction.click(updatePassword, "update password button");
        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @Then("^verify password not match$")
    public void verifyPasswordNotMatch() {

        try {
            String pswrdNotmatch = DriverAction.getElementText(passwordNotMatch);
            if (pswrdNotmatch.equals("Password and confirm password does not match")) ;
            GemTestReporter.addTestStep("Password and confirm password does not match", "Password and confirm password does not match", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("^click on close button$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitSec(10);
            //DriverAction.waitUntilElementAppear(popUpCloseButton, 5);
            DriverAction.click(popUpCloseButton, "close button");
            // DriverAction.click(clickOnChangeDetails,"change details button");
        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @When("^user click on apply lunch$")
    public void userClickOnApplyLunch() {

        try {
            // DriverAction.waitUntilElementAppear(applyLunch, 7);
            DriverAction.waitSec(5);
            DriverAction.click(applyLunch, "apply lunch");
        } catch (Exception e) {
            //  e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @And("^user click on from date and click on select from date$")
    public void userClickOnFromDate() {
        try {
            //DriverAction.waitUntilElementAppear(fromDate, 7);
            DriverAction.waitSec(5);
            DriverAction.click(fromDate, "from date");
        } catch (Exception e) {
            // e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
        try {
            // DriverAction.waitUntilElementAppear(selectFromDate, 3);
            DriverAction.waitSec(5);
            DriverAction.click(selectFromDate, "select from date");
        } catch (Exception e) {
            //e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("^user click on till date and select till date$")
    public void userClickOnTillDate() {
        try {
            // DriverAction.waitUntilElementAppear(tillDate, 3);
            DriverAction.waitSec(5);
            DriverAction.click(tillDate, "till date");
        } catch (Exception e) {
            //  e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
        try {
            DriverAction.waitUntilElementAppear(selectTillDate, 3);
            DriverAction.click(selectTillDate, "select till date");
        } catch (Exception e) {
            //  e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("^click on location container$")
    public void clickOnLocationContainer() {
        // DriverAction.waitUntilElementAppear(locationContainer,3);
        try {
            DriverAction.waitSec(5);
            DriverAction.click(locationContainer, "location container");
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "click location error occured" + e, STATUS.FAIL);
        }
    }

    @And("^select the location from the list$")
    public void selectTheLocationFromTheList() {
        //DriverAction.waitUntilElementAppear(selectLocation, 2);
        try {
            DriverAction.waitSec(5);
            DriverAction.click(selectLocation, "select location");
            //DriverAction.waitSec(5);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "select location error occured" + e, STATUS.FAIL);
        }
    }

    @Then("^click on add lunch button$")
    public void clickOnAddLunchButton() {
        DriverAction.waitSec(5);
        DriverAction.click(addLunchButton, "add lunch button");
    }

    @Then("^verify the warning message$")
    public void verifyTheWarningMessage() {
        //DriverAction.click(warning,"warning alert message");
        try {
            DriverAction.getElementText(warning);
            String s = DriverAction.getElementText(warning);
            if (s.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "You have already applied for these dates.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "verify warning error occured" + e, STATUS.FAIL);
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

    @When("^enter address in the update address tab$")
    public void enterAddressInTheUpdateAddressTab() {
        DriverAction.waitSec(5);
        try {
            DriverAction.click(clickOnChangeDetails, "change details button");
            DriverAction.click(clickOnUpdateAdd, "update add button");
            //DriverAction.waitSec(3);
            DriverAction.typeText(enterPincode, "121");
            DriverAction.click(updateButtonAdd);


        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "enter address in update add error occured" + e, STATUS.FAIL);
        }
    }

    @And("^click on pincode$")
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
        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(enterOldPassword);
            String op = DriverAction.getElementText(enterOldPassword);
            if (op.equals("Old Password")) {
                GemTestReporter.addTestStep("Old Password", "Old Password", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "verify password error occured" + e, STATUS.FAIL);
        }
    }

    @When("click on edit details button")
    public void clickOnEditDetailsButton() {
        //DriverAction.waitUntilElementAppear(clickOnChangeDetails,2);
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "click on edit details button");
    }

    @When("click on change details button")
    public void clickOnChangeDetailsButton() {
        //DriverAction.waitUntilElementAppear(clickOnChangeDetails,2);
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "click on edit details button");
    }

    @And("enter mobile number")
    public void enterMobileNumber() {
        //DriverAction.waitUntilElementAppear(enterMobileNo,2);
        DriverAction.waitSec(5);
        DriverAction.typeText(enterMobileNo, "123456789");
    }

    @And("click on update mobile number")
    public void clickOnUpdateMobileNumber() {
        //DriverAction.waitUntilElementAppear(updateMobileNo,2);
        DriverAction.waitSec(5);
        DriverAction.click(updateMobileNo, "click on update mobile no. button");
    }


    @Then("verify invalid phone number")
    public void verifyInvalidPhoneNumber() {
        //DriverAction.waitUntilElementAppear(invalidPhNumber,2);
        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(invalidPhNumber);
            String invalidNo = DriverAction.getElementText(warning);
            if (invalidNo.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "Please put 10 digit mobile number.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "invalid phone no. error occured" + e, STATUS.FAIL);
        }
    }

    @And("enter extension number")
    public void enterExtensionNumber() {
        //DriverAction.waitUntilElementAppear(enterExtNo,2);
        DriverAction.waitSec(5);
        DriverAction.typeText(enterExtNo, "11");
    }

    @Then("verify invalid ext number")
    public void verifyInvalidExtNumber() {
        //DriverAction.waitUntilElementAppear(invalidPhNumber,2);
        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(invalidPhNumber);
            String invalidNo = DriverAction.getElementText(warning);
            if (invalidNo.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "Extension number should only be 3 digits.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "invalid ext no. error occured" + e, STATUS.FAIL);
        }
    }
}






