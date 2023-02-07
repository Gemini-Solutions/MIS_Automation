package com.qa.MIS.StepDefinition;

import com.gemini.generic.ui.utils.DriverAction;
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
        DriverAction.typeText(Locators.txtUserName, "touqeer.subhani");
        DriverAction.typeText(Locators.txtPassword, "Gemini@123");
        DriverAction.click(Locators.buttonLogin);
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
            Date startDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(startDate);
            DriverAction.click(Locators.LNSA_PREVIOUS_BUTTON);
            while (! DriverAction.getElement(Locators.LNSA_NEXT_BUTTON).isEnabled()) {
                Thread.sleep(500);
            }
            String endDate = DriverAction.getElementText(Locators.LNSA_END_DATE);
            Date endDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(endDate);
            long diff = (startDate1.getTime() - endDate1.getTime()) / (1000 * 3600 * 24);
            if (diff != 1) {
                logger.info("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
                Assert.fail("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
            }


        }
    }
}
