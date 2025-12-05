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
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Test_HCSC_RamaCode {
ReportiumClient reportiumClient;
    @Test(groups = {"smoke"})
    public void HCSC_Rama_code() throws Exception {
        // String token = "<token>";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIyZmE2ZmEzMC0xYzQwLTRlOTAtYjJkNC1mOTYwZWUwMjk0YTQifQ.eyJpYXQiOjE3NjQwODk0NDQsImp0aSI6IjI1MGVmMDZkLTRmZDUtNDJlMS1iMWU0LWRkODVjOGQ1MzBmYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvaGNzYy1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2hjc2MtcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZjkwNDE0NzgtM2JmZC00ZWM3LTkxZTYtMWEwZWFjZGE1MWFhIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJlZDRhYmIxNi0xMjkwLTQ1MWYtODBiNS1hYmNmMzllMjQ1OWUiLCJzZXNzaW9uX3N0YXRlIjoiMGQ4MjFmNDYtZjExYS00ODZiLWJjOGMtMDdiNTc4MjA1YzFhIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiIwZDgyMWY0Ni1mMTFhLTQ4NmItYmM4Yy0wN2I1NzgyMDVjMWEifQ.ko4ufxTzYmMPTwgxx_6i7j9b8LCY6O7_fz1kjAjn7xs";
        XCUITestOptions xcuitestOptions = new XCUITestOptions();
        Map<String, Object> perfectoOptions = new HashMap<>();

       //xcuitestOptions.setPlatformName("ios");
        xcuitestOptions.setAutomationName("XCUITest");
      //xcuitestOptions.withBrowserName("Safari");
        xcuitestOptions.setPlatformVersion("15.1");
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("deviceName", "00008110-00084D262E41801E");
        perfectoOptions.put("appiumVersion", "2.4.1");
        //perfectoOptions.put("automationName", "XCUITest");
        perfectoOptions.put("automationVersion", "6.1.0");
        perfectoOptions.put("browserName", "Safari");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        xcuitestOptions.setCapability("perfecto:options", perfectoOptions);
        IOSDriver driver = new IOSDriver(new URL("https://hcsc.perfectomobile.com/nexperience/perfectomobile/wd/hub"), xcuitestOptions);

        System.out.println("new test driver init");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("appium2", "1.0"))
                        .withJob(new Job("appium2 tests", 1))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("appium2")
                        .withWebDriver(driver)
                        .build()
        );

        SoftAssert softAssert = new SoftAssert();
        try {
            reportiumClient.testStart("Fey Appium2 smoke", new TestContext("Appium_v2.0", "Android Web"));
            reportiumClient.stepStart("nav to bcbsil and click hamburger menu");
            System.out.println("new test code for smoke");
            driver.get("https://bcbsil.com/");
            driver.findElement(By.xpath("//*[@class='cmp-mega-nav__hamburger cmp-mega-nav__drawer-toggle']")).click();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            e.printStackTrace();
        } finally {
            try {
                driver.quit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("new test Run ended");
    }
}
