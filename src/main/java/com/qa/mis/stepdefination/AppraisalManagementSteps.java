package com.qa.mis.stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.AppraisalManagementLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qa.mis.utility.FileDownloaded;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AppraisalManagementSteps {
    Logger logger = LoggerFactory.getLogger(AppraisalManagementSteps.class);
    public String mainWindowHandle = null;
    Boolean output = false;
    STATUS status;
    String totalEntries = null;

    @Given("^Launch MIS Url (.+)$")
    public void launch_MIS_Url(String url) {
        DriverAction.waitSec(3);
        String currenturl = DriverAction.getCurrentURL();
        if (currenturl.equals(url))
            GemTestReporter.addTestStep("Url Validation", "Successful<br>Expected URL: " + url + "<br>Actual URL: " + currenturl, STATUS.PASS, DriverAction.takeSnapShot());
        // else
        //   GemTestReporter.addTestStep("Url Validation", "Unsuccessful<br>Expected URL: " + url + "<br>Actual URL: " + currenturl, STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Enter Username (.+) and password (.+)$")
    public void enter_username_and_password(String userName, String password) {
        status = DriverAction.typeText(AppraisalManagementLocator.txtUserName, userName);
        //   GemTestReporter.addTestStep("Enter User Name", "User name is entered", status, DriverAction.takeSnapShot());
        byte[] decodingString = Base64.decodeBase64(password);
        String passwordDecoded = new String(decodingString);
        status = DriverAction.typeText(AppraisalManagementLocator.txtPassword, passwordDecoded);
        //    GemTestReporter.addTestStep("Enter Password", "Password is entered", status, DriverAction.takeSnapShot());
    }

    @Then("User clicks on Sign-in button")
    public void user_clicks_on_signIn_button() {
        status = DriverAction.click(AppraisalManagementLocator.btnSignIn);
        //  GemTestReporter.addTestStep("User clicks on Sign-in button", "Successfully clicked on Sign in button", status, DriverAction.takeSnapShot());
        mainWindowHandle = DriverAction.getWindowHandle();
    }

    @Then("Login will be successful and homepage will be displayed.")
    public void login_will_be_successful_and_homepage_will_be_displayed() {
        try {
//            DriverAction.switchToWindow(mainWindowHandle);
//            String string = DriverAction.getWindowHandle();
            DriverAction.waitSec(7);
            Boolean bool = DriverAction.getElement(AppraisalManagementLocator.homePageLogo).isDisplayed();
            STATUS status;
            if (bool)
                status = STATUS.PASS;
            else
                status = STATUS.FAIL;
            //   GemTestReporter.addTestStep("Login will be successful and homepage will be displayed ", "Successfully logged in", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occured !", e);
            //   GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @When("User click on Sign-in button")
    public void user_click_on_sign_in_button() {
        try {
            DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnSignIn, 3);
            DriverAction.click(AppraisalManagementLocator.btnSignIn);
        } catch (Exception e) {
            logger.info("An exception occured !", e);
            //   GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @Then("Login failed pop up will be displayed")
    public void login_failed_pop_up_will_be_displayed() {
        try {

            Boolean bool = DriverAction.getElement(AppraisalManagementLocator.errorUserName).isDisplayed();
            STATUS status;
            if (bool)
                status = STATUS.PASS;
            else
                status = STATUS.FAIL;
            //  GemTestReporter.addTestStep("Failure Pop Up", "Expected : should be displayed", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occured !", e);
            //  GemTestReporter.addTestStep("Execution Failed", "Some Error Occurred", STATUS.FAIL);
        }
    }

    @When("Click on Appraisal Management link")
    public void click_on_appraisal_management_link() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lnkApraisalMgmnt, 3);
        status = DriverAction.click(AppraisalManagementLocator.lnkApraisalMgmnt);
        //    GemTestReporter.addTestStep("Click on Appraisal Management link", "Appraisal Management link is clicked", status, DriverAction.takeSnapShot());
    }

    @Then("Click on Add Goals link")
    public void click_on_add_goals_link() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lnkAddGoals, 2);
        status = DriverAction.click(AppraisalManagementLocator.lnkAddGoals);
        DriverAction.waitSec(3);
        // GemTestReporter.addTestStep("Click on Add Goals link", "Add Goals link is clicked", status, DriverAction.takeSnapShot());
    }

    @Then("Verify Add goal window")
    public void verify_add_goal_window() {
        output = false;
        output = DriverAction.getElement(AppraisalManagementLocator.addGoalsWindow).isDisplayed();
        if (output)
            status = STATUS.PASS;
        else
            status = STATUS.FAIL;
        // GemTestReporter.addTestStep("Verify Add goal window", "Add goal window should be displayed", status, DriverAction.takeSnapShot());
    }

    @Then("Verify financial year dropdown")
    public void verify_financial_year_dropdown() {
        Calendar cal = Calendar.getInstance();
        Date d = new Date();
        int year = Year.now().getValue();
        cal.set(year - 1, 3, 1);
        Date firstAprilOfYear = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMM yyyy");

        String date1 = format1.format(firstAprilOfYear);
        System.out.println(date1);

        status = DriverAction.click(AppraisalManagementLocator.drpdownFinancialYear);
        DriverAction.waitSec(1);
        List<WebElement> lstFinacialYr = DriverAction.getElements(AppraisalManagementLocator.elementsdrpFinancialYear);
        for (int i = 0; i < lstFinacialYr.size(); i++) {
            String str = lstFinacialYr.get(i).getText();
            if (str.equalsIgnoreCase("All") || str.contains(date1))
                status = STATUS.PASS;
            if (status == STATUS.FAIL)
                break;
        }
        // GemTestReporter.addTestStep("Verify financial year dropdown", "Dropdown should have Current Finacial Year", status, DriverAction.takeSnapShot());
    }

    @Then("Verify link for list of KRAs and KPIs")
    public void verify_link_for_list_of_kr_as_and_kp_is() {
        DriverAction.waitSec(1);
        status = DriverAction.click(AppraisalManagementLocator.lnkKRA_KPI);
        //  GemTestReporter.addTestStep("Verify link for list of KRAs and KPIs", "List of KRAs and KPIs link is clicked", status, DriverAction.takeSnapShot());
    }

    @And("Verify My Goal tab")
    public void verify_my_goa_tab() {
        String tabTitle = DriverAction.getElementText(AppraisalManagementLocator.tabMyGoal);
        if (tabTitle.equalsIgnoreCase("My Goal"))
            status = STATUS.PASS;
        else
            status = STATUS.FAIL;
    }

    @Then("Verify Add new KPI-KRA mapping button")
    public void verify_Add_New_KPIKRA_Mapping_Button() {
        output = false;
        output = DriverAction.getElement(AppraisalManagementLocator.btnAddNewKRAKPIMapping).isEnabled();
        if (output) {
            DriverAction.click(AppraisalManagementLocator.btnAddNewKRAKPIMapping);
            status = STATUS.PASS;
        } else
            status = STATUS.FAIL;
    }

    @Given("Click on Add new KPI-KRA mapping button")
    public void click_On_Add_New_KPIKRA_MappingButton() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnAddNewKRAKPIMapping, 2);
        DriverAction.click(AppraisalManagementLocator.btnAddNewKRAKPIMapping);
    }

    @Then("Verify Add goal window is open")
    public void verify_Add_Goal_Window_Is_Open() {
        // DriverAction.waitUntilElementAppear(AppraisalManagementLocator.addGoalsWindow, 2);
        //DriverAction.click(AppraisalManagementLocator.addGoalsWindow);


    }

    @Then("Click on submit button")
    public void click_On_Submit_Button() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnSubmit, 2);
        if (DriverAction.getElement(AppraisalManagementLocator.btnSubmit).isDisplayed() && DriverAction.getElement(AppraisalManagementLocator.btnSubmit).isEnabled()) {
            DriverAction.waitSec(1);
            DriverAction.click(AppraisalManagementLocator.btnSubmit);
            DriverAction.waitSec(2);
            status = STATUS.PASS;
        }
    }

    @Then("Click on close button")
    public void click_On_Close_Button() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnClose, 2);
        DriverAction.getElement(AppraisalManagementLocator.btnClose).isEnabled();
        DriverAction.waitSec(2);
        DriverAction.click(AppraisalManagementLocator.btnClose);
        DriverAction.waitSec(1);
    }

    @Then("Check validation for KRA textbox")
    public void check_Validation_For_KRA_Textbox() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.txtKRA, 2);
        DriverAction.getElement(AppraisalManagementLocator.txtKRA).isEnabled();
        //cssvalue code to be written
    }

    @Then("Validate and click add KPI button")
    public void validate_And_Click_Add_KPI_Button() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnAddKPI, 2);
        DriverAction.click(AppraisalManagementLocator.btnAddKPI);
        if (DriverAction.getElement(AppraisalManagementLocator.txtKPIDescription).isDisplayed()) {
            DriverAction.typeText(AppraisalManagementLocator.txtKPIDescription, "TestKPI");
            status = STATUS.PASS;
        } else
            status = STATUS.FAIL;
        //    GemTestReporter.addTestStep("Validate add KPI button", "KPA button is present and clickable", status, DriverAction.takeSnapShot());
    }

    @Then("Check validation for KPA textbox")
    public void check_Validation_For_KPA_Textbox() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.txtKPIDescription, 2);
        DriverAction.getElement(AppraisalManagementLocator.txtKPIDescription).isEnabled();
        //css value code to be write
    }

    @And("Enter KRA in textbox")
    public void enter_KRA_In_Textbox() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.txtKRA, 2);
        DriverAction.typeText(AppraisalManagementLocator.txtKRA, "TestKRA");

    }

    @And("Enter KPI description in text box")
    public void enter_KPI_Description_In_TextBox() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.txtKPIDescription, 2);
        DriverAction.typeText(AppraisalManagementLocator.txtKPIDescription, "TestKPIDescription");
    }

    @Then("Verify Success Popup appeared on screen and click on Ok button")
    public void verify_Success_Popup_Appeared_On_Screen_And_Click_On_OkButton() {

        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.KPISuccessOK, 2);
        DriverAction.click(AppraisalManagementLocator.KPISuccessOK);
        //  GemTestReporter.addTestStep("Add new KPI-KRA mapping in add goal window", "New KPI-KRA mapping in add goal window added", status, DriverAction.takeSnapShot());
    }

    @And("Check validation for empty Goal type Dropdown")
    public void check_Validation_For_Empty_Goal_Type_Dropdown() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.popupWarning, 2);
        if (DriverAction.getElementText(AppraisalManagementLocator.popupWarning).equalsIgnoreCase("Warning")) {
            DriverAction.click(AppraisalManagementLocator.btnOKWarning);
            status = STATUS.PASS;
            //DriverAction.click(AppraisalManagementLocator.KPISuccessOK);
        } else
            status = STATUS.FAIL;
    }

    @Then("Select any one option from Goal Type Dropdown")
    public void select_Any_One_Option_From_Goal_Type_Dropdown() {
        DriverAction.click(AppraisalManagementLocator.drpdownGoalType);
        List<WebElement> lstKRA = DriverAction.getElements(AppraisalManagementLocator.kRAList);
        lstKRA.get(0).click();
    }


    @Then("Click on close button of newly added KPI")
    public void click_On_Close_Button_Of_Newly_Added_KPI() {
        List<WebElement> btnClose = DriverAction.getElements(AppraisalManagementLocator.btnCloseKPI);
        btnClose.get(btnClose.size() - 1).click();
    }

    @When("Verify search entries count at bottom")
    public void verify_Search_Entries_Count_At_Bottom() {
        DriverAction.waitSec(2);
        totalEntries = DriverAction.getElementText(AppraisalManagementLocator.searchEntriesCount);
        status=STATUS.PASS;
        GemTestReporter.addTestStep("Verify search entries count at bottom", "Search entries count at bottom: " , STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Given("Type text in searchbox and verify search results")
    public void type_Text_In_Searchbox_And_Verify_Search_Results() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnSearch, 2);
        Boolean bool = DriverAction.getElement(AppraisalManagementLocator.btnSearch).isEnabled();
        DriverAction.typeText(AppraisalManagementLocator.btnSearch, "Behavioural");
        String searchEntries = DriverAction.getElementText(AppraisalManagementLocator.searchEntriesCount);
        if (!searchEntries.equalsIgnoreCase(totalEntries))
            status = STATUS.PASS;
        else
            status = STATUS.FAIL;
    }


    @Then("Clear text and verify original count at the bottom of the table")
    public void clear_Text_And_Verify_Original_Count_At_The_Bottom_Of_The_Table() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnSearch, 2);
        DriverAction.clearText(AppraisalManagementLocator.btnSearch);
        String entriesClearSearch = DriverAction.getElementText(AppraisalManagementLocator.searchEntriesCount);
        if (entriesClearSearch.equalsIgnoreCase(totalEntries))
            status = STATUS.PASS;
        else
            status = STATUS.FAIL;
    }
    @Given("Verify button is enabled and clickable")
    public void verify_button_is_enabled_and_clickable() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.btnExport, 2);
        if (DriverAction.getElement(AppraisalManagementLocator.btnExport).isEnabled() && DriverAction.getElement(AppraisalManagementLocator.btnExport).isEnabled()) {
            status = STATUS.PASS;
        } else
            status = STATUS.FAIL;
    }
    @Then("Click on Copy option and  and paste it in notepad")
    public void click_on_copy_option_and_and_paste_it_in_notepad() throws IOException {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lstExport, 2);
        List<WebElement> lstExport = DriverAction.getElements(AppraisalManagementLocator.lstExport);
        for (int i = 0; i < lstExport.size(); i++) {
            if (lstExport.get(i).getText().equalsIgnoreCase("Copy")) {
                ProcessBuilder pb=new ProcessBuilder("Notepad.exe","myFile.txt");
                pb.start();
                JFrame window = new JFrame("Notepad");
                window.setSize(600, 600);
                JTextArea txtArea = new JTextArea();
                JScrollPane scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            }
        }
    }

    @Then("Click on Excel option and check excel file is downloaded")
    public void click_on_excel_option_and_check_excel_file_is_downloaded() throws IOException {
        DriverAction.click(AppraisalManagementLocator.btnExport);
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lstExport, 2);
        Boolean a=DriverAction.getElement(AppraisalManagementLocator.lstExport).isDisplayed();
        List<WebElement> lstExport = DriverAction.getElements(AppraisalManagementLocator.lstExport);
        for (int i = 0; i < lstExport.size(); i++) {
            if (lstExport.get(i).getText().equalsIgnoreCase("Excel")) {
                lstExport.get(i).click();
                Boolean result= FileDownloaded.isFileDownloaded("All Self Goals", "xlsx", 5000);
                if(result=true)
                    status=STATUS.PASS;
                else
                    status=STATUS.FAIL;
                FileDownloaded.fileDeleted("All Self Goals", "xlsx", 5000);
            }
        }
    }

    @Then("Click on PDF option and check pdf file is downloaded")
    public void click_on_pdf_option_and_check_pdf_file_is_downloaded() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lstExport, 2);
        List<WebElement> lstExport = DriverAction.getElements(AppraisalManagementLocator.lstExport);
        for (int i = 0; i < lstExport.size(); i++) {
            if (lstExport.get(i).getText().equalsIgnoreCase("PDF")) {

            }
        }
    }

    @Then("Click on Print option and check print window open in new tab")
    public void click_on_print_option_and_check_print_window_open_in_new_tab() {
        DriverAction.waitUntilElementAppear(AppraisalManagementLocator.lstExport, 2);
        List<WebElement> lstExport = DriverAction.getElements(AppraisalManagementLocator.lstExport);
        for (int i = 0; i < lstExport.size(); i++) {
            if (lstExport.get(i).getText().equalsIgnoreCase("Print")) {

            }
        }
    }

    @Then("Close Print window")
    public void close_print_window() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Check number of pages in dropdown")
    public void check_number_of_pages_in_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}