package com.quantum.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeyStepdefs {
    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("User enters valid email address {string}")
    public void userEntersValidEmailAddress(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("User enters valid password {string}")
    public void userEntersValidPassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("User should login successful")
    public void userShouldLoginSuccessful() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



    @When("User enters invalid email address {string}")
    public void userEntersInvalidEmailAddress(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("User enters invalid password {string}")
    public void userEntersInvalidPassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("User should get proper warning message")
    public void userShouldGetProperWarningMessage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("User logs in with Valid credentials {string} and {string}")
    public void userLogsInWithValidCredentialsAnd(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
