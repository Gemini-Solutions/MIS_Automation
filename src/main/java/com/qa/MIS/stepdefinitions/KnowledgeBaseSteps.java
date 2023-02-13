package com.qa.MIS.stepdefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS.locators.KnowledgeBaseLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class KnowledgeBaseSteps {
    static WebElement el;

    @Given("logged in successfully")
    public void logged_in_successfully() throws InterruptedException {
        //DriverAction.typeText(KnowledgeBaseLocator.usernameByXpath,"prajjwal.negi");
        //DriverAction.typeText(KnowledgeBaseLocator.passwordByXpath,"Gemini@123");
        //Thread.sleep(5000);
        DriverAction.waitSec(5);
        if (DriverAction.isExist(KnowledgeBaseLocator.usernameByXpath)) {
            DriverAction.typeText(KnowledgeBaseLocator.usernameByXpath, "prajjwal.negi");
        } else {
            GemTestReporter.addTestStep("Username", "Username field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(KnowledgeBaseLocator.passwordByXpath)) {
            DriverAction.typeText(KnowledgeBaseLocator.passwordByXpath, "Gemini@123");
        } else {
            GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        DriverAction.click(KnowledgeBaseLocator.signInByXpath);
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.closeSkills,5);

        DriverAction.click(KnowledgeBaseLocator.closeSkills,"Close skill");
    }
    @When("navigating to view documents page")
    public void navigating_to_view_documents_page() throws InterruptedException {

        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);


    }
    @Then("add new document tags icon is present and functional")
    public void add_new_document_tags_icon_is_present_and_functional() {
        DriverAction.click(KnowledgeBaseLocator.addDocumentTag,"Add document Tag");
        DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag,"Test14");
        DriverAction.click(KnowledgeBaseLocator.saveDocumentTag,"Document Tag saved");
        String successMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagSuccessfullyAdded);
        System.out.println(successMessage);
        if(!successMessage.equalsIgnoreCase("Document tag Added Sucessfully")){
            Assert.fail();
        }

        DriverAction.click(KnowledgeBaseLocator.okButton,"Ok button");

    }

    @When("navigating to view documents page adding empty document tag")
    public void navigating_to_view_documents_page_adding_empty_document_tag() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.closeSkills,"Close skill");
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.addDocumentTag,"Add document Tag");
        DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag,"");
        DriverAction.click(KnowledgeBaseLocator.saveDocumentTag,"Document Tag saved");



    }
    @Then("throws warning message")
    public void throws_warning_message() {
        String warningMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagWarningMessage);
        System.out.println(warningMessage);
        if(warningMessage.equalsIgnoreCase("Please fill required field")){
            System.out.println("Warning Message!");


        }
        else{
            Assert.fail();
        }
