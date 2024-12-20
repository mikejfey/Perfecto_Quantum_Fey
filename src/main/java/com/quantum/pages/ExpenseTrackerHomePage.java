package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;

public class ExpenseTrackerHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {/* Native App doesn't require Open Page*/ }


	@FindBy(locator = "home.menu.btn")
	private QAFExtendedWebElement menuBtn;

	@FindBy(locator = "home.add.btn")
	private QAFExtendedWebElement addBtn;
	
	@FindBy(locator = "home.head.dropdown")
	private QAFExtendedWebElement headDropdown;

	@FindBy(locator = "home.flight.btn")
	private QAFExtendedWebElement flightOption;
	
	@FindBy(locator = "home.amount.textfield")
	private QAFExtendedWebElement amountInput;
	
	@FindBy(locator = "home.save.btn")
	private QAFExtendedWebElement savebtn;

	@FindBy(locator = "home.about.btn")
	private QAFExtendedWebElement aboutbtn;
	
	
	public void verifyHomeScreen() {
		ReportUtils.logAssert("Verify Home Screen.", menuBtn.isDisplayed());
	}
	
	public void enterExpenseDetails() {

		addBtn.click();
		
		 String platform = DriverUtils.getDriver().getCapabilities().getPlatformName().name();
		
		if("android".equalsIgnoreCase(platform) || "linux".equalsIgnoreCase(platform)) {
			headDropdown.click();
			flightOption.click();
		}else {
			headDropdown.sendKeys("Flight");
		}
		amountInput.sendKeys("100");
		savebtn.click();
	}
	
	public void verifyPopupText() {
//		String platform = DriverUtils.getDriver().getCapabilities().getPlatformName().name();
		String result = "";
		if(DriverUtils.isAndroid()) {
//		if("android".equalsIgnoreCase(platform) || "linux".equalsIgnoreCase(platform)) {
			result = "Select Currency";
		}else {
			result = "Please enter valid category";
		}
		ReportUtils.logAssert("Verify Popup Text.", new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("home.result.text"), result)).isDisplayed());
		
	}

	public void hamburgerAbout() {
		menuBtn.click();
		aboutbtn.click();
	}

	public void verifyAboutScreen() {

	}



}
