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

 * @author Mike Fey
 * @version 1.0
 *
 */
public class Test_Expense_Login_StF_Appium2 {
ReportiumClient reportiumClient;
    @Test
    public void Fey_Appium_v2_0_By_using_NewCapabilitiesOptons_AW() throws Exception {
        String browserName = "mobileOS";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String host = "statefarm.perfectomobile.com";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5ZDk1ODcyYi00MmZiLTQzN2ItYTAxMS05ZjQ5YmJlNjRmNDIifQ.eyJpYXQiOjE3ODAwNTc4MjksImp0aSI6ImVjNDczYjZkLTc2N2ItNDI0ZC05Mjg4LTNkZTJlOGYxMGIyNSIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvc3RhdGVmYXJtLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvc3RhdGVmYXJtLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6IjUyZGYwMWQ3LWExZjctNDI1NS1iNGE5LWE2ZDM3NmYzMzZmYSIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiODc2NzMxMTYtNjc3MS00YzQyLTg4ODYtMmQ4MDc4NzYyZmU1Iiwic2Vzc2lvbl9zdGF0ZSI6ImJiNzdjYzQwLWJmMzItNDlmZC04NDg4LTNiZTNjODI0MjI4NyIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIiwic2lkIjoiYmI3N2NjNDAtYmYzMi00OWZkLTg0ODgtM2JlM2M4MjQyMjg3In0.nGCVCOfiL3bGzIxlwxw07x_atqiM7uXmuC85ITuoeuQ";

        System.out.println("caps");
        UiAutomator2Options uiAutomatorCaps = new UiAutomator2Options();
        Map<String, Object> perfectoOptions = new HashMap<>();

        uiAutomatorCaps.setPlatformName("Android");
        uiAutomatorCaps.setDeviceName("R5CTB15LLQN");
       uiAutomatorCaps.withBrowserName("Chrome");
        uiAutomatorCaps.setAutomationName("UiAutomator2");
        perfectoOptions.put("securityToken", token);
      // perfectoOptions.put("appiumVersion", "2.4.1");
        perfectoOptions.put("automationVersion", "4.2.3");
        //perfectoOptions.put("model", "Galaxy.*");
        perfectoOptions.put("automationName", "UiAutomator2");
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Appium_v2.0 Android Web Test");
        perfectoOptions.put("takesScreenshot", true);
        perfectoOptions.put("screenshotOnError", false);

        uiAutomatorCaps.setCapability("perfecto:options", perfectoOptions);
        System.out.println("caps done");
        AndroidDriver driver = new AndroidDriver(new URL("https://statefarm.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomatorCaps);
        System.out.println("driver init");
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
        try {
            reportiumClient.testStart("Support_Appium2_Test", new TestContext("Appium_v2.0", "Android Web"));

            // write your code here
            System.out.println("test code");

            reportiumClient.stepStart("nav to url in chrome browser");
            driver.get("https://www.perforce.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            reportiumClient.testStop(TestResultFactory.createFailure(e.getMessage(), e));
            e.printStackTrace();
        } finally {
            try {
                driver.quit();

                // Retrieve the URL to the DigitalZoom Report (= Reportium Application) for an aggregated view over the execution
                String reportURL = reportiumClient.getReportUrl();

                // Retrieve the URL to the Execution Summary PDF Report
                String reportPdfUrl = (String)(driver.getCapabilities().getCapability("reportPdfUrl"));
                // For detailed documentation on how to export the Execution Summary PDF Report, the Single Test report and other attachments such as
                // video, images, device logs, vitals and network files - see http://developers.perfectomobile.com/display/PD/Exporting+the+Reports

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Run ended");
    }

}


