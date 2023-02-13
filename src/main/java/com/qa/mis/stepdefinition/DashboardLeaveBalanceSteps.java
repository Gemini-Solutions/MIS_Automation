package com.qa.mis.stepdefinition;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.DashboardLeaveBalanceLocator;
import com.qa.mis.locators.NavBarLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardLeaveBalanceSteps {
    String leaveCount;
    @Then("Verify leave balance section is present on the current page")
    public void verifySection(){
        DriverAction.waitSec(5);
        DriverAction.scrollIntoView(DashboardLeaveBalanceLocator.leaveBalanceSection);
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(DashboardLeaveBalanceLocator.leaveheading));
        if (DriverAction.isExist(DashboardLeaveBalanceLocator.leaveheading)) {
            GemTestReporter.addTestStep("Verify Section", "Leave Section is present on the current page", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Section", "Leave Section is not present on the current page", STATUS.FAIL, DriverAction.takeSnapShot());

        }

    }

    @And("Click on number of leaves")
    public void clickOnNumberOfLeaves() {
        DriverAction.waitSec(2);
        if (DriverAction.isExist(DashboardLeaveBalanceLocator.linkleaveBalanceType)) {
            leaveCount = DriverAction.getElementText(DashboardLeaveBalanceLocator.linkleaveBalanceType);
            DriverAction.click(DashboardLeaveBalanceLocator.linkleaveBalanceType, "Leave Balance link");
        } else {
            GemTestReporter.addTestStep("Leave Balance link", "Leave Balance link is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify leave history popup should be open")
    public void verifyLeaveHistoryPopupShouldBeOpen() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(DashboardLeaveBalanceLocator.linkleavePopup));
        if (DriverAction.isExist(DashboardLeaveBalanceLocator.leaveHistoryHeading)) {
            DriverAction.click(DashboardLeaveBalanceLocator.leaveHistoryHeading, "Leave history heading is present");
        } else {
            GemTestReporter.addTestStep("Leave history", "Leave history heading is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify number of leaves record")
    public void verifyNumberOfLeaves() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(DashboardLeaveBalanceLocator.leavesRecords));
        if (DriverAction.isExist(DashboardLeaveBalanceLocator.leavesRecords)) {
            String records= DriverAction.getElementText(DashboardLeaveBalanceLocator.leavesRecords);
          //  leaveCount = "0";
            if(records.contains(leaveCount)){
                GemTestReporter.addTestStep("Verify Leaves Record ", "Leaves record matched", STATUS.PASS, DriverAction.takeSnapShot());

            }else{
                GemTestReporter.addTestStep(" Verify Leaves Record", "Leaves record not matched", STATUS.FAIL, DriverAction.takeSnapShot());

            }
       } else {
            GemTestReporter.addTestStep("Leave Record", "Leaves record is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}
