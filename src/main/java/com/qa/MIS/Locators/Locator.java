package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class Locator {

    public static By txtUserName = By.xpath("//input[@id='username']");
    public static By txtPassword = By.xpath("//input[@id='password']");
    public static By btnSignIn = By.xpath("//input[@id='btnLogin']");
    public static By HomePageLogo= By.xpath("//img[@class='hidden-md-down']");
    public static By errorUserName= By.xpath("//span[contains(text(),'Username is required')]");
    public static By lnkApraisalMgmnt=By.xpath("//span[contains(text(),'Appraisal Management')]");
    public static By lnkAddGoals=By.xpath("//span[contains(text(),'Add Goals')]");
    public static By addGoalsWindow=By.xpath("//h5[contains(text(),'Add My Goal/Team Goal')]");
    public static By lnkKRA_KPI=By.xpath("//a[contains(text(),'List of KRAs and KPIs')]");
    public static By btnAddNewKRAKPIMapping=By.xpath("//button[contains(text(),'Add New KRA/KPI Mapping')]");
    public static By drpdownFinancialYear=By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    public static By elementsdrpFinancialYear=By.xpath("//li[contains(@class,'select2-results__option')]");
}
