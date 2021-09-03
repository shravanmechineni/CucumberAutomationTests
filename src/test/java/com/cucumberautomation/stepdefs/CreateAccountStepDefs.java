package com.cucumberautomation.stepdefs;

import com.cucumberautomation.pageobjects.CreateAccountPageObjects;
import com.cucumberautomation.util.TestData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class CreateAccountStepDefs {
    CreateAccountPageObjects createAccountPageObjects = new CreateAccountPageObjects();

    @Before()
    public void setup() {
        createAccountPageObjects.openBrowser("chrome");
    }

    @Given("I am on automation site")
    public void i_am_on_automation_site() {
        createAccountPageObjects.navigate(TestData.website);
    }

    @Given("I create an account with the following info")
    public void i_create_an_account_with_the_following_info(List<Map<String, String>> data) {
        String email = TestData.generateEmail(12);
        for (Map<String, String> user : data) {
            createAccountPageObjects.createAccount(email, user.get("firstname"), user.get("lastname"), user.get("password"), user.get("date"), user.get("month"), user.get("year"));
        }
    }

    @After
    public void tearDown() {
        createAccountPageObjects.closeBrowser();
    }


}
