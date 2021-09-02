$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/LoginAndLogout.feature");
formatter.feature({
  "name": "As a user, I would like to login and logout on website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "verify login and logout",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on automation site",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cucumberautomation.stepdefs.CreateAccountStepDefs.i_am_on_automation_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I logged into the automation site",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumberautomation.stepdefs.LoginAndLogoutStepDefs.i_logged_into_the_automation_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I logged out successfully",
  "keyword": "And "
});
formatter.match({
  "location": "com.cucumberautomation.stepdefs.LoginAndLogoutStepDefs.i_logged_out_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});