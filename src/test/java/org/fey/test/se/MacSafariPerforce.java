package org.fey.test.se;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import org.testng.annotations.Test;

public class MacSafariPerforce {

    @Test(groups = {"sanity"})
    public void testSelenium4SampleMac() throws Exception{

        // public static RemoteWebDriver driver;

        {

            String host = "supervalu.perfectomobile.com";
            //String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3Njk0NDg5ODEsImp0aSI6ImViYmNiNzQwLTUzM2UtNDM0OC1hZTkyLTY1MGJiMWY5YWYyYSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZDIxMDAzYzItMDY0Mi00MjVmLTg0ZDAtNzdiYjQ1ODU5MzVlIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI0OTFkNjA4MC1mNzA5LTQwM2UtOGEzOS0wNzI4MTZhMDMxMWMiLCJzZXNzaW9uX3N0YXRlIjoiNDZkZDQxOTAtNWJiOS00YmMxLWI1NzMtM2UwOGRjNzFlMjg1Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI0NmRkNDE5MC01YmI5LTRiYzEtYjU3My0zZTA4ZGM3MWUyODUifQ.alorMqVM6yWasyG_z9IMpCMxaAE-tgLHyTDLjRaMMPM";
            String token ="eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJmZTA0ZjI5My1mZjIxLTQ4NjUtYjJkZi0xZWRhNGYwNDAxZmMifQ.eyJpYXQiOjE3NzQ5ODE4ODgsImp0aSI6ImEwMzhlOGE4LTEwNTItNDc2YS04YjhlLWIxMjM3MGM4OWE2NiIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvc3VwZXJ2YWx1LXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvc3VwZXJ2YWx1LXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6IjRmMzQ5ZTljLTFlYzAtNGM1Yi04YzBkLTJhOGNkYzAxYTRiZSIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiMGYyMzYyMmItM2FlYi00YWVlLWJmNDgtN2I3OWQxMDUxOWMyIiwic2Vzc2lvbl9zdGF0ZSI6IjBiZGQxMDgzLTk2NDItNGE1ZS1iNjE4LWQ5ODlhYTQ3ZmJlOCIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIiwic2lkIjoiMGJkZDEwODMtOTY0Mi00YTVlLWI2MTgtZDk4OWFhNDdmYmU4In0.Llf0T5y8s0gRePz-EwIGhTnSzcAO8VTuNyoCZE3Auos";
            String myWUT = "https://www.perforce.com";
            String projectName = "Customer-WebTests-S4";
            String projectVersion = "4";
            String scriptname = null;
            String isshared = null;

            Map<String, Object> perfectoOptions = new HashMap<>();

            //DesiredCapabilities capabilities = new DesiredCapabilities();
            SafariOptions capabilities = new SafariOptions();

            perfectoOptions.put("platformName", "Mac");
            perfectoOptions.put("platformVersion", "macOS Tahoe");
            perfectoOptions.put("browserName", "Safari");
            perfectoOptions.put("browserVersion", "26");
            perfectoOptions.put("location", "NA-US-PHX");
            perfectoOptions.put("resolution", "1920x1080");
            perfectoOptions.put("securityToken", token);
            perfectoOptions.put("scriptName", "Mac-safari-Webtest-Perforce");
            capabilities.setCapability("perfecto:options", perfectoOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub/"), capabilities);
            System.out.println("Retrieving Browser Type and Session ID");
            System.out.println(driver);
            System.out.println(capabilities);

// Define execution timeouts and Desktop VM Window Size
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

// Reporting client. For more details, see https://github.com/perfectocode/samples/wiki/reporting
            PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                    .withProject(new Project(projectName, projectVersion))
                    .withJob(new Job("Perforce-Webtest-Mac-safari", 3)
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

                reportiumClient.stepStart("Check Text");
                params.clear();
                params.put("content", "fey");
                params.put("threshold", "80");
                params.put("timeout", "30");
                //String text1 = (String) driver.executeScript("mobile:text:find", params);

                WebElement textCheck = null;
                try {
                    textCheck = driver.findElement(By.xpath("//*[contains(text(),'software')]"));
                    String sText = textCheck.getText();
                    System.out.println("the text is in try" + sText);
                } catch (Exception e) {
                    System.out.println("in catch");
                }

                if (textCheck.isDisplayed()) {
                    //successful checkpoint code
                    try {
                        reportiumClient.reportiumAssert("Text Found", true);
                        System.out.println("found the text");
                    } catch (Exception e) {
                    }

                } else {
                    // failed checkpoint code
                    reportiumClient.reportiumAssert("Text Not Found - No Issue", false);
                    System.out.println("NOT found the text");
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
