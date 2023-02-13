package com.qa.mis.stepdefinition;
import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;


public class Hook {
    @Before
    public void start() throws GemException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-extensions");
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--proxy-server='direct://'");
//        options.addArguments("--proxy-bypass-list=*");
//        options.addArguments("--start-maximized");
//        // options.addArguments("--headless");
//        DriverManager.initializeChrome(options);
//        DriverAction.launchUrl(GemJarUtils.getGemJarConfigData("launchUrl"));
        DriverManager.setUpBrowser();
        DriverAction.maximizeBrowser();
//        DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
//        DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
//        DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));
    }
}

