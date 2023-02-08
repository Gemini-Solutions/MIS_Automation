package com.qa.MIS.StepDefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarUtils;
import com.qa.MIS.Locators.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(StepDefinition.class);

    @Given("^User is on the MIS Login Page$")
    public void userIsOnTheMISLoginPage() {
        if (!DriverAction.isExist(Locators.geminiLogo)) {
            logger.info("Gemini Logo not Present and User is not on MIS Homepage");
            Assert.fail("Gemini Logo not Present and User is not on MIS Homepage");
        }
    }

    @When("^User enters their login details and logs in$")
    public void userEntersLoginDetails() {
        DriverAction.typeText(Locators.txtUserName, GemJarUtils.getGemJarConfigData("username"));
        DriverAction.typeText(Locators.txtPassword, GemJarUtils.getGemJarConfigData("password"));
        DriverAction.click(Locators.buttonLogin,"User clicks on Sign-in button","Click on Sign-in button was a success");
    }

    @Then("^User clicks on LNSA from left menu panel$")
    public void userClicksOnLNSA() {
        try {
            DriverAction.waitUntilElementAppear(Locators.LNSA_HOME, 10);
            DriverAction.click(Locators.LNSA_HOME);
        } catch (Exception e) {
            Assert.fail("Unable to find LNSA Home and unable to click on it");
        }
    }

    @And("^User selects Apply LNSA from menu panel$")
    public void userSelectsFromMenuPanel() {
        try {
            DriverAction.waitUntilElementAppear(Locators.LNSA_APPLY_LNSA, 5);
            DriverAction.click(Locators.LNSA_APPLY_LNSA);
        } catch (Exception e) {
            logger.info("Unable to find LNSA Home and unable to click on it");
            Assert.fail("Unable to find LNSA Home and unable to click on it");
        }

    }

    @Then("^User tries to move to the previous date$")
    public void userTriesToMoveToThePreviousDate() throws ParseException, InterruptedException {
        try {
            DriverAction.waitUntilElementAppear(Locators.LNSA_START_DATE, 5);
        } catch (Exception e) {
            logger.info("Couldn't load Apply LNSA page");
            Assert.fail("Couldn't load Apply LNSA page");
        }
        if (DriverAction.isExist(Locators.LNSA_PREVIOUS_BUTTON)) {
            String startDate = DriverAction.getElementText(Locators.LNSA_START_DATE);
            Date startDate1 = new Date();
            try{
                startDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(startDate);
            }
            catch(Exception e){
                logger.info("Invalid format for start date found, could not parse the date. Date found: " +startDate);
                Assert.fail("Invalid format for start date found, could not parse the date. Date found: " +startDate);
            }
            DriverAction.click(Locators.LNSA_PREVIOUS_BUTTON, "User clicks on Previous button","Click on Previous button was a success");
            while (! DriverAction.getElement(Locators.LNSA_NEXT_BUTTON).isEnabled()) {
                Thread.sleep(500);
            }

            String endDate = DriverAction.getElementText(Locators.LNSA_END_DATE);
            Date endDate1 = new Date();

            try {
                endDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(endDate);
            }
            catch (Exception e){
                logger.info("Invalid format for date found, could not parse the date. Date found: " + endDate);
                Assert.fail("Invalid format for date found, could not parse the date. Date found: " + endDate);
            }
            long diff = (startDate1.getTime() - endDate1.getTime()) / (1000 * 3600 * 24);
            if (diff != 1) {
                logger.info("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
                Assert.fail("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
            }

        }
    }

    @Then("^User tries to move to the next date$")
    public void userMovesToNextDate() {
        try{
            DriverAction.waitUntilElementAppear(Locators.LNSA_NEXT_BUTTON, 5);
            DriverAction.click(Locators.LNSA_NEXT_BUTTON,"User clicks on Next button","Click on Next button was a success");
            Thread.sleep(1000);
        }catch (Exception e){
            logger.info("Unable to click on Next button");
            Assert.fail("Unable to click on Next button");
        }
    }

    @Then("^User selects a checkbox of any week present on the page$")
    public void userSelectsCheckbox() {
        try{
            DriverAction.waitUntilElementAppear(Locators.LNSA_WEEK_SELECT, 5);
            DriverAction.click(Locators.LNSA_WEEK_SELECT,"User clicks on Week Checkbox","Click and check of Week Checkbox was a success");
        }catch (Exception e){
            logger.info("Unable to click on Week Checkbox");
            Assert.fail("Unable to click on Week Checkbox");
        }
        DriverAction.click(Locators.LNSA_WEEK_SELECT,"User clicks on Week Checkbox again to uncheck","Click and uncheck of Week Checkbox was a success");
    }

    @And("User tries to Submit the LNSA without selecting date")
    public void userTriesToSubmitLNSA() {
        try{
            DriverAction.waitUntilElementAppear(Locators.LNSA_SUBMIT_BUTTON, 5);
            DriverAction.click(Locators.LNSA_SUBMIT_BUTTON,"User clicks on Submit button to Submit a blank LNSA","Click on Submit button was a success");
            DriverAction.waitUntilElementAppear(Locators.LNSA_WARNING_POP, 5);
            if (!DriverAction.isExist(Locators.LNSA_WARNING_POP))
                Assert.fail("Warning pop-up did not appear after submitting an empty LNSA");
        } catch (Exception e){
            logger.info("Unable to click on Submit button");
            Assert.fail("Unable to click on Submit button");
        }
        DriverAction.click(Locators.LNSA_OK_BUTTON, "Click on the OK Button to disappear the pop-up", "Click on OK Button was a success");
    }
}