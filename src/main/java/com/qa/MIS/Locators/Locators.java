package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class Locators {

    public static By Username = By.id("username");
    public static By Password = By.id("password");
    public static By Signbutton = By.id("btnLogin");

    public static By SkillPopup = By.id("mypopupUpdateSkills");
    public static By PopupClosebutton = By.xpath("//div[@id='mypopupUpdateSkills']//button[@class='close']");

    public  static By UserSection = By.className("widget-user");

    public static By Togglebtn = By.className("toggle-menu");

    public static By Sidebar = By.tagName("nav");

    public static  By Profilemenu = By.id("dd-user-menu");

    public static By UpdateProfileOption = By.id("updateProfile");

    public static By UpdateProfileSection = By.id("divUpdateProfile");


    public static By navigation_tabs(String tab) {
        System.out.println(tab);
        return By.xpath("//ul[@class='nav']/li//span[text()='" + tab + "']");
    }

    public static By fields(String field) {
        return By.xpath("//div[@role='tabpanel']//label[text()='" + field + "']");
    }

    public static By buttons(String button){
        return By.xpath("//div[@class='tab-pane active']//button[contains(text(),'"+button+"')]");
    }

    public static By SiteLogo = By.xpath("//a[@class='site-logo']/img");

    public static By SkillsOption = By.id("skills");
}


