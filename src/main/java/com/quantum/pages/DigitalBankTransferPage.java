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
import org.openqa.selenium.Keys;

public class DigitalBankTransferPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "transferPage.depositAmount")
    private QAFExtendedWebElement depositAmount;

    @FindBy(locator = "transferPage.description")
    private QAFExtendedWebElement description;

    @FindBy(locator = "transferPage.submit")
    private QAFExtendedWebElement submit;

    public void makeTransfer() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            depositAmount.click();
            depositAmount.sendKeys("50");
            description.click();
            description.sendKeys("pay check");
            submit.click();
            Thread.sleep(3000);
            System.out.println("its an android..");
        } else {
            System.out.println("its an ios... need AI");

        }
    }
    public void validateAtmLocation() {
         if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {

        System.out.println("its an android..");
    } else {
             System.out.println("its an ios... need AI");
         }
    }

}




