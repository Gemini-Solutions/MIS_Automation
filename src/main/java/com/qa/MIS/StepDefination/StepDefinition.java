package com.qa.MIS.StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS.Locators.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class StepDefinition {
    Logger logger = LoggerFactory.getLogger(StepDefinition.class);
    public String mainWindowHandle = null;
    Boolean output = false;
    STATUS status;


    @Given("^Launch MIS Url (.+)$")
    public void launch_MIS_Url(String url) {
        DriverAction.waitSec(3);
        String currenturl = DriverAction.getCurrentURL();
        if (currenturl.equals(url))
           GemTestReporter.addTestStep("Url Validation", "Successful<br>Expected URL: " + url + "<br>Actual URL: " + currenturl, STATUS.PASS, DriverAction.takeSnapShot());
       // else
         //   GemTestReporter.addTestStep("Url Validation", "Unsuccessful<br>Expected URL: " + url + "<br>Actual URL: " + currenturl, STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Enter Username (.+) and password (.+)$")
    public void enter_username_and_password(String userName, String password) {
        status = DriverAction.typeText(Locator.txtUserName, userName);
     //   GemTestReporter.addTestStep("Enter User Name", "User name is entered", status, DriverAction.takeSnapShot());
        status = DriverAction.typeText(Locator.txtPassword, password);
    //    GemTestReporter.addTestStep("Enter Password", "Password is entered", status, DriverAction.takeSnapShot());
    }

    @Then("User clicks on Sign-in button")
    public void user_clicks_on_signIn_button() {
        status = DriverAction.click(Locator.btnSignIn);
      //  GemTestReporter.addTestStep("User clicks on Sign-in button", "Successfully clicked on Sign in button", status, DriverAction.takeSnapShot());
        mainWindowHandle = DriverAction.getWindowHandle();
    }

    @Then("Login will be successful and homepage will be displayed.")
    public void login_will_be_successful_and_homepage_will_be_displayed() {
        try {
//            DriverAction.switchToWindow(mainWindowHandle);
//            String string = DriverAction.getWindowHandle();
            DriverAction.waitSec(7);
            Boolean bool = DriverAction.getElement(Locator.homePageLogo).isDisplayed();
            STATUS status;
            if (bool)
                status = STATUS.PASS;
            else
                status = STATUS.FAIL;
         //   GemTestReporter.addTestStep("Login will be successful and homepage will be displayed ", "Successfully logged in", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occured !", e);
         //   GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @When("User click on Sign-in button")
    public void user_click_on_sign_in_button() {
        try {
            DriverAction.waitUntilElementAppear(Locator.btnSignIn,3);
            DriverAction.click(Locator.btnSignIn);
        } catch (Exception e) {
            logger.info("An exception occured !", e);
         //   GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @Then("Login failed pop up will be displayed")
    public void login_failed_pop_up_will_be_displayed() {
        try {

            Boolean bool = DriverAction.getElement(Locator.errorUserName).isDisplayed();
            STATUS status;
            if (bool)
                status = STATUS.PASS;
            else
                status = STATUS.FAIL;
          //  GemTestReporter.addTestStep("Failure Pop Up", "Expected : should be displayed", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occured !", e);
          //  GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @When("Click on Appraisal Management link")
    public void click_on_appraisal_management_link() {
        DriverAction.waitUntilElementAppear(Locator.lnkApraisalMgmnt,3);
        status = DriverAction.click(Locator.lnkApraisalMgmnt);
    //    GemTestReporter.addTestStep("Click on Appraisal Management link", "Appraisal Management link is clicked", status, DriverAction.takeSnapShot());
    }

    @Then("Click on Add Goals link")
    public void click_on_add_goals_link() {
        DriverAction.waitUntilElementAppear(Locator.lnkAddGoals,2);
        status = DriverAction.click(Locator.lnkAddGoals);
       // GemTestReporter.addTestStep("Click on Add Goals link", "Add Goals link is clicked", status, DriverAction.takeSnapShot());
    }

    @Then("Verify Add goal window")
    public void verify_add_goal_window() {
        output = false;
        output = DriverAction.getElement(Locator.addGoalsWindow).isDisplayed();
        if (output)
            status = STATUS.PASS;
        else
            status = STATUS.FAIL;
       // GemTestReporter.addTestStep("Verify Add goal window", "Add goal window should be displayed", status, DriverAction.takeSnapShot());
    }

    @Then("Verify financial year dropdown")
    public void verify_financial_year_dropdown() {
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        int year = Year.now().getValue();
        cal.set(year - 1, 3, 1);
        Date firstAprilOfYear = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMM yyyy");

        String date1 = format1.format(firstAprilOfYear);
        System.out.println(date1);

        status = DriverAction.click(Locator.drpdownFinancialYear);
        List<WebElement> lstFinacialYr = DriverAction.getElements(Locator.elementsdrpFinancialYear);
        for (int i = 0; i < lstFinacialYr.size(); i++) {
            String str = lstFinacialYr.get(i).getText();
            if (str.equalsIgnoreCase("All") || str.contains(date1))
                status = STATUS.PASS;
            if (status == STATUS.FAIL)
                break;
        }
       // GemTestReporter.addTestStep("Verify financial year dropdown", "Dropdown should have Current Finacial Year", status, DriverAction.takeSnapShot());
    }

    @Then("Verify link for list of KRAs and KPIs")
    public void verify_link_for_list_of_kr_as_and_kp_is() {
        status = DriverAction.click(Locator.lnkKRA_KPI);
      //  GemTestReporter.addTestStep("Verify link for list of KRAs and KPIs", "List of KRAs and KPIs link is clicked", status, DriverAction.takeSnapShot());
    }

    @Then("Add new KPI-KRA mapping in add goal window")
    public void add_new_kpi_kra_mapping_in_add_goal_window() {
        DriverAction.click(Locator.btnAddNewKRAKPIMapping);
        String title = DriverAction.getElementText(Locator.titleAddGoal);
        if (title.equalsIgnoreCase("Add goal"))
            status = STATUS.PASS;
      //  GemTestReporter.addTestStep("Verify title for Add goal window", "Title matched", status, DriverAction.takeSnapShot());
        DriverAction.click(Locator.drpdownGoalType);
        List<WebElement> lstKRA = DriverAction.getElements(Locator.kRAList);
        lstKRA.get(2).click();
        DriverAction.typeText(Locator.txtKRA, "TestKRA");
    }

    @Then("validate add KPI button")
    public void validate_add_kpi_button() {
        DriverAction.click(Locator.btnAddKPI);
        if (DriverAction.getElement(Locator.txtKPIDescription).isDisplayed()) {
            DriverAction.typeText(Locator.txtKPIDescription, "TestKPI");
            status = STATUS.PASS;
        } else
            status = STATUS.FAIL;
    //    GemTestReporter.addTestStep("Validate add KPI button", "KPA button is present and clickable", status, DriverAction.takeSnapShot());
        if (DriverAction.getElement(Locator.btnSubmit).isDisplayed()) {
            DriverAction.click(Locator.btnSubmit);
            status = STATUS.PASS;
        }
        DriverAction.click(Locator.KPISuccessOK);
      //  GemTestReporter.addTestStep("Add new KPI-KRA mapping in add goal window", "New KPI-KRA mapping in add goal window added", status, DriverAction.takeSnapShot());
    }

    @Then("Verify warning popup appears when KPI-KRA fields are left empty")
    public void verify_warning_popup_appears_when_kpi_kra_fields_are_left_empty() {

    }

}