package com.quantum.pages;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;


public class DigitalBankRegisterPage extends WebDriverBaseTestPage<WebDriverTestPage>{
    @Override
    protected void openPage(PageLocator locator, Object... args) {
    }

    @FindBy(locator = "registerPage.firstName")
    private QAFExtendedWebElement firstName;

    @FindBy(locator = "registerPage.lastName")
    private QAFExtendedWebElement lastName;

    @FindBy(locator = "registerPage.maleRadio")
    private QAFExtendedWebElement maleRadio;

    @FindBy(locator = "registerPage.DOB")
    private QAFExtendedWebElement dob;

    @FindBy(locator = "registerPage.SSN")
    private QAFExtendedWebElement ssn;

    @FindBy(locator = "registerPage.email")
    private QAFExtendedWebElement email;

    @FindBy(locator = "registerPage.password")
    private QAFExtendedWebElement password;

    @FindBy(locator = "registerPage.address")
    private QAFExtendedWebElement address;

    @FindBy(locator = "registerPage.region")
    private QAFExtendedWebElement region;

    @FindBy(locator = "registerPage.locality")
    private QAFExtendedWebElement locality;

    @FindBy(locator = "registerPage.zipcode")
    private QAFExtendedWebElement zipcode;

    @FindBy(locator = "registerPage.country")
    private QAFExtendedWebElement country;

    @FindBy(locator = "registerPage.homePhone")
    private QAFExtendedWebElement homePhone;

    @FindBy(locator = "registerPage.workPhone")
    private QAFExtendedWebElement workPhone;

    @FindBy(locator = "registerPage.mobilePhone")
    private QAFExtendedWebElement mobilePhone;

    @FindBy(locator = "registerPage.agreeCheck")
    private QAFExtendedWebElement agreeCheck;

    @FindBy(locator = "registerPage.registerButton")
    private QAFExtendedWebElement registerButton;

    @FindBy(locator = "registerPage.cancelButton")
    private QAFExtendedWebElement cancelButton;


    public void signUpForm() {
        firstName.sendKeys("Mike");
        lastName.sendKeys("Fey");
        maleRadio.click();
        dob.sendKeys("02/21/2007");
        ssn.sendKeys("123456789");
        email.sendKeys("test@test.com");
        password.sendKeys("Perforce1");
        //need scroll before address
        Map<String, Object> params = new HashMap<>();
        params.put("start", "50%,90%");
        params.put("end", "50%,10%");
        params.put("duration", "3");
        Object res = driver.executeScript("mobile:touch:swipe", params);
        address.sendKeys("111 Lake");
        region.sendKeys("Orono");

        locality.sendKeys("MN");
        zipcode.sendKeys("12345");
        country.sendKeys("US");
        homePhone.sendKeys("123456789");
        mobilePhone.sendKeys("123456789");
        workPhone.sendKeys("123456789");
        agreeCheck.click();
        registerButton.click();
        cancelButton.click();

    }
}

