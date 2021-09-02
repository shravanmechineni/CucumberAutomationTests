package com.cucumberautomation.stepdefs;

import com.cucumberautomation.pageobjects.LoginAndLogoutPageObjects;
import com.cucumberautomation.util.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginAndLogoutStepDefs {
    LoginAndLogoutPageObjects loginAndLogoutPageObjects = new LoginAndLogoutPageObjects();

    @Given("I logged into the automation site")
    public void i_logged_into_the_automation_site() {
        loginAndLogoutPageObjects.login(TestData.email, TestData.password);
    }

    @And("I logged out successfully")
    public void i_logged_out_successfully() {
        loginAndLogoutPageObjects.logout();
    }

    @When("I logged in again")
    public void i_logged_in_again() {
        loginAndLogoutPageObjects.login(TestData.email, TestData.password);
    }

}
