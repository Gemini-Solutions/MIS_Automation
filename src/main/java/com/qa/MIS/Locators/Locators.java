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
    public static By forgotPasswordMessage = By.xpath("//span[@class='message']");
    public static By successMessage = By.xpath("//p[@class='lead text-muted '] ");
    public static By profileOption=By.xpath("//button[@id='dd-user-menu']");
    public static By logOutButton=By.xpath("//span[@class='font-icon glyphicon glyphicon-log-out']");

    public static By usernameByXpath = By.xpath("//input[@id='username']");

    public static By passwordByXpath = By.xpath("//input[@id='password']");
    public static By signInByXpath = By.xpath("//input[@id='btnLogin']");
    public static By closeSkills = By.id("btnskillsClose");
    //public static By closeSkills = By.className("close");
    public static By knowledgeBase = By.xpath("//span[text()='Knowledge Base']");
    public static By viewDocuments  = By.xpath("//span[text()='View Documents']");

    public static By addDocumentTag = By.xpath("//img[@title='Add New Document Tag']");

    public static By inputDocumentTag = By.id("txtTagName");

    public static By saveDocumentTag = By.id("btnSaveDocumentTag");

    public static By documentTagSuccessfullyAdded = By.xpath("//p[text()='Document tag Added Sucessfully']");

    public static By okButton = By.xpath("//button[text()='OK']");

    public static By documentTagWarningMessage = By.xpath("//p[text()='Please fill required field']");
    public static By attendanceMonth = By.xpath("//span[@id='select2-selectduration-container']");
    public static By folder = By.xpath("//a[text()='abc']");

    public static By addDocument = By.xpath("//a[text()='Add New document']");
    public static By deleteFolder = By.xpath("//a[text()='Delete']");

    public static By refresh = By.xpath("//img[@title='Refresh']");

    public static By upload = By.xpath("//input[@name='fileToUpload']");



    public static By searchDocument = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td[2]");

    public static By documentSearch = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td");
    public static By rename = By.xpath("//*[@id=\"myMenu\"]/li[4]/a");


    public static By dropdown = By.xpath("//*[@id=\"tbldocumentGridViewList_length\"]/label/select");

    public static By delete = By.xpath("//a[text()='Delete']");

    public static By titleSort = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/thead/tr/th[2]");

    public static By sortValue = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr[1]/td[2]");

    public static By search = By.xpath("//input[@type='search']");

    public static By userName = By.id("username");



    public static By signIn = By.id("btnLogin");

    public static By popUpCloseButton = By.xpath("//button[@id='btnskillsClose']");

    public static By clickOnChangeDetails = By.xpath("//i[@class='fa fa-edit']");

    public static By enterMobileNo = By.id("contactNo");

    public static By enterExtNo = By.id("extnNo");

    public static By clickOnUpdate = By.xpath("//button[@id='btnUpdate']");

    public static By clickOnUpdateAdd = By.xpath("//span[text()='Update Address']");

    public static By enterPincode = By.xpath("//input[@id='presentPincode']");

    public static By updateButtonAdd = By.xpath("//button[@id='btnUpdateAdd']");

    public static By warning = By.xpath("//h2[text()=\"Warning\"]");



    public static By warningText= By.xpath("//p[text()=\"Pin code should only be 6 digits.\"]");
    public static By invalidPincode = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    public static By enterOldPassword=By.id("txtOldPassword");
    public static By changePassword= By.xpath("//span[text()='Change Password']");

    public static By newPassword=By.xpath("//input[@id='txtNewPassword']");

    public static By confirmPassword=By.xpath("//input[@id='txtconfirmPassword']");

    public static By updatePassword=By.xpath("//button[@id='btnChangePassword']");

    public static By passwordNotMatch=By.xpath("//span[@id='password_match']");

    public static By applyLunch=By.xpath("//i[@class='fa fa-cutlery']");

    public static By fromDate=By.xpath("//input[@name='fromDate']");

    public static By selectFromDate=By.xpath("(//td[@class='day'])[1]");

    public static By tillDate=By.xpath("//input[@id='tillDateEmp']");

    public static By selectTillDate=By.xpath("(//td[@class='day'])[3]");

    public static By locationContainer=By.xpath("//span[@id='select2-location-container']");

    public static By selectLocation=By.xpath("//li[text()='Canaan Tower']");

    public static By addLunchButton=By.xpath("//button[@id='BtnsaveDateforLunch']");


}
