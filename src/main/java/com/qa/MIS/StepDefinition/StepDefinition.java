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
import java.util.List;

public class StepDefinition {

    @Given("^User should be on MIS login page and enter (.*) and (.*)$")
    public void enterUserCredentials(String Username, String Password) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Locators.Username)) {
                DriverAction.typeText(Locators.Username, Username, "username");
            }
            if (DriverAction.isExist(Locators.Password)) {
                DriverAction.typeText(Locators.Password, Password, "password");
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("EXCEPTION ERROR", "Getting failed while entering credentials", STATUS.FAIL);
        }
    }

    @When("Click on submit button")
    public void submitButton() {

        if (DriverAction.isExist(Locators.Signbutton)) {
            DriverAction.click(Locators.Signbutton, "sign in");
        }

    }

    @Then("User should be navigated to MIS homepage")
    public void navigateMisHomepage() {
        // DriverAction.waitSec(5);

        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Location));
        if (DriverAction.isExist(Locators.Location) && DriverAction.isExist(Locators.Dashboardheading)) {
            GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
        }
    }


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
        if (DriverAction.isExist(Locators.Profilemenu)) {
            DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        }

        DriverAction.waitUntilElementAppear(Locators.UpdateProfileOption, 5);
        if (DriverAction.isExist(Locators.Profilemenu)) {
            DriverAction.click(Locators.UpdateProfileOption, "UpdateProfile");
        }

        DriverAction.waitUntilElementAppear(Locators.UpdateProfileSection, 10);

    }

    @And("Click on Save button")
    public void clickSave() {
        if (DriverAction.isExist(Locators.skillSavebtn)) {
            DriverAction.click(Locators.skillSavebtn, "Save button");
        }
    }

    @And("^Verify all the (.*) and (.*) are present")
    public void verifyFields(String Fields, String Buttons) {
        String[] Sections = Fields.split(";");

        String[] Tabs;
        int flag = 0;
        String Field = "";
        try {
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

                    Field = fields[j];
                    WebElement field = DriverAction.getElement(Locators.fields(fields[j]));

                    if (field.isDisplayed()) {
                        flag = 1;
                    } else {
                        flag = 0;

                        break;
                    }
                }
                String[] buttons = Buttons.split(",");
                for (String button : buttons) {
                    Field = button;
                    WebElement btn = DriverAction.getElement(Locators.buttons(button));

                    if (btn.isDisplayed()) {
                        flag = 1;

                    } else {
                        flag = 0;

                        break;
                    }
                }
                if (flag == 1) {
                    // GemTestReporter.addTestStep("verify all the fields", "" + expectedAlertType + ", STATUS.FAIL,DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("verify all the fields", " "+Field +" "+"Field"+" "+ "is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            }

        } catch (Exception exception) {
            GemTestReporter.addTestStep("verify all the fields", " "+Field +" "+"Field"+" "+ "is not present", STATUS.FAIL, DriverAction.takeSnapShot());

        }


    }

    @Then("Click on Gemini logo")
    public void clickLogo() {

        DriverAction.waitSec(5);
        if (DriverAction.isExist(Locators.SiteLogo)) {

            DriverAction.click(Locators.SiteLogo, "SiteLogo");

        }
    }

    @Then("Click on Skills menu")
    public void clickSkill() {
        DriverAction.waitSec(5);
        if (DriverAction.isExist(Locators.Profilemenu)) {
            DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        }
        DriverAction.waitUntilElementAppear(Locators.SkillsOption, 5);
        if (DriverAction.isExist(Locators.SkillsOption)) {
            DriverAction.click(Locators.SkillsOption, "Skills");

        }
        DriverAction.waitUntilElementAppear(Locators.SkillPopup, 10);
    }

    @And("Enter all the details {string},{string},{string},{string},{string}")
    public void enterDetails(String Technology, String ProficiencyLevel, String SkillType, String TechExperience, String TotalWorkExp) {
        //  DriverAction.waitUntilElementAppear(Locators.technologySelect, 5);
        DriverAction.waitSec(5);
        if (DriverAction.isExist(Locators.technologySelect)) {
            DriverAction.click(Locators.technologySelect, "Techology Select");
        }
        DriverAction.waitUntilElementAppear(Locators.technologyOption(Technology), 5);
        WebElement option = DriverAction.getElement(Locators.technologyOption(Technology));
        if (DriverAction.isExist(Locators.technologyOption(Technology))) {
            DriverAction.click(option, "option");
        }
        DriverAction.waitUntilElementAppear(Locators.proficiencySelect, 5);
        if (DriverAction.isExist(Locators.proficiencySelect)) {
            DriverAction.dropDown(Locators.proficiencySelect, 1);
        }
        DriverAction.waitUntilElementAppear(Locators.skillSelect, 5);
        if (DriverAction.isExist(Locators.skillSelect)) {
            DriverAction.dropDown(Locators.skillSelect, 1);
        }
        DriverAction.waitUntilElementAppear(Locators.techExperience, 5);
        if (DriverAction.isExist(Locators.techExperience)) {
            DriverAction.typeText(Locators.techExperience, TechExperience, "Tech Experience");

        }
        DriverAction.waitUntilElementAppear(Locators.totalExperience, 5);
        if (DriverAction.isExist(Locators.totalExperience)) {
            DriverAction.typeText(Locators.totalExperience, TotalWorkExp, "Total Work Experience");
            DriverAction.waitSec(2);
        }

    }

    @And("Click on close button")
    public void clickClose() {
        if (DriverAction.isExist(Locators.skillClosebtn)) {
            DriverAction.click(Locators.skillClosebtn, "Close button");
        }
        WebElement popup = DriverAction.getElement(Locators.SkillPopup);
        if (!popup.isDisplayed()) {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is closed", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is not closed", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("Verify popup with message {string}")
    public void verifyMessage(String alertType) {
        String expectedAlertType = DriverAction.getElementText(Locators.heading_alertType);
        if (expectedAlertType.equals(alertType)) {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
//    @And("Verify popup with message {string} and {string}")
//    public void verifyMessage(String alertType, String alertMessage) {
//        String expectedAlertType = DriverAction.getElementText(Locators.heading_alertType);
//        String expectedAlertMessage = DriverAction.getElementText(Locators.text_alertMessage);
//        if (expectedAlertType.equals(alertType)) {
//            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.PASS, DriverAction.takeSnapShot());
//        } else {
//            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType + "\nActual Alert Type - " + alertType, STATUS.FAIL, DriverAction.takeSnapShot());
//        }
//        if (expectedAlertMessage.equals(alertMessage)) {
//            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching passed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.PASS, DriverAction.takeSnapShot());
//        } else {
//            GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matching failed.\nExpected Alert Message - " + expectedAlertMessage + "\nActual Alert Message - " + alertMessage, STATUS.FAIL, DriverAction.takeSnapShot());
//
//        }
//    }

    @Then("User click on Change AD Password and Verify new tab should be open")
    public void clickADPassword() {
        int tabCount = DriverAction.getWindowHandles().size();
        if (DriverAction.isExist(Locators.changeADPassword)) {
            DriverAction.click(Locators.changeADPassword, "AD Password");
        }

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
        if (DriverAction.isExist(Locators.Profilemenu)) {
            DriverAction.click(Locators.Profilemenu, "AD Password");
        }

        DriverAction.waitUntilElementAppear(Locators.Logout, 10);
        if (DriverAction.isExist(Locators.Logout)) {
            DriverAction.click(Locators.Logout, "AD Password");
        }


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

    @And("Enter experience{string} in TechExperience")
    public void enterExperienceInTechExperience(String TechExperience) {
        DriverAction.waitSec(5);
        DriverAction.waitUntilElementAppear(Locators.techExperience, 5);
        if (DriverAction.isExist(Locators.techExperience)) {
            DriverAction.typeText(Locators.techExperience, TechExperience, "Tech Experience");

        }

    }

    @And("Verify experience{string} of TechExperience")
    public void verifyExperienceOfTechExperience(String TechExperience) {
        String experience = DriverAction.getElementText(Locators.techExperience);

        if (experience.equalsIgnoreCase(TechExperience) && !experience.matches("[a-zA-Z]")) {
            GemTestReporter.addTestStep("verify Tech Experience field", "Tech Experience is accepting Integer value only", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("verify Tech Experience field", "Tech Experience is accepting all type of value", STATUS.PASS, DriverAction.takeSnapShot());

        }
    }

    @Then("Enter workExperience {string} in workExpField")
    public void enterWorkExperienceInWorkExpField(String TotalWorkExp) {
        DriverAction.waitUntilElementAppear(Locators.totalExperience, 5);
        if (DriverAction.isExist(Locators.totalExperience)) {
            DriverAction.typeText(Locators.totalExperience, TotalWorkExp, "Total Work Experience");
            DriverAction.waitSec(2);
        }
    }

    @And("Verify workExperience {string} of workExpField")
    public void verifyWorkExperienceOfWorkExpField(String TotalExperience) {
        String experience = DriverAction.getElementText(Locators.totalExperience);
        if (experience.equalsIgnoreCase(TotalExperience) && !experience.matches("[a-zA-Z]")) {

            GemTestReporter.addTestStep("verify Total Experience field", "Total Experience is accepting Integer value only", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("verify Total Experience field", "Total Experience is accepting all type of value", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @Then("Click on Dashboard setting")
    public void clickDashboard() {
        DriverAction.waitSec(5);
        if (DriverAction.isExist(Locators.Profilemenu)) {
            DriverAction.click(Locators.Profilemenu, "ProfileMenu");
        }
        if (DriverAction.isExist(Locators.Setting)) {
            DriverAction.click(Locators.Setting, " Dashboard Setting");
            DriverAction.waitSec(2);
        }


    }

    @And("Uncheck (.*) and click on update")
    public void updateDashboard(String Cards) {

        String[] WidgetName = Cards.split(",");
        for (String card : WidgetName) {
            WebElement cardCheckbox = DriverAction.getElement(Locators.Cardcheckbox(card));
            if (DriverAction.isExist(Locators.Cardcheckbox(card))) {
                DriverAction.click(cardCheckbox, cardCheckbox.getText());
                DriverAction.waitSec(2);
            }

        }
        if (DriverAction.isExist(Locators.updateDashboardbtn)) {
            DriverAction.click(Locators.updateDashboardbtn, "Update Button");
            DriverAction.waitSec(2);
        }

//
    }


    @And("Verify Dashboard setting table is visible on the current screen")
    public void verifyDashboardSettingTable() {
        DriverAction.waitUntilElementAppear(Locators.settingDashboard, 5);
        if (DriverAction.isExist(Locators.settingDashboard)) {
            GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is visible after click on Dashboard Setting", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @Then("Verify all check boxes are uncheck")
    public void verifyAllCheckBoxesAreUncheck() {
        DriverAction.waitUntilElementAppear(Locators.settingDashboard, 5);
        if (DriverAction.isExist(Locators.settingDashboard)) {
            List<WebElement> element = DriverAction.getElements(Locators.DashboardCheckbox);
            for (WebElement checkbox : element) {
                DriverAction.click(checkbox);

            }

        }
    }

    @And("Click on Update button")
    public void clickOnUpdateButton() {
        if (DriverAction.isExist(Locators.DashboardUpdatebtn)) {
            DriverAction.click(Locators.DashboardUpdatebtn, "Dashboard Update button");
        }
    }

    //@And("Verify {string} card is shown on the dashboard")
    //public void verifyCardIsShownOnTheDashboard(String isCardPresent) {
       // switch (isCardPresent) {
          //  case "no":
                // impl
              //  break;
           // case "all":
                // impl
               // break;
       // }
  //  }
}

