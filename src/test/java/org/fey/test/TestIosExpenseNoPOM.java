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

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class TestIosExpenseNoPOM {
ReportiumClient reportiumClient;
    @Test
    public void feyTestPOMIos() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
// Standard W3C capabilities
        capabilities.setCapability("platformName", "iOS");
        // capabilities.setCapability("browserName", "Safari");

        // Appium capabilities with prefix appium:
        // capabilities.setCapability("appium:automationName", "XCUITest");
        // capabilities.setCapability("appium:deviceModel", "iPhone-14.*");


        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3Njk0NDg5ODEsImp0aSI6ImViYmNiNzQwLTUzM2UtNDM0OC1hZTkyLTY1MGJiMWY5YWYyYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0OTFkNjA4MC1mNzA5LTQwM2UtOGEzOS0wNzI4MTZhMDMxMWMiLCJzZXNzaW9uX3N0YXRlIjoiNDZkZDQxOTAtNWJiOS00YmMxLWI1NzMtM2UwOGRjNzFlMjg1Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI0NmRkNDE5MC01YmI5LTRiYzEtYjU3My0zZTA4ZGM3MWUyODUifQ.alorMqVM6yWasyG_z9IMpCMxaAE-tgLHyTDLjRaMMPM";//String token = System.getenv("MY_SECRET_TOKEN");
        System.out.println("MY_SECRET_TOKEN: " + token);
        // Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("model", "iPhone-14.*");
        perfectoOptions.put("automationName", "XCUITest");
        perfectoOptions.put("useAppiumForWeb", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey TestQuantumPOM not POM:capability");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        perfectoOptions.put("app", "PUBLIC:ExpenseTracker/Native/InvoiceApp1.0.ipa");
        perfectoOptions.put("bundleId", "io.perfecto.expense.tracker");
        perfectoOptions.put("iOSResign", true);
        perfectoOptions.put("automationVersion", "6.1.0");
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
        reportiumClient.testStart("quantum test without POM:reportium", new TestContext("quantum"));

        reportiumClient.stepStart("login ExpenseTracker");
        driver.findElement(By.xpath("//*[@name=\"login_email\"]")).sendKeys("test@perfecto.com");
        driver.findElement(By.xpath("//*[@name=\"login_password\"]")).sendKeys("test123");
        WebElement loginButton = driver.findElement(By.xpath("//*[@name=\"Login\"]"));
        loginButton.click();


        reportiumClient.stepStart("try catch for a button that might not be found.  don't fail test");
        System.out.println("using try-catch to click button if displayed");
        try {
            WebElement button = driver.findElement(By.id("com.android.chrome:id/fey_example_button"));

            if (button.isDisplayed()) {
                button.click();
                System.out.println("Button was displayed and clicked");
            } else {
                System.out.println("Button is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Button not found or other error: " + e.getMessage());
            // System.out.println("moving on to next steps");
        }
        reportiumClient.testStop(TestResultFactory.createSuccess());
        driver.quit();
    }

}
