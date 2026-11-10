package org.fey.test.DigBank;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Sample Example on Android Web Application testing by using New and older way of writing the Capabilities for Appium v2.0 & Selenium v4.2.2 which has W3C standard.
 *	- using Duraion,
 *	- using AppiumBy,
 *	- ShadowDOM elements : finding ShadowDOM element , click Element ShadowDOM
 *
 * @author Mike Fey
 * @version 1.0
 *
 */
public class DigBankTransferAndroid {
ReportiumClient reportiumClient;
    @Test
    public void Fey_Appium_v2_0_By_using_NewCapabilitiesOptons_AW() throws Exception {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = "demo.perfectomobile.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3Nzc5OTc4MjYsImp0aSI6ImQ0OWRhNzQzLTNkNjEtNDk4MC1iZGI1LTZmODJjYzRmYzI2MiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJhMzI4ZTU0Mi01Mjk2LTRhNTItOGYwNS0wMDAxZDMwMTU2MjkiLCJzZXNzaW9uX3N0YXRlIjoiM2I2MmZhYzUtNTc4Ny00MDJkLWFjYzItNGU2OTMxYzIyYTYzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiIzYjYyZmFjNS01Nzg3LTQwMmQtYWNjMi00ZTY5MzFjMjJhNjMifQ.ht7QuCYxG6M7OPKYMQfVJx3E2d8JYPfVDv1_TJEMH1Y";
        System.out.println("caps");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();

        Map<String, Object> perfectoOptions = new HashMap<>();
        uiAutomatorCaps.setPlatformName("Android");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        uiAutomatorCaps.setApp("PRIVATE:ExpenseAppVer1ScriptInstFey.apk");
        uiAutomatorCaps.setAppPackage("io.perfecto.expense.tracker");
        perfectoOptions.put("securityToken", token);
        //perfectoOptions.put("model", "Galaxy.*");
        perfectoOptions.put("deviceName", "R3CY90QKKFX");
       /* perfectoOptions.put("autoInstrument", true);
        perfectoOptions.put("sensorInstrument", true);*/
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        //perfectoOptions.put("scriptName", " Android Web Test");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", true);
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);

        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("driver init");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("digBank xfer", "1.0"))
                        .withJob(new Job("digBank xfer", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );
        try {
            reportiumClient.testStart("Fey digBank xfer Android", new TestContext("Appium_v2.0", "Android Web"));

// code to login to dig bank


            reportiumClient.stepStart("transfer fund");

            driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/accountSpinner']")).click();
            driver.findElement(By.xpath("//*[@text='Individual Checking - 2129.0']")).click();
            driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/amountEditText']")).sendKeys("120.00");
            driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/descriptionEditText']")).sendKeys("transfer");
            driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/creditRadioButton']")).click();
            driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/submitButton']")).click();
            try {
                driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/transferConfirmation']")).isDisplayed();
                if (driver.findElement(By.xpath("//*[@resource-id='xyz.digitalbank.demo:id/transferConfirmation']")).isDisplayed()) {
                    System.out.println("Element is visible");
                } else {
                    System.out.println("Element exists but is not visible");
                }
            } catch (Exception e) {
                reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            }

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
        System.out.println("Run ended");
    }
}


