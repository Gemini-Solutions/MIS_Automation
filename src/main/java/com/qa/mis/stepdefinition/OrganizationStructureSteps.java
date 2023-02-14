package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.OrgStructureLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrganizationStructureSteps {
    @Given("Navigate to Organization Structure")
    public void Navigate_to_Organization_Structure() {
        if(DriverAction.isExist(OrgStructureLocator.orbbtn)){
            DriverAction.click(OrgStructureLocator.orbbtn);
        }
        else GemTestReporter.addTestStep("Element not found","Organization Module not clicked", STATUS.FAIL,DriverAction.takeSnapShot());
    }

    @When("^Entered employee name (.+) in search field")
    public void Entered_employee_name_in_search_field(String empname) {
        if (DriverAction.isExist(OrgStructureLocator.searchtab)){
            DriverAction.typeText(OrgStructureLocator.searchtab,empname);
        }
        else GemTestReporter.addTestStep("Element not found","Search filed not found", STATUS.FAIL,DriverAction.takeSnapShot());
    }

    @Then("^Validate availability of Employee (.+) and Designation (.+)")
    public void Validate_availability_of_Employee_and_Designation(String empname, String designation){


    }
}
