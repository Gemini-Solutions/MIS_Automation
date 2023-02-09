package com.qa.MIS_Automation.StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS_Automation.Locators.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
public class StepDefinition {
    @Given("User enters Username as {string}")
    public void userEntersUsernameAs(String userName) {
        if (DriverAction.isExist(Locators.userName)) {
            DriverAction.typeText(Locators.userName, userName);
        } else {
            GemTestReporter.addTestStep("User Enters the Wrong Username", "Username is not Verified", STATUS.FAIL);
        }
    }

    @And("User enters Password as {string}")
    public void userEntersPasswordAs(String password) {
        if (DriverAction.isExist(Locators.password)) {
            DriverAction.typeText(Locators.password, password);
        } else {
            GemTestReporter.addTestStep("User Enters the Wrong Password", "Password is not Verified", STATUS.FAIL);
        }
    }

    @Then("User clicks on sign in")
    public void userClicksOnSignIn() {
        if (DriverAction.isExist(Locators.bttnSignUp)) {
            DriverAction.click(Locators.bttnSignUp);
            DriverAction.setImplicitTimeOut(6);
        } else {
            GemTestReporter.addTestStep("User Clicks on SignIn", "sign in Unsuccessful", STATUS.FAIL);

        }
    }

    @And("User Verifies Landing Page")
    public void userVerifiesLandingPage() {
        if (DriverAction.isExist(Locators.geminiLogo)) {
            DriverAction.setImplicitTimeOut(6);
            GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is verified", STATUS.PASS);

        } else {
            GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is not verified", STATUS.FAIL);

        }
    }

