package com.qa.MIS.StepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.MIS.Locators.Locators;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.AN;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class StepDefinition {

    @Given("^User should be on MIS login page and enter (.*) and (.*)$")
    public void UserEnterCredentials(String Username, String Password) {
        DriverAction.waitSec(5);
        DriverAction.typeText(Locators.Username, Username);
        DriverAction.typeText(Locators.Password, Password);
    }

    @When("User clicked on submit button")
    public void User_clicked_on_submit_button() {
        DriverAction.waitSec(5);
        DriverAction.click(Locators.Signbutton);

    }

    @And("User should be navigated to MIS homepage")
    public void User_should_be__navigated_to_the_mis_homepage() {

        DriverAction.waitSec(10);

        WebElement Usersection = DriverAction.getElement(Locators.UserSection);
        if (Usersection.isDisplayed()) {
            GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("MIS Homepage", "User is not able navigated to the homepage", STATUS.FAIL);
        }
    }

    @Then("User verify a toggle button is present on Dashboard and clickable")
    public void Toggleclickability() {
        String sidebarclass = "";
        WebElement toggle = DriverAction.getElement(Locators.Togglebtn);
        WebElement menu = DriverAction.getElement(Locators.Sidebar);
        sidebarclass = menu.getAttribute("class");
        if (toggle.isDisplayed()) {
            System.out.println(sidebarclass);
            if (sidebarclass.equalsIgnoreCase("side-menu jspScrollable")) {
                DriverAction.click(toggle);
                DriverAction.waitSec(5);
                sidebarclass = menu.getAttribute("class");
                System.out.println(sidebarclass);
                if (sidebarclass.equalsIgnoreCase("side-menu")) {
                    GemTestReporter.addTestStep("Toggle button clickability", "button is working correctly", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Toggle button clickability", "button is not working correctly", STATUS.FAIL);
                }
            }

        }
    }

    @Then("User click on Profile menu")
    public void ClickProfileMenu() {
        DriverAction.click(Locators.Profilemenu);
        DriverAction.waitSec(2);
        DriverAction.click(Locators.UpdateProfileOption);
        DriverAction.waitUntilElementAppear(Locators.UpdateProfileSection, 10);
//        DriverAction.waitSec(5);
    }
    @And("User click on Save button")
        public void clickSave(){
            DriverAction.click(Locators.skillSavebtn,"Save button");
        }

    @And("^User Verify all the (.*) and (.*) are present")
    public void VerifyFields(String Fields, String Buttons) {

        String[] Sections = Fields.split(";");
        System.out.println(Sections.length);
        String[] Tabs;
        int flag = 0;
        ArrayList<String> Tabname = new ArrayList<String>();
        for (int i = 0; i < Sections.length; i++) {
            Tabs = Sections[i].split(":");
            String tabname = Tabs[0];
            String[] fields = Tabs[1].split(",");
            System.out.println(tabname);
            if (!tabname.equals("Update Profile")) {
                DriverAction.click(Locators.navigation_tabs(tabname));
            }
            DriverAction.waitSec(5);

            for (int j = 0; j < fields.length; j++) {
                WebElement field = DriverAction.getElement(Locators.fields(fields[j]));
                if (field.isDisplayed()) {
                    flag = 1;

                    System.out.println(field.getText());
                } else {
                    flag = 0;
                    break;
                }
            }
            String[] buttons = Buttons.split(",");
            for (String button : buttons) {
                WebElement btn = DriverAction.getElement(Locators.buttons(button));
                if (btn.isDisplayed()) {
                    flag = 1;
                    System.out.println(btn.getText());
                } else {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {

            } else {
                GemTestReporter.addTestStep("verify all the fields", "All the fields are not present ", STATUS.FAIL);
            }

        }

    }

    @Then("User click on Gemini logo and Verify should be on HomePage by url (.*)")
    public void ClickLogo(String expectedURL) {
        DriverAction.click(Locators.SiteLogo);
        DriverAction.getCurrentURL();
        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.urlToBe(expectedURL));
        if (DriverAction.getCurrentURL().equals(expectedURL)) {
            GemTestReporter.addTestStep("Verify page URL", "URL Matched.\n Expected URL-" + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.PASS);
        } else
            GemTestReporter.addTestStep("Verify page URL", "URL doesn't Matched.\n Expected URL-" + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.FAIL);
    }

    @Then("User click on Skills menu")
    public void ClickSkill() {
        DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        DriverAction.waitSec(2);
        DriverAction.click(Locators.SkillsOption);
        DriverAction.waitUntilElementAppear(Locators.SkillPopup, 10);


    }

    @And("User Enter all the details {string},{string},{string},{string},{string}")
    public void enterDetails(String Technology, String ProficiencyLevel, String SkillType, String TechExperience, String TotalWorkExp) {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.technologySelect);
        DriverAction.waitSec(2);
        WebElement option = DriverAction.getElement(Locators.technologyOption(Technology));
        DriverAction.click(option);
        DriverAction.waitSec(2);
        DriverAction.dropDown(Locators.proficiencySelect, 1);

        DriverAction.waitSec(2);
        DriverAction.dropDown(Locators.skillSelect, 2);

        DriverAction.waitSec(2);
        DriverAction.typeText(Locators.techExperience, TechExperience);
        DriverAction.waitSec(2);
        DriverAction.typeText(Locators.totalExperience, TotalWorkExp);
        DriverAction.waitSec(2);



    }

    @And("User click on close button")
    public void ClickClose() {
        DriverAction.click(Locators.skillClosebtn);
        WebElement popup = DriverAction.getElement(Locators.SkillPopup);
        if (!popup.isDisplayed()) {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button Skill popup is closed", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button Skill popup is not closed", STATUS.FAIL);
        }

    }



    @And("User verify popup with message {string} and {string}")
    public void VerifyMessage(String alertType, String alertMessage) {
        String expectedAlertType = DriverAction.getElementText(Locators.heading_alertType);
        String expectedAlertMessage = DriverAction.getElementText(Locators.text_alertMessage);
        if (expectedAlertType.equals(alertType)) {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.FAIL);
        }
        if (expectedAlertMessage.equals(alertMessage)) {
            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching passed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching failed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.FAIL);

        }
    }

    @Then("User click on Change AD Password and Verify new tab should be open")
    public void clickADPassword() {
        int tabCount = DriverAction.getWindowHandles().size();
        DriverAction.click(Locators.changeADPassword, "AD Password");
        DriverAction.waitSec(5);
        int newtabCount = DriverAction.getWindowHandles().size();
        if ((tabCount + 1) == newtabCount) {
            GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button","new tab is open",STATUS.PASS);
        }else {
            GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button","new tab is not open",STATUS.FAIL);
        }
    }

}

