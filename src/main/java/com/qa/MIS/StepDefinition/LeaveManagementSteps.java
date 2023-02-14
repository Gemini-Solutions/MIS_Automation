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
import io.cucumber.java.ht.Le;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LeaveManagementSteps {

    static int halfDayLeaveCount = 0;
    static String totalWorkingDaysBeforeApplyingHalfDay = null;

    @Given("User is logged into MIS using username and password")
    public void userIsLoggedIntoMISUsingUsernameAndPassword(DataTable credTable) {
        List<Map<String, String>> credentials = credTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");
        if (DriverAction.isExist(LeaveManagementLocators.input_loginUsername)) {
            DriverAction.typeText(LeaveManagementLocators.input_loginUsername, username, "username");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to enter text in username", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(LeaveManagementLocators.input_loginPassword)) {
            DriverAction.typeText(LeaveManagementLocators.input_loginPassword, password, "password");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to enter text in password", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(LeaveManagementLocators.button_SignIn)) {
            DriverAction.click(LeaveManagementLocators.button_SignIn, "sign in");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on Login", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
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
//        DriverAction.waitUntilElementAppear(By.xpath("//h3[@class='panel-title']"), 10);

        DriverAction.waitSec(3);
        DriverAction.waitUntilElementAppear(LeaveManagementLocators.menu_parentTabs(parentTab), 10);
        if (DriverAction.isExist(LeaveManagementLocators.menu_parentTabs(parentTab))) {
            DriverAction.click(LeaveManagementLocators.menu_parentTabs(parentTab), parentTab);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on " + parentTab, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        DriverAction.waitUntilElementAppear(LeaveManagementLocators.menu_parentTabs(parentTab), 10);
        if (DriverAction.isExist(LeaveManagementLocators.menu_childTabs(childTab))) {
            DriverAction.click(LeaveManagementLocators.menu_childTabs(childTab), childTab);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on " + childTab, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
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
        if (tabs.equals("Out Duty/Tour")) {
            tabs = " Out Duty/Tour";
        }
        DriverAction.click(LeaveManagementLocators.navigation_tabs(tabs), tabs);

    }

    @And("Verify {string} is displayed")
    public void verifyTabIsDisplayed(String tab) {
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
                id = "tabApplyOuting";
                expectedFields = Arrays.asList("From*", "Till*", "Type *", "Reason*", "Primary contact " +
                        "number*", "Other contact number");
                break;
            case "LWP Change Request":
                id = "tabLWPChangeRequest";
                expectedFields = Arrays.asList("In case of LWP marked by system", "Date:*", "Type of " +
                        "leave*", "Reason*");
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
                id = "tabApplyOuting";
                break;
            case "LWP Change Request":
                id = "tabLWPChangeRequest";
                break;
        }
        if (DriverAction.isExist(LeaveManagementLocators.button_leaveSubmit(id))) {
            DriverAction.click(LeaveManagementLocators.button_leaveSubmit(id), "Submit");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on submit", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
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
            case "calender":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocators.field_leaveCalender(field),
                                "class");
                break;
            case "outingCalender":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocators.field_outingCalender(field),
                                "class");
        }
        if (classValue.contains("error-validation")) {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Select compOff date {int} for {string} field")
    public void selectCompOffDateDateIndexFromDateField(Integer index, String field) {
        if (DriverAction.isExist(LeaveManagementLocators.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocators.field_leaveDropDown(field), index);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @Then("Enter compOff reason {string} for {string} field")
    public void enterCompOffReasonForField(String message, String field) {
        if (DriverAction.isExist(LeaveManagementLocators.field_leaveTextArea(field))) {
            DriverAction.typeText(LeaveManagementLocators.field_leaveTextArea(field), message, "reason");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify popup with message {string} and {string}")
    public void verifyPopupWithMessageAnd(String alertType, String alertMessage) {
        String expectedAlertType = DriverAction.getElementText(LeaveManagementLocators.heading_alertType);
        String expectedAlertMessage = DriverAction.getElementText(LeaveManagementLocators.text_alertMessage);

        if (expectedAlertType.equals(alertType)) {
            GemTestReporter.addTestStep("Verifying Alert Type",
                    "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType +
                            "\nActual Alert Type - " + alertType, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Type",
                    "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType +
                            "\nActual Alert Type - " + alertType, STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (expectedAlertMessage.equals(alertMessage)) {
            GemTestReporter.addTestStep("Verifying Alert Message",
                    "Alert Message matching passed.\nExpected Alert Message - " + expectedAlertMessage +
                            "\nActual Alert Message - " + alertMessage, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Message",
                    "Alert Message matching failed.\nExpected Alert Message - " + expectedAlertMessage +
                            "\nActual Alert Message - " + alertMessage, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify auto populated {string} field for {string}")
    public void verifyAutoPopulatedFieldFor(String fieldType, String field) {
        String defaultText = null;
        switch (fieldType) {
            case "textField":
                defaultText =
                        DriverAction.getElementText(LeaveManagementLocators.field_leaveTextFields(field));
                break;
        }
        if (!defaultText.equals(null)) {
            GemTestReporter.addTestStep("Verifying Default Fields",
                    field + "Fields having default values", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    field + "Fields not having default values", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Enter leave {string} for {string} field")
    public void enterLeaveForField(String date, String field) {
        String elementLabel = field.contains("FromDate") ? "From date" : "Till date";
        // date format == mm/dd/yyyy
        String[] dateArray = date.split("/");
        DriverAction.click(LeaveManagementLocators.field_leaveCalender(field), elementLabel);

        DriverAction.click(LeaveManagementLocators.datePicker_switchMonth);

        List<WebElement> monthElements = DriverAction.getElements(LeaveManagementLocators.datePicker_month);
        int monthNumber = Integer.parseInt(dateArray[0]);

        DriverAction.click(monthElements.get(monthNumber - 1), "month");
        List<WebElement> dayElements = DriverAction.getElements(LeaveManagementLocators.datePicker_day);

        for (WebElement day : dayElements) {
            if (DriverAction.getElementText(day).equals(dateArray[1])) {
                DriverAction.click(day, "day");
                break;
            }
        }

    }

    @And("Click total working days tool tip")
    public void clickTotalWorkingDaysToolTip() {
        DriverAction.waitSec(5);
//        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
//                .until(ExpectedConditions.elementToBeClickable(LeaveManagementLocators.button_tooltip));
        if (DriverAction.isExist(LeaveManagementLocators.button_tooltip)) {
//            DriverAction.click(LeaveManagementLocators.button_tooltip, "tooltip");
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("arguments[0].click();",
                    DriverAction.getElement(LeaveManagementLocators.button_tooltip));
            GemTestReporter.addTestStep("clicked on tool tip", "Pass", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Fail to click on tool tip", "Fail", STATUS.FAIL);
        }
    }

    @And("Verify tooltip message {string}")
    public void verifyTooltipMessage(String message) {
//        String expectedMessage = DriverAction.getAttributeName(LeaveManagementLocators.button_tooltip,
//                "data-content");
        DriverAction.waitSec(5);
        String expectedMessage = DriverAction.getElementText(LeaveManagementLocators.message_tooltip);
        if (expectedMessage.equals(message)) {
            GemTestReporter.addTestStep("Verifying ToolTip Message",
                    "ToolTip Message matching passed.\nExpected ToolTip Message - " + expectedMessage +
                            "\nActual ToolTip Message - " + message, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying ToolTip Message",
                    "ToolTip Message matching failed.\nExpected ToolTip Message - " + expectedMessage +
                            "\nActual ToolTip Message - " + message, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Select half day leave for {string}")
    public void SelectHalfDayLeaveFor(String halfDayOptions) {
        String[] options = halfDayOptions.split(",");
        halfDayLeaveCount = options.length;
        DriverAction.waitSec(2);
        totalWorkingDaysBeforeApplyingHalfDay = DriverAction.getElementText(LeaveManagementLocators.label_totalWorkingDays);
        for (String opt : options) {
            String elementLabel = (opt.trim()).equals("isLeaveFirstHalfDay") ? "FirstHalfDay" : "LastHalfDay";
            DriverAction.click(LeaveManagementLocators.checkbox_halfDayLeaveOption(opt.trim()), elementLabel);
        }

    }

    @And("Verify effective total working days")
    public void verifyEffectiveTotalWorkingDays() {
        String totalWorkingDaysAfterApplyingHalfDay =
                DriverAction.getElementText(LeaveManagementLocators.label_totalWorkingDays);

        String actualWorkingDays = null;
        if (halfDayLeaveCount == 1) {
            double wd = Integer.parseInt(totalWorkingDaysBeforeApplyingHalfDay) - 0.5;
            actualWorkingDays = Double.toString(wd);
        } else {
            int wd = Integer.parseInt(totalWorkingDaysBeforeApplyingHalfDay) - 1;
            actualWorkingDays = Integer.toString(wd);
        }

        if (actualWorkingDays.equals(totalWorkingDaysAfterApplyingHalfDay)) {
            GemTestReporter.addTestStep("Verifying Total Working Days",
                    "Total Working Days matching passed.\nExpected Total Working Days - " +
                            totalWorkingDaysAfterApplyingHalfDay + "\nActual Total Working Days - " +
                            actualWorkingDays, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Total Working Days",
                    "Total Working Days matching failed.\nExpected Total Working Days - " +
                            totalWorkingDaysAfterApplyingHalfDay + "\nActual Total Working Days - " +
                            actualWorkingDays, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Select leave type {int} for {string} field")
    public void selectLeaveTypeForField(int options, String field) {
        DriverAction.waitUntilElementAppear(LeaveManagementLocators.field_leaveDropDown(field), 20);
        if (DriverAction.isExist(LeaveManagementLocators.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocators.field_leaveDropDown(field), options);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Enter leave reason {string} for {string} field")
    public void enterLeaveReasonForField(String message, String field) {
        DriverAction.waitSec(1);
        if (DriverAction.isExist(LeaveManagementLocators.field_leaveTextArea(field))) {
            DriverAction.typeText(LeaveManagementLocators.field_leaveTextArea(field), message, "reason");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type text in reason", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Select availability for {string} field")
    public void selectAvailabilityForField(String field) {
        String[] availability = field.split(",");
        for (String aval : availability) {
            if (DriverAction.isExist(LeaveManagementLocators.field_leaveCheckBox(aval.trim()))) {
                DriverAction.click(LeaveManagementLocators.field_leaveCheckBox(aval.trim()), aval);
            } else {
                GemTestReporter.addTestStep("Error Occur", "Fail to click availability", STATUS.FAIL,
                        DriverAction.takeSnapShot());
            }
        }
    }

    @Then("Enter outing {string} for {string} field")
    public void enterOutingForField(String date, String field) {
        String elementLabel = field.contains("FromDate") ? "From date" : "Till date";
        // date format == mm/dd/yyyy
        String[] dateArray = date.split("/");
        DriverAction.click(LeaveManagementLocators.field_outingCalender(field), elementLabel);

        DriverAction.click(LeaveManagementLocators.datePicker_switchMonth);

        List<WebElement> monthElements = DriverAction.getElements(LeaveManagementLocators.datePicker_month);
        int monthNumber = Integer.parseInt(dateArray[0]);

        DriverAction.click(monthElements.get(monthNumber - 1), "month");
        List<WebElement> dayElements = DriverAction.getElements(LeaveManagementLocators.datePicker_day);

        for (WebElement day : dayElements) {
            if (DriverAction.getElementText(day).equals(dateArray[1])) {
                DriverAction.click(day, "day");
                break;
            }
        }
    }
}