    @Then("User clicks on closeButton")
    public void userClicksOnCloseBtn() {
        try{
            DriverAction.waitUntilElementAppear(Locators.skillTypeBtn, 7);
            DriverAction.click(Locators.closeBtn);
        } catch(Exception e){
            GemTestReporter.addTestStep("User clicks on close button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Given("User clicks on tab {string} and {string}")
    public void userClicksOnTabAnd(String form, String viewForm) {
        if (DriverAction.isExist(Locators.forms)) {
            DriverAction.click(Locators.forms);
            DriverAction.isExist(Locators.viewForm);
            DriverAction.click(Locators.viewForm);
        } else {
            GemTestReporter.addTestStep("User Clicks on Form", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String viewForms) {
        if (DriverAction.isExist(Locators.forms)) {
            DriverAction.isExist(Locators.viewForm);
            GemTestReporter.addTestStep("User Verifies View Forms Page ", "Form Page is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Clicks on View Form", "Click is unsuccessful", STATUS.FAIL);
        }
    }

    @Then("User verifies the presence of {string} Button")
    public void userVerifiesThePresenceOfBtn(String button) {
        if (DriverAction.isExist(Locators.previous)) {
            GemTestReporter.addTestStep("User Verifies Previous Button", "Previous Button is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Previous Button", "Previous Button is not verified", STATUS.FAIL);
        }
        if (DriverAction.isExist(Locators.next)) {
            GemTestReporter.addTestStep("User Verifies Next Button", "Next Button is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Next Button", "Next Button is not verified", STATUS.FAIL);
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {
        try {
            DriverAction.click(Locators.department);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on department", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User Clicks on {string}")
    public void userClicksOn(String accounts) {
        try {
            DriverAction.waitUntilElementAppear(Locators.accounts, 6);
            DriverAction.click(Locators.accounts);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on accounts", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        try {
            DriverAction.scrollIntoView(Locators.selectEntriesValue(element));
            DriverAction.click(Locators.selectEntriesValue(element));
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on the entries ", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        try {
            DriverAction.typeText(Locators.searchBtn, value);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on search field", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        if(DriverAction.isExist(Locators.accountsType(element))){
            DriverAction.waitUntilElementAppear(Locators.accountsType(element), 5);

        } else{
            GemTestReporter.addTestStep("User verifies the value ", "Verification is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User search field and enters invalid value {string}")
    public void userSearchFieldAndEntersInvalidValue(String value) {
        if (DriverAction.isExist(Locators.searchBtn)) {
            DriverAction.typeText(Locators.searchBtn, value + Keys.ENTER);
        } else {
            GemTestReporter.addTestStep("User enters the text", "Value is not Entered", STATUS.FAIL);

        }
    }

    @Then("User verifies the invalid value {string}")
    public void userVerifiesTheInvalidValue(String element) {
        try {
            DriverAction.waitUntilElementAppear(Locators.noDataAvailable,7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the invalid value", "Verification is Unsuccessful", STATUS.FAIL);

        }
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        try {
            DriverAction.click(Locators.eyeBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on eye button ", "Click is Unsuccessful", STATUS.FAIL);

        }
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        try {
            DriverAction.waitUntilElementAppear(Locators.policyCloseBtn, 7);
            DriverAction.click(Locators.policyCloseBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is Unsuccessful", STATUS.FAIL);
        }
    }

    @Then("User click on download image")
    public void userClickOnDownloadImage() {
        if (DriverAction.isExist(Locators.documentDownload)) {
            DriverAction.click(Locators.documentDownload);
        } else {
            GemTestReporter.addTestStep("User clicks on download image", "Download is not Entered", STATUS.FAIL);
        }
    }

    @Given("User clicks on the {string} and {string}")
    public void userClicksOnTheAnd(String forms, String myForms) {
        try {
            DriverAction.click(Locators.forms);
            DriverAction.click(Locators.myForms);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on forms button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("Verify the heading on the landing page")
    public void verifyTheHeadingOnTheLandingPage() {
        if(DriverAction.isExist(Locators.myFormsHeading)) {
            GemTestReporter.addTestStep("User clicks on search field", "Click is Successful", STATUS.PASS);

        } else {
            GemTestReporter.addTestStep("User clicks on search field", "Click is Unsuccessful", STATUS.FAIL);
        }
    }


    @When("User clicks on upload button")
    public void userClicksOnUploadBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.uploadBtn, 7);
            DriverAction.click(Locators.uploadBtn);
            DriverAction.setImplicitTimeOut(5);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on upload button", "Upload is Unsuccessful", STATUS.FAIL);

        }
    }

    @When("User Uploads the desired document {string} from {string}")
    public void userUploadTheDesiredDocument(String formType, String path) {
        try {
            DriverAction.waitUntilElementAppear(Locators.formTypeDropDown, 7);
            DriverAction.click(Locators.formTypeDropDown);
            DriverAction.waitUntilElementAppear(Locators.formType(formType), 5);
            DriverAction.click(Locators.formType(formType));
            DriverAction.waitUntilElementAppear(Locators.chooseFile, 7);
            DriverAction.fileUpload(Locators.chooseFile, path);
            DriverAction.setImplicitTimeOut(7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads the document", "Upload is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User clicks on save button")
    public void userClicksOnSaveBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.saveBtn, 6);
            DriverAction.click(Locators.saveBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on save button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }


    @And("User Uploads the undesired document {string} from {string}")
    public void userUploadTheUndesiredDocument(String formType, String path) {
        try {
            DriverAction.waitUntilElementAppear(Locators.formTypeDropDown,8);
            DriverAction.click(Locators.formTypeDropDown);
            DriverAction.waitUntilElementAppear(Locators.formType(formType), 5);
            DriverAction.click(Locators.formType(formType));
            DriverAction.fileUpload(Locators.chooseFile, path);
            DriverAction.setImplicitTimeOut(7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads invalid document", "Upload is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("Verify the {string}")
    public void verifyThe(String warningMsg) {
        try {
            DriverAction.waitUntilElementAppear(Locators.warningMsg, 5);

        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the warning message", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User clicks on ok button")
    public void userClicksOnOkbtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.okBtn, 4);
            DriverAction.click(Locators.okBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on ok button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User enters valid value in My forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        try {
            DriverAction.typeText(Locators.searchBtn, Loyalty + Keys.ENTER);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not Entered", STATUS.FAIL);

        }
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        try {
            DriverAction.typeText(Locators.searchBtn, QA + Keys.ENTER);
            DriverAction.setImplicitTimeOut(6);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not Entered", STATUS.FAIL);

        }
    }


    @When("User clicks on active form")
    public void userClicksOnActiveForm() {
        try {
            DriverAction.waitUntilElementAppear(Locators.activeForm, 5);
            DriverAction.click(Locators.activeForm);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on active form", "Click is unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User hovers and clicks on deactivate button")
    public void userHoversAndClicksOnDeactivateBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.deactivateBtn,4);
            DriverAction.click(Locators.deactivateBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on deactivate button", "Click is unsuccessful", STATUS.FAIL);

        }
    }

    @Then("User clicks on yes button")
    public void userClicksOnYesBtn() {
        if (DriverAction.isExist(Locators.yesBtn)) {
            DriverAction.waitUntilElementAppear(Locators.yesBtn, 6);
            DriverAction.click(Locators.yesBtn);
        } else {
            GemTestReporter.addTestStep("User Clicks on Yes Button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @And("User hovers and clicks on download button")
    public void userHoversAndClicksOnDownloadBtn() {
        if (DriverAction.isExist(Locators.downloadBtn)) {
            DriverAction.waitSec(5);
            DriverAction.click(Locators.downloadBtn);
        } else {
            GemTestReporter.addTestStep("User Clicks on Download Button", "Click is Unsuccessful", STATUS.FAIL);
        }
    }

    @When("User validates the error message as {string}")
    public void userValidatesTheErrorMessageAs(String element) {
        DriverAction.waitUntilElementAppear(Locators.errorMsg, 7);
        try {
            DriverAction.click(Locators.errorMsg);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User validates the error message", "Validation is Unsuccessful", STATUS.FAIL);

        }
    }

}
