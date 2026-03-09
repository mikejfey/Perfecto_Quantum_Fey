package com.quantum.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import org.openqa.selenium.By;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;


public class DigitalBankAtmPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "atmPage.atmGPS")
    private QAFExtendedWebElement atmPageGps;

    @FindBy(locator = "atmPage.allowWhileUsing")
    private QAFExtendedWebElement atmPageAllowWhileUsing;

    @FindBy(locator = "atmPage.getLocation")
    private QAFExtendedWebElement atmPageGetLocation;

    public void findATM() {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
           atmPageAllowWhileUsing.click();
           atmPageGps.click();
           atmPageGetLocation.click();

            System.out.println("its an android... there is a logout button");
        } else {

            System.out.println("its an ios... GPS is the default");
            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap 'get location'",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );

        }

    }

}



/*
atmPage.allowWhileUsing=id=com.android.permissioncontroller:id/permission_allow_foreground_only_button
atmPage.atmGPS=xpath=//*[@resource-id="xyz.digitalbank.demo:id/checkbox1"]
atmPage.getLocation=id=xyz.digitalbank.demo:id/getLocationButton*/
