package com.cucumberautomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@login",
        glue = "com.cucumberautomation.stepdefs",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class LoginAndLogoutCukesIT {
}
