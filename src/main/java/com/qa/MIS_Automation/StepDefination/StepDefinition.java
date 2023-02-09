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

import static sun.security.ssl.SSLLogger.info;


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
            DriverAction.waitUntilElementAppear(Locators.skillBtn, 7);
            DriverAction.click(Locators.closeBtn);
        } catch(Exception e){
            info("An exception occured while clicking closeBtn !", e);
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
            GemTestReporter.addTestStep("User Verifies Previous Btn", "Previous Btn is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Previous Btn", "Previous Btn is not verified", STATUS.FAIL);
        }
        if (DriverAction.isExist(Locators.next)) {
            GemTestReporter.addTestStep("User Verifies Next Btn", "Next Btn is verified", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("User Verifies Next Btn", "Next Btn is not verified", STATUS.FAIL);
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {
        try {
            DriverAction.isExist(Locators.department);
            DriverAction.click(Locators.department);
        } catch (Exception e) {
            info("An exception occured while clicking department !", e);
        }
    }

    @Then("User Clicks on {string}")
    public void userClicksOn(String accounts) {
        try {
            DriverAction.waitUntilElementAppear(Locators.accounts, 6);
            DriverAction.click(Locators.accounts);
        } catch (Exception e) {
            info("An exception occured while clicking accounts !", e);
        }
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        try {
            DriverAction.isExist(Locators.selectEntriesValue(element));
            DriverAction.scrollIntoView(Locators.selectEntriesValue(element));
            DriverAction.click(Locators.selectEntriesValue(element));
        } catch (Exception e) {
            info("An exception occured while entering element !", e);
        }
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        try {
            DriverAction.isExist(Locators.searchBtn);
            DriverAction.typeText(Locators.searchBtn, value);
        } catch (Exception e) {
            info("An exception occured while entering value !", e);
        }
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        try {
            DriverAction.waitUntilElementAppear(Locators.accountsType(element), 5);
            DriverAction.isExist(Locators.accountsType(element));
        } catch (Exception e) {
            info("An exception occured while entering value !", e);
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
            DriverAction.isExist(Locators.noDataAvailable);
        } catch (Exception e) {
            info("An exception occured while verifying the value !", e);
        }
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        try {
            DriverAction.isExist(Locators.eyeBtn);
            DriverAction.click(Locators.eyeBtn);
        } catch (Exception e) {
            info("An exception occured while clicking eyeBtn !", e);
        }
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        try {
            DriverAction.waitUntilElementAppear(Locators.policyCloseBtn, 7);
            DriverAction.click(Locators.policyCloseBtn);
        } catch (Exception e) {
            info("An exception occured while viewing policy !", e);
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
            info("An exception occured while clicking  forms !", e);
        }
    }

    @Then("Verify the heading on the landing page")
    public void verifyTheHeadingOnTheLandingPage() {
        try {
            DriverAction.isExist(Locators.myFormsHeading);

        } catch (Exception e) {
            info("An exception occured while landing on the page !", e);
        }
    }


    @When("User clicks on upload button")
    public void userClicksOnUploadBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.uploadBtn, 7);
            DriverAction.click(Locators.uploadBtn);
            DriverAction.setImplicitTimeOut(5);
        } catch (Exception e) {
            info("An exception occured while clicking  uploadBtn !", e);
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
            info("An exception occured while uploading document !", e);
        }
    }

    @Then("User clicks on save button")
    public void userClicksOnSaveBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.saveBtn, 6);
            DriverAction.isExist(Locators.saveBtn);
            DriverAction.click(Locators.saveBtn);
        } catch (Exception e) {
            info("An exception occured while clicking saveBtn !", e);
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
            info("An exception occured while uploading document !", e);
        }
    }

    @Then("Verify the {string}")
    public void verifyThe(String warningMsg) {
        try {
            DriverAction.waitUntilElementAppear(Locators.warningMsg, 5);

        } catch (Exception e) {
            info("An exception occured while verifying warningMsg !", e);
        }
    }

    @Then("User clicks on ok button")
    public void userClicksOnOkbtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.okBtn, 4);
            DriverAction.click(Locators.okBtn);
        } catch (Exception e) {
            info("An exception occured while clicking  okBtn !", e);
        }
    }

    @Then("User enters valid value in My forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        try {
            DriverAction.isExist(Locators.searchBtn);
            DriverAction.typeText(Locators.searchBtn, Loyalty + Keys.ENTER);
        } catch (Exception e) {
            info("An exception occured while entering the loyalty !", e);
        }
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        try {
            DriverAction.isExist(Locators.searchBtn);
            DriverAction.typeText(Locators.searchBtn, QA + Keys.ENTER);
            DriverAction.setImplicitTimeOut(6);
        } catch (Exception e) {
            info("An exception occured while entering QA !", e);
        }
    }


    @When("User clicks on active form")
    public void userClicksOnActiveForm() {
        try {
            DriverAction.waitUntilElementAppear(Locators.activeForm, 5);
            DriverAction.isExist(Locators.activeForm);
            DriverAction.click(Locators.activeForm);
        } catch (Exception e) {
            info("An exception occured while clicking active form !", e);
        }
    }

    @Then("User hovers and clicks on deactivate button")
    public void userHoversAndClicksOnDeactivateBtn() {
        try {
            DriverAction.waitUntilElementAppear(Locators.deactivateBtn,4);
            DriverAction.click(Locators.deactivateBtn);
        } catch (Exception e) {
            info("An exception occured while clicking deactivate Btn !", e);
        }
    }

    @Then("User clicks on yes button")
    public void userClicksOnYesBtn() {
        if (DriverAction.isExist(Locators.yesBtn)) {
            DriverAction.waitUntilElementAppear(Locators.yesBtn, 6);
            DriverAction.click(Locators.yesBtn);
        } else {
            GemTestReporter.addTestStep("User Clicks on Yes Btn", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @And("User hovers and clicks on download button")
    public void userHoversAndClicksOnDownloadBtn() {
        if (DriverAction.isExist(Locators.downloadBtn)) {
            DriverAction.waitUntilElementAppear(Locators.downloadBtn, 8);
            DriverAction.isExist(Locators.downloadBtn);
            DriverAction.click(Locators.downloadBtn);
        } else {
            GemTestReporter.addTestStep("User Clicks on Download Btn", "Click is Unsuccessful", STATUS.FAIL);
        }
    }

    @When("User validates the error message as {string}")
    public void userValidatesTheErrorMessageAs(String element) {
        DriverAction.waitUntilElementAppear(Locators.errorMsg, 7);
        try {
            DriverAction.click(Locators.errorMsg);
        } catch (Exception e) {
            info("An exception occured while getting error message !", e);
        }
    }
}
