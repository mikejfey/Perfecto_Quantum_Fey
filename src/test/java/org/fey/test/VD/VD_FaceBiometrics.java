package org.fey.test.VD;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class VD_FaceBiometrics {
ReportiumClient reportiumClient;
    @Test
    public void feyTestVDIos() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3Nzc5OTc4MjYsImp0aSI6ImQ0OWRhNzQzLTNkNjEtNDk4MC1iZGI1LTZmODJjYzRmYzI2MiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJhMzI4ZTU0Mi01Mjk2LTRhNTItOGYwNS0wMDAxZDMwMTU2MjkiLCJzZXNzaW9uX3N0YXRlIjoiM2I2MmZhYzUtNTc4Ny00MDJkLWFjYzItNGU2OTMxYzIyYTYzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiIzYjYyZmFjNS01Nzg3LTQwMmQtYWNjMi00ZTY5MzFjMjJhNjMifQ.ht7QuCYxG6M7OPKYMQfVJx3E2d8JYPfVDv1_TJEMH1Y";
        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("manufacturer", "Apple");
        perfectoOptions.put("model", "iPhone 16 Pro");
        perfectoOptions.put("platformVersion", "18.0");
        perfectoOptions.put("platformName", "iOS");
        perfectoOptions.put("useVirtualDevice", true);
        perfectoOptions.put("automationName", "XCUITest");
        perfectoOptions.put("scriptName", "Support VD Face Biometrics");
        perfectoOptions.put("app", "Public:ExpenseTracker/Native/iOS/InvoiceApp.zip");
        perfectoOptions.put("bundleId", "io.perfecto.expense.tracker");
        capabilities.setCapability("perfecto:options", perfectoOptions);

        String perfectoURL = "https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        IOSDriver driver = new IOSDriver(new URL(perfectoURL), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        System.out.println("Driver used: " + driver);

        // Reporting client.
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("Support VD Face Biometrics", "1.0"))
                        .withJob(new Job("vd bio job support", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );
        try {
            reportiumClient.testStart("FaceBio on iOS VD", new TestContext("quantum"));
            Map<String, Object> parsLog = new HashMap<>();
            parsLog.put("tail", 300);
            String reStr = (String) driver.executeScript("mobile:device:log", parsLog);



            reportiumClient.stepStart("pass face biometrics");
            System.out.println(driver.getPageSource());
            Map<String, Object> paramsBio = new HashMap<>();
// send pass/fail result to app for faceID
            paramsBio.put("identifier", "io.perfecto.expense.tracker");
            paramsBio.put("resultAuth", "fail");  // may be either "fail" or "success"
            driver.executeScript("mobile:sensorAuthentication:set", paramsBio);



        } catch (Exception e) {
            System.out.println("some elementfey not found or other error: " + e.getMessage());
        }

        reportiumClient.testStop(TestResultFactory.createSuccess());
        driver.quit();
    }

}
