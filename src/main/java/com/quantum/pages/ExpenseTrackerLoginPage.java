package com.quantum.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import org.openqa.selenium.By;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;

public class ExpenseTrackerLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@FindBy(locator = "login.email.textfield")
	private QAFWebElement logintextfiled;

	@FindBy(locator = "login.emailNative.textfield")
	private QAFWebElement emailNativeTextfield;

	@FindBy(locator = "login.headerTextNative.label")
	private QAFWebElement headerTextNative;

	@FindBy(locator = "login.passwordNative.textfield")
	private QAFWebElement passwordlNativeTextfield;

	@FindBy(locator = "login.loginNative.btn")
	private QAFWebElement loginlNativeButton;

	@FindBy(locator = "login.email.textFieldValue")
	private QAFWebElement loginlEmailTextFieldValue;

	@FindBy(locator = "login.invalid.ok")
	private QAFWebElement loginlInvalidOk;

	@FindBy(locator = "login.bio.enable")
	private QAFWebElement enableBio;

	@FindBy (locator = "login.signup.link")
	private QAFWebElement signupLink;

	public void verifyExpenseTrackerLoginScreen() {
		Map<String, Object> params = new HashMap<>();
		params.put("content", "Email");
		params.put("timeout", "15");
		driver.executeScript("mobile:text:find", params);
	}

	public void verifyExpenseTrackerNativeLoginScreen() {
		//	if(DriverUtils.getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("ios")) {
		//		QAFExtendedWebElement ele = new QAFExtendedWebElement(By.xpath("//*[@label='OK']"));
		//		try {
		//			ele.click();
		//		} catch (Exception e) {
		//		}
		//	}
		ReportUtils.logAssert("Verify Login screen title", headerTextNative.isDisplayed());
		ReportUtils.logAssert("Verify Login screen Email", emailNativeTextfield.isDisplayed());
        System.out.println("the driver is " + driver);
	}

	public void loginNative(String email, String password) {
		emailNativeTextfield.sendKeys(email);
		ReportUtils.logAssert("Email was entered as expected", emailNativeTextfield.getText().equalsIgnoreCase(email));
		passwordlNativeTextfield.sendKeys(password);

		if(DriverUtils.isIOS()) {
		DriverUtils.getIOSDriver().hideKeyboard();
	}else {
			DriverUtils.getAndroidDriver().hideKeyboard();
		}

		//loginlNativeButton.click();

	}

	public void loginWithInvalidData(String email, String password) {
		emailNativeTextfield.sendKeys(email);
		ReportUtils.logAssert("Email was entered as expected", loginlEmailTextFieldValue.getText().equalsIgnoreCase(email));
		passwordlNativeTextfield.sendKeys(password);

//		if(DriverUtils.isIOS()) {
//			DriverUtils.getIOSDriver().hideKeyboard();
//		}else {
//			DriverUtils.getAndroidDriver().hideKeyboard();
//		}

		loginlNativeButton.click();
		String platform = DriverUtils.getDriver().getCapabilities().getPlatformName().name();

		if ("ios".equalsIgnoreCase(platform) || "linux".equalsIgnoreCase(platform)) {
			loginlInvalidOk.click();
		} else {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}

		emailNativeTextfield.clear();
	}

	public void loginWithValidData(String username, String password) {
		emailNativeTextfield.sendKeys(username);
		ReportUtils.logAssert("Email was entered as expected", loginlEmailTextFieldValue.getText().equalsIgnoreCase(username));
		passwordlNativeTextfield.sendKeys(password);

//		if(DriverUtils.isIOS()) {
//			DriverUtils.getIOSDriver().hideKeyboard();
//		}else {
//			DriverUtils.getAndroidDriver().hideKeyboard();
//		}

		loginlNativeButton.click();

	}

	public void enableBiometrics() {
		enableBio.click();

	}

	public void feyFingerprintSuccess() {
		Map<String, Object> params = new HashMap<>();
// use either the "identifier" or "name" parameter to identify the app
		params.put("identifier", "io.perfecto.expense.tracker");
		params.put("resultAuth", "success");  // may be either "fail" or "success"
		params.put("errorType", "authFailed");  // may be authFailed, userCancel, userFallback, systemCancel, or lockout
		driver.executeScript("mobile:sensorAuthentication:set", params);
	}

	public void enterUserAndPwd(String username, String password) {
		emailNativeTextfield.sendKeys(username);
		ReportUtils.logAssert("Email was entered as expected", loginlEmailTextFieldValue.getText().equalsIgnoreCase(username));
		passwordlNativeTextfield.sendKeys(password);


	}

	public void clickLoginBtn() {
		loginlNativeButton.click();
	}

	public void	clickSignup() { signupLink.click(); }
}





