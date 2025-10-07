package com.quantum.steps;


import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.ExpenseTrackerCrashPage;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class FeySteps {
    @Given("An existing customer navigates to login page")
    public void userNavigatesToLoginPage() {
        System.out.println("login step");
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
