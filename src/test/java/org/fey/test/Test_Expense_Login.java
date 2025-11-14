package org.fey.test;
import java.io.*;
import java.net.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.*;
import io.appium.java_client.android.options.UiAutomator2Options;


import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;

/**
 *
 * Sample Example on Android Web Application testing by using New and older way of writing the Capabilities for Appium v2.0 & Selenium v4.2.2 which has W3C standard.
 *	- using Duraion,
 *	- using AppiumBy,
 *	- ShadowDOM elements : finding ShadowDOM element , click Element ShadowDOM
 *
 * @author Mike Fey
 * @version 1.0
 *
 */
public class Test_Expense_Login {
ReportiumClient reportiumClient;
    @Test
    public void Fey_Appium_v2_0_By_using_NewCapabilitiesOptons_AW() throws Exception {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = "demo.perfectomobile.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";

        System.out.println("caps");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        //uiAutomatorCaps.setDeviceName("R5CWA2726XK");
        // uiAutomator2Options.withBrowserName("Chrome");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        uiAutomatorCaps.setApp("PUBLIC:ExpenseTracker/Native/ExpenseAppVer1.0.apk");
        uiAutomatorCaps.setAppPackage("io.perfecto.expense.tracker");
        //uiAutomator2Options.setAppActivity("app.perfecto.com.expencemanager.ui.splash.SplashActivity");
        perfectoOptions.put("securityToken", token);
        //perfectoOptions.put("deviceName", "R5CWA2726XK");
        //perfectoOptions.put("app", "PUBLIC:raghav/v1.0/ExpenseHybridAppVer1.apk");
        //perfectoOptions.put("bundleId", "io.perfecto.expense.tracker.hybrid");
        perfectoOptions.put("appiumVersion", "1.22.3");
        perfectoOptions.put("automationVersion", "1.70.1");
        perfectoOptions.put("model", "Galaxy.*");
        perfectoOptions.put("automationName", "UiAutomator2");
        //perfectoOptions.put("autoInstrument", true);
        //perfectoOptions.put("sensorInstrument", true);
        //perfectoOptions.put("iOSResign", true);
        //perfectoOptions.put("autoLaunch", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Appium_v2.0 Android Web Test");
        //perfectoOptions.put("takesScreenshot", false);
        //perfectoOptions.put("screenshotOnError", true);
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("driver init");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("reportium project fey nov14", "1.0"))
                        .withJob(new Job("reportium job nov14", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );
        try {
            reportiumClient.testStart("Fey Appium testng expense tracker login", new TestContext("Appium_v2.0", "Android Web"));

            // write your code here
            System.out.println("test code");
            // write your code here

            //driver.get("https://www.nhl.com");
            //declare the Map for script parameters
            Map<String, Object> params = new HashMap<>();
            System.out.println("open expense app");
            params.put("identifier", "io.perfecto.expense.tracker");
            driver.executeScript("mobile:application:open", params);
            //driver.executeScript("mobile:launchApp", "io.perfecto.expense.tracker");
            System.out.println("enter username");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_email']")).sendKeys("test@perfecto.com");
            Thread.sleep(10000);
            reportiumClient.stepStart("login to expense tracker");
            System.out.println("enter password");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_password'] | //*[@id='login_password'] | //*[@resource-id='login_password']")).sendKeys("test123");
            System.out.println("click login button");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_login_btn'] | //*[@id='login_login_btn'] | //*[@resource-id='login_login_btn']")).click();
            System.out.println("assert that 'Expenses' is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Expenses']")).isDisplayed());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));






            // reportiumClient.testStep("step1"); // this is a logical step for reporting
            // add commands...
            // reportiumClient.testStep("step2");
            // more commands...


            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            e.printStackTrace();
        } finally {
            try {
                driver.quit();

                // Retrieve the URL to the DigitalZoom Report (= Reportium Application) for an aggregated view over the execution
                String reportURL = reportiumClient.getReportUrl();

                // Retrieve the URL to the Execution Summary PDF Report
                String reportPdfUrl = (String)(driver.getCapabilities().getCapability("reportPdfUrl"));
                // For detailed documentation on how to export the Execution Summary PDF Report, the Single Test report and other attachments such as
                // video, images, device logs, vitals and network files - see http://developers.perfectomobile.com/display/PD/Exporting+the+Reports

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Run ended");
    }


}


