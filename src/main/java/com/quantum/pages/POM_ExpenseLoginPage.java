package com.quantum.pages;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class POM_ExpenseLoginPage {
    AndroidDriver driver;

    //Locators
    By usernameField = By.id("io.perfecto.expense.tracker:id/login_email");
    By passwordField = By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_password']");

    By loginBtn = By.id("io.perfecto.expense.tracker:id/login_login_btn");

    // Constructor
    public POM_ExpenseLoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //page actions

    public void launchApp() {
        Map<String, Object> params = new HashMap<>();
        System.out.println("open expense app");
        params.put("identifier", "io.perfecto.expense.tracker");
        System.out.println("launching app");
        driver.executeScript("mobile:application:open", params);
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys("test@perfecto.com");
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys("test123");
    }

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }

    //combined action
    public POM_Expense_Homepage logingAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new POM_Expense_Homepage(driver); // Navigates to Home Page
    }
}
