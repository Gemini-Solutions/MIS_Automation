package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class Locators {

    public static By username = By.id("username");
    public static By password = By.id("password");
    public static By signInButton = By.id("btnLogin");
    public static By forgotPasswordButton = By.id("lnkForgotPassword");
    public static By loginWithSSOButton = By.xpath("//button[@class='btn btn-rounded ssobtn']");
    public static By loginMsg = By.xpath("//div[@class='loginMsgDiv']");
    public static By loginErrorMessage = By.xpath("//span[@class='message']");
    public static By closeButton = By.xpath("//div[@id='skillsSettings']//button[@class='close']");
}
