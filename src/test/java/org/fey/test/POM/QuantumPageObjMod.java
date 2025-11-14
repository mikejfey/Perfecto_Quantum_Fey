package org.fey.test.POM;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.quantum.pages.ExpenseTrackerCrashPage;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;
import org.testng.annotations.Test;


public class QuantumPageObjMod extends WebDriverBaseTestPage<WebDriverTestPage> {

   ExpenseTrackerLoginPage loginPage;
   ExpenseTrackerHomePage homePage;
   ReportiumClient reportiumClient;

   @Override
    protected void openPage(PageLocator locator, Object... args) {

    }
    @Test
    public void quantumPageObjModTest() throws Exception {
        reportiumClient.testStart("adb command to make a call", new TestContext("quantum"));
        reportiumClient.stepStart("send adb command");
        try {
            loginPage.loginNative("test@perfecto.com", "test123");
            homePage.verifyHomeScreen();
        }
        catch (Exception e) {System.out.println("could not login " + e.getMessage());
        }
        reportiumClient.testStop(TestResultFactory.createSuccess());

    }
}
