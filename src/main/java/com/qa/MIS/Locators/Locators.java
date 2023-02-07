package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class Locators {
    public static By geminiLogo = By.xpath("//img[contains(@src, 'Gemini')]");
    public static By txtUserName = By.xpath("//input[@id='username']");
    public static By txtPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//input[@id='btnLogin']");

    //----------------------------------LNSA Locators----------------------------------//

    public static By LNSA_HOME = By.xpath("//span[text()='LNSA']/..");
    public static By LNSA_APPLY_LNSA = By.xpath("//a[contains(@href, 'Lnsa/Apply')]/span");
    public static By LNSA_APPLY_TEXT = By.xpath("//h5[contains(text(), 'LNSA')]");
    public static By LNSA_VIEW_REQUEST_STATUS = By.xpath("//a[contains(@href, 'Lnsa/View')]/span");
    public static By LNSA_NEXT_BUTTON = By.xpath("//input[contains(@id,'Next')]");
    public static By LNSA_PREVIOUS_BUTTON = By.xpath("//input[contains(@id,'Previous')]");
    public static By LNSA_START_DATE = By.xpath("//span[@id='startDate']");
    public static By LNSA_END_DATE = By.xpath("//span[@id='endDate']");
    public static By LNSA_SUBMIT_BUTTON = By.xpath("//button[@id = 'btnReasonPop']");
    public static By LNSA_OK_BUTTON = By.xpath("//button[text() = 'OK']");
    public static By LNSA_WARNING_MSG = By.xpath("//p[contains(text(), 'date.')]");
    public static String LNSA_WEEK_SELECT = "//input[contains(@id,'selectAll')]";

}
