package com.qa.mis.locators;

import org.openqa.selenium.By;

public class ApplyToAnyCardLocator {
    public static By cardNameBeta(String cardName) {
        return By.xpath("(//h3[text()='" + cardName + "']//parent::header/div/ul/li)[1]/a");
    }

    public static By minimiseMaximizeButton(String btn, String cardName) {
        if (btn.contains("minimize")) {
            return By.xpath("(//h3[text()='" + cardName + "']//parent::header/div/ul/li)[1]/a");
        }
        return By.xpath("(//h3[text()='" + cardName + "']//parent::header/div/ul/li)[2]/a");
    }

    public static By collapsedCard = By.xpath("//section[contains(@class, 'panel-collapsed')]/header/h3");
    public static By expandedCard = By.xpath("//section[contains(@class, 'panel-expanded')]/header/h3");
}
