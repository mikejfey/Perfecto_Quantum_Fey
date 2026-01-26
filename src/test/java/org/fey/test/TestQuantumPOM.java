package org.fey.test;



import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import com.quantum.pages.ExpenseTrackerLoginPage;

import java.net.URL;
import java.time.Duration;


public class TestQuantumPOM {

    ExpenseTrackerLoginPage loginPage;
   // ExpenseTrackerHomePage homepage;

    @Test (groups = {"@smoke"})
    public void testPOMinQuantum() throws Exception {
    /* want to use capabilities in env.properties.... not hard coded in @Test
        DesiredCapabilities capabilities = new DesiredCapabilities();
// Standard W3C capabilities
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("browserName", "Safari");

        // Appium capabilities with prefix
        capabilities.setCapability("appium:automationName", "XCUITest");
        capabilities.setCapability("appium:deviceModel", "iPhone-14.*");


        //Perfecto capabilities with prefix
        HashMap<String, Object> perfectoOptions = new HashMap<>();
        perfectoOptions.put("model", "iPhone-14.*");
        perfectoOptions.put("automationName", "Appium");
        perfectoOptions.put("useAppiumForWeb", true);
        perfectoOptions.put("javascriptEnabled", true);
        perfectoOptions.put("openDeviceTimeout", 5.0);
        perfectoOptions.put("scriptName", "Fey TestQuantum not POM");
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
*/

      loginPage = new ExpenseTrackerLoginPage();
      //System.out.println("driver used: " + driver);
       loginPage.loginNative("test@perfecto.com","test123");


       // driver.quit();


    }
}
