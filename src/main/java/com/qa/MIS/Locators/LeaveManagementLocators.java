package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class LeaveManagementLocators {

    public static By input_loginUsername = By.xpath("//input[@id='username']");
    public static By input_loginPassword = By.xpath("//input[@id='password']");
    public static By button_SignIn = By.xpath("//input[@id='btnLogin']");
    public static By menu_HomePage = By.xpath("//ul[@class='side-menu-list']");

    public static By menu_parentTabs(String parentTab) {
        return By.xpath("//ul[@class='side-menu-list']//span[text()='" + parentTab + "']");
    }

    public static By menu_childTabs(String childTab) {
        return By.xpath("//ul[@class='side-menu-list']//ul/li//span[text()='" + childTab + "']");
    }

    public static By heading_Page = By.xpath("//div[@class='card-block']/h5");

    public static By navigation_tabs(String tab) {
        return By.xpath("//ul[@class='nav']/li//span[text()='" + tab + "']");
    }

    public static By title_LeaveFields(String tab) {
        return By.xpath("//div[@id='" + tab + "']/section/div/div/div[not(contains" +
                "(@style,'none'))]//label");
    }

    public static By button_leaveSubmit(String tab) {
        return By.xpath("//div[@id='" + tab + "']/section//input[@value='Submit']");
    }

    public static By field_leaveTextFields(String field) {
        return By.xpath("//input[@id='" + field + "']");
    }

    public static By field_leaveDropDown(String field) {
        return By.xpath("//select[@id='" + field + "']");
    }

    public static By field_leaveTextArea(String field) {
        return By.xpath("//textarea[@id='" + field + "']");
    }
}
