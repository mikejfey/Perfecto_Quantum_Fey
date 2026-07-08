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

public class TangVD_iOS {
ReportiumClient reportiumClient;
    @Test
    public void feyTestVDIos() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIwNGM5ZTM4NC03OWE0LTQ5YTEtODAyNC1kMDhhNDkxODgyMTEifQ.eyJpYXQiOjE3ODMzNTYxMjcsImp0aSI6IjE2MGNmNzU0LTFmYmUtNDg4Yy04YTNmLTBjYTRjZGY1ZjcxMyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvdGFuZ2VyaW5ldGVzdC1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RhbmdlcmluZXRlc3QtcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZmQ4OTJkZTAtMDdlMy00ZGIyLWJlYzMtMGI4OWM0YTg0ZjhlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI3ZmRlYzNiOS02NjQ1LTQ2YmMtYTMzZi03YTg3Y2U2MmU2ZjIiLCJzZXNzaW9uX3N0YXRlIjoiNzVkNmQ1MzEtMmYyZC00ZTE0LTkzMDMtMGRiYmRhYjFhNDI3Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3NWQ2ZDUzMS0yZjJkLTRlMTQtOTMwMy0wZGJiZGFiMWE0MjcifQ.NQRHT-_ZO_xjUvFxRY2X20czVNZIv575CGWAip27yzg";
        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("manufacturer", "Apple");
        perfectoOptions.put("model", "iPhone 17");
        perfectoOptions.put("platformVersion", "26.5");
        perfectoOptions.put("platformName", "iOS");
        perfectoOptions.put("useVirtualDevice", true);
        perfectoOptions.put("automationName", "XCUITest");
        perfectoOptions.put("scriptName", "Support VD Test iOS");
        perfectoOptions.put("app", "PUBLIC:DevTangerine.app.zip");
        perfectoOptions.put("bundleId", "ca.tangerine.mobile.banking.app.dev");
        capabilities.setCapability("perfecto:options", perfectoOptions);

        String perfectoURL = "https://tangerinetest.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        IOSDriver driver = new IOSDriver(new URL(perfectoURL), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        System.out.println("Driver used: " + driver);

        // Reporting client.
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("support VD iOs", "1.0"))
                        .withJob(new Job("vd job support", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );
        try {
            reportiumClient.testStart("Launch app on VD", new TestContext("quantum"));
            Map<String, Object> parsLog = new HashMap<>();
            parsLog.put("tail", 300);
            String reStr = (String) driver.executeScript("mobile:device:log", parsLog);

            reportiumClient.stepStart("dismiss notification popup step");
            System.out.println(driver.getPageSource());
            driver.switchTo().alert().dismiss();

            reportiumClient.stepStart("long wait for app to launch");
            Thread.sleep(60000);

            reportiumClient.stepStart("Accept All Privacy step");
            System.out.println(driver.getPageSource());
            //driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Accept All']")).click();
            driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Accept All'")).click();

            reportiumClient.stepStart("dismiss popup for track activity");
            try {
                driver.switchTo().alert().dismiss();
            } catch (NoAlertPresentException e) {
                System.out.println(e.getMessage());
            }

            reportiumClient.stepStart("get started");
            driver.findElement(By.name("signupBenefits_getStarted")).click();

        } catch (Exception e) {
            System.out.println("some elementfey not found or other error: " + e.getMessage());
        }

        reportiumClient.testStop(TestResultFactory.createSuccess());
        driver.quit();
    }

}
