package com.qa.MIS.StepDefinition;



import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS.Locators.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.qa.MIS.Locators.Locators.*;

public class StepDefinition {
    static WebElement el;

    @Given("logged in successfully")
    public void logged_in_successfully() throws InterruptedException {
        DriverAction.typeText(Locators.usernameByXpath,"prajjwal.negi");
        DriverAction.typeText(Locators.passwordByXpath,"Gemini@1234");
        //Thread.sleep(5000);
        DriverAction.click(Locators.signInByXpath);
        Thread.sleep(5000);
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
        DriverAction.typeText(Locators.inputDocumentTag,"Test14");
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
        //DriverAction.fileUpload(Locators.upload,"testinput.xlsx");
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

    @When("navigating to view documents page and searched")
    public void navigating_to_view_documents_page_and_searched() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);

    }
    @Then("search is functional")
    public void search_is_functional() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.typeText(Locators.search,"xyz1");
        String documentName = DriverAction.getElementText(Locators.searchDocument);
        if(documentName.equalsIgnoreCase("xyz1")){

        }
        else{
            Assert.fail();
        }




    }


    @When("navigating to view documents page and searched document not present")
    public void navigating_to_view_documents_page_and_searched_document_not_present() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);

    }
    @Then("search is functional and nothing is shown")
    public void search_is_functional_and_nothing_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        DriverAction.typeText(Locators.search,"xyz2");
        String mismatch = DriverAction.getElementText(Locators.documentSearch);
        if(mismatch.equalsIgnoreCase("No matching records found")){

        }
        else{
            Assert.fail();
        }


    }

    @When("navigating to view documents page and renaming the {string}")
    public void navigating_to_view_documents_page_and_renaming_the(String folderRename) throws InterruptedException {
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(Locators.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+folderRename+"']"));
        Thread.sleep(5000);
        DriverAction.click(Locators.rename);
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
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);
        WebElement el = DriverAction.getElement(Locators.dropdown);
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
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(Locators.folder,5);
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.click(Locators.delete);


    }
    @Then("folder is deleted")
    public void folder_is_deleted() {

    }


    @When("navigating to view document and {string} is selected and {string} is selected")
    public void navigating_to_view_document_and_is_selected_and_is_selected(String string, String string2) throws InterruptedException {
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(Locators.folder,5);
        Thread.sleep(5000);
        DriverAction.click(By.xpath("//a[text()='"+string+"']"));
        Thread.sleep(5000);
        DriverAction.rightClick(By.xpath("//a[text()='"+string2+"']"));
        Thread.sleep(5000);
        DriverAction.click(Locators.delete);
    }
    @Then("sub folder is deleted")
    public void sub_folder_is_deleted() {

    }

    @When("navigating to view document and title sort applied")
    public void navigating_to_view_document_and_title_sort_applied() throws InterruptedException {
        DriverAction.click(Locators.knowledgeBase,"Knowledge Base");
        DriverAction.click(Locators.viewDocuments,"View Documents");
        Thread.sleep(5000);
        DriverAction.waitUntilElementAppear(Locators.folder,5);
        Thread.sleep(5000);
        DriverAction.click(Locators.titleSort);
        DriverAction.click(Locators.titleSort);
        Thread.sleep(5000);
        if(DriverAction.getElementText(Locators.sortValue).equalsIgnoreCase("zyx")){
            System.out.println("SUCCESS");
        }else{
            Assert.fail();
        }

    }
    @Then("list is sorted according to title")
    public void list_is_sorted_according_to_title() {

    }
   @When("^user click on url$")
    public void userClickOnUrl()
    {
       DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username$")
    public void userName()
    {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password$")
    public void  enterPassword()
    {
        DriverAction.typeText(password,"Gemini@123");
    }
    @When("^click on SignIn button$")
    public void signIn()
    {
        DriverAction.click(signIn);
        DriverAction.waitSec(10);
    }

    @When("^user update mobile and extension number$")
    public void clickOnMobile(){
       DriverAction.click(popUpCloseButton);
       DriverAction.waitSec(7);
       DriverAction.click(clickOnChangeDetails);
       DriverAction.waitSec(7);
    }

    @When("^Enter mobile number and ext number$")
    public void enterMobileNoAndExtNo(){
       DriverAction.typeText(enterMobileNo,"1234567890");
       DriverAction.typeText(enterExtNo,"111");
    }
    @When("^click on update$")
    public void clickOnUpdate(){
       DriverAction.click(clickOnUpdate);
       DriverAction.waitSec(10);
    }

    @When("^click on update address$")
    public void clickOnUpdateAdd(){
       DriverAction.click(popUpCloseButton);
       DriverAction.click(clickOnChangeDetails);
       DriverAction.waitSec(10);
       DriverAction.click(clickOnUpdateAdd);
       DriverAction.waitSec(10);
    }

    @When("^enter pinCode$")
    public void clickOnPinCode()
    {
        DriverAction.typeText(enterPincode,"121");
        DriverAction.waitSec(10);
        DriverAction.click(updateButtonAdd);
        DriverAction.waitSec(7);
    }

    @And("^verify invalid pincode$")
    public void enterInvalidPincode() {

        DriverAction.getElementText(invalidPincode);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "warningText", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @When("click on change password")
    public void clickOnChangePassword() {
        DriverAction.click(popUpCloseButton,"window close button");
        DriverAction.waitSec(3);
        DriverAction.click(clickOnChangeDetails,"update details");
        DriverAction.waitSec(10);
        DriverAction.click(changePassword,"change password");
        DriverAction.waitSec(7);
    }
        @And("^enter old password$")
        public void enterOldPassword() {
            /*DriverAction.click(popUpCloseButton,"window close button");
            DriverAction.waitSec(3);
            DriverAction.click(clickOnChangeDetails,"update details");
            DriverAction.waitSec(10);*/

            DriverAction.typeText(enterOldPassword, "12345");
            DriverAction.typeText(newPassword, "Gemini123");
            DriverAction.waitSec(5);
            DriverAction.typeText(confirmPassword, "Gemini123");
            DriverAction.click(updatePassword, "update password");
            DriverAction.waitSec(10);
        }
        @And("^verify the the password is incorrect$")
        public void verifyPasswordIncorrect(){
            DriverAction.getElementText(warning);
            String s = DriverAction.getElementText(warning);
            if (s.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "The old password you entered is not valid. Please try again with correct password.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.click(okButton);
    }
    /*@When("click on change password")
    public void clickOnChangePassword() {
        DriverAction.waitSec(10);
        DriverAction.click(changePassword,"change password button");
        DriverAction.waitSec(10);
    }*/

    @When("^enter new password and confirm password$")
    public void enterNewPasswordAndConfirmPassword() {
       DriverAction.click(popUpCloseButton,"close button");
       DriverAction.waitSec(3);
        DriverAction.click(clickOnChangeDetails,"change details button");
        DriverAction.waitSec(3);
        DriverAction.click(changePassword,"change password button");
        DriverAction.waitSec(5);
        DriverAction.typeText(newPassword,"Gemini");
        DriverAction.typeText(confirmPassword,"Gemini123");
        DriverAction.click(updatePassword,"update button");

    }

    @And("^click on update password$")
    public void clickOnUpdatePassword() {
       DriverAction.click(updatePassword,"update password button");
    }

    @Then("^verify password not match$")
    public void verifyPasswordNotMatch() {
       DriverAction.click(passwordNotMatch);
        String sl=DriverAction.getElementText(passwordNotMatch);
        if(sl.equals("Password and confirm password does not match"));
        GemTestReporter.addTestStep("Password and confirm password does not match","Password and confirm password does not match", STATUS.PASS,DriverAction.takeSnapShot());
    }

    @When("^click on close button$")
    public void clickOnCloseButton() {

        DriverAction.click(popUpCloseButton,"close button");
        DriverAction.click(clickOnChangeDetails,"change details button");
    }

    @When("^user click on apply lunch$")
    public void userClickOnApplyLunch() {
        DriverAction.click(popUpCloseButton,"close button");
        DriverAction.waitSec(10);
        DriverAction.click(applyLunch,"apply lunch");
        DriverAction.waitSec(5);
    }

    @And("^user click on from date and click on select from date$")
    public void userClickOnFromDate() {
        DriverAction.click(fromDate,"from date");
        DriverAction.click(selectFromDate,"select from date");
    }

    @And("^user click on till date and select till date$")
    public void userClickOnTillDate() {
        DriverAction.click(tillDate, "till date");
        DriverAction.click(selectTillDate,"select till date");
    }

    @And("^click on location container$")
    public void clickOnLocationContainer() {
        DriverAction.click(locationContainer,"location container");
    }

    @And("^select the location from the list$")
    public void selectTheLocationFromTheList() {
        DriverAction.click(selectLocation,"select location");
        DriverAction.waitSec(5);
    }

    @Then("^click on add lunch button$")
    public void clickOnAddLunchButton() {
        DriverAction.click(addLunchButton,"add lunch button");
    }

    @Then("^verify the warning message$")
    public void verifyTheWarningMessage() {
        //DriverAction.click(warning,"warning alert message");
        DriverAction.getElementText(warning);
        String s = DriverAction.getElementText(warning);
        if (s.equals("Warning")) {
            GemTestReporter.addTestStep("warning", "You have already applied for these dates.", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }


    @Then("^verify select is blank$")
    public void verifySelectIsBlank() {
       DriverAction.getElementText(locationContainer);
        String s=DriverAction.getElementText(locationContainer);
        if(s.equals("Select")){
            GemTestReporter.addTestStep("Select is blank", "Select is blank", STATUS.PASS, DriverAction.takeSnapShot());
        }

        }

    @Then("^verify the old password is blank$")
    public void verifyTheOldPasswordIsBlank() {
        DriverAction.getElementText(enterOldPassword);
        String sb=DriverAction.getElementText(enterOldPassword);
        if(sb.equals("old password")){
            GemTestReporter.addTestStep("old password is blank","Old password is blank",STATUS.PASS,DriverAction.takeSnapShot());
        }

    }
}


