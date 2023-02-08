package com.qa.MIS_Automation.StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS_Automation.Locators.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static sun.security.ssl.SSLLogger.info;


public class StepDefination {
    @Given("User enters Username as {string}")
    public void userEntersUsernameAs(String userName) {
        DriverAction.isExist(Locators.userName);
        DriverAction.typeText(Locators.userName, userName);
    }

    @And("User enters Password as {string}")
    public void userEntersPasswordAs(String password) {
        DriverAction.isExist(Locators.password);
        DriverAction.typeText(Locators.password, password);
    }

    @Then("User clicks on sign in")
    public void userClicksOnSignIn() {
        DriverAction.isExist(Locators.bttnSignUp);
        DriverAction.click(Locators.bttnSignUp);
    }

    @And("User Verifies Landing Page")
    public void userVerifiesLandingPage() {
        DriverAction.setImplicitTimeOut(6);
        DriverAction.isExist(Locators.geminiLogo);
        GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is verified", STATUS.PASS);
        DriverAction.waitSec(4);

    }

    @Then("User clicks on closeBtn")
    public void userClicksOnCloseBtn() {
        if (DriverAction.isExist(Locators.closeBtn)) {
            DriverAction.waitUntilElementAppear(Locators.closeBtn, 4);
            DriverAction.click(Locators.closeBtn);
        }
    }

    @Given("User clicks on tab {string} and {string}")
    public void userClicksOnTabAnd(String form, String viewForm) {
        DriverAction.isExist(Locators.forms);
        DriverAction.click(Locators.forms);
        DriverAction.isExist(Locators.viewForm);
        DriverAction.click(Locators.viewForm);
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String viewForms) {
        DriverAction.isExist(Locators.forms);
        DriverAction.isExist(Locators.viewForm);
        GemTestReporter.addTestStep("User Verifies Forms Page ", "Form Page is verified", STATUS.PASS);
    }

