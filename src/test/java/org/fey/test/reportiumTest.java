package org.fey.test;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class reportiumTest {
    ReportiumClient reportiumClient;
    @Test
    public void feyReportium() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();

// Standard W3C capabilities
        capabilities.setCapability("platformName", "iOS");
        // capabilities.setCapability("browserName", "Safari");

        // Appium capabilities with prefix
        // capabilities.setCapability("appium:automationName", "XCUITest");
        // capabilities.setCapability("appium:deviceModel", "iPhone-14.*");

        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";

        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("model", "iPhone-7.*");
        perfectoOptions.put("automationName", "XCUITest");
        perfectoOptions.put("useAppiumForWeb", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey reportium test not POM");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        perfectoOptions.put("app", "PUBLIC:ExpenseTracker/Native/InvoiceApp1.0.ipa");
        perfectoOptions.put("bundleId", "io.perfecto.expense.tracker");
        perfectoOptions.put("iOSResign", true);
        capabilities.setCapability("perfecto:options", perfectoOptions);


        String perfectoURL = "https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/";

        IOSDriver driver = new IOSDriver(new URL(perfectoURL), capabilities);
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
        reportiumClient.testStart("fey reportium test nov14", new TestContext("quantum"));
        reportiumClient.stepStart("login step ExpenseTracker nov14");
        driver.findElement(By.xpath("//*[@name=\"login_email\"]")).sendKeys("test@perfecto.com");
        driver.findElement(By.xpath("//*[@name=\"login_password\"]")).sendKeys("test123");
        WebElement loginButton = driver.findElement(By.xpath("//*[@name=\"Login\"]"));
        loginButton.click();

        reportiumClient.stepStart("nov14 soft assert to replace try-catch.  fake button...should fail");
        System.out.println("using try-catch to click button if displayed");
        //WebElement button = driver.findElement(By.id("com.android.chrome:id/fey_example_button"));
        SoftAssert softAssert = new SoftAssert();
        try {
            System.out.println("inside the try");
            boolean isDisplayed = driver.findElement(By.id("com.android.chrome:id/fey_example_button")).isDisplayed();
            softAssert.assertTrue(isDisplayed, "Example button should be displayed");

        } catch (Exception e) {
            System.out.println("inside the catch");
            softAssert.fail("Example button not found: " + e.getMessage());
        }
        System.out.println("after the catch");
        System.out.println("stop the test... createSuccess");
        reportiumClient.testStop(TestResultFactory.createSuccess());
// Continue with other assertions...



        System.out.println("now quit the driver");
        driver.quit();
    }

}
