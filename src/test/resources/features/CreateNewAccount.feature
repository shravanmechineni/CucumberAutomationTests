@createaccount
Feature: As a user, I would like to create a account, so that I can track my orders, etc.

  Scenario: verify creating a new account
    Given I am on automation site
    And I create an account with the following info
      | firstname | lastname  | password    | date | month | year |
      | testfname | testlname | Password123 | 16   | 12    | 1990 |
