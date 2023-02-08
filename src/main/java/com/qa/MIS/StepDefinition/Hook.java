package com.qa.MIS.StepDefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;

import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {
    @Before
    public void start()  {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.addArguments("--start-maximized");
            //  options.addArguments("--headless");
            DriverManager.initializeChrome(options);
            DriverAction.launchUrl(GemJarUtils.getGemJarConfigData("launchUrl"));
            DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
            DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
            DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));

    }
}
