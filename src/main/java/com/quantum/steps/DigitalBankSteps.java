package com.quantum.steps;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.*;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class DigitalBankSteps {

    @Then("I should see the Digital Bank Login Screen")
    public void iShouldSeeTheDigitalBankLoginScreen() {
        new DigitalBankLoginPage().verifyDigitalBankLoginScreen();
    }


    @When("I click the sign up link")
    public void iClickTheSignUpLink() {
        new DigitalBankLoginPage().clickSignUpHere();
    }

    @Then("I register as a new user")
    public void iRegisterAsANewUser() {
        new DigitalBankRegisterPage().signUpForm();
    }

    @When("I login into Digital Banking")
    public void iLoginIntoDigitalBanking() {
        new DigitalBankLoginPage().loginBanking();
    }

    @And("I logout of Digital Banking app")
    public void iLogoutOfDigitalBanking() {
        new DigitalBankHomePage().logout();
    }
    @Given("I launch Digital Banking app on iOS or Android")
    public void iLaunchDigitalBankingAppOnIOS() {
        System.out.println("Launching Digital Banking app on iOS or Android");


    }
    @Then("I test the Savings flow")
    public void iTestTheSavingsFlow() throws InterruptedException {
        new DigitalBankHomePage().selectIndividualSavingsAccount();
    }

    @When("I test the Checking flow")
    public void iTestTheCheckingFlow() throws InterruptedException {
        new DigitalBankHomePage().selectIndividualCheckingAccount();
    }

    @Then("The checking account should display")
    public void theCheckingAccountShouldDisplay() throws InterruptedException {
        new DigitalBankHomePage().softAssertCheckingAccount();
    }

    @When("I Navigate to the ATM page")
    public void iNavToATM() {
        new DigitalBankNavBarPage().navigateToATM();
    }
    @Then("I find an ATM")
    public void iFindANATM() throws InterruptedException {
        new DigitalBankAtmPage().findATM();
    }

    @When("I navigate to the Transfer page")
    public void iNavigateToTheTransferPage() {
        new DigitalBankNavBarPage().navigateToTransfer();

    }
    @And("I transfer to credit")
    public void iTransferToCredit() throws InterruptedException {
        new DigitalBankTransferPage().makeTransfer();

    }

    @Then("I should see atm location")
    public void iShouldSeeATMLocation() throws InterruptedException {
        new DigitalBankAtmPage().atmLocationVerify();
    }

}
