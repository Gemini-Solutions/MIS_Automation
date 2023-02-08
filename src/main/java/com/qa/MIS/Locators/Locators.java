package com.qa.MIS.Locators;

import org.openqa.selenium.By;

public class Locators {
    public static By username = By.xpath("//input[@id='username']");

    public static By password = By.xpath("//input[@id='password']");
    public static By signIn = By.xpath("//input[@id='btnLogin']");
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

    public static By search = By.xpath("//input[@type='search']");

    public static By searchDocument = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td[2]");

    public static By documentSearch = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td");
    public static By rename = By.xpath("//*[@id=\"myMenu\"]/li[4]/a");


    public static By dropdown = By.xpath("//*[@id=\"tbldocumentGridViewList_length\"]/label/select");

    public static By delete = By.xpath("//a[text()='Delete']");

    public static By titleSort = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/thead/tr/th[2]");

    public static By sortValue = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr[1]/td[2]");

}
