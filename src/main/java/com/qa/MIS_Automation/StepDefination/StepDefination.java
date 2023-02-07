package com.qa.MIS_Automation.StepDefination;

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

public class StepDefination {
    @Given("User enters Username as {string}")
    public void userEntersUsernameAs(String userName) {
        DriverAction.typeText(Locators.userName,userName);
    }

    @And("User enters Password as {string}")
    public void userEntersPasswordAs(String password) {
        DriverAction.typeText(Locators.password,password);
    }

    @Then("User clicks on sign in")
    public void userClicksOnSignIn() {
        DriverAction.click(Locators.bttnSignUp);
    }

    @And("User Verifies Landing Page")
    public void userVerifiesLandingPage() {
        DriverAction.setImplicitTimeOut(6);
        DriverAction.isExist(Locators.geminiLogo);
        System.out.println("Gemini Logo is present");
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
        DriverAction.click(Locators.forms);
        DriverAction.click(Locators.viewForm);
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String viewForms) {
        DriverAction.isExist(Locators.forms);
        System.out.println("Forms is successfully opened");
        DriverAction.isExist(Locators.viewForm);
        System.out.println("View Forms is successfully opened");
    }

    @Then("User verifies the presence of {string} Btn")
    public void userVerifiesThePresenceOfBtn(String button) {
        if(DriverAction.isExist(Locators.previous)){
            System.out.println("Previous is present");
        }
        else{
            System.out.println("Previous button not found");
        }
        if (DriverAction.isExist(Locators.next)){
            System.out.println("Next button is present");
        }
        else {
            System.out.println("Next Button not found");
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {
        DriverAction.click(Locators.department);
    }

    @Then("User Clicks on {string}")
    public void userClicksOn(String accounts) {
        DriverAction.waitUntilElementAppear(Locators.accounts,6);
   DriverAction.click(Locators.accounts);
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        DriverAction.scrollIntoView(Locators.selectEntriesValue(element));
        DriverAction.click(Locators.selectEntriesValue(element));
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        DriverAction.typeText(Locators.searchBtn,value);
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        DriverAction.waitUntilElementAppear(Locators.accountsType(element),5);
        DriverAction.isExist(Locators.accountsType(element));
    }

    @Then("User search field and enters invalid value {string}")
    public void userSearchFieldAndEntersInvalidValue(String value) {
        DriverAction.typeText(Locators.searchBtn,value+Keys.ENTER);
    }

    @Then("User verifies the invalid value {string}")
    public void userVerifiesTheInvalidValue(String arg0) {
        DriverAction.isExist(Locators.noDataAvailable);
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        DriverAction.click(Locators.eyeBtn);
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        DriverAction.waitSec(4);
        DriverAction.click(Locators.policyCloseBtn);
    }

    @Then("User click on download image")
    public void userClickOnDownloadImage() {
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
        DriverAction.waitUntilElementAppear(Locators.uploadBtn,5);
        DriverAction.click(Locators.uploadBtn);
    }

    @When("User Upload the desired document {string}")
    public void userUploadTheDesiredDocument(String formType) {
        DriverAction.waitSec(3);
        DriverAction.click(Locators.formTypeDropDown);
        DriverAction.waitUntilElementAppear(Locators.formType(formType),5);
        DriverAction.click(Locators.formType(formType));
        DriverAction.waitSec(3);
        DriverAction.fileUpload(Locators.chooseFile, "C:\\Users\\sh.singh9\\Desktop\\MIS GemJar\\MIS_Automation_GemJar - Final\\src\\main\\resources\\Loyalty Redemption Form.pdf");
        DriverAction.waitSec(4);
    }
    @Then("User clicks on save btn")
    public void userClicksOnSaveBtn() {
        DriverAction.click(Locators.saveBtn);
        DriverAction.waitSec(3);
    }


    @And("User Upload the undesired document {string}")
    public void userUploadTheUndesiredDocument(String formType) {
        DriverAction.waitSec(3);
        DriverAction.click(Locators.formTypeDropDown);
        DriverAction.waitUntilElementAppear(Locators.formType(formType),5);
        DriverAction.click(Locators.formType(formType));
        DriverAction.waitSec(3);
        DriverAction.fileUpload(Locators.chooseFile, "C:\\Users\\sh.singh9\\Desktop\\MIS GemJar\\MIS_Automation_GemJar - Final\\src\\main\\resources\\17 may.docx");
        DriverAction.waitSec(4);
    }

    @Then("Verify the {string}")
    public void verifyThe(String warningMsg) {
        DriverAction.waitUntilElementAppear(Locators.warningMsg,5);
        System.out.println("Error msg appeared");
    }

    @Then("User clicks on okbtn")
    public void userClicksOnOkbtn() {
        DriverAction.waitUntilElementAppear(Locators.okBtn,4);
        DriverAction.click(Locators.okBtn);
    }

    @Then("User enters valid value in My forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        DriverAction.typeText(Locators.searchBtn,Loyalty+Keys.ENTER);
        DriverAction.waitSec(3);
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        DriverAction.typeText(Locators.searchBtn,QA+Keys.ENTER);
        DriverAction.waitSec(3);
    }

}
