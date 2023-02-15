package com.qa.mis.locators;

import org.openqa.selenium.By;

public class ReferalLocator {


    public static By dashboardVisible=By.xpath("//span[text()='Dashboard']");

   // public static By dsbrdVisible=By.xpath("//a[@href='https://mymis.geminisolutions.com/Dashboard/Index']");

    public static By verifyJdWindow=By.xpath("//section[@id='Referrals']");

    public static By referralAction=By.xpath("//button[@title='Refer']");

    public static By refName=By.xpath("//input[@maxlength='200']");

    public static By refSection=By.xpath("//section[@id='Referrals']");

    public static By refEmail=By.xpath("(//input[@maxlength='200'])[2]");

    public static By refSaveButton=By.xpath("//button[@id='btnAddReferral']");

    public static By refWarning=By.xpath("//h2[text()='Warning']");

}
