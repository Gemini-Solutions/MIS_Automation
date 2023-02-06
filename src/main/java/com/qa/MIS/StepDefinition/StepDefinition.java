package com.qa.MIS.StepDefinition;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.MIS.Locators.Locators;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class StepDefinition {

    @Given("^User should be on MIS login page and enter (.*) and (.*)$")
    public void UserEnterCredentials(String Username,String Password){
        DriverAction.waitSec(5);
        DriverAction.typeText(Locators.Username,Username);
        DriverAction.typeText(Locators.Password,Password);
    }
    @When("User clicked on submit button")
    public void User_clicked_on_submit_button(){
        DriverAction.waitSec(5);
        DriverAction.click(Locators.Signbutton);

    }
    @And("User should be able to navigated to the mis homepage")
    public void User_should_be_able_to_navigated_to_the_mis_homepage(){
        DriverAction.waitSec(15);

        WebElement popup = DriverAction.getElement(Locators.SkillPopup);

        if(popup.isDisplayed()){
            DriverAction.click(Locators.PopupClosebutton);
            DriverAction.waitSec(5);
        }
       WebElement Usersection = DriverAction.getElement(Locators.UserSection);
        if(Usersection.isDisplayed()){
            GemTestReporter.addTestStep("MIS Homepage","User is on homepage of MIS",STATUS.PASS);
        }
        else{
            GemTestReporter.addTestStep("MIS Homepage","User is not able navigated to the homepage", STATUS.FAIL);
        }
}
@Then("User verify a toggle button is present on Dashboard and clickable")
    public void Toggleclickability(){
    String sidebarclass="";
        WebElement toggle = DriverAction.getElement(Locators.Togglebtn);
    WebElement menu = DriverAction.getElement(Locators.Sidebar);
   sidebarclass = menu.getAttribute("class");
        if(toggle.isDisplayed()){
          System.out.println(sidebarclass);
          if(sidebarclass.equalsIgnoreCase("side-menu jspScrollable")){
              DriverAction.click(toggle);
              DriverAction.waitSec(5);
               sidebarclass = menu.getAttribute("class");
              System.out.println(sidebarclass);
              if(sidebarclass.equalsIgnoreCase("side-menu")){
                  GemTestReporter.addTestStep("Toggle button clickability","button is working correctly",STATUS.PASS);
              }else {
                  GemTestReporter.addTestStep("Toggle button clickability","button is not working correctly",STATUS.FAIL);
              }
          }

        }
}
    @Then("User click on Profile menu")
     public void ClickProfileMenu(){
        DriverAction.click(Locators.Profilemenu);
        DriverAction.waitSec(2);
        DriverAction.click(Locators.UpdateProfileOption);
        DriverAction.waitUntilElementAppear(Locators.UpdateProfileSection,10);
//        DriverAction.waitSec(5);
    }
@And("^User Verify all the (.*) and (.*) are present")
    public void VerifyFields(String Fields,String Buttons){

        String[] Sections = Fields.split(";");
        System.out.println(Sections.length);
        String[] Tabs;
        int flag = 0;
        ArrayList<String> Tabname = new ArrayList<String>();
        for (int i =0;i<Sections.length;i++){
            Tabs=Sections[i].split(":");
            String tabname = Tabs[0];
            String[] fields = Tabs[1].split(",");
            System.out.println(tabname);
        if(tabname!="Update Profile"){
           DriverAction.click(Locators.navigation_tabs(tabname));}
           DriverAction.waitSec(5);

            for (int j =0;j<fields.length;j++) {
            WebElement field = DriverAction.getElement(Locators.fields(fields[j]));
            if(field.isDisplayed()){
                flag =1;

                System.out.println(field.getText());
            }
            else{
                flag=0;
                break;
            }
            }
            String[] buttons = Buttons.split(",");
            for (String button: buttons) {
               WebElement btn = DriverAction.getElement(Locators.buttons(button));
               if(btn.isDisplayed()){
                   flag=1;
                   System.out.println(btn.getText());
               }else {
                   flag=0;
                   break;
               }
            }
            if(flag==1){

            }else {
                GemTestReporter.addTestStep("verify all the fields","All the fields are not present ",STATUS.FAIL);
            }

        }

}
@Then("User click on Gemini logo")
    public void ClickLogo(){
        DriverAction.click(Locators.SiteLogo);
        WebElement Popup = DriverAction.getElement(Locators.SkillPopup);
        DriverAction.waitUntilElementAppear(Popup,5);
        if(Popup.isDisplayed()){
            GemTestReporter.addTestStep("Click on Gemini logo","After click on logo user redirect to landing page",STATUS.PASS);
        }
}
@Then("User click on Skills menu")
    public void ClickSkill(){
    DriverAction.click(Locators.Profilemenu);
    DriverAction.waitSec(2);
    DriverAction.click(Locators.SkillsOption);
    DriverAction.waitUntilElementAppear(Locators.UpdateProfileSection,10);


}

@And("User Enter all the details (.*),(.*),(.*),(.*),(.*) and click on close button")

    public void Enterdetails(String Technology,String ProficiencyLevel,String SkillType,String TechExperience,String TotalWorkExp){


        }


    }

