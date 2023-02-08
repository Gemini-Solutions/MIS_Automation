package com.qa.MIS.StepDefination;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class HookAM {
    @Before
    public void start() throws GemException {
        DriverManager.setUpBrowser();
        DriverAction.setImplicitTimeOut(2000);
        DriverAction.maximizeBrowser();
    }
}