//        if(!warningMessage.equalsIgnoreCase("Please fill required field")){
//            Assert.fail();
//        }




    }

    @When("navigating to my attendance")
    public void navigating_to_my_attendance() {

        DriverAction.click(KnowledgeBaseLocator.attendanceMonth,"Attendance Month Selection");

    }
    @Then("selecting {string} and verifying the attendance")
    public void selecting_and_verifying_the_attendance(String month) throws InterruptedException {
        DriverAction.click(By.xpath("//li[text()='"+month+"'"+"]"));


    }

    @Then("right click functionality is working")
    public void right_click_functionality_is_working() throws InterruptedException {
        Thread.sleep(5000);
        DriverAction.rightClick(KnowledgeBaseLocator.folder);
        if(!DriverAction.isExist(KnowledgeBaseLocator.deleteFolder)){
            Assert.fail();
        }

    }

    @When("navigating to view documents page and adding an invalid document type")
    public void navigating_to_view_documents_page_and_adding_an_invalid_document_type() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(KnowledgeBaseLocator.folder);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.addDocument,"Add Document");
        Thread.sleep(5000);
        DriverAction.fileUpload(KnowledgeBaseLocator.upload,"C:\\Users\\Prajjwal\\MISAutomaiton2\\MIS_Automation\\src\\main\\resources\\testdocument.txt");
        //DriverAction.typeText(Locators.upload,"src\\main\\resources\\testdocument.txt");
        Thread.sleep(5000);






    }
    @Then("invalid document type warning should be displayed")
    public void invalid_document_type_warning_should_be_displayed() {
        if(DriverAction.getElementText(KnowledgeBaseLocator.invalidDoc).equalsIgnoreCase("Invalid file selected. supported extensions are .xlsx,.xls,.pdf")){
            System.out.println("SUCCESS");
        }
        else{
            Assert.fail();
        }


    }

    @When("navigating to view documents page and page is refreshed")
    public void navigating_to_view_documents_page_and_page_is_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        DriverAction.click(KnowledgeBaseLocator.refresh,"refresh");

    }
    @Then("page is refreshed")
    public void page_is_refreshed() {
        // Write code here that turns the phrase above into concrete actions
        if(!DriverAction.isExist(KnowledgeBaseLocator.folder)){
            Assert.fail();
        }

    }

    @When("navigating to view documents page and searched")
    public void navigating_to_view_documents_page_and_searched() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);

    }
    @Then("search is functional")
    public void search_is_functional() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.typeText(KnowledgeBaseLocator.search,"xyz");
        String documentName = DriverAction.getElementText(KnowledgeBaseLocator.searchDocument);
        if(documentName.equalsIgnoreCase("xyz")){

        }
        else{
            Assert.fail();
        }




    }


    @When("navigating to view documents page and searched document not present")
    public void navigating_to_view_documents_page_and_searched_document_not_present() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);

    }
    @Then("search is functional and nothing is shown")
    public void search_is_functional_and_nothing_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.typeText(KnowledgeBaseLocator.search,"xyz2");
        String mismatch = DriverAction.getElementText(KnowledgeBaseLocator.documentSearch);
        if(mismatch.equalsIgnoreCase("No matching records found")){

        }
        else{
            Assert.fail();
        }


    }

    @When("navigating to view documents page and renaming the {string}")
    public void navigating_to_view_documents_page_and_renaming_the(String folderRename) throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+folderRename+"']"));
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.rename);
        Thread.sleep(5000);
        DriverAction.typeText(By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[3]/span"),"1");
        Thread.sleep(5000);




    }
    @Then("the folder name should be renamed")
    public void the_folder_name_should_be_renamed() {
        //System.out.println("1");


    }

    @When("navigating to view documents page and selecting {string} from dropdown")
    public void navigating_to_view_documents_page_and_selecting_from_dropdown(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        WebElement el = DriverAction.getElement(KnowledgeBaseLocator.dropdown);
        Select list = new Select(el);
        list.selectByValue(string);
        Thread.sleep(5000);





    }
    @Then("dropdown is functional")
    public void dropdown_is_functional() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions


    }

    @When("navigating to view document and {string} is selected")
    public void navigating_to_view_document_and_is_selected(String string) throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.delete);


    }
    @Then("folder is deleted")
    public void folder_is_deleted() {

    }


    @When("navigating to view document and {string} is selected and {string} is selected")
    public void navigating_to_view_document_and_is_selected_and_is_selected(String string, String string2) throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.click(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string2+"']"));
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.delete);
    }
    @Then("sub folder is deleted")
    public void sub_folder_is_deleted() {

    }

    @When("navigating to view document and title sort applied")
    public void navigating_to_view_document_and_title_sort_applied() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.titleSort);
        DriverAction.click(KnowledgeBaseLocator.titleSort);
        Thread.sleep(5000);
        if(DriverAction.getElementText(KnowledgeBaseLocator.sortValue).equalsIgnoreCase("zyx")){
            System.out.println("SUCCESS");
        }else{
            Assert.fail();
        }

    }
    @Then("list is sorted according to title")
    public void list_is_sorted_according_to_title() {

    }

    @When("navigating to view document and date sort applied")
    public void navigating_to_view_document_and_date_sort_applied() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.titleSort);
        DriverAction.click(KnowledgeBaseLocator.titleSort);
        Thread.sleep(5000);

    }
    @Then("list is sorted according to date")
    public void list_is_sorted_according_to_date() {

    }

    @When("navigating to view document and adding folder")
    public void navigating_to_view_document_and_adding_folder() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);

        DriverAction.click(KnowledgeBaseLocator.addFolder);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.saveFolder);


    }
    @Then("folder is added successfully")
    public void folder_is_added_successfully() throws InterruptedException {


    }

    @When("navigating to view document and adding subfolder to {string}")
    public void navigating_to_view_document_and_adding_subfolder_to(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"));
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.saveFolder);



    }
    @Then("sub folder is added successfully")
    public void sub_folder_is_added_successfully() {

    }

    @When("navigating to view document and adding folder with duplicate name")
    public void navigating_to_view_document_and_adding_folder_with_duplicate_name() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);

        DriverAction.click(KnowledgeBaseLocator.addFolder);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.saveFolder);

    }
    @Then("warning is given for duplicate name")
    public void warning_is_given_for_duplicate_name() {

    }

    @When("navigating to view document and adding subfolder with duplicate name to {string}")
    public void navigating_to_view_document_and_adding_subfolder_with_duplicate_name_to(String string) throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"));
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.saveFolder);
    }
    @Then("warning is given for duplicate subfolder")
    public void warning_is_given_for_duplicate_subfolder() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("navigating to view documents page and adding an valid document type")
    public void navigating_to_view_documents_page_and_adding_an_valid_document_type() throws InterruptedException {
        DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
        DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
        DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(KnowledgeBaseLocator.folder);
        Thread.sleep(5000);
        DriverAction.click(KnowledgeBaseLocator.addDocument,"Add Document");
        Thread.sleep(5000);
        DriverAction.fileUpload(KnowledgeBaseLocator.upload,"C:\\Users\\Prajjwal\\MISAutomaiton2\\MIS_Automation\\src\\main\\resources\\testdocument.xlsx");
        //DriverAction.typeText(Locators.upload,"src\\main\\resources\\testdocument.txt");
        Thread.sleep(5000);



    }
    @Then("document is added successfully")
    public void document_is_added_successfully() throws InterruptedException {
//        DriverAction.typeText(Locators.titleById,"xyz1");
//        Thread.sleep(5000);
//        DriverAction.typeText(Locators.titleDescriptionById,"Sample1");
//        Thread.sleep(5000);
//        DriverAction.click(Locators.tagClick);
//        Thread.sleep(5000);
//        DriverAction.click(Locators.tag);
//        Thread.sleep(5000);
//        DriverAction.click(By.xpath("//*[@id=\"select2-txtDocumentTags-result-592a-2\"]"));
//        Thread.sleep(5000);
//       // DriverAction.typeText(By.xpath("//*[@id=\"mypopupWindowAddNewDocumentModal\"]/div/div/div[2]/div[4]/div/div[2]/span/span[1]/span/ul"), "Test 1");
//        DriverAction.click(Locators.addDocumentTag);

    }














}