    @Then("User verifies the presence of {string} Btn")
    public void userVerifiesThePresenceOfBtn(String button) {
        if (DriverAction.isExist(Locators.previous)) {
            GemTestReporter.addTestStep("User Verifies Previous Btn", "Previous Btn is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Previous Btn", "Previous Btn is verified", STATUS.FAIL);
        }
        if (DriverAction.isExist(Locators.next)) {
            GemTestReporter.addTestStep("User Verifies Next Btn", "Next Btn is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Next Btn", "Next Btn is verified", STATUS.FAIL);
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {

        DriverAction.isExist(Locators.department);
        DriverAction.click(Locators.department);
    }

    @Then("User Clicks on {string}")
    public void userClicksOn(String accounts) {
        DriverAction.waitUntilElementAppear(Locators.accounts, 6);
        DriverAction.click(Locators.accounts);
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        DriverAction.isExist(Locators.selectEntriesValue(element));
        DriverAction.scrollIntoView(Locators.selectEntriesValue(element));
        DriverAction.click(Locators.selectEntriesValue(element));
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        DriverAction.isExist(Locators.searchBtn);
        DriverAction.typeText(Locators.searchBtn, value);
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        DriverAction.waitUntilElementAppear(Locators.accountsType(element), 5);
        DriverAction.isExist(Locators.accountsType(element));
    }

    @Then("User search field and enters invalid value {string}")
    public void userSearchFieldAndEntersInvalidValue(String value) {
        DriverAction.isExist(Locators.searchBtn);
        DriverAction.typeText(Locators.searchBtn, value + Keys.ENTER);
    }

    @Then("User verifies the invalid value {string}")
    public void userVerifiesTheInvalidValue(String element) {
        DriverAction.isExist(Locators.noDataAvailable);
        DriverAction.isExist(Locators.noDataAvailable);
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        DriverAction.isExist(Locators.eyeBtn);
        DriverAction.click(Locators.eyeBtn);
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        DriverAction.waitSec(4);
        DriverAction.click(Locators.policyCloseBtn);
    }

    @Then("User click on download image")
    public void userClickOnDownloadImage() {
        DriverAction.isExist(Locators.documentDownload);
        DriverAction.click(Locators.documentDownload);
    }

    @Given("User clicks on the {string} and {string}")
    public void userClicksOnTheAnd(String forms, String myForms) {
        DriverAction.click(Locators.forms);
        DriverAction.click(Locators.myForms);
    }

    @Then("Verify the heading on the landing page")
    public void verifyTheHeadingOnTheLandingPage() {
        DriverAction.isExist(Locators.myFormsHeading);
        System.out.println("You are on the My Forms page");
    }


    @When("User clicks on upload btn")
    public void userClicksOnUploadBtn() {
        DriverAction.waitUntilElementAppear(Locators.uploadBtn, 5);
        DriverAction.click(Locators.uploadBtn);
    }

    @When("User Upload the desired document {string}")
    public void userUploadTheDesiredDocument(String formType) {
        DriverAction.waitSec(3);
        DriverAction.click(Locators.formTypeDropDown);
        DriverAction.waitUntilElementAppear(Locators.formType(formType), 5);
        DriverAction.click(Locators.formType(formType));
        DriverAction.waitSec(3);
        DriverAction.fileUpload(Locators.chooseFile, "C:\\Users\\sh.singh9\\Desktop\\MIS GemJar\\MIS_Automation_GemJar - Final\\src\\main\\resources\\Loyalty Redemption Form.pdf");
        DriverAction.waitSec(4);
    }

    @Then("User clicks on save btn")
    public void userClicksOnSaveBtn() {
        DriverAction.isExist(Locators.saveBtn);
        DriverAction.click(Locators.saveBtn);
        DriverAction.waitSec(3);
    }


    @And("User Upload the undesired document {string}")
    public void userUploadTheUndesiredDocument(String formType) {
        DriverAction.waitSec(3);
        DriverAction.click(Locators.formTypeDropDown);
        DriverAction.waitUntilElementAppear(Locators.formType(formType), 5);
        DriverAction.click(Locators.formType(formType));
        DriverAction.waitSec(3);
        DriverAction.fileUpload(Locators.chooseFile, "C:\\Users\\sh.singh9\\Desktop\\MIS GemJar\\MIS_Automation_GemJar - Final\\src\\main\\resources\\17 may.docx");
        DriverAction.waitSec(4);
    }

    @Then("Verify the {string}")
    public void verifyThe(String warningMsg) {
        DriverAction.waitUntilElementAppear(Locators.warningMsg, 5);
        System.out.println("Error msg appeared");
    }

    @Then("User clicks on okbtn")
    public void userClicksOnOkbtn() {
        DriverAction.waitUntilElementAppear(Locators.okBtn, 4);
        DriverAction.click(Locators.okBtn);
    }

    @Then("User enters valid value in My forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        DriverAction.isExist(Locators.searchBtn);
        DriverAction.typeText(Locators.searchBtn, Loyalty + Keys.ENTER);
        DriverAction.waitSec(3);
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        DriverAction.isExist(Locators.searchBtn);
        DriverAction.typeText(Locators.searchBtn, QA + Keys.ENTER);
        DriverAction.waitSec(3);
    }


    @When("User clicks on active form")
    public void userClicksOnActiveForm() {
        DriverAction.waitUntilElementAppear(Locators.activeForm, 5);
        DriverAction.isExist(Locators.activeForm);
        DriverAction.click(Locators.activeForm);
    }

    @Then("User hovers and clicks on deactivate Btn")
    public void userHoversAndClicksOnDeactivateBtn() {

        DriverAction.waitSec(5);
        DriverAction.isExist(Locators.deactivateBtn);
        DriverAction.click(Locators.deactivateBtn);
    }

    @Then("User clicks on yesBtn")
    public void userClicksOnYesBtn() {
        DriverAction.waitUntilElementAppear(Locators.yesBtn, 6);
        DriverAction.click(Locators.yesBtn);
        DriverAction.waitSec(4);
    }

    @And("User hovers and clicks on download Btn")
    public void userHoversAndClicksOnDownloadBtn() {
        DriverAction.waitUntilElementAppear(Locators.downloadBtn, 8);
        DriverAction.isExist(Locators.downloadBtn);
        DriverAction.click(Locators.downloadBtn);
        DriverAction.waitSec(5);

    }

    @When("User validates the error message as {string}")
    public void userValidatesTheErrorMessageAs(String element) {
        DriverAction.waitUntilElementAppear(Locators.errorMsg, 7);
        try {
            DriverAction.click(Locators.errorMsg);
        } catch (Exception e) {
            info("An exception occured !", e);
        }
    }
}
