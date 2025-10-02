package org.fey.test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AndroidDoNotResetApp {

    @Test
    public void feyAndroidNoReset() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();

// Standard W3C capabilities
        //capabilities.setCapability("platformName", "Android");
        // capabilities.setCapability("browserName", "Safari");
        // Appium capabilities with prefix
        // capabilities.setCapability("appium:automationName", "XCUITest");
        // capabilities.setCapability("appium:deviceModel", "iPhone-14.*");

        capabilities.setCapability("perfecto:securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");


        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        //perfectoOptions.put("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
        //perfectoOptions.put("model", "iPhone-14.*");
        perfectoOptions.put("platformName", "Android");
        perfectoOptions.put("deviceName", "R5CWA2726XK");
        perfectoOptions.put("automationName", "UiAutomator2");
        perfectoOptions.put("useAppiumForWeb", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Android Do not reset app each time");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        //perfectoOptions.put("app", "PUBLIC:ExpenseTracker/Native/InvoiceApp1.0.ipa");
        perfectoOptions.put("noReset", true);
        perfectoOptions.put("dataReset", false);
        perfectoOptions.put("fullReset", false);
        perfectoOptions.put("appActivity", "io.perfecto.expense.tracker.MainActivity");
        perfectoOptions.put("bundleId", "io.perfecto.expense.tracker");
        capabilities.setCapability("perfecto:options", perfectoOptions);


        String perfectoURL = "https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        System.out.println("Driver used: " + driver);

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("Fey Quantum POM try", "1.0"))
                .withJob(new Job("Fey Quantum POM job", 45))
                .withCustomFields(new CustomField("programmer", "Mike Fey"))
                .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                .withContextTags("quantum")
                .withWebDriver(driver)
                .build();
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

        reportiumClient.testStart("Android don't reset app each test", new TestContext("quantum"));
        Map<String, Object> params1 = new HashMap<>();
        params1.put("identifier", "io.perfecto.expense.tracker");
        driver.executeScript("mobile:application:open", params1);

        try {
            reportiumClient.stepStart("login ExpenseTracker");
            System.out.println("try to enter username");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_email']")).sendKeys("test@perfecto.com");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_password']")).sendKeys("test123");
            WebElement loginButton = driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_login_btn']"));
            loginButton.click();
            reportiumClient.stepStart("logout ExpenseTracker");
        } catch (Exception e) {
            System.out.println("fey App not open or on correct page: " + e.getMessage());
        }
        try {
            reportiumClient.stepStart("logout after test");
           // driver.findElement(B)
        } catch (Exception e) {
            System.out.println("fey App not logged in or is not on correct page: " + e.getMessage());
        }
        reportiumClient.stepStart("close the app after test");
        System.out.println("closing app after test");
        Map<String, Object> params = new HashMap<>();
        params.put("identifier", "io.perfecto.expense.tracker");
        driver.executeScript("mobile:application:close", params);
        reportiumClient.testStop(TestResultFactory.createSuccess());
        driver.quit();
    }

}
