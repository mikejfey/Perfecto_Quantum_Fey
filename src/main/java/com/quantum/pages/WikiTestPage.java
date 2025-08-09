package com.quantum.pages;


import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;


public class WikiTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	PropertyUtil props = ConfigurationManager.getBundle();

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@FindBy(locator = "browser.noThanks")
	private QAFExtendedWebElement browserNoThanks;


	public void clickNoThanks() {
		try {
			if (browserNoThanks.isPresent()) {
				browserNoThanks.click();
				System.out.println("++++++++++++++++++++++Button was displayed and clicked.");
			} else {
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++zebra Button is not displayed.");
			}
		} catch(Exception e){
				System.out.println("Error: " + e.getMessage());
				System.out.println("to the zebra catch++++++++++++++++++++++++");
			}
		}
	}

