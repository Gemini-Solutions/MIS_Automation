package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.MySkillsLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySkillsSteps {


    @Then("Skills are updated with {string}")
    public void verifyTheSkillsAreUpdatedWith(String mySkills) {
        try {
             DriverAction.waitUntilElementAppear(MySkillsLocator.mySkill(mySkills), 3);
            DriverAction.click(MySkillsLocator.mySkill(mySkills));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Skills are updated with valid data", "Skills not updated", STATUS.FAIL);

        }
    }

    @Given("User scrolls to skills view")
    public void userScrollsToSkills() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.skillsUpdated, 4);
            DriverAction.scrollIntoView(MySkillsLocator.skillsUpdated);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User scrolls to skills view area", "Scrolling is unsuccessful", STATUS.FAIL);
        }
    }

    @Then("^User clicks on close button$")
    public void userClicksOnCloseButton() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.closeBtn, 3);
            DriverAction.click(MySkillsLocator.closeBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is unsuccessful", STATUS.FAIL);
        }
    }


    @Given("User clicks on user image button")
    public void userClicksOnUserImgButton() {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(MySkillsLocator.userImg);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on user image", "Click is Unsuccessful", STATUS.FAIL);
        }
    }

    @And("User clicks on skills button")
    public void userClicksOnSkillsButton() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.skillsBtn, 3);
            DriverAction.click(MySkillsLocator.skillsBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on skills button", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @When("User clicks on technology dropdown")
    public void userClicksOnTechnologyDropdown() {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(MySkillsLocator.technologyDropDown);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on technology dropdown", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @And("User selects the {string}")
    public void userSelectsThe(String technology) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.selectTechnology(technology), 6);
            DriverAction.click(MySkillsLocator.selectTechnology(technology));
        } catch (Exception e) {
            GemTestReporter.addTestStep("User selects the technology", "Click is Unsuccessful", STATUS.FAIL);

        }
    }


    @When("User clicks on professional dropdown")
    public void userClicksOnProfessionalDropdown() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.professionalDropDown, 7);
            DriverAction.click(MySkillsLocator.professionalDropDown);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on professional dropdown", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @And("User selects the professional level as {string}")
    public void userSelectsTheProfessionalLevelAs(String professionalLevel) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.selectProfessional(professionalLevel), 4);
            DriverAction.click(MySkillsLocator.selectProfessional(professionalLevel));
        } catch (Exception e) {
            GemTestReporter.addTestStep("User selects professional level", "Click is Unsuccessful", STATUS.FAIL);

        }
    }

    @When("User enters the tech experience {string}")
    public void userEntersTheTechExperience(String techExperience) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.techExperience, 4);
            DriverAction.typeText(MySkillsLocator.techExperience, techExperience);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the tech experience", "Tech experience can not be entered", STATUS.FAIL);

        }
    }

    @When("User enters the total experience {string}")
    public void userEntersTheTotalExperience(String totalExperience) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.totalExperience, 4);
            DriverAction.typeText(MySkillsLocator.totalExperience, totalExperience);

        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the total experience", "Total experience can not be entered", STATUS.FAIL);

        }
    }

    @Then("User clicks on skill ok button")
    public void userClicksOnSkillOkButton() {
        try {
            DriverAction.click(MySkillsLocator.skillSaveBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on ok button", "Click is unsuccessful", STATUS.FAIL);

        }
    }
}

