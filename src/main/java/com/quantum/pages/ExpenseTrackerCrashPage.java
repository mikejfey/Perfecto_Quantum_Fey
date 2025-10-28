package com.quantum.pages;


import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;
import org.testng.asserts.SoftAssert;

public class ExpenseTrackerCrashPage extends WebDriverBaseTestPage<WebDriverTestPage> {
    @Override
    protected void openPage(PageLocator locator, Object... args) {

    }

    @FindBy(locator = "crash.crashme.btn")
    private QAFExtendedWebElement crashBtn;

    public void crashMe() {

        crashBtn.click();
    }
}
