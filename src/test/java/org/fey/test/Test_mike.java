package org.fey.test;
import java.io.*;
import java.net.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

public class Test_mike {
    public static void main(String[] args) throws MalformedURLException, IOException {

    }
    @org.testng.annotations.Test
    public void Fey_New_Test() throws Exception {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = "partners.perfectomobile.com";
        System.out.println("caps new test");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        uiAutomatorCaps.setDeviceName("R5CWA2726XK");
        // uiAutomator2Options.withBrowserName("Chrome");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        uiAutomatorCaps.setApp("PUBLIC:ExpenseTracker/Native/ExpenseAppVer1.0.apk");
        uiAutomatorCaps.setAppPackage("io.perfecto.expense.tracker");
        //uiAutomator2Options.setAppActivity("app.perfecto.com.expencemanager.ui.splash.SplashActivity");

        perfectoOptions.put("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
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
        perfectoOptions.put("scriptName", "Appium_v2.0 Android Web Test");
        //perfectoOptions.put("takesScreenshot", false);
        //perfectoOptions.put("screenshotOnError", true);
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("new test caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("new test driver init");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Fey new testng proj", "1.0"))
                .withJob(new Job("Appium v2.0 Job", 45))
                .withCustomFields(new CustomField("programmer", "Raghavendra Kundaragi"))
                .withCustomFields(new CustomField("author", "rk@perforce.com"))
                .withContextTags("Appiumv2.0")
                .withWebDriver(driver)
                .build();
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

        try {
            reportiumClient.testStart("Fey New testng", new TestContext("Appium_v2.0", "Android Web"));

            // write your code here
            System.out.println("new test code");
            // write your code here



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

        System.out.println("new test Run ended");
    }
}
