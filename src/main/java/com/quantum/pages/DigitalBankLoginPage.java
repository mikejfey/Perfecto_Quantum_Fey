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

public class DigitalBankLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "loginPage.signUpHere")
    private QAFExtendedWebElement signUpHere;

    @FindBy(locator = "loginPage.loginButton")
    private QAFExtendedWebElement loginButton;

    @FindBy(locator = "loginPage.email.textField")
    private QAFExtendedWebElement emailField;

    @FindBy(locator = "loginPage.password.textField")
    private QAFExtendedWebElement passwordField;


    public void verifyDigitalBankLoginScreen() {

        Map<String, Object> params = new HashMap<>();
        params.put("content", "Bank");
        params.put("timeout", "15");
        driver.executeScript("mobile:text:find", params);
    }

    public void clickSignUpHere() {
        signUpHere.click();
    }

    public void loginBanking() {
        //emailField.click();
        emailField.clear();
        emailField.sendKeys("jsmith@demo.io");
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Demo123!");
        loginButton.click();
    }

}
