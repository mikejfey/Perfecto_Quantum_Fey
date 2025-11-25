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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Test_HCSC_Appium2Smoke {
ReportiumClient reportiumClient;
    @Test(groups = {"smoke"})
    public void Fey_New_Test() throws Exception {
        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIyZmE2ZmEzMC0xYzQwLTRlOTAtYjJkNC1mOTYwZWUwMjk0YTQifQ.eyJpYXQiOjE3NjQwODk0NDQsImp0aSI6IjI1MGVmMDZkLTRmZDUtNDJlMS1iMWU0LWRkODVjOGQ1MzBmYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvaGNzYy1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2hjc2MtcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZjkwNDE0NzgtM2JmZC00ZWM3LTkxZTYtMWEwZWFjZGE1MWFhIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJlZDRhYmIxNi0xMjkwLTQ1MWYtODBiNS1hYmNmMzllMjQ1OWUiLCJzZXNzaW9uX3N0YXRlIjoiMGQ4MjFmNDYtZjExYS00ODZiLWJjOGMtMDdiNTc4MjA1YzFhIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiIwZDgyMWY0Ni1mMTFhLTQ4NmItYmM4Yy0wN2I1NzgyMDVjMWEifQ.ko4ufxTzYmMPTwgxx_6i7j9b8LCY6O7_fz1kjAjn7xs";
        System.out.println("caps new test");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("deviceName", "45201FDJG001AZ");
        perfectoOptions.put("appiumVersion", "1.22.3");
        perfectoOptions.put("automationVersion", "1.70.1");
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Appium_v2.0 Android Web Test");
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("new test caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://hcsc.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("new test driver init");
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

        SoftAssert softAssert = new SoftAssert();
        try {
            reportiumClient.testStart("Fey Appium2 smoke", new TestContext("Appium_v2.0", "Android Web"));
            System.out.println("new test code for smoke");
            softAssert.assertTrue(1 == 2, "1 is not equal to 2");
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
