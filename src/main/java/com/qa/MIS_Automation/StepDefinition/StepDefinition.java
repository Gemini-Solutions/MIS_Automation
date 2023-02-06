package com.qa.MIS_Automation.StepDefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.MIS_Automation.Locators.Locators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.sql.Driver;

public class StepDefinition {

    @Given("logged in successfully")
    public void logged_in_successfully() throws InterruptedException {
        DriverAction.typeText(Locators.username,"prajjwal.negi");
        DriverAction.typeText(Locators.password,"Gemini@1234");
        DriverAction.click(Locators.signIn);
        Thread.sleep(3000);
        //DriverAction.waitUntilElementAppear(Locators.closeSkills,5);

        DriverAction.click(Locators.closeSkills,"Close skill");
    }
    @When("navigating to view documents page")
    public void navigating_to_view_documents_page() {

        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");


    }
    @Then("add new document tags icon is present and functional")
    public void add_new_document_tags_icon_is_present_and_functional() {
        DriverAction.click(Locators.addDocumentTag,"Add document Tag");
        DriverAction.typeText(Locators.inputDocumentTag,"Test12");
        DriverAction.click(Locators.saveDocumentTag,"Document Tag saved");
        String successMessage = DriverAction.getElementText(Locators.documentTagSuccessfullyAdded);
        System.out.println(successMessage);
        if(!successMessage.equalsIgnoreCase("Document tag Added Sucessfully")){
            Assert.fail();
        }

        DriverAction.click(Locators.okButton,"Ok button");

    }

    @When("navigating to view documents page adding empty document tag")
    public void navigating_to_view_documents_page_adding_empty_document_tag() {
        DriverAction.click(Locators.closeSkills,"Close skill");
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        DriverAction.click(Locators.addDocumentTag,"Add document Tag");
        DriverAction.typeText(Locators.inputDocumentTag,"");
        DriverAction.click(Locators.saveDocumentTag,"Document Tag saved");



    }
    @Then("throws warning message")
    public void throws_warning_message() {
        String warningMessage = DriverAction.getElementText(Locators.documentTagWarningMessage);
        System.out.println(warningMessage);
        if(!warningMessage.equalsIgnoreCase("Please fill required field")){
            Assert.fail();
        }




    }

    @When("navigating to my attendance")
    public void navigating_to_my_attendance() {

        DriverAction.click(Locators.attendanceMonth,"Attendance Month Selection");

    }
    @Then("selecting {string} and verifying the attendance")
    public void selecting_and_verifying_the_attendance(String month) throws InterruptedException {
        DriverAction.click(By.xpath("//li[text()='"+month+"'"+"]"));


    }

    @Then("right click functionality is working")
    public void right_click_functionality_is_working() throws InterruptedException {
        Thread.sleep(5000);
        DriverAction.rightClick(Locators.folder);
        if(!DriverAction.isExist(Locators.deleteFolder)){
            Assert.fail();
        }

    }

    @When("navigating to view documents page and adding an invalid document type")
    public void navigating_to_view_documents_page_and_adding_an_invalid_document_type() throws InterruptedException {
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        DriverAction.waitUntilElementAppear(Locators.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(Locators.folder);
        DriverAction.click(Locators.addDocument,"Add Document");
        DriverAction.fileUpload(Locators.upload,"testinput.xlsx");
        //DriverAction.typeText(Locators.upload,"src\\main\\resources\\testdocument.txt");
        Thread.sleep(5000);






    }
    @Then("invalid document type warning should be displayed")
    public void invalid_document_type_warning_should_be_displayed() {


    }

    @When("navigating to view documents page and page is refreshed")
    public void navigating_to_view_documents_page_and_page_is_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        DriverAction.click(Locators.refresh,"refresh");

    }
    @Then("page is refreshed")
    public void page_is_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        if(!DriverAction.isExist(Locators.folder)){
            Assert.fail();
        }

    }







}
