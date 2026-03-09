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


public class DigitalBankHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "homePage.toolBar.icon")
    private QAFExtendedWebElement toolBar;

    @FindBy(locator = "homePage.toolBar.logout")
    private QAFExtendedWebElement logoutButton;

    @FindBy(locator = "homePage.bottomNav.pieChart")
    private QAFExtendedWebElement pieChart;

    @FindBy(locator = "navigation.bar.home")
    private QAFExtendedWebElement navigationBarHome;

    @FindBy(locator = "homePage.acctSelector")
    private QAFExtendedWebElement acctSelector;

    @FindBy(locator = "homePage.acctSelector.savings")
    private QAFExtendedWebElement acctSelectorSavings;

    @FindBy(locator = "homePage.acctSelector.checking")
    private QAFExtendedWebElement acctSelectorChecking;


    public void logout() {

        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            toolBar.click();
            logoutButton.click();
                System.out.println("its an android... there is a logout button");
            	} else {
                    System.out.println("its an ios... need AI");
            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap the tool bar icon in the upper right corner",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );

            }
        }

    public void selectIndividualSavingsAccount() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            acctSelector.click();
            acctSelectorSavings.click();
            Thread.sleep(2000);


        } else {
            System.out.println("its an ios... need AI");
            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap the Account Selection dropdown",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );
        }

         }

    public void selectIndividualCheckingAccount() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            acctSelector.click();
            acctSelectorChecking.click();
        } else {
            System.out.println("its an ios... need AI");
            Boolean result = (Boolean) driver.executeScript("perfecto:ai:user-action",
                    Map.of(
                            "action", "tap the Account Selection dropdown",
                            "reasoning", false,
                            "outputVariable", false
                    )
            );

        }

      }

      public void softAssertCheckingAccount() throws InterruptedException {
        if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
            ReportUtils.logVerify("Savings flow test",acctSelector.isDisplayed());
        } else {
        System.out.println("its an ios... need AI");
            }
      }

      public void navToATM() throws InterruptedException {
          if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("android")) {
              ReportUtils.logVerify("Savings flow test",acctSelector.isDisplayed());
          } else {
              System.out.println("its an ios... need AI");
          }
      }
    }

