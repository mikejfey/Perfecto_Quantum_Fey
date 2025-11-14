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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Android_ADB_Call {
ReportiumClient reportiumClient;
    @Test
    public void adbMakeCall() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";
       // String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg";
// Standard W3C capabilities
        //capabilities.setCapability("platformName", "Android");
        // capabilities.setCapability("browserName", "Safari");
        // Appium capabilities with prefix
        // capabilities.setCapability("appium:automationName", "XCUITest");
        // capabilities.setCapability("appium:deviceModel", "iPhone-14.*");



        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        //perfectoOptions.put("securityToken", "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTQzOTMyNTQsImp0aSI6ImNjZDgxMjQyLTI3YzctNDYxNS05Mzk2LTM1NzExZDhiY2YwYyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiYzNhZDkxZTgtZTRhYS00YTU5LThiMzItZTIxNmM2MDYyODA0IiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0ZjMwYmMyOS05MmFjLTQ0ZDItOWIyYy0yZDdiZjljY2Y5ZDQiLCJzZXNzaW9uX3N0YXRlIjoiZGNkMjZhYzktZWYwYy00NzEwLTk0OTItMGZiZTk2YjVhYWI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJkY2QyNmFjOS1lZjBjLTQ3MTAtOTQ5Mi0wZmJlOTZiNWFhYjcifQ.tGIQck0sJxJPFuTw5d91DgBnc7zJaXTjs4sERlLHjCg");
        //perfectoOptions.put("model", "iPhone-14.*");
        perfectoOptions.put("securityToken", token);
        //perfectoOptions.put("platformName", "Android");
        perfectoOptions.put("deviceName", "9887BC443241585150");
        perfectoOptions.put("automationName", "UiAutomator2");
        perfectoOptions.put("useAppiumForWeb", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        //perfectoOptions.put("scriptName", "Android adb shell command");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        //perfectoOptions.put("app", "PUBLIC:ExpenseTracker/Native/InvoiceApp1.0.ipa");
        perfectoOptions.put("noReset", true);
        perfectoOptions.put("dataReset", false);
        perfectoOptions.put("fullReset", false);
       // perfectoOptions.put("appActivity", "io.perfecto.expense.tracker.MainActivity");
       // perfectoOptions.put("bundleId", "io.perfecto.expense.tracker");
        capabilities.setCapability("perfecto:options", perfectoOptions);


        String perfectoURL = "https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        System.out.println("Driver used: " + driver);

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
        reportiumClient.testStart("adb command to make a call", new TestContext("quantum"));
        reportiumClient.stepStart("send adb command");

        try {

            System.out.println("try to make a call ");
            String telNumber = "6124410937";
            HashMap<String, Object> args = new HashMap<>();
            args.put("command", "am");
            args.put("args", new String[]{"start", "-a", "android.intent.action.CALL", "-d", "tel:" + telNumber});
            driver.executeScript("mobile: shell", args);
            reportiumClient.stepStart("answer your phone call");

        } catch (Exception e) {
            System.out.println("did not make call " + e.getMessage());
        }

        reportiumClient.testStop(TestResultFactory.createSuccess());
        driver.quit();
    }

}
