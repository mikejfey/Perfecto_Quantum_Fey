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

    @FindBy(locator = "atmPage.showLocation")
    private QAFExtendedWebElement atmPageShowLocation;

    public void findATM() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
           atmPageAllowWhileUsing.click();
           atmPageGps.click();
           atmPageGetLocation.click();
           //Thread.sleep(2000);
            ReportUtils.logVerify("atm location",atmPageShowLocation.isDisplayed());

            System.out.println("its an android... there is a logout button");
        } else {

            System.out.println("its an ios... GPS is the default");
            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap 'get location' if a popup appears, select 'allow'",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );

        }

    }

    public void atmLocationVerify() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            ReportUtils.logVerify("atm location",atmPageShowLocation.isDisplayed());

            System.out.println("its an android... there is a logout button");
        } else {

            System.out.println("its an ios... GPS is the default");

        }

    }

}



