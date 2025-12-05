package org.fey.test.se;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.util.Assert;

import com.perfecto.reportium.client.DigitalZoomClient;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;

import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.Test;

public class Se4Sample{

    @SuppressWarnings({"unused"})
    @Test(groups = {"sanity"})
    public void testSelenium4Sample() throws Exception{

        // public static RemoteWebDriver driver;

        {

            String host = "demo.perfectomobile.com";
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NTk0Mjk3NTYsImp0aSI6IjIwNDliZmVlLTEwYmUtNGNkNy1iMDI3LTVkNDZjZDExYjU2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiIyOGMyZjQxZS1jYjA3LTRhZDAtYjA3MS1jYzllOWYyNzA1MzgiLCJzZXNzaW9uX3N0YXRlIjoiN2IyMjBhZWYtM2Y1MC00NTk2LWE3ZTEtMzFiMDY2ZGM1MzAxIiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3YjIyMGFlZi0zZjUwLTQ1OTYtYTdlMS0zMWIwNjZkYzUzMDEifQ.GQTd314MFRHYM14RCJPKrC5auLRO9WWY1g-dFEo_Xr8";

            String myWUT = "https://www.time.is";
            String projectName = "Customer-WebTests-S4";
            String projectVersion = "4";
            String scriptname = null;
            String isshared = null;

            Map<String, Object> perfectoOptions = new HashMap<>();

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows");
            browserOptions.setBrowserVersion("latest");
            perfectoOptions.put("platformVersion", "11");
            perfectoOptions.put("location", "US East");
            perfectoOptions.put("resolution", "1920x1080");
            perfectoOptions.put("securityToken", token);
            perfectoOptions.put("scriptName", "Windows-Chrome-Webtest-S4");
            browserOptions.setCapability("perfecto:options", perfectoOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub/"), browserOptions);
            System.out.println("Retrieving Browser Type and Session ID");
            System.out.println(driver);
            System.out.println(browserOptions);

// Define execution timeouts and Desktop VM Window Size
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

// Reporting client. For more details, see https://github.com/perfectocode/samples/wiki/reporting
            PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                    .withProject(new Project(projectName, projectVersion))
                    .withJob(new Job("Customer-Webtest-S4", 3)
                            .withBranch("Web-SampleCode"))
                    .withContextTags("SampleCode")
                    .withWebDriver(driver)
                    .build();
            ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

            try {

                System.out.println("**************** TEST STARTED ****************");

                Map<String, Object> params = new HashMap<>();

                reportiumClient.testStart(scriptname, new TestContext("fey Se 4 WebTest", "SampleCode", isshared));

                reportiumClient.stepStart("Navigate to the Website");
                driver.get(myWUT);

                reportiumClient.stepStart("Clear Disclaimer - If needed");
                params.clear();
                params.put("content", "value your privacy");
                params.put("threshold", "80");
                params.put("timeout", "30");
                String disclaimer1 = (String) driver.executeScript("mobile:text:find", params);

                if (disclaimer1.equalsIgnoreCase("true")) {
                    //successful checkpoint code
                    try {
                        reportiumClient.reportiumAssert("Text Found", true);
                        params.clear();
                        params.put("label", "agree");
                        params.put("timeout", "15");
                        params.put("threshold", "80");
                        driver.executeScript("mobile:button-text:click", params);
                    } catch (Exception e) {
                    }

                } else {
                    // failed checkpoint code
                    reportiumClient.reportiumAssert("Text Not Found - No Issue", false);
                }

                reportiumClient.stepStart("Verify The Time");
                params.clear();
                params.put("content", "Your Time is");
                params.put("timeout", "30");
                String res1 = (String) driver.executeScript("mobile:text:find", params);

                if (res1.equalsIgnoreCase("true")) {
                    //successful checkpoint code
                    reportiumClient.reportiumAssert("Text Found", true);
                } else {
                    // failed checkpoint code
                    reportiumClient.reportiumAssert("Text Not Found - Alternate Search", false);

                    reportiumClient.stepStart("Alternate Verify");
                    params.clear();
                    params.put("content", "Your clock is");
                    params.put("timeout", "30");
                    String res2 = (String) driver.executeScript("mobile:text:find", params);
                    if (res2.equalsIgnoreCase("true")) {
                        //successful checkpoint code
                        reportiumClient.reportiumAssert("Text Found", true);
                    } else {
                        // failed checkpoint code
                        reportiumClient.reportiumAssert("Text Not Found", false);
                    }
                }

                reportiumClient.reportiumAssert("Successful Test Run", true);
                System.out.println("Successful Test Run");
                reportiumClient.testStop(TestResultFactory.createSuccess());

                System.out.println("**************** TEST ENDED ****************");


            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());

                reportiumClient.reportiumAssert("Test Did Not Pass", false);

                reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            } finally {
                try {
                    driver.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                driver.quit();

                System.out.println("Completed My Desktop Windows Web VM Test");

                String reportUrl = reportiumClient.getReportUrl();
                System.out.println(reportUrl);
            }

            System.out.println("Report Link Above");

        }
    }

}