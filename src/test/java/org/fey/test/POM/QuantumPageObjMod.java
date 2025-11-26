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
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;
import org.testng.annotations.*;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;


public class QuantumPageObjMod extends WebDriverTestCase {

    ReportiumClient reportiumClient;
    protected ExpenseTrackerLoginPage loginPage2;
    protected ExpenseTrackerHomePage homePage2;
   // protected QAFWebDriver driver = getDriver();
/*      @Override
       protected void openPage(PageLocator locator, Object... args) {
       }*/
    @BeforeTest(alwaysRun = true)
    public void initPages() throws Exception {
        QAFExtendedWebDriver driver = getDriver();
            String testDevice = driver.getCapabilities().getCapability("deviceName").toString();
            System.out.println("using this driver " + driver);
            System.out.println("using this deviceID " + testDevice);
        loginPage2 = new ExpenseTrackerLoginPage();
        homePage2 = new ExpenseTrackerHomePage();
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(
                new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                        .withProject(new Project("POM project fey nov17 sanity", "1.0"))
                        .withJob(new Job("Quantum PoM job nov17", 45))
                        .withCustomFields(new CustomField("programmer", "Mike Fey"))
                        .withCustomFields(new CustomField("author", "mike.fey@perforce.com"))
                        .withWebDriver(driver)
                        .build()
        );

    }


    @Test(groups = {"smoke"})
    public void quantumPageObjModTestSanity() throws Exception {

        reportiumClient.testStart("TC-001: Quantum POM with no BDD sanity", new TestContext("quantum"));
        reportiumClient.stepStart("login from ExpenseTrackerLoginPage class");
        try {
            loginPage2.droidLogin("test@perfecto.com", "test123");
            homePage2.verifyHomeScreen();

        } catch (Exception e) {
            System.out.println("could not login " + e.getMessage());
            reportiumClient.testStop(TestResultFactory.createFailure("failed to login"));
        }
        reportiumClient.testStop(TestResultFactory.createSuccess());
    }

    /*@Test(groups = {"smoke"})
    public void quantumPageObjModTestSmoke() throws Exception {

        reportiumClient.testStart("TC-001: Quantum POM with no BDD smoke", new TestContext("quantum"));
        reportiumClient.stepStart("login from ExpenseTrackerLoginPage class");

        try {
            loginPage2.droidLogin("test@perfecto.com", "test123");
            homePage2.verifyHomeScreen();
        } catch (Exception e) {
            System.out.println("could not login " + e.getMessage());
            reportiumClient.testStop(TestResultFactory.createFailure("failed to login"));
        }
        reportiumClient.testStop(TestResultFactory.createSuccess());
    }*/

/*    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
       // QAFWebDriver driver = getDriver();
        if (getDriver() != null) {
            System.out.println("after suite quit driver " + getDriver());
            getDriver().quit(); // This releases the device
            System.out.println("Driver quit successfully, device released.");
        }
    }*/
}