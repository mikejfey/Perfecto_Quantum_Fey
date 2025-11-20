package org.fey.test.POM;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.quantum.pages.ExpenseTrackerCrashPage;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;
import org.testng.annotations.Test;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

import java.util.HashMap;
import java.util.Map;


public class QuantumPageObjMod extends WebDriverTestCase {

    ReportiumClient reportiumClient;
    ExpenseTrackerLoginPage loginPage2;
    ExpenseTrackerHomePage homePage2;


    /*  @Override
       protected void openPage(PageLocator locator, Object... args) {

       }*/
    @MetaData("{'feature':'login','type':'sanity'}")
    @Test(groups = {"sanity"})

    public void quantumPageObjModTestSanity() throws Exception {
        QAFWebDriver driver = getDriver();
        System.out.println("using this driver " + driver);

        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("POM project fey nov17 sanity", "1.0"))
                        .withJob(new Job("Quantum PoM job nov17", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withWebDriver(driver)
                        .build()
        );
        reportiumClient.testStart("TC-001: Quantum POM with no BDD sanity", new TestContext("quantum"));
        reportiumClient.stepStart("login from ExpenseTrackerLoginPage class");
        try {
            loginPage2.droidLogin("test@perfecto.com", "test123");
            homePage2.verifyHomeScreen();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            System.out.println("could not login " + e.getMessage());
            reportiumClient.testStop(TestResultFactory.createFailure("failed to login"));

        }
        //is this a good way to end gracefully...  should it go in @AfterSuite
           /* if (driver != null) {
                driver.quit();
                System.out.println("Driver quit successfully, device released.");
            }*/
    }

    @MetaData("{'feature':'login','type':'smoke'}")
    @Test(groups = {"smoke"})

    public void quantumPageObjModTestSmoke() throws Exception {
        QAFWebDriver driver = getDriver();
        System.out.println("using this driver " + driver);
        loginPage2 = new ExpenseTrackerLoginPage();
        homePage2 = new ExpenseTrackerHomePage();
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("POM project fey nov17 smoke", "1.0"))
                        .withJob(new Job("Quantum PoM job nov17", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withWebDriver(driver)
                        .build()
        );
        reportiumClient.testStart("TC-001: Quantum POM with no BDD smoke", new TestContext("quantum"));
        reportiumClient.stepStart("login from ExpenseTrackerLoginPage class");
        Map<String, Object> params = new HashMap();
        params.put("message", "hello");
        params.put("status", false);
        driver.executeScript("mobile:status:assert", params);

        try {
            loginPage2.droidLogin("test@perfecto.com", "test123");
            homePage2.verifyHomeScreen();
            reportiumClient.testStop(TestResultFactory.createSuccess());
        } catch (Exception e) {
            System.out.println("could not login " + e.getMessage());
            reportiumClient.testStop(TestResultFactory.createFailure("failed to login"));
        }
            /*if (driver != null) {
                driver.quit(); // This releases the device
                System.out.println("Driver quit successfully, device released.");
            }*/
    }
}
