package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.ExpenseTrackerCrashPage;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class ExpenseTrackerSteps {


    @Then("I should see expense tracker login screen")
    public void verifyExpenseTrackerLogin() {
        new ExpenseTrackerLoginPage().verifyExpenseTrackerLoginScreen();
    }

    @Then("I should see expense tracker Native login screen")
    public void verifyExpenseTrackerNativeLogin() throws InterruptedException {

        new ExpenseTrackerLoginPage().verifyExpenseTrackerNativeLoginScreen();
    }

    @When("^I enter \"(.*?)\" and \"(.*?)\" in native login screen$")
    public void iEnterLoginDetilsInNativeLoginScreen(String email, String password) {
        new ExpenseTrackerLoginPage().loginNative(email, password);
    }

    @When("I enter \"(.*?)\" and \"(.*?)\" for biometrics")
    public void iEnterLoginDetilsForBiometics(String email, String password) {
        new ExpenseTrackerLoginPage().enterUserAndPwd(email, password);
    }

    @When("^I enter invalid credentials \"(.*?)\" and \"(.*?)\" in native login screen$")
    public void iEnterInvalidLoginDetilsInNativeLoginScreen(String email, String password) {
        new ExpenseTrackerLoginPage().loginWithInvalidData(email, password);
    }

    @Then("I should see expense tracker home screen")
    public void iShouldSeeExpenseTrackerHomeScreen() {
        new ExpenseTrackerHomePage().verifyHomeScreen();
    }

    @When("I enter expense details and save")
    public void iEnterExpenseDetailsAndSave() {
        new ExpenseTrackerHomePage().enterExpenseDetails();
    }

    @Then("I should see error popup")
    public void iShouldSeeErrorPopup() {
        new ExpenseTrackerHomePage().verifyPopupText();
    }

    @When("I tap hamburger then 'About'")
    public void iTapHamburgerAbout() {
        new ExpenseTrackerHomePage().hamburgerAbout();
    }

    @Then("I should see the About screen")
    public void iShouldSeeAboutScreen() {
        new ExpenseTrackerHomePage().verifyAboutScreen();
    }

    @When("I tap 'Crash Me'")
    public void iTapCrashMe() {
        new ExpenseTrackerCrashPage().crashMe();
    }

    @When("^I login with INVALID creds from datafile  \"(.*?)\" and \"(.*?)\"$")
    public void iLoginWithInvalidData(String username, String password) {
        new ExpenseTrackerLoginPage().loginWithInvalidData(username, password);
    }

    @When("^I login with VALID creds from datafile  \"(.*?)\" and \"(.*?)\"$")
    public void iLoginWithValidData(String username, String password) {
        new ExpenseTrackerLoginPage().loginWithValidData(username, password);
    }

    @Then("I click the enable Biometrics")
    public void iClickEnableBiometrics() {
        new ExpenseTrackerLoginPage().enableBiometrics();
    }

    @And("I send success result for biometrics")
    public void iSetFingerprintSuccess() {
        new ExpenseTrackerLoginPage().feyFingerprintSuccess();
    }

    @Then("I click the login button")
    public void iClickLoginBtn() {
        new ExpenseTrackerLoginPage().clickLoginBtn();
    }

    @When("I click the signup link")
    public void iClickSignupLink() {
        new ExpenseTrackerLoginPage().clickSignup();
    }


}


