package org.fey.test;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.quantum.pages.POM_ExpenseLoginPage;
import com.quantum.pages.POM_Expense_Homepage;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.*;
import io.appium.java_client.android.options.UiAutomator2Options;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class Test_POM_Login {
    AndroidDriver driver;
    POM_ExpenseLoginPage loginPage;
    POM_Expense_Homepage homepage;
    ReportiumClient reportiumClient;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        uiAutomatorCaps.setDeviceName("R5CWA2726XK");
        // uiAutomator2Options.withBrowserName("Chrome");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        uiAutomatorCaps.setApp("PUBLIC:ExpenseTracker/Native/ExpenseAppVer1.0.apk");
        uiAutomatorCaps.setAppPackage("io.perfecto.expense.tracker");
        //uiAutomator2Options.setAppActivity("app.perfecto.com.expencemanager.ui.splash.SplashActivity");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("deviceName", "R5CWA2726XK");
        //perfectoOptions.put("app", "PUBLIC:raghav/v1.0/ExpenseHybridAppVer1.apk");
        //perfectoOptions.put("bundleId", "io.perfecto.expense.tracker.hybrid");
        perfectoOptions.put("appiumVersion", "1.22.3");
        perfectoOptions.put("automationVersion", "1.70.1");
        //perfectoOptions.put("autoInstrument", true);
        //perfectoOptions.put("sensorInstrument", true);
        //perfectoOptions.put("iOSResign", true);
        //perfectoOptions.put("autoLaunch", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey Login using POM reportium");
        //perfectoOptions.put("takesScreenshot", false);
        //perfectoOptions.put("screenshotOnError", true);
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"),
                uiAutomatorCaps);
        System.out.println("driver init");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withWebDriver(driver)
                        .build()
        );

        loginPage = new POM_ExpenseLoginPage(driver);
    }



    @Test (groups ={"regression"})
    public void testFeyValidLogin() {
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Fey Appium v2.0 Demo Proj", "1.0"))
                .withJob(new Job("Fey POM  Nightly Job", 45))
                .withCustomFields(new CustomField("programmer", "Mike Fey POM"))
                .withCustomFields(new CustomField("author", "mikejfey@hotmail.com"))
                .withContextTags("Appiumv2.0")
                .withWebDriver(driver)
                .build();

        loginPage.launchApp();
        //loginPage.logingAs("test@perfecto.com");
        homepage = loginPage.logingAs("test@perfecto.com", "test123");
        String welcomeText = homepage.getWelcomeText();

        reportiumClient.testStop(TestResultFactory.createSuccess());
        //driver.quit();
        homepage.quitDriver();
    }


}