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
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class ReportingURLExample {
ReportiumClient reportiumClient;
    @Test
    public void Fey_ReportingURL_Example() throws Exception {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = "demo.perfectomobile.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3Nzc5OTc4MjYsImp0aSI6ImQ0OWRhNzQzLTNkNjEtNDk4MC1iZGI1LTZmODJjYzRmYzI2MiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiJhMzI4ZTU0Mi01Mjk2LTRhNTItOGYwNS0wMDAxZDMwMTU2MjkiLCJzZXNzaW9uX3N0YXRlIjoiM2I2MmZhYzUtNTc4Ny00MDJkLWFjYzItNGU2OTMxYzIyYTYzIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiIzYjYyZmFjNS01Nzg3LTQwMmQtYWNjMi00ZTY5MzFjMjJhNjMifQ.ht7QuCYxG6M7OPKYMQfVJx3E2d8JYPfVDv1_TJEMH1Y";

        System.out.println("caps");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        //uiAutomatorCaps.setDeviceName("R5CWA2726XK");
        // uiAutomator2Options.withBrowserName("Chrome");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        uiAutomatorCaps.setApp("PUBLIC:ExpenseAppVer.apk");
        uiAutomatorCaps.setAppPackage("io.perfecto.expense.tracker");
        //uiAutomator2Options.setAppActivity("app.perfecto.com.expencemanager.ui.splash.SplashActivity");
        perfectoOptions.put("securityToken", token);
        perfectoOptions.put("model", "Galaxy.*");
        perfectoOptions.put("automationName", "UiAutomator2");
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "FeyReportingURLExample");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", false);
        perfectoOptions.put("skipLogCapture", false);
        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("driver init");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        // Reporting client. For more details, see http://developers.perfectomobile.com/display/PD/Reporting
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("accessibility pipeline fey", "1.0"))
                        .withJob(new Job("accessibility pipe fey", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );

        String reportURL = reportiumClient.getReportUrl();

        System.out.println("Perfecto Report URL: " + reportURL);
        try {
            reportiumClient.testStart("Fey Reporting URL Example", new TestContext("Appium_v2.0", "Android Web"));
            reportiumClient.stepStart("launch Expense Tracker setup");
            Map<String, Object> parsLog = new HashMap<>();
            parsLog.put("tail", 300);
            String reStr = (String) driver.executeScript("mobile:device:log", parsLog);

            System.out.println("test code");



            Map<String, Object> params = new HashMap<>();
            System.out.println("open expense app");
            params.put("identifier", "io.perfecto.expense.tracker");
            driver.executeScript("mobile:application:open", params);
            //driver.executeScript("mobile:launchApp", "io.perfecto.expense.tracker");
            System.out.println("enter username");

            reportiumClient.stepStart("login to expense tracker");
            Thread.sleep(1000);

            Map<String, Object> paramsAcc = new HashMap<>();
            paramsAcc.put("tag", "login-screen");
            driver.executeScript("mobile:checkAccessibility:audit", paramsAcc);
            paramsAcc.clear();

            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_email']")).sendKeys("test@perfecto.com");

            Thread.sleep(10000);

            System.out.println("enter password");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_password'] | //*[@id='login_password'] | //*[@resource-id='login_password']")).sendKeys("test123");
            System.out.println("click login button");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_login_btn'] | //*[@id='login_login_btn'] | //*[@resource-id='login_login_btn']")).click();
            System.out.println("assert that 'Expenses' is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Expenses']")).isDisplayed());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));






            // reportiumClient.testStep("step1"); // this is a logical step for reporting
            // add commands...
            // reportiumClient.testStep("step2");
            // more commands...


            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {


            reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            e.printStackTrace();
        } finally {
            try {
                driver.quit();

                // Retrieve the URL to the DigitalZoom Report (= Reportium Application) for an aggregated view over the execution
//                String reportURL = reportiumClient.getReportUrl();
//
//                // Retrieve the URL to the Execution Summary PDF Report
//                String reportPdfUrl = (String)(driver.getCapabilities().getCapability("reportPdfUrl"));
//                // For detailed documentation on how to export the Execution Summary PDF Report, the Single Test report and other attachments such as
//                // video, images, device logs, vitals and network files - see http://developers.perfectomobile.com/display/PD/Exporting+the+Reports

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Run ended");
    }


}


