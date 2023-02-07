package com.qa.MIS.StepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.qa.MIS.Locators.Locators.*;

public class StepDefinition {

   @When("^user click on url$")
    public void userClickOnUrl()
    {
       DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username$")
    public void userName()
    {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password$")
    public void  enterPassword()
    {
        DriverAction.typeText(password,"Gemini@123");
    }
    @When("^click on SignIn button$")
    public void signIn()
    {
        DriverAction.click(signIn);
        DriverAction.waitSec(10);
    }

    @When("^user update mobile and extension number$")
    public void clickOnMobile(){
       DriverAction.click(popUpCloseButton);
       DriverAction.waitSec(7);
       DriverAction.click(clickOnChangeDetails);
       DriverAction.waitSec(7);
    }

    @When("^Enter mobile number and ext number$")
    public void enterMobileNoAndExtNo(){
       DriverAction.typeText(enterMobileNo,"1234567890");
       DriverAction.typeText(enterExtNo,"111");
    }
    @When("^click on update$")
    public void clickOnUpdate(){
       DriverAction.click(clickOnUpdate);
       DriverAction.waitSec(10);
    }

    @When("^click on update address$")
    public void clickOnUpdateAdd(){
       DriverAction.click(popUpCloseButton);
       DriverAction.click(clickOnChangeDetails);
       DriverAction.waitSec(10);
       DriverAction.click(clickOnUpdateAdd);
       DriverAction.waitSec(10);
    }

    @When("^enter pinCode$")
    public void clickOnPinCode()
    {
        DriverAction.typeText(enterPincode,"121");
        DriverAction.waitSec(10);
        DriverAction.click(updateButtonAdd);
        DriverAction.waitSec(7);
    }

    @And("^verify invalid pincode$")
    public void enterInvalidPincode() {

        DriverAction.getElementText(invalidPincode);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "warningText", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @When("click on change password")
    public void clickOnChangePassword() {
        DriverAction.click(popUpCloseButton,"window close button");
        DriverAction.waitSec(3);
        DriverAction.click(clickOnChangeDetails,"update details");
        DriverAction.waitSec(10);
        DriverAction.click(changePassword,"change password");
        DriverAction.waitSec(7);
    }
        @And("^enter old password$")
        public void enterOldPassword() {
            /*DriverAction.click(popUpCloseButton,"window close button");
            DriverAction.waitSec(3);
            DriverAction.click(clickOnChangeDetails,"update details");
            DriverAction.waitSec(10);*/

            DriverAction.typeText(enterOldPassword, "12345");
            DriverAction.typeText(newPassword, "Gemini123");
            DriverAction.waitSec(5);
            DriverAction.typeText(confirmPassword, "Gemini123");
            DriverAction.click(updatePassword, "update password");
            DriverAction.waitSec(10);
        }
        @And("^verify the the password is incorrect$")
        public void verifyPasswordIncorrect(){
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

    @When("enter new password and confirm password")
    public void enterNewPasswordAndConfirmPassword() {
       DriverAction.click(popUpCloseButton,"close button");
        DriverAction.click(clickOnChangeDetails,"change details button");
        DriverAction.waitSec(3);
        DriverAction.click(changePassword,"change password button");
        DriverAction.waitSec(5);
        DriverAction.typeText(newPassword,"Gemini");
        DriverAction.typeText(confirmPassword,"Gemini123");
        DriverAction.click(updatePassword,"update button");

    }

    @And("click on update password")
    public void clickOnUpdatePassword() {
       DriverAction.click(updatePassword,"update password button");
    }

    @Then("verify password not match")
    public void verifyPasswordNotMatch() {
       DriverAction.click(passwordNotMatch);
        String sl=DriverAction.getElementText(passwordNotMatch);
        if(sl.equals("Password and confirm password does not match"));
        GemTestReporter.addTestStep("Password and confirm password does not match","Password and confirm password does not match", STATUS.PASS,DriverAction.takeSnapShot());
    }

    @When("click on close button")
    public void clickOnCloseButton() {

        DriverAction.click(popUpCloseButton,"close button");
        DriverAction.click(clickOnChangeDetails,"change details button");
    }

    @When("user click on apply lunch")
    public void userClickOnApplyLunch() {
        DriverAction.click(popUpCloseButton,"close button");
        DriverAction.waitSec(10);
        DriverAction.click(applyLunch,"apply lunch");
        DriverAction.waitSec(5);
    }

    @And("user click on from date and click on select from date")
    public void userClickOnFromDate() {
        DriverAction.click(fromDate,"from date");
        DriverAction.click(selectFromDate,"select from date");
    }

    @And("user click on till date and select till date")
    public void userClickOnTillDate() {
        DriverAction.click(tillDate, "till date");
        DriverAction.click(selectTillDate,"select till date");
    }

    @And("click on location container")
    public void clickOnLocationContainer() {
        DriverAction.click(locationContainer,"location container");
    }

    @And("select the location from the list")
    public void selectTheLocationFromTheList() {
        DriverAction.click(selectLocation,"select location");
        DriverAction.waitSec(5);
    }

    @Then("click on add lunch button")
    public void clickOnAddLunchButton() {
        DriverAction.click(addLunchButton,"add lunch button");
    }

    @Then("verify the warning message")
    public void verifyTheWarningMessage() {
        //DriverAction.click(warning,"warning alert message");
        DriverAction.getElementText(warning);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "You have already applied for these dates.", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }


}
