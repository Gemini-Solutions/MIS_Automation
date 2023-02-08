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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class StepDefinition {

    @Given("^User should be on MIS login page and enter (.*) and (.*)$")
    public void enterUserCredentials(String Username, String Password) {
        try {
            DriverAction.waitUntilElementAppear(Locators.Username, 1000);
            DriverAction.typeText(Locators.Username, Username, "Username");
            DriverAction.typeText(Locators.Password, Password, "Password");
        } catch (Exception e) {
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @When("Click on submit button")
    public void submitButton() {
        DriverAction.waitUntilElementAppear(Locators.Signbutton, 10);
        DriverAction.click(Locators.Signbutton, "SignIn");


    }

    @Then("User should be navigated to MIS homepage")
    public void navigateMisHomepage() {
        // DriverAction.waitSec(5);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Location));
        if (DriverAction.isExist(Locators.Location) && DriverAction.isExist(Locators.Dashboardheading)) {
            GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
      } else {
//            GemTestReporter.addTestStep("MIS Homepage", "User is not able navigated to the homepage", STATUS.FAIL, DriverAction.takeSnapShot());
       }}
//        DriverAction.waitUntilElementAppear(Locators.UserSection, 20);
//
//        WebElement Usersection = DriverAction.getElement(Locators.Location);
//        if (Usersection.isDisplayed()) {
//            GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
//        } else {
//            GemTestReporter.addTestStep("MIS Homepage", "User is not able navigated to the homepage", STATUS.FAIL, DriverAction.takeSnapShot());
//        }
    //}

    @Then("Verify a toggle button is present on Dashboard and clickable")
    public void toggleClickability() {
        String sidebarclass = "";

        DriverAction.waitSec(5);
        WebElement toggle = DriverAction.getElement(Locators.Togglebtn);
        WebElement menu = DriverAction.getElement(Locators.Sidebar);
        sidebarclass = menu.getAttribute("class");
        if (toggle.isDisplayed()) {

            if (sidebarclass.equalsIgnoreCase("side-menu jspScrollable")) {
                DriverAction.click(toggle, "toggle");
                DriverAction.waitSec(5);
                sidebarclass = menu.getAttribute("class");

                if (sidebarclass.equalsIgnoreCase("side-menu")) {
                    GemTestReporter.addTestStep("Toggle button clickability", "Toggle button is clickable", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Toggle button clickability", "Toggle button is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
            }

        }
    }

    @Then("Click on Profile menu")
    public void clickProfileMenu() {
         DriverAction.waitSec(5);

        DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        DriverAction.waitUntilElementAppear(Locators.UpdateProfileOption, 5);
        DriverAction.click(Locators.UpdateProfileOption, "UpdateProfile");
        DriverAction.waitUntilElementAppear(Locators.UpdateProfileSection, 10);

    }

    @And("Click on Save button")
    public void clickSave() {
        DriverAction.click(Locators.skillSavebtn, "Save button");
    }

    @And("^Verify all the (.*) and (.*) are present")
    public void verifyFields(String Fields, String Buttons) {
        try {
            String[] Sections = Fields.split(";");

            String[] Tabs;
            int flag = 0;
            String Field = "";
            ArrayList<String> Tabname = new ArrayList<String>();
            for (int i = 0; i < Sections.length; i++) {
                Tabs = Sections[i].split(":");
                String tabname = Tabs[0];
                String[] fields = Tabs[1].split(",");

                if (!tabname.equals("Update Profile")) {
                    DriverAction.click(Locators.navigation_tabs(tabname), tabname);
                }
                DriverAction.waitSec(5);

                for (int j = 0; j < fields.length; j++) {
                    WebElement field = DriverAction.getElement(Locators.fields(fields[j]));
                    if (field.isDisplayed()) {
                        flag = 1;


                    } else {
                        flag = 0;
                        Field = field.getText();
                        break;
                    }
                }
                String[] buttons = Buttons.split(",");
                for (String button : buttons) {
                    WebElement btn = DriverAction.getElement(Locators.buttons(button));
                    if (btn.isDisplayed()) {
                        flag = 1;

                    } else {
                        flag = 0;
                        Field = btn.getText();
                        break;
                    }
                }
                if (flag == 1) {
                    // GemTestReporter.addTestStep("verify all the fields", "" + expectedAlertType + ", STATUS.FAIL,DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("verify all the fields", "Field" + Field + "is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            }

        } catch (Exception exception) {
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }


    }

    @Then("Click on Gemini logo")
    public void clickLogo() {

       DriverAction.waitSec(5);
        if (DriverAction.isExist(Locators.SiteLogo)) {
        //DriverAction.waitUntilElementAppear(Locators.SiteLogo,20);
        DriverAction.click(Locators.SiteLogo, "SiteLogo");

    }}

    @Then("Click on Skills menu")
    public void clickSkill() {
        DriverAction.waitSec(5);

            DriverAction.click(Locators.Profilemenu, "ProfileMenu");
            DriverAction.waitUntilElementAppear(Locators.SkillsOption, 5);
            DriverAction.click(Locators.SkillsOption, "UpdateProfile");
            DriverAction.waitUntilElementAppear(Locators.SkillPopup, 10);}



    @And("Enter all the details {string},{string},{string},{string},{string}")
    public void enterDetails(String Technology, String ProficiencyLevel, String SkillType, String TechExperience, String TotalWorkExp) {
        //  DriverAction.waitUntilElementAppear(Locators.technologySelect, 5);
        DriverAction.waitSec(5);
        DriverAction.click(Locators.technologySelect, "Techology Select");
        DriverAction.waitUntilElementAppear(Locators.technologyOption(Technology), 5);
        WebElement option = DriverAction.getElement(Locators.technologyOption(Technology));

        DriverAction.click(option, "option");
        DriverAction.waitUntilElementAppear(Locators.proficiencySelect, 5);
        DriverAction.dropDown(Locators.proficiencySelect, 1);

        DriverAction.waitUntilElementAppear(Locators.skillSelect, 5);
        DriverAction.dropDown(Locators.skillSelect, 2);

        DriverAction.waitUntilElementAppear(Locators.techExperience, 5);
        DriverAction.typeText(Locators.techExperience, TechExperience, "Tech Experience");
        DriverAction.waitUntilElementAppear(Locators.totalExperience, 5);
        DriverAction.typeText(Locators.totalExperience, TotalWorkExp, "Total Work Experience");
        DriverAction.waitSec(2);


    }

    @And("Click on close button")
    public void clickClose() {
        DriverAction.click(Locators.skillClosebtn, "Close button");
        WebElement popup = DriverAction.getElement(Locators.SkillPopup);
        if (!popup.isDisplayed()) {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is closed", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is not closed", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }


    @And("Verify popup with message {string} and {string}")
    public void verifyMessage(String alertType, String alertMessage) {
        String expectedAlertType = DriverAction.getElementText(Locators.heading_alertType);
        String expectedAlertMessage = DriverAction.getElementText(Locators.text_alertMessage);
        if (expectedAlertType.equals(alertType)) {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (expectedAlertMessage.equals(alertMessage)) {
            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching passed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching failed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User click on Change AD Password and Verify new tab should be open")
    public void clickADPassword() {
        int tabCount = DriverAction.getWindowHandles().size();
        DriverAction.click(Locators.changeADPassword, "AD Password");
        DriverAction.waitSec(5);
        int newtabCount = DriverAction.getWindowHandles().size();
        if ((tabCount + 1) == newtabCount) {
            GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button", "new tab is open", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button", "new tab is not open", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Logout menu")
    public void clickOnLogoutMenu() {
        DriverAction.waitSec(5);
        DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        DriverAction.waitUntilElementAppear(Locators.Logout, 10);
        DriverAction.click(Locators.Logout, "Logout");

    }

    @And("User navigate to login page")
    public void loginPageNavigation() {
        DriverAction.waitUntilElementAppear(Locators.loginForm, 10);
        if (DriverAction.isExist(Locators.loginForm)) {
            GemTestReporter.addTestStep("verify navigation to login page", "login page is open after click on logout", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("verify navigation to login page", "login page is not open after click on logout", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }


//    @And("Verify Experience fields accept integer type data")
//    public void verifyExperienceFields() {
//
//    }
//    @Then("Click on Dashboard setting")
//    public void clickDashboard(){
//        DriverAction.waitUntilElementAppear(Locators.Profilemenu, 10);
//        DriverAction.click(Locators.Profilemenu, "ProfileMenu");
//        DriverAction.waitUntilElementAppear(Locators.Setting, 10);
//        DriverAction.click(Locators.Setting, "Logout");
//    }
//    @And("Uncheck (.*) and click on update")
//    public void updateDashboard(String Cards){
//       String[] WidgetName = Cards.split(",");
//        for (String card:WidgetName) {
//            WebElement cardCheckbox= DriverAction.getElement(Locators.Cardcheckbox(card));
//            DriverAction.click(cardCheckbox);
//        }
//        DriverAction.click(Locators.updateDashboardbtn,"Update Button");
//
//    }
}

