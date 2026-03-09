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

public class DigitalBankNavBarPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "navigation.bar.atm")
    private QAFExtendedWebElement navigationBarATM;

    @FindBy(locator = "navigation.bar.transfer")
    private QAFExtendedWebElement navigationBarTransfer;


    public void navigateToATM() {
        if (DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            navigationBarATM.click();
            System.out.println("its an android... there is a logout button");
        } else {

            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap ATM in the lower right",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );
        }


    }

public void navigateToTransfer() {
    if (DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
        navigationBarTransfer.click();
        System.out.println("its an android... there is a logout button");
    } else {

        Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                Map.of(
                        "action", "tap Transfer in the bottom navigation bar",
                        "reasoning", false,
                        "outputVariable", false
                )
        );
    }
  }


}
