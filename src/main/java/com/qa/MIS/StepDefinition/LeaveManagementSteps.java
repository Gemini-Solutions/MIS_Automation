package com.qa.MIS.StepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.MIS.Locators.LeaveManagementLocators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class LeaveManagementSteps {

    @Given("User is logged into MIS using username and password")
    public void userIsLoggedIntoMISUsingUsernameAndPassword(DataTable credTable) {
        List<Map<String, String>> credentials = credTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");
        DriverAction.typeText(LeaveManagementLocators.input_loginUsername, username, "username");
        DriverAction.typeText(LeaveManagementLocators.input_loginPassword, password, "password");
        DriverAction.click(LeaveManagementLocators.button_SignIn, "sign in");
    }

    @When("User is on MIS Home Page")
    public void userIsOnMISHomePage() {
        String expectedURL = "https://mymis.geminisolutions.com/Dashboard/Index";
        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.urlToBe(expectedURL));
        if (DriverAction.getCurrentURL().equals(expectedURL)) {
            GemTestReporter.addTestStep("Verifying Page URL",
                    "URL matching passed.\nExpected URL - " + expectedURL +
                            "\nActual URL - " + DriverAction.getCurrentURL(), STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Page URL",
                    "URL matching failed.\nExpected URL - " + expectedURL +
                            "\nActual URL - " + DriverAction.getCurrentURL(), STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("User clicks on {string} sub tab of {string} tab in MIS")
    public void userClicksOnSubTabOfTabInMIS(String childTab, String parentTab) {
        DriverAction.waitSec(2);
        DriverAction.click(LeaveManagementLocators.menu_parentTabs(parentTab), parentTab);
        DriverAction.waitSec(2);
        DriverAction.click(LeaveManagementLocators.menu_childTabs(childTab), childTab);
    }

    @And("Verify {string} of {string} tab")
    public void verifyOfTab(String expectedHeading, String childTab) {
        DriverAction.waitUntilElementAppear(LeaveManagementLocators.heading_Page, 10);
        String actualHeading = DriverAction.getElementText(LeaveManagementLocators.heading_Page);
        if (actualHeading.equals(expectedHeading)) {
            GemTestReporter.addTestStep("Verifying Heading",
                    "Heading matching passed.\nExpected Heading - " + expectedHeading +
                            "\nActual Heading - " + actualHeading, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Heading",
                    "Heading matching failed.\nExpected Heading - " + expectedHeading +
                            "\nActual Heading - " + actualHeading, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("User clicks on {string} Tab")
    public void userClicksOnTab(String tabs) {
        DriverAction.waitSec(2);
        DriverAction.click(LeaveManagementLocators.navigation_tabs(tabs), tabs);
    }

    @And("Verify {string} displays")
    public void verifyDisplays(String tab) {
        DriverAction.waitSec(2);
        List<String> expectedFields = null;
        String id = null;
        switch (tab) {
            case "Leave":
                id = "tabApplyLeave";
                expectedFields = Arrays.asList("From*", "Till*", "Reason*", "Primary contact number*",
                        "Other contact number", "Availability on");
                break;
            case "Work From Home":
                id = "tabApplyWFH";
                expectedFields = Arrays.asList("Date*", "Reason*", "Mobile No.*");
                break;
            case "Comp Off":
                id = "tabApplyCompOff";
                expectedFields = Arrays.asList("Date*", "Reason*");
                break;
            case "Out Duty/Tour":
                id = "tabLWPChangeRequest";
                expectedFields = Arrays.asList("From*", "Till*", "Type*", "Reason*", "Primary contact number*",
                        "Other contact number");
                break;
            case "LWP Change Request":
                id = "tabApplyOuting";
                expectedFields = Arrays.asList("Date*", "Type of leave*", "Reason*");
                break;
        }

        List<String> actualFields =
                DriverAction.getElementsText(LeaveManagementLocators.title_LeaveFields(id));
        if (actualFields.equals(expectedFields)) {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching passed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching failed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on submit button for {string}")
    public void userClicksOnSubmitButtonFor(String tab) {
        DriverAction.waitSec(2);
        String id = null;

        switch (tab) {
            case "Leave":
                id = "tabApplyLeave";
                break;
            case "Work From Home":
                id = "tabApplyWFH";
                break;
            case "Comp Off":
                id = "tabApplyCompOff";
                break;
            case "Out Duty/Tour":
                id = "tabLWPChangeRequest";
                break;
            case "LWP Change Request":
                id = "tabApplyOuting";
                break;
        }

        DriverAction.click(LeaveManagementLocators.button_leaveSubmit(id), "Submit");
    }

    @And("Verify mandatory {string} field for {string}")
    public void verifyMandatoryFieldFor(String fieldType, String field) {
        String classValue = null;
        switch (fieldType) {
            case "dropdown":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocators.field_leaveDropDown(field),
                                "class");
                break;
            case "textField":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocators.field_leaveTextFields(field),
                                "class");
                break;
            case "textArea":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocators.field_leaveTextArea(field),
                                "class");
                break;
        }
        if (classValue.contains("error-validation")) {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("select compOff date {int} for {string} field")
    public void selectCompOffDateDateIndexFromDateField(Integer index, String field) {
        DriverAction.dropDown(LeaveManagementLocators.field_leaveDropDown(field), index);
    }

    @Then("enter compOff reason {string} for {string} field")
    public void enterCompOffReasonForField(String message, String field) {
        DriverAction.typeText(LeaveManagementLocators.field_leaveTextArea(field), message, "reason");
    }
}
