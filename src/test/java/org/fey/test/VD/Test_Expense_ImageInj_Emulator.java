package org.fey.test.VD;

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
public class Test_Expense_ImageInj_Emulator {
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
        perfectoOptions.put("manufacturer", "Samsung");
        perfectoOptions.put("model", "galaxy s25");/**/
        perfectoOptions.put("platformVersion", "16");
        perfectoOptions.put("platformName", "android");
        perfectoOptions.put("useVirtualDevice", true);
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
                        .withProject(new Project("image injection", "1.0"))
                        .withJob(new Job("fey image injection VD", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withContextTags("quantum")
                        .withWebDriver(driver)
                        .build()
        );
        try {
            reportiumClient.testStart("Fey Expense Image Injection and Bio Emulator", new TestContext("Appium_v2.0", "Android Web"));


            System.out.println("enter username");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_email']")).sendKeys("test@perfecto.com");
            Thread.sleep(10000);
            reportiumClient.stepStart("login to expense tracker");
            System.out.println("enter password");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_password'] | //*[@id='login_password'] | //*[@resource-id='login_password']")).sendKeys("test123");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_biometric_check_box']")).click();
            System.out.println("click login button");
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/login_login_btn'] | //*[@id='login_login_btn'] | //*[@resource-id='login_login_btn']")).click();

            Map<String, Object> paramsFp = new HashMap<>();
            paramsFp.put("identifier", "io.perfecto.expense.tracker");
            paramsFp.put("resultAuth", "success");  // may be either "fail" or "success"
            driver.executeScript("mobile:sensorAuthentication:set", paramsFp);


            System.out.println("assert that 'Expenses' is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Expenses']")).isDisplayed());
            // image injection steps
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/list_add_btn']")).click();





            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/add_attach_btn']")).click();
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/btn_attach_camera']")).click();
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
            Map<String, Object> paramsStart = new HashMap<>();
            paramsStart.put("repositoryFile", "PUBLIC:CoffeeReceipt.jpg");
            paramsStart.put("identifier", "io.perfecto.expense.tracker");
            driver.executeScript("mobile:image.injection:start", paramsStart);
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/add_attach_btn']")).click();
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/btn_attach_camera']")).click();
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();

            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/view_view_attach_btn']")).click();
            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/removeAttachment']")).click();

           // driver.findElement(By.xpath("//*[@resource-id='io.perfecto.expense.tracker:id/add_save_btn']")).click();

           /* Map<String, Object> paramsBack = new HashMap<>();
            paramsBack.put("keySequence", "BACK");
            driver.executeScript("mobile:presskey", paramsBack);*/
            //driver.navigate().back();


            Map<String, Object> paramsStop = new HashMap<>();
            driver.executeScript("mobile:image.injection:stop", paramsStop);

            reportiumClient.testStop(TestResultFactory.createSuccess());
            String reportURL = reportiumClient.getReportUrl();

            System.out.println("Perfecto Report URL: " + reportURL);
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


