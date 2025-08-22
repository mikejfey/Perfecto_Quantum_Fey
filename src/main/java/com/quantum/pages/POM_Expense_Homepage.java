package com.quantum.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class POM_Expense_Homepage {
    AndroidDriver driver;

    //locator
    By homepageText = By.xpath("//*[@text='Expenses']");

    //constructor
    public POM_Expense_Homepage(AndroidDriver driver) {
        this.driver = driver;

    }

    //actions
public String getWelcomeText() {
        return driver.findElement(homepageText).getText();
}

public void quitDriver() {
        System.out.println("driver quiting");
        driver.quit();
}

}
